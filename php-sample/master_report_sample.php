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

echo "Test Master Report\n";
$item = "Keyword";
$master_full_req = array(
    "item" => $item
);
echo "  #1. full master\n";
$response = $api->POST("/master-reports", $master_full_req);
debug($response, $DEBUG);
$id = $response["id"];
$status = $response["status"];
echo "registed : id = $id, status = " . $status . "\n";
while ($status == 'REGIST' || $status == 'RUNNING') {
    echo "waiting a report..\n";
    sleep(5);
    $response = $api->GET("/master-reports/" . $id);
    $status = $response["status"];
    echo "check : id = $id, status = " . $status . "\n";
}
if ($status == 'BUILT') {
    echo "downloadUrl => " . $response["downloadUrl"] . "\n";
    $api->DOWNLOAD($response["downloadUrl"], $item . "-" . $id . ".tsv");
} else if ($status == 'ERROR') {
    echo "failed to build master report\n";
} else if ($status == 'NONE') {
    echo "master has no data\n";
}

echo "  #2. delta master\n";
$fromTime = "2016-04-01T00:00:00Z";
$master_delta_req = array(
    "item" => $item,
    "fromTime" => $fromTime
);
$response = $api->POST("/master-reports", $master_delta_req);
debug($response, $DEBUG);
$id = $response["id"];
$status = $response["status"];
echo "registed : id = $id, status = " . $status . "\n";
while ($status == 'REGIST' || $status == 'RUNNING') {
    echo "waiting a report..\n";
    sleep(5);
    $response = $api->GET("/master-reports/" . $id);
    $status = $response["status"];
    echo "check : id = $id, status = " . $status . "\n";
}
if ($status == 'BUILT') {
    echo "downloadUrl => " . $response["downloadUrl"] . "\n";
    $api->DOWNLOAD($response["downloadUrl"], "delta-" . $item . "-" . $id . ".tsv");
} else if ($status == 'ERROR') {
    echo "failed to build master report\n";
} else if ($status == 'NONE') {
    echo "master has no data\n";
}

echo "\nTest End\n";
?>