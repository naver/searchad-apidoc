---
categories: [release]
---

#### AdExtension
* `CATALOG` 광고 그룹 유형 및 `CATALOG_AD` 소재 유형 하위에 등록 가능한 신규 확장 소재들이 추가됩니다.
  * 신규 유형
	  * `CATALOG_PURCHASE_CONDITION`, `CATALOG_BRAND_MESSAGE`
* 광고 그룹에 등록 가능한 유형은 아래와 같습니다.
	* `CATALOG_BRAND_MESSAGE`
* 소재에 등록 가능한 유형은 아래와 같습니다.
  * `CATALOG_PURCHASE_CONDITION`, `CATALOG_BRAND_MESSAGE`
* `adExtension` 속성의 샘플은 아래 gist 참조하시면 됩니다.
  * https://gist.github.com/naver-searchad/f8e941f61b9152972feb676689046b87
* `CATALOG_DETAIL` 유형에 상세 정보는 `REVIEW` 만 등록가능합니다.


* new types under `CATALOG` adgroup, `CATALOG_AD` ad will be added
* here are new types.
  * `CATALOG_PURCHASE_CONDITION`, `CATALOG_BRAND_MESSAGE`
* available under adgroup
	* `CATALOG_PROMOTION`, `CATALOG_EVENT`, `CATALOG_MOVIE`
* available under ad
	* `CATALOG_PURCHASE_CONDITION`, `CATALOG_BRAND_MESSAGE`
* you can see gist that describes the json sample of `adExtension` property.
  * https://gist.github.com/naver-searchad/f8e941f61b9152972feb676689046b87
* you can register only `REVIEW` detail property of `CATALOG_DETAIL` type.
