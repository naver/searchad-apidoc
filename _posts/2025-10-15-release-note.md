---
title: Release Note
categories: [release]
---

#### 쇼핑검색광고 전환목표 자동입찰(Beta) 서비스 오픈 안내

안녕하세요. 네이버 검색광고 API입니다.


기존에  "쇼핑검색광고 자동입찰(Beta) 서비스 종료 안내 ([공지 바로가기 >](https://ads.naver.com/notice/23991))" 에서 안내드린 바와 같이 2025년 10월 15일부터, 새로운 쇼핑검색광고의 전환목표 자동입찰 (Beta) 서비스를 오픈합니다.


전환 로그를 수집하고 있는 쇼핑몰 상품형 광고 그룹이라면, [광고그룹 생성 API](https://naver.github.io/searchad-apidoc/#/operations/POST/~2Fncc~2Fadgroups)와 [광고그룹 수정 API](https://naver.github.io/searchad-apidoc/#/operations/PUT/~2Fncc~2Fadgroups~2F%7BadgroupId%7D)을 이용하여 자동입찰을 설정하실 수 있습니다.
자동입찰은 하루예산 내에서 광고주의 목표 달성을 위한 방향으로 광고그룹의 기본입찰가와 각 소재의 노출 여부, 실제 입찰가를 관리합니다. 

- 적용 일정 :  2025년 10월 15일(수) 오후 
- 적용 대상 : 쇼핑검색광고 쇼핑몰 상품형 유형 광고 그룹에 적용이 됩니다.
- 적용 방법 : 광고 그룹 생성/수정 API 호출시 `autobidStrategy` property에 자동입찰 전략을 설정합니다.
- 쇼핑몰 상품형 유형 광고 그룹 조회시 자동입찰 전략 정보가 포함됩니다.
- 자동입찰 전략은 아래의 JSON 구조를 가집니다.
```
{
  "nccAutobidStrategyId": "string",
  "customerId": "number",
  "autobidTargetId": "string",
  "autobidTargetType": "GRP",
  "isAutobidActive": true/false,
  "autobidBidGoal": "NONE/MAX_CONV_VALUE",
  "autobidBidType": "CPC",
  "autobidBidStrategy": "NO_CAP",
  "autobidBidStrategyValue": 0
}
```
  - nccAutobidStrategyId: 자동입찰 전략 ID
  - customerId: 광고 계정 Customer ID
  - autobidTargetId: 광고 그룹 ID
  - autobidTargetType: 자동입찰 타겟 유형(`GRP` 고정)
  - isAutobidActive: 자동입찰 사용 여부 (true/false)
  - autobidBidGoal: 자동입찰 목표 (`NONE` - 없음, `MAX_CONV_VALUE` - 전환가치 최대화)
  - autobidBidType: 자동입찰 유형 (`CPC` - 고정) 
  - autobidBidStrategy: 자동입찰 전략(`NO_CAP` - 고정)
  - autobidBidStrategyValue: 자동입찰 입찰가 (0 - 고정)

감사합니다.

----
 

#### Launch of Conversion-based Automated Bidding (Beta) on Shopping Search Ads

As previously announced in the [Termination Notice of Automated Bidding (Beta) on Shopping Search Ads](https://ads.naver.com/notice/23991), a new Conversion-based Automated Bidding (Beta) will be launched starting October 15, 2025.

Advertisers running Online store type ad groups with conversion logs can configure automated bidding through the following APIs:

* [Adgroup Create API](https://naver.github.io/searchad-apidoc/#/operations/POST/~2Fncc~2Fadgroups)
* [Adgroup Update API](https://naver.github.io/searchad-apidoc/#/operations/PUT/~2Fncc~2Fadgroups~2F%7BadgroupId%7D)

Automated bidding manages an ad group's default bids, creative delivery, and actual bids within the daily budget to meet campaign goals.

- Effective Date: October 15, 2025 (Wednesday) afternoon
- Target Adgroup: Online store type, Shopping Search Ads
- How to apply: Configure automated bidding strategy using the `autobidStrategy` property when calling Adgroup Create or Update API.
- Automated bidding strategy information will be included when retrieving Online store type ad groups through the Adgroup Gep API.
- Automated bidding strategy follows the JSON structure below:


```
{
  "nccAutobidStrategyId": "string",
  "customerId": "number",
  "autobidTargetId": "string",
  "autobidTargetType": "GRP",
  "isAutobidActive": true/false,
  "autobidBidGoal": "NONE/MAX_CONV_VALUE",
  "autobidBidType": "CPC",
  "autobidBidStrategy": "NO_CAP",
  "autobidBidStrategyValue": 0
}
```

  - nccAutobidStrategyId: ID of the automated bidding strategy  
  - customerId: Customer ID of the advertiser account  
  - autobidTargetId: Ad group ID  
  - autobidTargetType: Automated bidding target type (fixed to `GRP`)  
  - isAutobidActive: Indicates whether automated bidding is active (`true`/`false`)  
  - autobidBidGoal: Automated bidding goal (`NONE` = None, `MAX_CONV_VALUE` = Maximize conversion value)  
  - autobidBidType: Automated bidding type (fixed to `CPC`)  
  - autobidBidStrategy: Automated bidding capping strategy (fixed to `NO_CAP`)  
  - autobidBidStrategyValue: Value of the automated bidding capping strategy (fixed to `0`)





