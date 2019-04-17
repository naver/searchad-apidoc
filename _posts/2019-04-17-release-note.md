---
categories: [release]
---

### 광고 그룹
* 2019년 04월 17일 쇼핑 캠페인의 광고그룹에 컨텐츠 네트워크 입찰가와 가중치 값이 적용됩니다. ([공지사항 보기](https://saedu.naver.com/notice/view.nhn?notiSeq=3490&catg=1&fixYn=N&searchOpt=all&keyword=))
* 컨텐츠 네트워크 입찰 가중치는 `useCntsNetworkBidWeight`, `contentsNetworkBidWeight` 프로퍼티에 설정 가능합니다.
* 컨텐츠 네트워크 입찰 가중치의 기본 값은 `사용안함`입니다.
* 쇼핑 캠페인이외 다른 캠페인에서는 `useCntsNetworkBidWeight`, `contentsNetworkBidWeight` 프로퍼티가 무시 됩니다.

#### JSON 예제
* 컨텐츠 네트워크 입찰 사용안함.
  ```
  {
    useCntsNetworkBidWeight: false,
    useCntsNetworkBidAmt: false
  }
  ```
* 컨텐츠 네트워크 입찰가 사용.
  ```
  {
    useCntsNetworkBidAmt: true,
    useCntsNetworkBidWeight: false,
    contentsNetworkBidAmt: 700     // 700원
  }
  ```
* 컨텐츠 네트워크 입찰 가중치 사용.
  ```
  {
    useCntsNetworkBidAmt: false,
    useCntsNetworkBidWeight: true,
    contentsNetworkBidWeight: 120   // 120%
  }
  ```

### Adgroup
* April 17, 2019 Ad groups in Shopping campaigns have content network bid amount and weight values. ([Notice](https://saedu.naver.com/notice/view.nhn?notiSeq=3490&catg=1&fixYn=N&searchOpt=all&keyword=))
* The content network bid weights can be set in the `useCntsNetworkBidWeight` and` contentsNetworkBidWeight` properties.
* The default value for content network bid weights is `unuse`.
* For campaigns other than Shopping campaigns, the `useCntsNetworkBidWeight` and` contentsNetworkBidWeight` properties are ignored.

#### JSON Examples
* Unuse content network bid weight.
  ```
  {
    useCntsNetworkBidWeight: false,
    useCntsNetworkBidAmt: false
  }
  ```
* Use content network bid amount
  ```
  {
    useCntsNetworkBidAmt: true,
    useCntsNetworkBidWeight: false,
    contentNetworkBidAmt: 700     // 700 KRW
  }
  ```
* Use content network bid weight
  ```
  {
    useCntsNetworkBidAmt: false,
    useCntsNetworkBidWeight: true,
    contentNetworkBidWeight: 120   // 120%
  }
  ```
