---
categories: [release]
---

#### 2023년 6월 28일, 파워링크 키워드 확장 Beta에 일치(유사검색어) 노출 여부 기능이 추가 됩니다.

### 광고그룹
* 일치(유사검색어) 노출 여부 (`useCloseVariant`)가 광고그룹에 추가됩니다.(boolean)
* 일치(유사검색어) 노출 여부는 파워링크 광고그룹(WEB_SITE 유형)에서만 유효합니다.
* 일치(유사검색어) 노출 여부는 `키워드 확장 (useKeywordPlus)`기능과의 조합으로 사용됩니다.
* 일치(유사검색어) 노출 여부는 `키워드 확장 (useKeywordPlus)`값이 사용(`true`)일 경우에 사용안함(`false`)로 설정이 불가능합니다.
* 광고그룹 생성시 일치(유사검색어) 노출 여부를 입력하지 않을 경우 `사용함(true)`로 설정이 됩니다.

|useKeywordPlus|useCloseVariant|설명|
---------------|---------------|----
true|true|키워드 확장 + 일치(유사검색어) 노출
false|true| 일치(유사검색어) 노출
true|false| 사용 불가
false|false| 일치 노출



#### 광고그룹 예제
```javascript
{
    "nccAdgroupId": "grp-a001-00-000000000000000",
    "adgroupType": "WEB_SITE",
    "name": "파워링크 그룹",
    "nccCampaignId": "cmp-a001-00-000000000000000",
    "useCntsNetworkBidAmt": true,
    "useDailyBudget": true,
    "useKeywordPlus": false,
    "useCloseVariant": true,
    "userLock": true,
    ....
}
```


#### On June 28, 2023, Powerlink Keyword Plus Beta will add Close Variant match.

### AdGroups
* Close Variant match (`useCloseVariant`) is added to ad groups.(boolean)
* Close Variant match is only valid for Powerlink adgroups (WEB_SITE type).
* Close Variant match is used in combination with the `Keyword Plus (useKeywordPlus)` feature.
* Close Variant match cannot be set to disabled (`false`) when the value of `Keyword Plus (useKeywordPlus)` is enabled (`true`).
* If you do not enter whether to Close Variant when creating an adgroup, it will be set to `enabled (true)`.

|useKeywordPlus|useCloseVariant|Description|
---------------|---------------|----
true|true|Keyword Plus + Close Variant
false|true| Close Variant
true|false|Disabled
false|false| Exact match


#### Adgroup Example
```javascript
{
    "nccAdgroupId": "grp-a001-00-000000000000000",
    "adgroupType": "WEB_SITE",
    "name": "파워링크 그룹",
    "nccCampaignId": "cmp-a001-00-000000000000000",
    "useCntsNetworkBidAmt": true,
    "useDailyBudget": true,
    "useKeywordPlus": false,
    "useCloseVariant": true,
    "userLock": true,
    ....
}
