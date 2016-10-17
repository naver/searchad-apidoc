### Stat
#### add a new parameter
* GET /stats/{?id,`statType`}
* statType : predefined type of stats
* Available statType : NPLA_SCH_KEYWORD

#### StatType : NPLA_SCH_KEYWORD
* Receive the search keyword, total clicks, direct conversion ratio, sales amount(including VAT) by ad id or adgroup id within the last 30 days
* Actual data will be provided after it has been displayed on `November 10` shopping search advertising 
 * http://searchad.naver.com/AIHM20/AIHM2002_A01.nbp?noticeId=2868
* This type offers the only `shopping campaign type` data

Property name|Data type|Description
---|---|---
schKeyword |string|search keyword
clkCnt|integer|clicks
drtCrto|real|direct conversion ratio
salesAmt |integer|sales amount(including VAT)
