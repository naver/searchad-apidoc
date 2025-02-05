---
categories: [release]
---

#### 2025년 2월 5일, 가격링크 확장소재의 등록 기능이 종료됩니다.([공지사항](https://ads.naver.com/notice/18250?categoryId=147))

### 가격링크(PRICE_LINK)
* /ncc/ad-extensions API에서 확장소재(PRICE_LINK)가 삭제됩니다.
```
PRICE_LINKS
{
  "name": "1박2일 패키지",
  "price": 149000,
  "modifier": "부터",
  "final": "https://www.naver.com"
}
```

- Request
```
POST /ncc/ad-extensions (확장소재 PRICE_LINK 등록 불가)
```

#### On February 5, 2025, the registration function of the extended material of the price link will end. ([Notice](https://ads.naver.com/notice/18250?categoryId=147))

### PRICE_LINK
* The extension material (PRICE_LINK) is deleted from the /ncc/ad-extensions API.
```
PRICE_LINKS
{
  "name": "1박2일 패키지",
  "price": 149000,
  "modifier": "부터",
  "final": "https://www.naver.com"
}
```
- Request
```
POST /ncc/ad-extensions (Unable to register adExtension of PRICE_LINK)
```
