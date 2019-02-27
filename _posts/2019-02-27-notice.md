---
categories: [release]
---

## 타겟팅
* 신규 타겟팅이 2019년 02월 27일에 적용됩니다. ([공지사항 보기](https://saedu.naver.com/notice/view.nhn?notiSeq=3454))
* 신규 타겟팅의 `targetTp` 값은 `AD_TAG` 입니다.

* 신규 타겟팅은 쇼핑 캠페인 하위의 카탈로그 광고 소재에 적용되며, 그외 소재에 등록할 때 오류가 발생합니다.
* 등록가능항 태그의 길이는 최소 3자 부터 최대 10자이며, 최대 30개까지 등록 가능합니다.
* 타겟팅의 자세한 JSON은 아래 Sample을 참고하세요.

### JSON Sample
**target JSON Sample**
```json
"target": {
		"requested": ["냉장고", "김치냉장고", "스탠드형냉장고"]
 }
```

**AD TAG 타겟팅 등록,수정 및 삭제**

PUT /api/ncc/targets/tgt-a001-02-000000000289235

```javascript
{
	"nccTargetId": "tgt-a001-02-000000000285478", // 또는 null
	"ownerId": "nad-a001-02-000000000076414", // 필수 입력
	"targetTp": "AD_TAG", // 필수 입력
	"target": {
		"requested": ["냉장고", "김치냉장고", "스탠드형냉장고"] // 필수 입력
	}
}
```

## Targeting
* New targeting type will be added on February 27, 2019. ([See announce](https://saedu.naver.com/notice/view.nhn?notiSeq=3454))
* The new target's `targetTp` value is `AD_TAG`.

* New targeting is applied to `CATALOG_AD` creatives under `SHOPPING` campaigns, and errors occur when you register with other creative types.
* The length of registerable tag is minimum 3 characters to maximum 10 characters. Up to 30 tags can be registered.
* For detailed JSON targeting, please refer to the sample below.

### JSON Sample
**target JSON Sample**
```json
"target": {
		"requested": ["냉장고", "김치냉장고", "스탠드형냉장고"]
 }
```

**Register, edit, and delete AD TAG targeting**

PUT /api/ncc/targets/tgt-a001-02-000000000289235

```javascript
{
	"nccTargetId": "tgt-a001-02-000000000285478", // or null
	"ownerId": "nad-a001-02-000000000076414", // required
	"targetTp": "AD_TAG", // required
	"target": {
		"requested": ["냉장고", "김치냉장고", "스탠드형냉장고"] // required
	}
}
```
