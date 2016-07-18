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

echo "Test ManagedCustomerLink\n";
$customerlist = $api->GET('/customer-links', array('type' => 'MYCLIENTS'));
debug($customerlist, $DEBUG);

echo "Test BusinessChannel\n";
$businesschannellist = $api->GET('/ncc/channels');
debug($businesschannellist, $DEBUG);

echo "Test Campaign\n";
$campaignlist = $api->GET('/ncc/campaigns');
debug($campaignlist, $DEBUG);

echo "Test Adgroup\n";
echo "  #1. GET Adgroup\n";
$adgrouplist = $api->GET('/ncc/adgroups');
debug($adgrouplist, $DEBUG);
$targetadgroup = $adgrouplist[0];

echo "  #2. CREATE Adgroup\n";
$data = array(
    "name" => 'TEST_#' . rand(),
    "nccCampaignId" => $targetadgroup ["nccCampaignId"],
    "pcChannelId" => $targetadgroup ["pcChannelId"],
    "mobileChannelId" => $targetadgroup ["mobileChannelId"]
);
$createadgroup = $api->POST('/ncc/adgroups', $data);
debug($createadgroup, $DEBUG);

echo "  #3. UPDATE Adgroup\n";
$createadgroup["userLock"] = 1;
$updateadgroup = $api->PUT('/ncc/adgroups/' . $createadgroup["nccAdgroupId"], $createadgroup, array("fields" => 'userLock'));
debug($updateadgroup, $DEBUG);

echo "Test AdKeyword\n";
echo "  #1. CREATE AdKeyword\n";
$data = array(
    array(
        "keyword" => "hello2"
    )
);
$createkeyword = $api->POST('/ncc/keywords', $data, array("nccAdgroupId" => $updateadgroup["nccAdgroupId"]));
debug($createkeyword, $DEBUG);

echo "  #2. GET AdKeyword\n";
$adkeywordlist = $api->GET('/ncc/keywords', array("nccAdgroupId" => $updateadgroup["nccAdgroupId"]));
debug($adkeywordlist, $DEBUG);

echo "  #3. UPDATE AdKeyword\n";
$adkeywordlist[0]["userLock"] = 1;
$updatekeyword = $api->PUT('/ncc/keywords', $adkeywordlist, array("fields" => "userLock"));
debug($updatekeyword, $DEBUG);

echo "  #4. DELETE AdKeyword\n";
$api->DELETE('/ncc/keywords/' . $createkeyword[0]["nccKeywordId"]);

echo "  #4. DELETE Adgroup\n";
$api->DELETE('/ncc/adgroups/' . $createadgroup["nccAdgroupId"]);

echo "Test Estimate\n";
echo "  #1. average-position-bid\n";
$req_avg_pos = array(
    "device" => "PC",
    "items" => array(
        array("key" => "제주여행", "position" => 1),
        array("key" => "게스트하우스", "position" => 2),
        array("key" => "자전거여행", "position" => 3),
    )
);
$response = $api->POST('/estimate/average-position-bid/keyword', $req_avg_pos);
debug($response, $DEBUG);

echo "  #2. exposure-minimum-bid\n";
$req_bid = array(
    "device" => "PC",
    "period" => "MONTH",
    "items" => array(
        "제주여행",
        "게스트하우스",
        "자전거여행",
    )
);
$response = $api->POST('/estimate/exposure-minimum-bid/keyword', $req_bid);
debug($response, $DEBUG);

echo "  #3. median-bid\n";
$response = $api->POST('/estimate/median-bid/keyword', $req_bid);
debug($response, $DEBUG);

echo "  #4. performance\n";
$req_performance = array(
    "device" => "PC",
    "keywordplus" => true,
    "key" => "중고차",
    "bids" => array(
        100,
        500,
        1000,
        1500,
        2000,
        3000,
        5000,
    )
);
$response = $api->POST('/estimate/performance/keyword', $req_performance);
debug($response, $DEBUG);

echo "  #5. performance-bulk\n";
$req_performance_bulk = array (
		"items" => array (
				0 => array (
						"device" => "PC",
						"keywordplus" => true,
						"keyword" => "제주여행",
						"bid" => 70 
				),
				1 => array (
						"device" => "PC",
						"keywordplus" => true,
						"keyword" => "제주도",
						"bid" => 80 
				),
				2 => array (
						"device" => "PC",
						"keywordplus" => true,
						"keyword" => "제주맛집",
						"bid" => 90 
				) 
		) 
);
$response = $api->POST('/estimate/performance-bulk', $req_performance_bulk);
debug($response, $DEBUG);

echo "\nTest End\n";
?>