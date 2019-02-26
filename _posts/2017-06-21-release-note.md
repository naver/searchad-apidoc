---
categories: [release]
---

### Stat Report
#### Expansion of data offer period
* Report type `AD_DETAIL` data offer period has been extended.

Report Type|Before| After
---------------------|---------------------|---------------
AD_DETAIL|From the time of api request, provide up to past `21 days` | From the time of api request, provide up to past `30 days`

#### Apply automatic report deletion
* Report files `older than 30 days from the date of report generation` will be automatically deleted.
* Even if the report file is deleted, it can be regenerated if it falls within the data offer period.
