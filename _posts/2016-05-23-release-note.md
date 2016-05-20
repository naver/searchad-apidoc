### Master Report
   * `SeasonalEvent` report has added
   
No|Field Name|Value|Max.Length|Description
----|---|---|---|---
1|ID|int||Business ID
2|Event Name|string|100|Event Name
3|SuperBusinessId|int||Superordinate seasonal event id
4|Level|int||Category level
5|Related month information|string|30|Comma(,) delimitted month relation. ex) 8,9,10,11


## Ad Manage
* Json Object data type has been changed

### AdGroup

Json Property Name | AS-IS Type| TO-BE Type
------------------|---------------------|---------------
userLock | Integer | boolean 
delFlag | Integer | boolean
useDailyBudget | Integer | boolean
budgetLock  | Integer | boolean
useKeywordPlus | Integer | boolean
useCntsNetworkBidAmt | Integer | boolean
