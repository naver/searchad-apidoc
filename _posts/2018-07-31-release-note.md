### Master Report
#### Campaign

   * A `ON/OFF`  column added to `Campaign` master report.
   
No|Field Name|Value|Max.Length|Description
--|--|--|--|--
11|ON/OFF|int|| - 0: ON<br/> - 1: OFF

### Ad Management

#### Campaign
* 새로운 캠페인 유형이 2018년 07월 31일에 추가 됩니다.
* 새로운 캠페인 유형은 `PLACE` 입니다.
* `PLACE` 유형의 캠페인 타입에 대한 자세한 내용은 아래 링크를 참고하세요.
* [공지사항 보기](https://saedu.naver.com/notice/view.nhn?notiSeq=3382)

* A new campaign type will be added on July 31, 2018.
* The new campaign type is `PLACE`.
* To learn more about `PLACE` type campaigns, please see the link below.
* [See announce](https://saedu.naver.com/notice/view.nhn?notiSeq=3382)

#### AD
* 플레이스 캠페인 하위에 등록가능한 소재 신규 유형 "PLACE_AD"가 추가 됩니다.
* 소재에는 광고주가 입력할 내용은 없으므로, 소재 속성 에는 empty json 만 허용됩니다.
* 광고그룹 하위에 단 1개의 소재만 등록 가능합니다.

* The new type of ad, `PLACE_AD` will be added.
* The available value of ad property is only **empty json**.
* You can register only **one** ad per Adgroup.
