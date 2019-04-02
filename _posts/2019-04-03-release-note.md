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
* 자동입찰 프로퍼티를 사용으로 설정할 경우 하루 예산을 설정하지 않을 경우 오류가 발생합니다.
* 자동입찰 프로퍼티를 사용으로 설정 하고, 입찰가를 입력할 경우 오류가 발생합니다.

* 자동입찰 사용 설정을 하시면, 아래 고지 내용을 읽고 동의한 것으로 간주됩니다.
  * 이 기능은 광고 성과의 유지 및 향상을 보장하지 않는 단순 광고 운영 편의 기능입니다. [도움말:자동입찰 동작 방식](https://saedu.naver.com/help/faq/ncc/view.nhn?faqSeq=690)
  * 자동입찰 사용 시 반드시 하루예산을 설정해야 합니다. 개별 입찰가가 설정된 키워드에는 자동 조정된 그룹의 기본입찰가가 적용되지 않습니다.
  * 장애 또는 광고주님의 과실 등으로 인한 '자동입찰 기능'의 오작동, 미실행 등에 대하여 네이버는 원칙적으로 책임지지 않습니다.

### Adgroup
* April 03, 2019 The automatic bidding property will be added to the adgroup. ([See announcement](https://saedu.naver.com/notice/view.nhn?notiSeq=3476))
* The automatic bidding property is `systemBiddingType` and has the values `NONE`, `ML`.
  * `NONE`: unuse.
  * `ML`: use.
* If you do not set the automatic bidding property, the `NONE` value is applied.
* The automatic bidding property applies to `WEB_SITE` type campaigns, which will cause errors when used in other type campaigns.
* If you set the automatic bidding property to `ML`, an error will occur if you do not set a daily budget.
* If you set the automatic bidding property to `ML` and enter a bid amount, an error will occur.

* If you enable the automatic bidding, you are regarded as you read and agree the below
  * This feature may enhance your convenience in ad operations, but does not guarantee either clicks or conversions. Help: How Auto Bidding works
  * To use Auto Bidding, you should set your daily budget. If you set a different bid for one of your keywords, the bid will be used instead of an ad group default bid.
  * NAVER is not responsible for any malfunctions or non-executions of Automatic Bidding resulting from system failure or your mistakes.
