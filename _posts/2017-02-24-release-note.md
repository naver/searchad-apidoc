### Master Report
   * New Channel Type value added to `Business Channel Type` and `Channel Contents`.

#### Business Channel (BusinessChannel)
No|Field Name|Value|Max.Length|Description
----|---|---|---|---
4|Business Channel Type|int|| - 1: Web Site<br/> - 2: Phone<br/> - 3: Address<br/> - 4: "NAVER Booking" Service<br/> - 5: "NAVER TALK" service<br/> - 6: NAVER Shopping<br/> - 7 : NAVER BLOG
5|Channel Contents|string|1024|short information by channel type.<br/>	1: Site URL<br/>	2: Phone Number<br/>	3: Address<br/>	4: "NAVER Booking" Site URL<br/>	5: "NAVER Talk" URL<br/>	6: Shopping Mall ID, Shopping Mall URL<br/>	7: Contents Url

   * A `Content Type`  column added to `Ad group` master report.

### Ad group (Adgroup)
No|Field Name|Value|Max.Length|Description
----|---|---|---|---
17|Content Type|string|32|Content type information. Only if the campaign type is 3.<br/>- INFORMATION : Contents  Ad Type is Information Type.<br/>- PRODUCT : Contents Ad Type is Product Type.

   * `ContentsAd` master report has added. 

### Contents (ContentsAd)
No|Field Name|Value|Max.Length|Description
----|---|---|---|---
1|Customer ID|int||Customer ID
2|Ad Group ID|string|31|Ad Group ID
3|Ad ID|string|31|Ad Creative ID
4|Ad Creative Inspect Status|int|| - 10: UNDER_REVIEW<br/> - 20: APPROVED<br/> - 30: LIMITED_APPROVED<br/> - 40: PENDING
5|Subject|string|256|Title of Keyword ads.<br/>It appears as a hyperlink when a Keyword ad is exposed. The maximum number of characters allowed (regardless of character types) is 15. Korean Hangul, alphanumeric characters, and special characters (^ < >: \t \n \r \v) can be used.
6|Description|string|256|Description of Keyword ads.<br/>It appears on the right part of Title when a Keyword ad is exposed. Maximum 45 characters from minimum 20 characters regardless of character types. Korean Hangul, alphanumeric characters, and special characters (^ < >: \t \n \r \v) can be used.Note that “<Keyword>" strings are replaced by Keyword of the corresponding Keyword ad. The Keyword can be used up to three times. An error occurs when more than 3 times are repeated.The string length, in case of containing "<Keyword>," is calculated after replacement is done.
7|Landing URL(PC)|string|1024|Ad landing URL in PC Media(RFC 1738)
8|Landing URL(Mobile)|string|1024|Ad landing URL in mobile Media(RFC 1738)
9|Image URL|string|1024|Contents image Url
10|Company Name|string|128|Company Name
11|Contents Issue Date|date||the day of issue contents
12|Release Date|date||the day of release contents
13|ON/OFF|int|| - 0: ON<br/> - 1: OFF
14|regTm|date||The time at which information was created(ISO8601)
15|delTm|date||The time at which the campaign was deleted(ISO8601)

