---
categories: [release]
---

#### 2023년 4월 26일, 광고시스템에 공유예산 기능을 제공합니다. ([공지사항](https://saedu.naver.com/notice/view.naver?notiSeq=4064))

### 캠페인
* 브랜드검색, 플레이스 캠페인에서는 제공 되지 않습니다.
* 공유예산을 사용하는 캠페인 정보 조회시 아래의 내용이 추가됩니다.
  * sharedBudgetId: 공유예산 ID
  * sharedDailyBudget: 공유예산
  * sharedBudgetName: 공유예산명
  * sharedBudgetLock: 공유예산 잠김여부
  * sharedBudgetExpectCost: 공유예산 예상과금액
  * numberInUse: 공유예산 사용 entity 갯수
  * sharedBudgetDeliveryMethod: 예산배분방식(ACCELERATED (1), STANDARD(2))
```javascript
{
  sharedBudgetId: "nsb-a001-01-000000000000274"
  sharedDailyBudget: 20000
  sharedBudgetName: "캠페인공유예산"
  sharedBudgetLock: false
  sharedBudgetExpectCost: 15000
  numberInUse: 4
  sharedBudgetDeliveryMethod: "ACCELERATED"
}
```
* 공유예산을 사용하는 캠페인 정보 수정시 아래의 내용이 추가됩니다.
    * sharedBudgetId: 공유예산 ID
    * sharedDailyBudget: 공유예산
    * sharedBudgetName: 공유예산명
    * sharedBudgetDeliveryMethod: 예산배분방식(ACCELERATED (1), STANDARD(2))
### 광고 그룹
* 브랜드검색, 플레이스 캠페인에서는 제공 되지 않습니다.
* 공유예산을 사용하는 광고그룹 정보 조회시 아래의 내용이 추가됩니다.
  * sharedBudgetId: 공유예산 ID
  * sharedDailyBudget: 공유예산
  * sharedBudgetName: 공유예산명
  * sharedBudgetLock: 공유예산 잠김여부
  * sharedBudgetExpectCost: 공유예산 예상과금액
  * numberInUse: 공유예산 사용 entity 갯수
```javascript
{
  sharedBudgetId: "nsb-a001-01-000000000000274"
  sharedDailyBudget: 20000
  sharedBudgetName: "광고그룹공유예산"
  sharedBudgetLock: false
  sharedBudgetExpectCost: 15000
  numberInUse: 4
}
```
* 공유예산을 사용하는 광고그룹 정보 수정시 아래의 내용이 추가됩니다.
    * sharedBudgetId: 공유예산 ID
    * sharedDailyBudget: 공유예산
    * sharedBudgetName: 공유예산명

### 공유예산

* 캠페인, 광고그룹에 공유예산이 추가됩니다.
* 새로운 광고 객체(공유예산)가 추가됩니다.

SharedBudgetRequest
```javascript
{
  sharedBudgetId: string              // 공유예산 Id
  customerId: Long	                  // 광고주 번호
  name: String                        // 공유예산 이름
  ownerType: SharedBudgetOwnerType    // 공유예산 종류 'Campaign', 'Adgroup'
  deliveryMethod: DeliveryMethodType  // 노출 방식 'Accelerated', 'Standard'
  dailyBudget: Long                   // 하루 예산
  budgetLock: Boolean                 // 노출 잠김 여부
  regTm: Date                         // 등록 시각
  editTm: Date                        // 수정 시각
  numberInUse: Int                    // 연결된 캠페인/광고그룹 수
  campaignList: List<CampaignRequest> // 연결될 캠페인 
  adgroupList: List<<AdgroupRequest>  // 연결될 광고그룹
}
```
SharedBudgetResponse
```javascript
{
  sharedBudgetId: string              // 공유예산 Id
  customerId: Long	                  // 광고주 번호
  name: String                        // 공유예산 이름
  ownerType: SharedBudgetOwnerType    // 공유예산 종류 'Campaign', 'Adgroup'
  deliveryMethod: DeliveryMethodType  // 노출 방식 'Accelerated', 'Standard'
  dailyBudget: Long                   // 하루 예산
  budgetLock: Boolean                 // 노출 잠김 여부
  regTm: Date                         // 등록 시각
  editTm: Date                        // 수정 시각
  status: Status                      // 상태
  statusReason: StatusReason          // 상태 이유
  numberInUse: Int                    // 연결된 캠페인/광고그룹 수
}
```
SharedBudgetOwnerType
```javascript
enum SharedBudgetOwnerType{
  CAMPAIGN = 'CAMPAIGN'               // 캠페인
  ADGROUP = 'ADGROUP'                 // 광고그룹
}
```

### 공유예산 API 
* 공유예산 API가 제공됩니다.

Desc | Rest API | Params | Response
----------|----------|------|-----
공유예산 전체 조회 | GET /ncc/shared-budgets | X | List\<SharedBudgetResponse> 
공유예산 단건 조회 | GET /ncc/shared-budgets/{공유예산 ID} | SharedBudgetRequest | SharedBudgetResponse 
공유예산 생성 | POST /ncc/shared-budgets | SharedBudgetRequest | SharedBudgetResponse  
공유예산 수정 | PUT /ncc/shared-budgets/{공유예산 ID} | SharedBudgetRequest | SharedBudgetResponse  
공유예산 하루예산액 수정 | PUT /ncc/shared-budgets | fields=dailyBudget, List\<SharedBudgetRequest\> | List\<SharedBudgetResponse> 
공유예산 삭제 | DELETE /ncc/shared-budgets | ids=[{공유예산 id}, ...] | X 
공유예산에 연결된 캠페인 제외 | PUT /ncc/shared-budgets/campaigns | ids=[{캠페인 id}, ...] | X 
공유예산에 연결된 광고그룹 제외 | PUT /ncc/shared-budgets/adgroups | ids=[{광고그룹 id}, ...] | X 
공유예산에 연결된 캠페인 리스트 조회 | GET /ncc/campaigns/shared-budgets/{공유예산 ID} | X | List\<CampaignResponse> 
공유예산에 연결된 광고그룹 리스트 조회 | GET /ncc/adgroups/shared-budgets/{공유예산 ID} | X | List\<AdgroupResponse>

---
#### A shared budget feature to the ad system will be added On April 26, 2023, ([Announcement](https://saedu.naver.com/notice/view.naver?notiSeq=4064))

### Campaigns
* Not available for brand search and place campaigns.
* The following information will be added when searching for campaign information  that uses a shared budget.
  * sharedBudgetId: Shared budget ID
  * sharedDailyBudget: Daily budget
  * sharedBudgetName: Shared budget name
  * sharedBudgetLock: Whether the shared budget is locked or not
  * sharedBudgetExpectCost: Expected cost of the shared budget
  * numberInUse: Number of entities using the shared budget
  * sharedBudgetDeliveryMethod: Budget distribution method (ACCELERATED (1), STANDARD(2))
```javascript
{
  sharedBudgetId: "nsb-a001-01-000000000000274"
  sharedDailyBudget: 20000
  sharedBudgetName: "Campaign shared budget"
  sharedBudgetLock: false
  sharedBudgetExpectCost: 15000
  numberInUse: 4
  sharedBudgetDeliveryMethod: "ACCELERATED"
}
```
* The following information is added when modifying campaign information that uses a shared budget.
  * sharedBudgetId: Shared budget ID
  * sharedDailyBudget: Daily budget
  * sharedBudgetName: Shared budget name
  * sharedBudgetDeliveryMethod: Budget allocation method (ACCELERATED (1), STANDARD(2))
### Ad Groups
* Not available for Brand Search and Place campaigns.
* The following information is added when searching for ad groups that use shared budget.
  * sharedBudgetId: Shared budget ID
  * sharedDailyBudget: Daily budget
  * sharedBudgetName: Shared budget name
  * sharedBudgetLock: Whether the shared budget is locked or not
  * sharedBudgetExpectCost: Expected cost of the shared budget
  * numberInUse: number of entities using the shared budget
```javascript
{
  sharedBudgetId: "nsb-a001-01-000000000000274"
  sharedDailyBudget: 20000
  sharedBudgetName: "adgroup shared budget"
  sharedBudgetLock: false
  sharedBudgetExpectCost: 15000
  numberInUse: 4
}
```
* The following information is added when modifying ad group information that uses a shared budget.
  * sharedBudgetId: Shared budget ID
  * sharedDailyBudget: Daily budget
  * sharedBudgetName: Shared budget name

### sharedBudget

* Shared budget is added to campaigns and adgroups.
* A new ad object (shared budget) is added.

SharedBudgetRequest
```javascript
{
  sharedBudgetId: string // Shared budget Id
  customerId: Long // Advertiser number
  name: String // Shared budget name
  ownerType: SharedBudgetOwnerType // Shared budget type 'CAMPAIGN', 'ADGROUP'
  deliveryMethod: DeliveryMethodType // Delivery method 'ACCELERATED', 'STANDARD'
  dailyBudget: Long // Daily budget
  budgetLock: Boolean // Whether the impression is locked or not
  regTm: Date // Registration time
  editTm: Date // Edit time
  numberInUse: Int // The number of connected campaigns/adgroups
  campaignList: List<CampaignRequest> // Campaigns to be connected 
  adgroupList: List<<AdgroupRequest> // Adgroups to be connected
}
```
SharedBudgetResponse
```javascript
{
  sharedBudgetId: string // Shared budget Id
  customerId: Long // Advertiser number
  name: String // Shared budget name
  ownerType: SharedBudgetOwnerType // Shared budget type 'CAMPAIGN', 'ADGROUP'
  deliveryMethod: DeliveryMethodType // Delivery method 'ACCELERATED', 'STANDARD'
  dailyBudget: Long // Daily budget
  budgetLock: Boolean // Whether the impression is locked or not
  regTm: Date // Registration time
  editTm: Date // Edit time
  status: Status // Status
  statusReason: StatusReason // Status reason
  numberInUse: Int // The number of connected campaigns/adgroups
}
```

SharedBudgetOwnerType
```javascript
enum SharedBudgetOwnerType{
  CAMPAIGN = 'CAMPAIGN' // CAMPAIGN
  ADGROUP = 'ADGROUP' // ADGROUP
}
```

### Shared budget API
* Shared budget API is provided.

Desc | Rest API | Params | Response
  ----------|----------|------|-----
Get all shared budgets | GET /ncc/shared-budgets | X | List\<SharedBudgetResponse> 
Get a single shared budget | GET /ncc/shared-budgets/{shared-budget ID} | SharedBudgetRequest | SharedBudgetResponse 
Create a shared budget | POST /ncc/shared-budgets | SharedBudgetRequest | SharedBudgetResponse  
Modify a shared budget | PUT /ncc/shared-budgets/{shared-budget ID} | SharedBudgetRequest | SharedBudgetResponse  
Modify a shared budget daily budget amount | PUT /ncc/shared-budgets | fields=dailyBudget, List\<SharedBudgetRequest\> | List\<SharedBudgetResponse> 
Delete a shared budget | DELETE /ncc/shared-budgets | ids=[{shared-budget id}, ...] | X 
Remove a campaign associated with a shared budget | PUT /ncc/shared-budgets/campaigns | ids=[{campaign id}, ...] | X 
Exclude ad groups linked to a shared budget | PUT /ncc/shared-budgets/adgroups | ids=[{adgroup id}, ...] | X 
Get a list of campaigns connected to a shared budget | GET /ncc/campaigns/shared-budgets/{shared-budget ID} | X | List\<CampaignResponse> 
Get a list of ad groups connected to a shared budget | GET /ncc/adgroups/shared-budgets/{shared-budget ID} | X | List\<AdgroupResponse>

---
