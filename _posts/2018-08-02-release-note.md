### Master Report

#### Place Contents (PlaceAd)

   * `PlaceAd` master report has added. 

No | Field Name | Value | Max.Length | Description
--|--|--|--|--
1 | Customer   ID | int |   | Customer   ID
2 | Ad   Group ID | string | 31 | Ad   Group ID
3 | Ad   ID | string | 31 | Ad   Creative ID
4 | Ad   Creative Inspect Status | int |   | - 10: UNDER_REVIEW<br/> - 20: APPROVED<br/> - 30: LIMITED_APPROVED<br/> - 40: PENDING
5 | ON/OFF | int |   | -   0: ON<br/> - 1: OFF
6 | NAME | string | 256 | Ad Name
7 | TITLE | string | 256 | Ad Creative Title
8 | SUBTITLE | string | 256 | Ad Creative subTitle
9 | Ad   Image URL | string | 256 | Ad Creative image URL
10| regTm|date||The time at which information was created(ISO8601)
11| delTm|date||The time at which the campaign was deleted(ISO8601)
