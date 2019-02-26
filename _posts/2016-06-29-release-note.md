---
categories: [release]
---

# Ad Management

### add a new parameter
* GET /ncc/campaigns{?baseSearchId,recordSize,`selector`}
* GET /ncc/adgroups{?nccCampaignId,baseSearchId,recordSize,`selector`}
* GET /ncc/keywords{?nccAdgroupId,baseSearchId,recordSize,`selector`}
* `selector` : Optional. If, please enter the value of the "PREVIOUS" to the `selector` parameter if you want to read the previous data. 
* Default : "NEXT"
* Available values:
  * "PREVIOUS" : previous datas (exclude the baseSearchId)
  * "NEXT" : next datas (exclude the baseSearchId)
