---
categories: [release]
---

#### 2022년 4월 26일에 광고그룹의 타겟팅 관리 방식이 변경됩니다. ([공지사항](https://saedu.naver.com/notice/view.naver?notiSeq=3896))

### Sandbox 환경 안내
* 새로운 API를 사용해볼 수 있는 Sandbox API가 제공됩니다.
* Sandbox 환경에 접속할 수 있는 방법은 4월 1일에 제공되어 4월 25일까지 유지됩니다.
* Sandbox 환경에는 기존에 등록한 캠페인, 광고그룹, 광고, 키워드, 확장소재, 비즈니스 채널은 제공하지 않습니다.
* 4월 1일에 제공되는 API는 아래의 광고 관리 관련 API입니다.
* 지표 관련 API의 제공일정은 추후 공지할 예정입니다.

### 새로운 광고 객체 추가
* `지역`, `요일시간`, `성별`, `연령(대)` 타겟팅을 지원하는 새로운 광고객체가 추가되었습니다.
* Criterion
  ```javascript
  {
    dictionaryCode: string            // Criterion Dictionary Code
    ownerId: string                   // 광고 그룹 ID
    customerId: number                // 광고주 번호
    type: DictionaryType              // Criterion 종류 'SD', 'AG', 'GN', 'RL', 'RP'
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
    ALL_REGIONAL = 'ALL_REGIONAL', // 지역 +  반경
  }
  ```

### 광고그룹 변경 사항
* 개별 광고그룹 조회 API의 결과에서 `지역`, `요일시간`, `성별`, `연령(대)` 정보가 더이상 지원되지 않습니다.
* 광고 그룹 생성 API 호출시 `지역`, `요일시간`, `성별`, `연령(대)` 타겟팅은 기본 설정 (타겟팅 사용안함)으로 설정됩니다.
* 광고 그룹 생성 API 호출시 `지역`, `요일시간`, `성별`, `연령(대)` 타겟팅이 포함된 경우 무시됩니다.
* `지역 소상공인 광고그룹`을 API를 이용하여 생성할 경우 선택한 비즈채널의 주소와 가장 가까운 5개의 동이 자동으로 추가됩니다. 추가된 지역의 변경은 아래의 신규 지원 API를 이용하여 변경할 수 있습니다.

### 타겟팅 변경 사항
* `지역`, `요일시간`, `성별`, `연령(대)` 의 타겟팅 변경 전용 API가 제공됩니다.
* 광고그룹 유형별 지원되는 타겟팅과 입찰가 가중치 지원 여부는 아래와 같습니다.

  광고그룹 유형 | 요일/시간 | 지역 | 성별 | 연령대 
  ----------|---------|-----|-----|------
  파워링크 유형 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 
  쇼핑몰 상품 유형 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 미지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 
  제품 카탈로그 유형 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 미지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 
  쇼핑 브랜드 유형 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 미지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 
  파워 컨텐츠 유형 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원 
  브랜드 검색 유형 | 미지원 | 미지원 | 미지원 | 미지원 
  브랜드 존 유형 | 미지원 | 미지원 | 미지원 | 미지원 
  지역 소상공인 유형 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 지원, 입찰가가중치 미지원 | 미지원
  플레이스 검색 유형 | 타겟팅 지원, 입찰가가중치 미지원 | 타겟팅 지원, 입찰가가중치 미지원 | (타겟팅, 입찰가가중치) 지원 | (타겟팅, 입찰가가중치) 지원


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
* 등록된 타겟티의 입찰가 가중치를 변경할 수 있습니다.

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

---
#### On April 26, 2022, the advertising group's targeting management method will be changed. ([Notice](https://saedu.naver.com/notice/view.naver?notiSeq=3896))

### Sandbox Environmental Guide
* Sandbox API will be available for you to try new API.
* Access to the Sandbox environment will be provided on April 1st and will be maintained until April 25th.
* Sandbox does not offer previously registered campaigns, advertising groups, advertising, keywords, extension materials, or business channels.
* The API to be provided on April 1st is the following API related to advertising management.
* The schedule for providing API related to indicators will be announced later.

### Add a new advertising object
* New advertising objects have been added to support targeting 'Region', 'Schedule', 'Gender' and 'Age range'.
* Criterion
  ```javascript
  {
    dictionaryCode: string            // Criterion Dictionary Code
    ownerId: string                   // adgroup ID
    customerId: number                // 광고주 번호
    type: DictionaryType              // Criterion type 'SD', 'AG', 'GN', 'RL', 'RP'
    value: string                     // Criterion value
    bidWeight: number                 // bid weight: 50 ~ 500
    negative: boolean                 // exposure on/off
    enable: boolean                   // enable criterion
    delFlag: boolean                   
    regTm: string                      
    delTm: string                      
    editTm: string                     
    codeName: string                   
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
    ALL_REGIONAL = 'ALL_REGIONAL', // 지역 +  반경
  }
  ```

### Adgroup changes
* Information on 'Region', 'Schedule', 'Gender' and 'Age range' are no longer supported in the results of the individual adgroup inquiry API.
* When calling the adgroup creation API, targeting 'Region', 'Schedule', 'Gender' and 'Age range' are set to the default setting (targeting disabled).
* When calling the adgroup creation API, it is ignored if targeting 'Region', 'Schedule', 'Gender' and 'Age range' are included.
* When creating a 'place type adgroup' using API, the five dongs closest to the address of the selected biz channel will be automatically added. Changes to the added area can be made using the new support API below.

### Target chaanges
* Targeting change API for 'Region', 'Schedule', 'Gender', and 'Age range' is provided.
* Whether or not to support the weight of supported targeting and bidding price by adgroup type is as follows.

Adgroup type | Schedule | Region | Gender | Age range
----------|---------|-----|-----|------
Power Link Type | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support
Shopping mall product type | Targeting support, Bid weight not supported | Targeting not supported | (Targeting, Bid weight) support | (Targeting, Bid weight) support
Product catalog type | Targeting support, Bid weight not supported | Targeting not supported | (Targeting, Bid weight) support | (Targeting, Bid weight) support
Shopping Brand Type | Targeting support, Bid weight not supported | Targeting not supported | (Targeting, Bid weight) support | (Targeting, Bid weight) support
Power Content Type | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support | (Targeting, Bid weight) support
Brand Search Type | Not supported | Not supported | Not supported
brand zone type | Not supported | Not supported | Not supported
Place type | Targeting support, Bid weight not supported | Targeting support, Bid weight not supported | Targeting support, Bid weight not supported | Targeting support | Bid weight not supported
Local Ad type | Targeting support, Bid weight not supported | Targeting support, Bid weight not supported | (Targeting, Bid weight) support | (Targeting, Bid weight) support

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

#### 타겟팅 변경
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
