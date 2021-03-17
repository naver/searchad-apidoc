---
categories: [release]
---

#### 2021년 3월 17일에 쇼핑검색광고 브랜드형 광고가 추가 됩니다. ([공지사항](https://saedu.naver.com/notice/view.nhn?notiSeq=3752&catg=1&fixYn=N&searchOpt=all&keyword=))


### 광고 그룹
* 쇼핑 캠페인 광고 그룹에 성별/연령 타겟팅 기능이 추가 됩니다. ([공지사항](https://saedu.naver.com/notice/view.nhn?notiSeq=3759&catg=&fixYn=N&searchOpt=all&keyword=))
* 광고 그룹 유형에 `쇼핑 브랜드(SHOPPING_BRAND)` 유형이 추가 됩니다.
* 쇼핑 브랜드 유형 광고 그룹은 쇼핑 캠페인 내부에서만 유효합니다.
* 쇼핑 브랜드 유형 광고 그룹을 생성하기 위해서는 기존 광고그룹에 `상품 그룹 ID(nccProductGroupId)`가 포함되어야 합니다.
* 쇼핑 브랜드 유형 광고 그룹은 기존의 쇼핑 켐페인의 광고 그룹 유형 (쇼핑몰 상품형 유형, 제품 카탈로그 유형)과 다르게 키워드를 추가할 수 있습니다.
* 쇼핑 브랜드 유형 광고 그룹의 입찰가는 최소 300원 입니다.
* 쇼핑 브랜드 유형 광고 그룹 생성 예제
  * Request
  ```shell
  POST /api/ncc/adgroups
  ```
  * Request Body
  ```json
    {
      ... 기존 광고그룹 생성과 동일
	  "adgroupType": "SHOPPING_BRAND",
	  "nccProductGroupId": "pdg-a001-00-000000000000320"
    }
  ```

### 키워드
* 쇼핑 브랜드 유형 광고 그룹에 추가되는 키워드의 최소 입찰가는 300원입니다.
* 쇼핑 브랜드 유형 광고 그룹에 키워드를 추가 하기 위해서는 키워드 생성 요청에 아래의 정보가 추가 되어야 합니다.
* `attr.shopping_brand_keyword_type` 
* `shopping_brand_keyword_type`의 값은 number 타입으로 `0(일반 키워드)`, `1(내 브랜드 키워드)`, `2(다른 브랜드 키워드)`를 입력할 수 있습니다.
  
  ```json
    {
      "attr": {
         "shopping_brand_keyword_type" : 1
      }
    }
  ```

* 키워드 등록 예제
  * Request
  ```shell
  POST /api/ncc/keywords?nccAdgroupId={광고 그룹 ID}
  ```
  * Request Body
  ```json
    [{
        "customerId": 1234567890,
        "nccAdgroupId": "{광고 그룹 ID}",
        "keyword": "{키워드1}",
        "attr": {
            "shopping_brand_keyword_type": 1
        }
    }, {
        "customerId": 1234567890,
        "nccAdgroupId": "{광고 그룹 ID}",
        "keyword": "{키워드2}",
        "attr": {
            "shopping_brand_keyword_type": 1
        }
    }]
  ```


### 비즈니스 채널
* 비즈니스 채널 유형에 `SHOPPING_BRAND`가 추가 되었습니다.
* `SHOPPING_BRAND` 유형의 비즈니스 채널은 API를 이용하여 등록할 수 없습니다.


### 소재
* 소재 유형에 `SHOPPING_BRAND_AD`가 추가 되었습니다.
* `SHOPPING_BRAND_AD` 유형의 소재는 API를 이용하여 등록할 수 없습니다.


### 확장소재
* 확장소재 유형에 `SHOPPING_BRAND_VIDEO`, `SHOPPING_BRAND_IMAGE`, `SHOPPING_BRAND_BROADCAST`가 추가 되었습니다.
* 추가된 확장소재 유형은 API를 이용하여 등록할 수 없습니다.

### 상품 그룹
* 상품 그룹이 새로 추가 되었습니다.
* 상품 그룹은 쇼핑몰에 연동이된 정보를 가지고 있습니다.
* 상품 그룹은 광고주 계정에 연동이 되며 한개의 상품 그룹은 여러개의 광고 그룹에 연결 할 수 있습니다.
* 상품 그룹에서 사용하는 NVMID는 네이버 쇼핑에서 조회 가능합니다.

* 상품 그룹 타입

  컬럼이름 | 타입 | 설명 
  --------|------|-----
  nccProductGroupId | string | 상품 그룹 ID
  customerId | number | 광고주 번호
  nccBusinessChannelId | string | 비즈채널 ID
  name | string | 상품 그룹 이름
  registrationMethod | string	| 상품이 전체 등록인지 선택 등록인지를 나타내는 값. EACH: 선택 등록, WHOLE: 전체 등록 
  registeredProductType | string | 상품 그룹 등록시 선택한 비즈채널이 일반형인지 카탈로그형인지를 나타내는 값. GENERAL: 일반형, CATALOG:  카탈로그형
  mallId | string | 몰 ID
  mallName | string | 몰 이름
  brandNo | string | 브랜드 NO 또는 브랜드 SEQ
  brandName | string | 브랜드 이름
  attrJson | ProductGroupAttrJson | 상품 그룹 속성 JSON
  regTm |	string | 상품 그룹 생성 시각
  editTm | string | 상품 그룹 최근 수정 시각
  numberOfAdgroups | number | 상품 그룹을 사용하고 있는 광고 그룹의 개수

* 상품 그룹 속성 Json(ProductGroupAttrJson) 타입

  프로퍼티 | 타입 | 설명 
  --------|------|------
  productNvmids | string[] | 상품 그룹의 registrationMethod 값이 EACH일 경우에 노출할 상품의 nvmid 목록 (순서는 노출 선호 순서)
  excludeNvmids | string[] | 상품 그룹의 registrationMethod 값이 WHOLE일 경우에 노출 제외할 상품의 nvmid 목록
  prvdrId	| string | 상품 그룹의 registredProductType 이 CATALOG일 경우에 쇼핑의 프로바이더 ID값

* 상품 그룹은 API를 이용하여 등록할 수 없습니다.
* 계정에 등록된 상품 그룹의 목록은 아래의 API를 이용하여 조회할 수 있습니다.
  * Request 
  ```shell
  GET /api/ncc/product-groups
  ```
  * Response Body
  ```json
  [{
	"nccProductGroupId": "pdg-a001-00-000000000000XXXXX",
	"customerId": 1234567890,
	"nccBusinessChannelId": "bsn-a001-00-0000000000XXXXX",
	"name": "상품_그룹_이름#1",
	"registrationMethod": "WHOLE",
	"registeredProductType": "CATALOG",
	"mallId": "mall-id",
	"mallName": "몰 이름",
	"brandNo": "브랜드 번호",
	"brandName": "브랜드 이름",
	"attrJson": {
		"prvdrId": "프로바이더 아이디"
	},
	"regTm": "2021-03-04T06:51:56.000Z",
	"editTm": "2021-03-04T06:51:56.000Z",
	"numberOfAdgroups": 1
  }, {
	"nccProductGroupId": "pdg-a001-00-000000000000XXX",
	"customerId": 318734,
	"nccBusinessChannelId": "bsn-a001-00-0000000000XXXXX",
	"name": "상품_그룹_이름#2",
	"registrationMethod": "EACH",
	"registeredProductType": "CATALOG",
	"mallId": "mall-id2",
	"mallName": "몰 이름",
	"brandNo": "브랜드 번호",
	"brandName": "브랜드 이름",
	"attrJson": {
		"prvdrId": "942041",
		"productNvmids": ["1234567890", "0987654321", "1234512345"]
	},
	"regTm": "2021-03-09T03:13:04.000Z",
	"editTm": "2021-03-09T03:13:04.000Z",
	"numberOfAdgroups": 0
  }]
  ```

### 리포트
* 쇼핑 브랜드 유형 광고의 /stats API에 성별, 연령대별 breakdown 추가
* 성별, 연령대별 breakdown 은 쇼핑 캠페인 유형 광고에서만 사용할 수 있습니다.
* 쇼핑 브랜드 유형 광고의 /stats API에 topImpRto(검색상단노출률) field 추가 (나머지 유형에 대해서는 0으로 리턴)
* topImpRto(검색상단노출률) 지표는 노출이 시작된 이후부터 값이 리턴됩니다. (노출 시작일  2021년 3월 31일)

  * Request
  ```shell
  GET /stats{?id,fields,timeRange,datePreset,timeIncrement,breakdown}
  GET /stats{?ids,fields,timeRange,datePreset,timeIncrement,breakdown}
  ```

---


#### On March 17, 2021, a shopping-brand ad will be added. ([Notice](https://saedu.naver.com/notice/view.nhn?notiSeq=3752&catg=1&fixYn=N&searchOpt=all&keyword=))

### Adgroup
* Add gender/age targeting to adgroups in shopping campaigns. ([Notice](https://saedu.naver.com/notice/view.nhn?notiSeq=3759&catg=&fixYn=N&searchOpt=all&keyword=))
* Type `SHOPPING_BRAND` will be added to the adgroup type.
* Shopping brand type adgroups are valid only within shopping campaigns.
* To create a shopping brand type adgroup, an existing advertising group must include a `nccProductGroupId`
* Shopping brand type adgroups may add keywords differently from the existing shopping campaign's adgroup type (shopping mall product type, product catalog type).
* The bidding price for the shopping brand type adgroup is at least 300 KRW.
* Example of creating a shopping brand type adgroup
  * Request
  ```shell
  POST /api/ncc/adgroups
  ```
  * Request Body
  ```json
    {
      ... Same as creating an existing adgroup
	  "adgroupType": "SHOPPING_BRAND",
	  "nccProductGroupId": "pdg-a001-00-000000000000320"
    }
  ```

### Keyword
* The minimum bid for the keyword added to the shopping brand type adgroup is 300 KRW.
* In order to add keywords to the shopping brand type adgroup, the following information must be added to the keyword create request:
* `attr.shopping_brand_keyword_type` 
* The value of `shopping_brand_keyword_type` is number type and can be entered as `0(general keyword)`, `1(my brand keyword)`, and `2(other brand keyword)`.
  
  ```json
    {
      "attr": {
         "shopping_brand_keyword_type" : 1
      }
    }
  ```

* Keyword Registration Example
  * Request
  ```shell
  POST /api/ncc/keywords?nccAdgroupId={adgroup ID}
  ```
  * Request Body
  ```json
    [{
        "customerId": 1234567890,
        "nccAdgroupId": "{adgroup ID}",
        "keyword": "{keyword1}",
        "attr": {
            "shopping_brand_keyword_type": 1
        }
    }, {
        "customerId": 1234567890,
        "nccAdgroupId": "{adgroup ID}",
        "keyword": "{keyword2}",
        "attr": {
            "shopping_brand_keyword_type": 1
        }
    }]
  ```


### Business Channel
* Added `SHOPPING_BRAND` to business channel type.
* Business channels of type `SHOPPING_BRAND` cannot be registered using API.


### Ad
* Added `SHOPPING_BRAND_AD` to ad type.
* Ad of type `SHOPPING_BRAND_AD` cannot be registered using API.


### Ad Extension
*  Ad Extension types include `SHOPPING_BRAND_VIDEO`, `SHOPPING_BRAND_IMAGE`, and `SHOPPING_BROADCAST`.
* Added ad extension type cannot be registered using API.

### Product Group
* A new product group will be added.
* Product group has linked information in the shopping mall.
* Product groups are linked to advertiser accounts and one product group can be linked to multiple adgroups.
* The NVMID used by the product group can be viewed on Naver Shopping.

* Product Group

  column | type | description 
  --------|------|-----
  nccProductGroupId | string | product group ID
  customerId | number | customer ID
  nccBusinessChannelId | string | business channel ID
  name | string | Name of Product Group
  registrationMethod | string	| The value indicating whether the product is a full or optional registration. EACH: Register selection, WHOLE: Register All
  registeredProductType | string | Value indicating whether the Biz channel selected when registering a product group is generic or catalog-type. GENERAL: Generic, CATALOG: Catalog
  mallId | string | Mall ID
  mallName | string | Mall name
  brandNo | string | Brand NO or Brand SEQ
  brandName | string | Brand name
  attrJson | ProductGroupAttrJson | Product group attribute JSON
  regTm |	string | Product group creation time
  editTm | string | Product group last modified time
  numberOfAdgroups | number | The number of adgroups using a product group

* Product group attribute JSON (ProductGroupAttrJson)

  column | type | description
  --------|------|------
  productNvmids | string[] | NVMID list of products to be exposed if the registration method value of the product group is EACH (in order of exposure preference)
  excludeNvmids | string[] | NVMID list of products to be excluded from exposure if registration method value of product group is WHOLE
  prvdrId	| string | Provider ID value for shopping if registredProductType in product group is CATALOG

* Product group cannot be registered using API.
* The list of product groups registered in the account can be inquired using the API below.
  
  * Request 
  ```shell
  GET /api/ncc/product-groups
  ```
  * Response Body
  ```json
  [{
	"nccProductGroupId": "pdg-a001-00-000000000000XXXXX",
	"customerId": 1234567890,
	"nccBusinessChannelId": "bsn-a001-00-0000000000XXXXX",
	"name": "product_group_name#1",
	"registrationMethod": "WHOLE",
	"registeredProductType": "CATALOG",
	"mallId": "mall-id",
	"mallName": "mall_name",
	"brandNo": "brand_no",
	"brandName": "brand_name",
	"attrJson": {
		"prvdrId": "provider_id"
	},
	"regTm": "2021-03-04T06:51:56.000Z",
	"editTm": "2021-03-04T06:51:56.000Z",
	"numberOfAdgroups": 1
  }, {
	"nccProductGroupId": "pdg-a001-00-000000000000XXX",
	"customerId": 318734,
	"nccBusinessChannelId": "bsn-a001-00-0000000000XXXXX",
	"name": "product_group_name#2",
	"registrationMethod": "EACH",
	"registeredProductType": "CATALOG",
	"mallId": "mall-id2",
	"mallName": "mall_name2",
	"brandNo": "brand_no",
	"brandName": "brand_name",
	"attrJson": {
		"prvdrId": "942041",
		"productNvmids": ["1234567890", "0987654321", "1234512345"]
	},
	"regTm": "2021-03-09T03:13:04.000Z",
	"editTm": "2021-03-09T03:13:04.000Z",
	"numberOfAdgroups": 0
  }]
  ```

### Report
* Add genderNm/ageRangeNm breakdown to /stats API in shopping campaign report.
* Breakdown genderNm/ageRangeNm can be used only for shopping campaign report. 
* Add topImpRtp field to /stats API in shopping-brand ad report
* topImpRto field will return values after impression start. (March 31, 2021)

  * Request
  ```shell
  GET /stats{?id,fields,timeRange,datePreset,timeIncrement,breakdown}
  GET /stats{?ids,fields,timeRange,datePreset,timeIncrement,breakdown}
  ```
