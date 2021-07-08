---
categories: [release]
---

### Master Report

#### Brand Ad (BrandAd)

   * `BrandAd` master report has added.
   * provides creatives of type `SHOPPING_BRAND_AD`.

No|Field Name|Value|Max.Length|Description
----|---|---|---|---
1|Customer ID|int||Customer ID
2|Ad Group ID|string|31|Ad Group ID
3|Ad ID|string|31|Ad Creative ID
4|Ad Creative Inspect Status|int|| - 10: UNDER_REVIEW<br/> - 20: APPROVED<br/> - 30: LIMITED_APPROVED<br/> - 40: PENDING
5|Brand Description|string|256| brand description text.
6|Logo image path|string|256| relative path of log image 
7|ON/OFF|int|| - 0: ON<br/> - 1: OFF
8|regTm|date||The time at which information was created(ISO8601)
9|delTm|date||The time at which the campaign was deleted(ISO8601)

