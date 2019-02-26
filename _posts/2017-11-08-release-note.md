---
categories: [release]
---

### Stat
#### Expansion of ```brand search ad breakdown data``` offer period
* Applied to /api/stats when requesting with the breakdown parameter.
  + ```GET /stats?id,fields,timeRange,datePreset,timeIncrement,breakdown```
  + ```GET /stats?ids,fields,timeRange,datePreset,timeIncrement,breakdown```
* Applied to PC / mobile(PC/모바일 구분), day of the week(요일 구분) and hour of day(시간대 구분)

Before| After
---------------------|---------------
From the time of api request with breakdown parameter, provide up to past 7 days of all campaign types | From the time of api request with breakdown parameter, For brand ad only, provide up to past 90 days for some entities(AdgroupId, AdId, KeywordId) 

#### Add entity lookup constraint
* If you request an entity list (AdgroupId, AdId, KeywordId) with the ids parameter, they must all belong to the same campaign type
* If you request it in combination with an ID that belongs to another campaign type, the following error is returned
```
Http Status code - 400 (BAD REQUEST) 
Internal classification code - 11003 
Message - 선택하신 조건에 지표가 확인되지 않습니다. 동일한 캠페인 유형을 id, ids 파라미터에 포함해서 요청하세요.
```
