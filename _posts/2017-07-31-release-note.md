---
categories: [release]
---

### Stat
* Brand ad item detail(브랜드검색 소재 상세 항목) statistical metrics lookup functionality is added for the API below.
  + GET /stats?id,fields,timeRange,datePreset,timeIncrement,breakdown
  + GET /stats?ids,fields,timeRange,datePreset,timeIncrement,breakdown
* You can request it by adding an ```nccAdId``` as an id, ids parameter and ```eventCode``` as breakdown parameter.

#### Reference
* Brand ad item detail(브랜드검색 소재 상세 항목) statistical metrics are available.
* If you request ```metrics other than clicks```, they will ```all be returned as zero or empty list```.
* From the time of api request, Brand ad item detail statistical metrics provide up to ```past 7 days```
  + datePreset parameter supports today, last7days, yesterday, same as other breakdown parameters.
