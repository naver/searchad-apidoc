### Stat
* The aggregation criteria for the provided indicators will change.
  + Applied to GET /stats?id,statType, statType=NPLA_SCH_KEYWORD
* The impCnt (impressions) added to the metric provided with the change in aggregation criteria.
* There is no change to the request interface, and an additional impCnt is returned as the api response value.

Stat Type|Before| After
---------------------|---------------------|---------------
NPLA_SCH_KEYWORD|Provides metrics for shopping search keywords with clicks in the last 30 days | Provides metrics for shopping search keywords with impressions in the last 30 days, plus additional impression metrics

#### Reference
* The results of the API response, in descending order of impressions, will return up to 1000 statistics metrics for each query.
