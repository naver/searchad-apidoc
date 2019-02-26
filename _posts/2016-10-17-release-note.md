---
categories: [release]
---

### Stat

#### add a new parameter
* GET /stats{?id,`statType`}
* statType : predefined type of stats
* Available statType : NPLA_SCH_KEYWORD

#### StatType : NPLA_SCH_KEYWORD
* Receive the search keyword, total clicks, direct conversion ratio, sales amount(including VAT) by ad id or adgroup id within the last 30 days
* Data will be provided only when `the number of clicks is equal to or greater than 1`
* Actual data will be provided after it has been displayed on `November 10` shopping search advertising 
* This type offers the only `shopping campaign type` data

Property name|Data type|Description
---|---|---
schKeyword |string|search keyword
clkCnt|integer|clicks
drtCrto|real|direct conversion ratio
salesAmt |integer|sales amount(including VAT)

### Target

#### new operation added
  * GET /ncc/targets{?ownerId,types}
    * Retrieves the targets of owner entity.
    * Also filtering by type(targetTp) is available.
    * parameter description
      * the `ownerId` is either adgroup id or ad id. (Required)
      * the `types` is targetTp. (Optional)

  * PUT /ncc/targets/{targetId}
    * Updates single target.
    * the `ownerId` MUST be provided in request body.
