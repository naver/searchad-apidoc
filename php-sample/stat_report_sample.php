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
$statDt = date('Ymd',strtotime("-1 days"));;
$stat_req = array(
    "reportTp" => $reportType,
    "statDt" => $statDt
);

$response = $api->POST("/stat-reports", $stat_req);
debug($response, $DEBUG);
$reportjobid = $response["reportJobId"];
$status = $response["status"];
echo "registed : reportJobId = $reportjobid, status = " . $status . "\n";
while ($status == 'REGIST' || $status == 'RUNNING' || $status == 'WAITING') {
    echo "waiting a report..\n";
    sleep(5);
    $response = $api->GET("/stat-reports/" . $reportjobid);
    $status = $response["status"];
    echo "check : reportJobId = $reportjobid, status = " . $status . "\n";
}
if ($status == 'BUILT') {
    echo "downloadUrl => " . $response["downloadUrl"] . "\n";
    $api->DOWNLOAD($response["downloadUrl"], $reportType . "-" . $statDt . ".tsv");
} else if ($status == 'ERROR') {
    echo "failed to build stat report\n";
} else if ($status == 'NONE') {
    echo "report has no data\n";
} else if ($status == 'AGGREGATING') {
    echo "stat aggregation not yet finished\n";
}

echo "\nTest End\n";
?>