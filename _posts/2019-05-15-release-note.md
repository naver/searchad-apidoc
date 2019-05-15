---
categories: [release]
---

#### AdExtension
* `WEB_SITE` 광고 그룹 유형 하위에 등록 가능한 신규 확장 소재 `홍보 영상` 유형이 추가됩니다.
  * 유형 이름: `NAVER_TV_VIDEO`
  * 네이버 TV 서비스 (https://tv.naver.com) 클립 동영상을 활용한 확장 소재 유형
  * 하나의 광고그룹에 최대 5개까지 등록 가능합니다
* 신규 확장 소재는 특정 비즈채널과 연결되어야 하며 이 비즈채널은 네이버 TV 서비스 의 채널과 연동됩니다.
	* channelTp: `NAVER_TV`
* `adExtension` 속성의 샘플은 아래 gist 참조하시면 됩니다.
  * https://gist.github.com/naver-searchad/f8e941f61b9152972feb676689046b87#naver_tv_video
* 확장 소재 Resource 에 새로운 property `enable`이 추가됩니다.
  * 연동상태 여부 속성 입니다. `true` 일 경우에는 정상이며 `false` 인 경우에는 노출제한 상태로 되어 확장 소재 노출을 할 수 없게 됩니다.
  * `false` 로 바뀔 경우에는 연동된 서비스의 특정 엔터티의 상태에 변경사항이 발생하였다는 것을 의미합니다.
  * `NAVER_TV_VIDEO` 유형의 경우 특정 주기마다 네이버 TV 클립에서 광고 노출할 수 없는 조건이 반영되는 경우, 해당 확장 소재 `enable` 속성은 `false`로 변경됩니다.
* 확장 소재의 상태 속성 (`status` property) 에 새로운 값이 추가됩니다.
  * 상태 값: `AD_EXTENSION_ABNORMAL_INTERLOCK`
  * 의미: `enable` 속성이 `false` 이면서 특정 조건을 만족하면 해당 상태값을 가지게 되며 이는 연동된 서비스에 의해 확장 소재를 노출할 수 없다는 의미입니다.

* Under `WEB_SITE` Adgroup, new adExtension type (promotional video) is will be added.
  * type name: `NAVER_TV_VIDEO`
  * this type connects with the clip entity of naver tv service (https://tv.naver.com).
  * you can register max 5 entity under one adgroup.
* This AdExtension should be connected to biz channel which connects with the channel entity of naver tv service.
  * channelTp: `NAVER_TV`
* You can see gist that describes the json sample of `adExtension` property.
  * https://gist.github.com/naver-searchad/f8e941f61b9152972feb676689046b87#naver_tv_video
* New property `enable` of AdExtension resource will be added.
  * This property is the status of external service. When this value is `false`, this AdExtension cannot be exposed.
  * In the case of `NAVER_TV_VIDEO`, if ad related properties of clip changed, then `enable` property of AdExtension updated periodically.
* New value of `status` property will be added.
  * new value: `AD_EXTENSION_ABNORMAL_INTERLOCK`
  * If the value of `enable` property is `false` and some conditions are met, then the value of status is `AD_EXTENSION_ABNORMAL_INTERLOCK`.
