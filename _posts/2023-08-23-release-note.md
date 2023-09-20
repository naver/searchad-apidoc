---
categories: [release]
---

#### 2023년 8월 23일, 파워링크 캠페인 광고 그룹에 이용자 세그먼트(BETA) 타겟팅 기능이 추가됩니다.([공지 보기](https://saedu.naver.com/notice/view.naver?notiSeq=4151))


### 기존 광고 객체 변경
* Criterion 광고 객체의 유형에 `이용자 세그먼트(Beta)` 이 추가 되었습니다.
* Criterion 광고 객체는 `지역`, `요일시간`, `성별`, `연령(대)`, `이용자 세그먼트(Beta)` 타겟팅을 지원합니다.
* Criterion
  ```javascript
  {
    dictionaryCode: string            // Criterion Dictionary Code
    ownerId: string                   // 광고 그룹 ID
    customerId: number                // 광고주 번호
    type: DictionaryType              // Criterion 종류 'SD', 'AG', 'GN', 'RL', 'RP', 'AD'
    value: string                     // Criterion 값, type=RP일 경우 위도, 경도, 반경이 json형식으로 저장
    bidWeight: number                 // 입찰 가중치: 50 ~ 500
    negative: boolean                 // 노출 제외 여부
    enable: boolean                   // Criterion 사용 여부
    delFlag: boolean                  // 삭제 여부
    regTm: string                     // 등록 시각
    delTm: string                     // 삭제 시각
    editTm: string                    // 수정 시각
    codeName: string                  // Criterion Dictionary Code 이름
  }

  ```

* Dictionary
  ```javascript
  {
      dictionaryCode: string
      name?: string
      type: CriterionDictionaryType
      value?: string
      delFlag: boolean
  }
  ```

* Dictionary Type
  ```javascript
  enum DictionaryType {
    SCHEDULE = 'SD', // 요일/시간
    GENDER = 'GN', // 성별
    AGE = 'AG', // 연령대
    REGIONAL = 'RL', // 지역
    PROXIMITY = 'RP', // 반경
    ALL_REGIONAL = 'ALL_REGIONAL', // 지역 +  반경,
    AUDIENCE = 'AD', // 이용자 세그먼트(Beta)
  }
  ```

### 타겟팅 변경 사항
* 기존 `지역`, `요일시간`, `성별`, `연령(대)` 변경 API에 , `이용자 세그먼트(Beta)`가 추가 제공됩니다.
* 광고그룹 유형별 지원되는 타겟팅과 입찰가 가중치 지원 여부는 아래와 같습니다.

  광고그룹 유형 | 요일/시간 | 지역 | 성별 | 연령대 | 이용자 세그먼트(Beta)
  ----------|---------|-----|-----|------|-----
  파워링크 유형 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰 가중치) 지원
  쇼핑몰 상품 유형 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 미지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | 미지원
  제품 카탈로그 유형 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 미지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | 미지원
  쇼핑 브랜드 유형 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 미지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | 미지원
  파워 컨텐츠 유형 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원| 미지원 
  브랜드 검색 유형 | 미지원 | 미지원 | 미지원 | 미지원 | 미지원
  브랜드 존 유형 | 미지원 | 미지원 | 미지원 | 미지원 | 미지원
  지역 소상공인 유형 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 지원, 입찰가가중치 미지원 | 미지원| 미지원
  플레이스 검색 유형 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 지원, 입찰가가중치 미지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원| 미지원


#### 타겟팅 조회
  * Request 
    ```shell
      GET /ncc/criterion/{광고 그룹 ID}?type={CriterionDictionaryType}
    ```
  * Response
    ```
    [{
	  "dictionaryCode": "SDWED0009",
	  "codeName": "수요일 00시부터 09시까지",
	  "ownerId": "grp-a001-01-0000000000XXXXX",
	  "customerId": 123456789,
	  "type": "SD",
	  "value": null,
	  "bidWeight": 100,
	  "negative": false,
	  "enable": true,
	  "regTm": "2022-03-14T11:15:50.000Z",
	  "editTm": "2022-03-14T11:15:50.000Z",
	  "delFlag": false
    }, ...]
    ```
#### 타겟팅 입찰가 가중치 변경
* 등록된 타겟팅의 입찰가 가중치를 변경할 수 있습니다.

* Request
  ```shell
  PUT /ncc/criterion/{광고그룹 ID}/bidWeight?codes={dictionaryCode 리스트}&bidWeight={입찰가 가중치 50 ~ 500}
  ex) PUT /ncc/criterion/grp-a001-01-0000000000XXXXX/bidWeight?codes=SDWED0009,SDSUN0024&bidWeight=50
  ```
* Response
  ```json
  [{
    "dictionaryCode": "SDWED0009",
    "codeName": "수요일 00시부터 09시까지",
    "ownerId": "grp-a001-01-0000000000XXXXX",
    "customerId": 123456,
    "type": "SD",
    "value": null,
    "bidWeight": 50,
    "negative": false,
    "enable": true,
    "regTm": "2022-03-14T11:15:50.000Z",
    "editTm": "2022-03-14T11:15:50.000Z",
    "delFlag": false
  },{
    "dictionaryCode": "SDSUN0024",
    "codeName": "일요일 00시부터 24시까지",
    "ownerId": "grp-a001-01-0000000000XXXXX",
    "customerId": 123456,
    "type": "SD",
    "value": null,
    "bidWeight": 50,
    "negative": false,
    "enable": true,
    "regTm": "2022-03-14T11:15:50.000Z",
    "editTm": "2022-03-14T11:15:50.000Z",
    "delFlag": false
  }]
  ```

#### 타겟팅 변경
* 타겟팅 유형별로 타겟팅을 변경할 수 있습니다.
* 타겟팅 변경시 Request Body에 `포함되지 않는 코드는 모두 사용안함 처리`가 되니 주의를 요합니다.
* 반경 타겟티의 추가의 경우 dictionaryCode에 'Proximity' 문자열을 입력해 주세요. 서버에 저장후 정상적인 code로 반환이 됩니다.
* Request
  ```shell
    PUT /ncc/criterion/{광고그룹 ID}/{dictionary type}
  ```
* Request Body
  ```json
  [{
    "dictionaryCode": "SDWED0009",
    "codeName": "수요일 00시부터 09시까지",
    "ownerId": "grp-a001-01-0000000000XXXXX",
    "customerId": 123456,
    "type": "SD",
    "value": null,
    "bidWeight": 50,
    "negative": false,
    "enable": true
  }, {
    "dictionaryCode": "SDSUN0024",
    "codeName": "일요일 00시부터 24시까지",
    "ownerId": "grp-a001-01-0000000000XXXXX",
    "customerId": 123456,
    "type": "SD",
    "value": null,
    "bidWeight": 50,
    "negative": false,
    "enable": true
  }]
  ```
#### 타겟팅 코드 조회
* 광고그룹에서 지원되는 타게팅 코드를 조회할 수 있습니다.
* 반경(PROXIMITY)는 조회할 수 없습니다.
* Request
  ```shell
    GET /ncc/criterion-dictionary/{dictionary type}
  ```
* Request Body
  ```json
  [{
	"dictionaryCode": "AG0013",
	"type": "AG",
	"name": "14세 이하",
	"value": null,
	"regTm": "2022-03-14T11:15:50.000Z",
	"editTm": "2022-03-14T11:15:50.000Z",
	"delFlag": false
  }, {
  	"dictionaryCode": "AG1418",
  	"type": "AG",
  	"name": "14세 ~ 18세",
  	"value": null,
  	"regTm": "2022-03-14T11:15:50.000Z",
  	"editTm": "2022-03-14T11:15:50.000Z",
  	"delFlag": false
  }, ...]
  ```
* 타겟팅 코드는 아래의 규칙으로 생성이 됩니다.
* 요일 시간 코드
  * 'SD' + 요일코드(3) + 시작시간(2) + 종료시간(2)
  * 요일코드: SUN, MON, TUE, WED, THU, FRI, SAT
* 성별 코드
  * 'GN' + M(남성) / F (여성) / U (알수 없음)
* 지역 코드
  * 'RL' + 법정동 코드(2~8)
* 반경 코드
  * 'RP' + 순번(9)
* 연령대 코드
  * AG + 시작나이(2) + 종료나이(2), XX: 알수 없음
* 잠재 고객
  * AD + 00 (캠페인 유형 코드) + 00 (잠재 고객 유형 코드) +  판매셋 번호 


#### 이용자 세그먼트(Beta) 노출 설정
* 이용자 세그먼트(Beta)의 노출 설정을 변경할 수 있습니다.
* negative Parameter의 값이 false일 경우 해당 이용자 세그먼트에 대해서는 광고 노출이 되지 않습니다.
* Request
  ```shell
    PUT /ncc//criterion/{ownerId}/negative?codes={타겟팅 코드}&negative={true/false}
  ```

#### 이전 타겟팅 변경에 대한 자세한 내용은 [2022-04-26 Release Note](http://naver.github.io/searchad-apidoc/#/release-notes)를 참고하세요.




----

#### On August 23, 2023, Audience Targeting (BETA) will be added to PowerLink Campaign adgroups.([View announcement](https://saedu.naver.com/notice/view.naver?notiSeq=4151))

### Changes to existing ad objects
* Added Audience (Beta) to the Criterion ad object type.
* Criterion ad objects support `Region`, `Schedule`, `Gender`, `Age Range`, `Audience (Beta)` targeting.
* Criterion
  ```javascript
  {
    dictionaryCode: string // Criterion Dictionary Code
    ownerId: string // AdGroup ID
    customerId: number // Advertiser number
    type: DictionaryType // Criterion type 'SD', 'AG', 'GN', 'RL', 'RP', 'AD'
    value: string // Criterion value, latitude, longitude, and radius in json format if type=RP
    bidWeight: number // Bid weight: 50 ~ 500
    negative: boolean // Whether to exclude impressions
    enable: boolean // Whether to use Criterion or not
    delFlag: boolean // Whether to delete the flag
    regTm: string // Registration time
    delTm: string // Deletion time
    editTm: string // Edit time
    codeName: string // Criterion Dictionary Code name
  }

  ```


* Dictionary
  ```javascript
  {
      dictionaryCode: string
      name?: string
      type: CriterionDictionaryType
      value?: string
      delFlag: boolean
  }
  ```

* Dictionary Type
  ```javascript
  enum DictionaryType {
    SCHEDULE = 'SD', // Schedule
    GENDER = 'GN', // Gender
    AGE = 'AG', // Age
    REGIONAL = 'RL', // Region
    PROXIMITY = 'RP', // Proximity
    ALL_REGIONAL = 'ALL_REGIONAL', // Region +  Proximity,
    AUDIENCE = 'AD', // Audience (Beta)
  }
  ```

  ### Targeting changes
* To the existing `Region`, `Schedule`, `Gender`, and `Age Range` change APIs, we've added `Audience (Beta)`.
* Supported targeting and bid weighting for each ad group type is as follows.

  Ad Group Type | Schedule | Region | Gender | Age Group | Audience (Beta)
  ----------|---------|-----|-----|------|-----
  Power Link Type | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support
  Shopping mall product type | Targeting support, Bid weight not supported | Targeting not supported | (Targeting, Bid weight) support | (Targeting, Bid weight) support | Not supported
  Product catalog type | Targeting support, Bid weight not supported | Targeting not supported | (Targeting, Bid weight) support | (Targeting, Bid weight) support | Not supported
  Shopping Brand Type | Targeting support, Bid weight not supported | Targeting not supported | (Targeting, Bid weight) support | (Targeting, Bid weight) support | Not supported
  Power Content Type | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support | Not supported
  Brand Search Type | Not supported | Not supported | Not supported | Not supported
  brand zone type | Not supported | Not supported | Not supported | Not supported
  Place type | Targeting support, Bid weight not supported | Targeting support, Bid weight not supported | Targeting support, Bid weight not supported | Targeting support | Bid weight not supported | Not supported
  Local Ad type | Targeting support, Bid weight not supported | Targeting support, Bid weight not supported | (Targeting, Bid weight) support | (Targeting, Bid weight) support | Not supported


#### Targeting inquiry
  * Request 
    ```shell
      GET /ncc/criterion/{Adgroup ID}?type={CriterionDictionaryType}
    ```
  * Response
    ```
    [{
	  "dictionaryCode": "SDWED0009",
	  "codeName": "수요일 00시부터 09시까지",
	  "ownerId": "grp-a001-01-0000000000XXXXX",
	  "customerId": 123456789,
	  "type": "SD",
	  "value": null,
	  "bidWeight": 100,
	  "negative": false,
	  "enable": true,
	  "regTm": "2022-03-14T11:15:50.000Z",
	  "editTm": "2022-03-14T11:15:50.000Z",
	  "delFlag": false
    }, ...]
    ```
#### Change in targeting bid weight
* You can change the bid weight for registered targets.

* Request
  ```shell
  PUT /ncc/criterion/{adgroup ID}/bidWeight?codes={dictionaryCode list}&bidWeight={bid weight 50 ~ 500}
  ex) PUT /ncc/criterion/grp-a001-01-0000000000XXXXX/bidWeight?codes=SDWED0009,SDSUN0024&bidWeight=50
  ```
* Response
  ```json
  [{
    "dictionaryCode": "SDWED0009",
    "codeName": "수요일 00시부터 09시까지",
    "ownerId": "grp-a001-01-0000000000XXXXX",
    "customerId": 123456,
    "type": "SD",
    "value": null,
    "bidWeight": 50,
    "negative": false,
    "enable": true,
    "regTm": "2022-03-14T11:15:50.000Z",
    "editTm": "2022-03-14T11:15:50.000Z",
    "delFlag": false
  },{
    "dictionaryCode": "SDSUN0024",
    "codeName": "일요일 00시부터 24시까지",
    "ownerId": "grp-a001-01-0000000000XXXXX",
    "customerId": 123456,
    "type": "SD",
    "value": null,
    "bidWeight": 50,
    "negative": false,
    "enable": true,
    "regTm": "2022-03-14T11:15:50.000Z",
    "editTm": "2022-03-14T11:15:50.000Z",
    "delFlag": false
  }]
  ```

#### Change targeting
* Targeting can be changed by targeting type.
* Please note that when you change the targeting, all code that is not included in the Request Body will be disabled.
* If you want to add a Proximity target, enter the "Proximity" string in dictionaryCode. It will be saved on the server and returned to normal code.
* Request
  ```shell
    PUT /ncc/criterion/{Adgroup ID}/{dictionary type}
  ```
* Request Body
  ```json
  [{
    "dictionaryCode": "SDWED0009",
    "codeName": "수요일 00시부터 09시까지",
    "ownerId": "grp-a001-01-0000000000XXXXX",
    "customerId": 123456,
    "type": "SD",
    "value": null,
    "bidWeight": 50,
    "negative": false,
    "enable": true
  }, {
    "dictionaryCode": "SDSUN0024",
    "codeName": "일요일 00시부터 24시까지",
    "ownerId": "grp-a001-01-0000000000XXXXX",
    "customerId": 123456,
    "type": "SD",
    "value": null,
    "bidWeight": 50,
    "negative": false,
    "enable": true
  }]
  ```
#### Targeting code inquiry
* You can check the target code supported by the adgroup.
* The PROXIMITY cannot be inquired.

* Request
  ```shell
    GET /ncc/criterion-dictionary/{dictionary type}
  ```
* Request Body
  ```json
  [{
	"dictionaryCode": "AG0013",
	"type": "AG",
	"name": "14세 이하",
	"value": null,
	"regTm": "2022-03-14T11:15:50.000Z",
	"editTm": "2022-03-14T11:15:50.000Z",
	"delFlag": false
  }, {
  	"dictionaryCode": "AG1418",
  	"type": "AG",
  	"name": "14세 ~ 18세",
  	"value": null,
  	"regTm": "2022-03-14T11:15:50.000Z",
  	"editTm": "2022-03-14T11:15:50.000Z",
  	"delFlag": false
  }, ...]
  ```
* Targeting codes are generated by the following rules:
* Schedule code
  * "SD" + day of the week code (3) + start time (2) + end time (2)
  * Day code: SUN, MON, TUE, WED, THU, FRI, SAT
* Gender code
  * "GN" + M (male) / F (female) / U (unknown)
* Region code
  * "RL" + legal dong code (2-8).
* Proximity code
  * "RP" + sequence (9)
* Age range code
  * AG + start age (2) + end age (2), XX: Unknown
* Audience
  * AD + 00 (Campaign type code) + 00 (Audience type code) + Salesset number 

#### Audience (Beta) exposure settings
* You can change the exposure settings for an audience (Beta).
* If the value of the 'negative' parameter is false, the ad will not be exposed for that audience.
* Request
  ```shell
    PUT /ncc//criterion/{ownerId}/negative?codes={Dictionary code}&negative={true/false}
  ```


#### For more information about previous targeting changes, see the "2022-04-26 Release Note" at http://naver.github.io/searchad-apidoc/#/release-notes.
