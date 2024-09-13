---
categories: [release]
---

#### 2024년 10월 2일, 파워링크 확장검색 기능이 추가됩니다. 노출제한키워드가 제외검색어로 변경됩니다.

### 광고그룹
* 확장 검색 사용여부 (`useExpSearch`)가 광고그룹에 추가됩니다.
* 확장 검색 예산 비율(`expSearchBudgetRatio`)이 광고그룹에 추가됩니다.
* 공유예산 확장 검색 예산 비율(`sharedExpSearchBudgetRatio`)이 광고그룹에 추가됩니다.

#### 광고그룹 예제
```json
{
    "nccAdgroupId": "grp-a001-00-000000000000000",
    "adgroupType": "WEB_SITE",
    "name": "파워링크 그룹",
    "nccCampaignId": "cmp-a001-00-000000000000000",
    "useCntsNetworkBidAmt": true,
    "useDailyBudget": true,
    "userLock": true,
    "useExpSearch": true,
    "expSearchBudgetRatio": 40,
    ....
}
```

### 제외검색어
* type의 값이 추가되었습니다.
  * EXP_SEARCH : 확장 검색 
  * KEYWORD_PLUS_RESTRICT : 스마트블록 및 유사검색어

#### 제외검색어 예제
```json
{
  "nccAdgroupId": "grp-a001-00-000000000000000",
  "keyword": "대출",
  "type": "EXP_SEARCH"
}
```

#### On August 19, 2024, Added power link extension search function. Exposure restriction keywords will be changed to negative search terms.

### AdGroups
* Enable extended search ('useExpSearch') is added to the advertising group.
* An extended search budget ratio ('expSearchBudgetRatio') is added to the advertising group.
* 'SharedExpSearchBudgetRatio' is added to the ad group.
 
#### Adgroup Example

```json
{
    "nccAdgroupId": "grp-a001-00-000000000000000",
    "adgroupType": "WEB_SITE",
    "name": "파워링크 그룹",
    "nccCampaignId": "cmp-a001-00-000000000000000",
    "useCntsNetworkBidAmt": true,
    "useDailyBudget": true,
    "userLock": true,
    "useExpSearch": true,
    "expSearchBudgetRatio": 40,
    ....
}
```
### negative search term
* Value of type added.
    * EXP_SEARCH: Extension Search
    * KEYWORD_PLUS_RESTRICT: Smartblock and similar search terms

#### Negative Search Terms Example
```json
{
  "nccAdgroupId": "grp-a001-00-000000000000000",
  "keyword": "loan",
  "type": "EXP_SEARCH"
}
```
