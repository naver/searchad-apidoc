---
categories: [release]
---

#### 2021년 9월 15일에 쇼핑검색광고 브랜드형 상단노출가능입찰가 API가 제공됩니다.

### ESTIMATE
* 상단노출가능입찰가 API(PC/모바일) 신규 제공 
* 키워드 입력 시 품질지수 4단계 기준으로 값 제공 
* 등록 키워드 아이디 입력 시 해당 등록 키워드의 품질 지수 반영하여 제공 
* 최대 200개까지 동시 호출 가능 

  * Request
  ```shell
  GET /api/ncc/estimate/shopping-brand/type/pc_mins
  GET /api/ncc/estimate/shopping-brand/type/mobile_mins
  ```
  * Request Body
  ```
     [
       {"keyword": "keyword1"},
       {"keyword": "keyword2"}
     ]
    or 
     [
       {"nccKeywordId": "nkw-a001-02-000000000000001"},
       {"nccKeywordId": "nkw-a001-02-000000000000002"}
     ]
  ```
  * Response
  ```
     [
       {"keyword":"keyword1","bidAmt":100}
       {"keyword":"keyword2","bidAmt":200}
     ]
    or 
     [
      {"keyword":"keyword3","nccKeywordId":"nkw-a001-02-000000000000001","bidAmt":300}
      {"keyword":"keyword4","nccKeywordId":"nkw-a001-02-000000000000002","bidAmt":400}
     ]
  ```
---

#### A shopping search advertisement brand-type upper exposable bid API is provided on September, 15, 2021. 
### ESTIMATE
* New offer of upper exposable bid API (PC/mobile)
* When entering a keyword, the value is provided based on the 4th level of the quality index
* When entering a registered keyword ID, the quality index of the registered keyword is reflected and provided
* Up to 200 simultaneous calls
 * Request
  ```shell
  GET /api/ncc/estimate/shopping-brand/type/pc_mins
  GET /api/ncc/estimate/shopping-brand/type/mobile_mins
  ```
  * Request Body
  ```
     [
       {"keyword": "keyword1"},
       {"keyword": "keyword2"}
     ]
    or 
     [
       {"nccKeywordId": "nkw-a001-02-000000000000001"},
       {"nccKeywordId": "nkw-a001-02-000000000000002"}
     ]
  ```
  * Response
  ```
     [
       {"keyword":"keyword1","bidAmt":100}
       {"keyword":"keyword2","bidAmt":200}
     ]
    or 
     [
      {"keyword":"keyword3","nccKeywordId":"nkw-a001-02-000000000000001","bidAmt":300}
      {"keyword":"keyword4","nccKeywordId":"nkw-a001-02-000000000000002","bidAmt":400}
     ]
  ```
