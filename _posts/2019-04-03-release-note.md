---
categories: [release]
---

### 광고 그룹
* 2019년 04월 03일 광고그룹에 신규 자동입찰 프로퍼티가 추가 됩니다. ([공지사항 보기](https://saedu.naver.com/notice/view.nhn?notiSeq=3476))
* 자동입찰 프로퍼티는 `systemBiddingType` 이며 `NONE`,`ML` 값을 가집니다.
  * `NONE`: 자동입찰 사용안함.
  * `ML`: 자동입찰 사용함.
* 자동입찰 프로퍼티를 설정하지 않을 경우 `NONE` 값이 적용 됩니다.
* 자동입찰 프로퍼티는 `파워링크` 유형 캠페인에 적용되며, 다른 캠페인에서 사용할 경우 오류가 발생합니다.
* 자동입찰 프로퍼티를 사용으로 설정 하고, 하루 예산을 설정하지 않을 경우 오류가 발생합니다.
* 자동입찰 프로퍼티를 사용으로 설정 하고, 입찰가를 입력할 경우 오류가 발생합니다.

### Adgroup
* April 03, 2019 The automatic bidding property will be added to the adgroup. ([See announcement](https://saedu.naver.com/notice/view.nhn?notiSeq=3476))
* The automatic bidding property is `systemBiddingType` and has the values `NONE`, `ML`.
  * `NONE`: unuse.
  * `ML`: use.
* If you do not set the automatic bidding property, the `NONE` value is applied.
* The automatic bidding property applies to `WEB_SITE` type campaigns, which will cause errors when used in other type campaigns.
* If you set the automatic bidding property to `ML`, an error will occur if you do not set a daily budget.
* If you set the automatic bidding property to `ML` and enter a bid amount, an error will occur.
