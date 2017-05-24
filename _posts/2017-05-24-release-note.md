### Stat
* NccAdExtensionId statistical metrics lookup functionality is added for the API below.
 + GET /stats?id,fields,timeRange,datePreset,timeIncrement,breakdown
 + GET /stats?ids,fields,timeRange,datePreset,timeIncrement,breakdown
* You can request it by adding an nccAdExtensionId as an id, ids parameter.

#### Reference
* NccAdExtensionId statistical metrics are **available starting from 2017.03.01 (KST)**.
* datePreset parameter is supported **except for today parameter**
* Breakdown parameter is supported **only PC / mobile classification(PC/모바일 구분) and day of the week classification(요일 구분)**.
