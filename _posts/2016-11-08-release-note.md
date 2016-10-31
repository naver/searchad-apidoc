### Master Report
   * `ShoppingProduct` report has added

No|Field Name|Value|Max.Length|Description
----|---|---|---|---
1|Customer ID|int||Customer ID
2|Ad Group ID|string|31|Ad Group ID
3|Ad ID|string|31|Ad Creative ID
4|Ad Creative Inspect Status|int|| - 10: UNDER_REVIEW<br/> - 20: APPROVED<br/> - 30: LIMITED_APPROVED<br/> - 40: PENDING
5|ON/OFF|int|| - 0: ON<br/> - 1: OFF
6|Ad Product Name|string|256|product name when ad is exposed.
7|Ad Image URL|string|256|product image url when ad is exposed.
8|Bid|int||Korean Won(KRW), from 50 to 100,000
9|Using Ad Group Bid Amount|boolean|| - false: not used <br/> - true: used
10|Ad Link Status|int||0: Disable.<br/>1: Enable.
11|regTm|date||The time at which information was created(ISO8601)
12|delTm|date||The time at which the campaign was deleted(ISO8601)
13|Product ID|string|256|Unique key of Shopping Product
14|Product ID Of Mall|string|256|Product Id of Mall
15|Product Name|string|256|Product name
16|Product Image URL|string|256|Product Image URL
17|PC Landing URL|string|256|Product landing page(PC)
18|Mobile Landing URL|string|256|Product landing page(Mobile)
19|Price(PC)|string|256|Low Price(PC)
20|Price(Mobile)|string|256|Low Price(Mobile)
21|Delivery Fee|string|256|delivery fee
22|NAVER Shopping Category Name 1|string|256|Category Name
23|NAVER Shopping Category Name 2|string|256|Category Name
24|NAVER Shopping Category Name 3|string|256|Category Name
25|NAVER Shopping Category Name 4|string|256|Category Name
26|NAVER Shopping Category ID 1|string|256|Category ID
27|NAVER Shopping Category ID 2|string|256|Category ID
28|NAVER Shopping Category ID 3|string|256|Category ID
29|NAVER Shopping Category ID 4|string|256|Category ID
30|Category Name of Mall|string|256|Category Name

   * `BusinessChannel` report has changed

No|Field Name|Value|Max.Length|Description
----|---|---|---|---
1|Customer ID|int||Customer ID
2|Name|string|256|channel name
3|Business Channel Id|string|31|Business Channel Id
4|Business Channel Type|int|| - 1: Web Site<br/> - 2: Phone<br/> - 3: Address<br/> - 4: "NAVER Booking" Service<br/> - 5: "NAVER TALK" service<br/> - 6: Shopping
5|Channel Contents|string|1024|short information by channel type.<br/>	1: Site URL<br/>	2: Phone Number<br/>	3: Address<br/>	4: "NAVER Booking" Site URL<br/>	5: "NAVER Talk" URL<br/>	6: Shopping Mall ID, Shopping Mall URL
6|PC Inspect Status|int|| - 10: UNDER_REVIEW<br/> - 20: APPROVED<br/> - 30: LIMITED_APPROVED<br/> - 40: PENDING
7|Mobile Inspect Status|int|| - 10: UNDER_REVIEW<br/> - 20: APPROVED<br/> - 30: LIMITED_APPROVED<br/> - 40: PENDING
8|regTm|date||The time at which information was created(ISO8601)
9|delTm|date||The time at which the campaign was deleted(ISO8601)

