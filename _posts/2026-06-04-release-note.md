---
categories: [release]
---

#### 2026년 6월 4일, 사이트검색광고 '톡톡상담' 확장소재 등록 지원.

### 톡톡상담(TALKTALK_CONSULTATION)
* /ncc/ad-extensions API에서 톡톡상담(TALKTALK_CONSULTATION)가 추가됩니다.
* 필수: talkAccountId, url, description

example
```
POST /ncc/ad-extensions

TALKTALK_CONSULTATION
{
  "talkAccountId": "xxxxxx",
  "name": "에어컨 청소 견적서",
  "url": "https://talk.naver.com/profile/xxxxxx/form/1",
  "description": "최저가 상담"
}

```

#### June 4, 2026: Support Added for Registering the “TalkTalk Consultation” Ad Extension in Search Ads

### TalkTalk Consultation (TALKTALK_CONSULTATION)

* The TalkTalk Consultation (TALKTALK_CONSULTATION) ad extension has been added to the /ncc/ad-extensions API.
* Required fields: talkAccountId, url, description

Example
```
POST /ncc/ad-extensions

TALKTALK_CONSULTATION

{
"talkAccountId": "xxxxxx",
"name": "Air Conditioner Cleaning Quote",
"url": "https://talk.naver.com/profile/xxxxxx/form/1",
"description": "Lowest-price consultation"
}
```
