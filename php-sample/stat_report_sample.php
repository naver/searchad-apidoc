<?php
ini_set("default_socket_timeout", 30);
require_once 'restapi.php';

$config = parse_ini_file("sample.ini");
print_r($config);

function debug($obj, $detail = false)
{
    if (is_array($obj)) {
        echo "size : " . count($obj) . "\n";
    }
    if ($detail) {
        print_r($obj);
    }
}

// #. detail log
$DEBUG = false;

$api = new RestApi($config['BASE_URL'], $config['API_KEY'], $config['SECRET_KEY'], $config['CUSTOMER_ID']);

echo "Test StatReport\n";
$reportType = "AD_DETAIL";
$statDt = "20160201";
$stat_req = array(
    "reportTp" => $reportType,
    "statDt" => $statDt
);

$response = $api->POST("/stat-reports", $stat_req);
debug($response, $DEBUG);
$reportjobid = $response["reportJobId"];
$status = $response["buildState"];
echo "registed : reportJobId = $reportjobid, buildState = " . $status . "\n";
while ($status == 'W' || $status == 'R') {
    echo "waiting a report..\n";
    sleep(5);
    $response = $api->GET("/stat-reports/" . $reportjobid);
    $status = $response["buildState"];
    echo "check : reportJobId = $reportjobid, buildState = " . $status . "\n";
}
if ($status == 'S') {
    echo "downloadUrl => " . $response["downloadUrl"] . "\n";
    $api->DOWNLOAD($response["downloadUrl"], $reportType . "-" . $statDt . ".tsv");
} else if ($status == 'E') {
    echo "failed to build stat report\n";
} else if ($status == 'N') {
    echo "report has no data\n";
} else if ($status == 'Y') {
    echo "stat aggregation not yet finished\n";
}

echo "\nTest End\n";
?>