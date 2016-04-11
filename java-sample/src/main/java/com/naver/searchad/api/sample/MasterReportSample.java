package com.naver.searchad.api.sample;

import com.mashape.unirest.http.HttpResponse;
import com.naver.searchad.api.model.MasterReport;
import com.naver.searchad.api.rest.MasterReports;
import com.naver.searchad.api.util.PropertiesLoader;
import com.naver.searchad.api.util.RestClient;
import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class MasterReportSample {

	public static void main(String[] args) {
		try {
			Properties properties = PropertiesLoader.fromResource("sample.properties");
			String baseUrl = properties.getProperty("BASE_URL");
			String apiKey = properties.getProperty("API_KEY");
			String secretKey = properties.getProperty("SECRET_KEY");
			long customerId = Long.parseLong(properties.getProperty("CUSTOMER_ID"));

			RestClient rest = RestClient.of(baseUrl, apiKey, secretKey);

			MasterReport.Item item = MasterReport.Item.Keyword; // Ad Keywords

			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			calendar.add(Calendar.DATE, -1); // one day ago
			String fromTime = DatatypeConverter.printDateTime(calendar);
			// Get Full Master
			System.out.println("load full master : " + item);
			MasterReport fullReport = MasterReports.CreateFullMasterReportJob(rest, customerId, item);
			if (fullReport != null) {
				load(rest, customerId, fullReport);
			}

			System.out.println("load delta master from " + fromTime + " : " + item);
			// Get Delta Master
			MasterReport deltaReport = MasterReports.CreateDeltaMasterReportJob(rest, customerId, item, fromTime);
			if (deltaReport != null) {
				load(rest, customerId, deltaReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void load(RestClient rest, long customerId, MasterReport created) throws Exception {
		int retryNumber = 100;
		int retryIntervalInSeconds = 5;
		while (true) {
			System.out.println("check Job status...");
			MasterReport getjob = MasterReports.GetMasterReportJob(rest, customerId, created.getId());
			MasterReport.Status status = getjob.getStatus();
			System.out.println("job status is " + status);
			switch (status) {
				case BUILT:
					System.out.println("report was built.");
					System.out.println("get delta from : " + getjob.getFromTime() + " to : " + getjob.getUpdateTime());
					download(rest, customerId, getjob);
					return;
				case ERROR:
					System.err.println("failed to build report.");
					return;
				case NONE:
					System.out.println("report has no data");
					return;
				case REGIST:
				case RUNNING:
					if (--retryNumber < 1) {
						System.out.println("exceeded max-retry number....");
					} else {
						System.out.println("[" + retryNumber + "] next check status after " + retryIntervalInSeconds + " second");
						TimeUnit.SECONDS.sleep(retryIntervalInSeconds);
					}
					break;
			}
		}
	}

	private static void download(RestClient rest, long customerId, MasterReport built) throws Exception {
		List<NameValuePair> params = URLEncodedUtils.parse(new URI(built.getDownloadUrl()), "UTF-8");
		if (!params.isEmpty()) {
			NameValuePair value = params.get(0);
			if ("authtoken".equals(value.getName())) {
				String authtoken = value.getValue();
				HttpResponse<InputStream> response = rest.get("/report-download", customerId)
						.queryString("authtoken", authtoken)
						.asBinary();
				File downloaded = new File("test-" + built.getItem() + "-" + built.getId() + ".tsv");
				try (FileOutputStream out = new FileOutputStream(downloaded);
				     InputStream in = response.getBody()) {
					System.out.println("Download Available: " + in.available());
					IOUtils.copy(in, out);
					System.out.println("file-size = " + downloaded.length());
					System.out.println("file = " + downloaded.toString());
				}
			}
		}
	}
}
