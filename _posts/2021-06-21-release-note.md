---
categories: [release]
---

#### 2021년 6월 21일에 플레이스 광고가 추가 됩니다. ([공지사항](https://saedu.naver.com/notice/view.nhn?notiSeq=3797&catg=&fixYn=Y&searchOpt=all&keyword=))


### 광고 그룹
* 광고 그룹 유형에 `플레이스 검색(LOCAL_AD)` 유형이 추가 됩니다.
* 플레이스 검색 유형 광고 그룹은 플레이스 캠페인 내부에서만 유효합니다.
* 플레이스 검색 유형 광고 그룹은 플레이스 유형 비즈채널만 선택할 수 있습니다.
* 플레이스 검색 유형 광고 그룹 생성 예제
  * Request
  ```shell
  POST /api/ncc/adgroups
  ```
  * Request Body
  ```json
    {
      ... 기존 광고그룹 생성과 동일
	  "adgroupType": "LOCAL_AD"
    }
  ```



### 소재
* 소재 유형에 `플레이스 검색(LOCAL_AD)`유형 소재가 추가 되었습니다.
* `플레이스 검색(LOCAL_AD)` 유형의 소재는 API를 이용하여 등록할 수 없습니다.


### 확장소재
* 확장소재 유형에 `플레이스 스마트 주문(PLACE_SMART_ORDER)`가 추가 되었습니다.
* 추가된 확장소재 유형은 API를 이용하여 등록할 수 없습니다.


---


#### Place ads will be added on June 21, 2021. ([Notice](https://saedu.naver.com/notice/view.nhn?notiSeq=3797&catg=&fixYn=Y&searchOpt=all&keyword=))

### Adgroup
* The type 'Place Search (LOCAL_AD)' is added to the ad group type.
* Place search type adgroups are valid only within PLACE campaigns.
* Place search type adgroups can only select PLACE type business channels.
* Example of creating a place search type adgroup

  * Request
  ```shell
  POST /api/ncc/adgroups
  ```
  * Request Body
  ```json
    {
      ... Same as creating an existing adgroup
	  "adgroupType": "LOCAL_AD"
    }
  ```


### Ad
* Added `LOCAL_AD` to ad type.
* Ad of type `LOCAL_AD` cannot be registered using API.


### Ad Extension
*  Ad Extension types include `PLACE_SMART_ORDER`.
* Added ad extension type cannot be registered using API.
