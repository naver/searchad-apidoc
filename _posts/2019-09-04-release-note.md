---
categories: [release]
---

#### AdExtension
* `WEB_SITE` 광고 그룹 유형 하위에 등록 가능한 신규 확장 소재 `블로그 리뷰` 유형이 추가됩니다.
  * 유형 이름: `NAVER_BLOG_REVIEW`
  * 네이버 블로그 서비스 (https://blog.naver.com) 포스트를 활용한 확장 소재 유형
  * 하나의 광고그룹에 최대 5개까지 등록 가능합니다
* `referenceKey` 속성 값에는 블로그 포스트 ID 가 대응됩니다.
* 사용자 입력이 요구되지 않으므로 `adExtension` 속성은 `null` 입니다.
* 해당 유형은 `enable` 속성 값이 블로그 포스트 상태 및 애드포스트 (https://adpost.naver.com) 의 광고 사용 동의 여부에 따라서 바뀔 수 있습니다.

* Under `WEB_SITE` Adgroup, new adExtension type (blog review) is will be added.
  * type name: `NAVER_BLOG_REVIEW`
  * this type connects with the post entity of naver blog service (https://blog.naver.com).
  * you can register max 5 entity under one adgroup.
* The value of `referenceKey` is the ID of naver blog post.
* This type does not require user input. So `adExtension` value is `null`.
* The value of `enable` property depends on either naver blog post status or ad usage agreement of adpost (https://adpost.naver.com).
