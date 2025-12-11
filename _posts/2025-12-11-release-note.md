---
categories: [release]
---

#### 2025년 12월 11일, 검색광고의 '최적화 신규 지표' OPEN API 제공 안내 ([공지 보기](https://ads.naver.com/notice/27412?searchValue=&page=3))

### 파워링크 키워드 응답 객체 변경
* Keyword 응답 객체에 `광고 연관 지수(adRelevanceScore)`와 `클릭 기대 지수(expectedClickScore)` 필드가 추가되었습니다.
* Keyword
```
  {
    nccKeywordId: string 
    nccAdgroupId: string 
    customerId: number
    keyword: string
    bidAmt: number
    useGroupBidAmt: boolean 
    adRelevanceScore: number          // 광고 연관 지수 (신규)
    expectedClickScore: number        // 클릭 기대 지수 (신규)
    regTm: string
    // ... 기타 필드
  }
```

### Powerlink Keyword Response Object Changes
* The Keyword response object now includes `Ad Relevance Score` and `Expected Click Score` fields.
* Keyword

```
  {
    nccKeywordId: string
    nccAdgroupId: string
    customerId: number
    keyword: string
    bidAmt: number
    useGroupBidAmt: boolean
    adRelevanceScore: number          // Ad Relevance Score (new)
    expectedClickScore: number        // Expected Click Score (new)
    regTm: string
    // ... other fields
  }
```
