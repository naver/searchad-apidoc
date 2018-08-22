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

echo "Test RelKeywordStat\n";

$query = array(
    'hintKeywords' => "사과,배,딸기", // Up to 5 keywords could be listed.
    
    // optional
    'siteId' => "", // Buisness chanel ID(nccBusinessChannelId) restricted for site channel type (channelTp= “SITE”)
    'biztpId' => "", // Business type id
    'event' => 73, // 농산물/수산물
    'month' => 9, // 9월
    'showDetail' => 0 // Set 0 For fetching related keywords and monthly query count info only.
);

$response = $api->GET("/keywordstool", $query);
debug($response, $DEBUG);

print_r($response);

echo "\nTest End\n";
?>