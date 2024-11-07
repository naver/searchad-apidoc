---
categories: [release]
---

#### 2024년 11월 7일, Stat API의 breakdown에서 일부 파라미터값이 삭제됩니다.

### Stat
* /stats API에서 성별(genderNm), 연령대별(ageRangeNm), 읍/면/동별(regnR3Nm) breakdown이 삭제됩니다. 

- Request 
```
GET /stats{?id,fields,timeRange,datePreset,timeIncrement,breakdown}
GET /stats{?ids,fields,timeRange,datePreset,timeIncrement,breakdown}
```

#### On November 7, 2024, some parameter values will be removed from the breakdown in the Stat API.

### Stat
* Gender(genderNm), Age Range(ageRangeNm), and Town/City District(regnR3Nm) breakdown will be removed from the /stats API.

#### Request

```
GET /stats{?id,fields,timeRange,datePreset,timeIncrement,breakdown}
GET /stats{?ids,fields,timeRange,datePreset,timeIncrement,breakdown}
```
