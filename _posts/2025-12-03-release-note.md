---
title: Release Note
categories: [release]
---

#### 2025년 12월 3일, 검수이력 조회가 API로 지원이 됩니다.
- **비즈채널, 소재, 확장소재, 키워드, 애셋**의 검수이력이 API로 조회가 지원이 됩니다.
- **최근 3개월 이내**의 이력만 조회가 가능합니다.
- 사유가 없거나 존재하지 않는 id의 경우는 빈 객체로 응답합니다.

### 검수이력 단건 조회
* /ncc/inspect-history/{id} API로 검수이력 1건 조회

#### 예제
* Request

```
GET /ncc/inspect-history/nkw-a001-01-000000001234567
```

* Response Body

```
{
  "id": "nkw-a001-01-000000001234567",
  "pcInspectComment": [
    {
      "content": "자체 콘텐츠가 충분하지 않은 사이트는 광고할 수 없습니다.",
      "faq": "http://saedu.naver.com/help/faq/ncc/view.nhn?faqSeq=103",
    }
  ],
  "mobileInspectComment": [
  ]
} 
```

### 검수이력 여러건 조회
* /ncc/inspect-history API로 검수이력 여러건 조회
* 최대 100건까지 조회가 가능합니다.

#### 예제
* Request

```
POST /ncc/inspect-history
```

* Request Body

```
[
  "bsn-a001-01-000000001234567",
  "nad-a001-01-000000001234567",
  "nkw-a001-01-000000001234567",
]

```

* Response Body

```
[
    {
        "id": "bsn-a001-01-000000001234567",
        "pcInspectComment": [
        {
            "content": "비즈채널의 콘텐츠가 충분하지 않습니다.",
            "faq": "http://saedu.naver.com/help/faq/ncc/view.nhn?faqSeq=103",
        }
        ],
        "mobileInspectComment": [
        ]
    },
    {
        "id": "nad-a001-01-000000001234567",
        "pcInspectComment": [
        {
            "content": "소재의 콘텐츠가 충분하지 않습니다.",
            "faq": "http://saedu.naver.com/help/faq/ncc/view.nhn?faqSeq=103",
        }
        ],
        "mobileInspectComment": [
        ]
    },
    {
        "id": "nkw-a001-01-000000001234567"
    }
] 
```

#### December 3, 2025 – Inspection History API Support
* The inspection history for Business Channels, Creatives, Extended Creatives, Keywords, and Assets is now available via API.
* Only records from the most recent three months can be retrieved.
* If there is no reason or the specified ID does not exist, an empty object will be returned.

### Retrieve a Single Inspection History Record
* Retrieve a single inspection history using the /ncc/inspect-history/{id} API.

### Example:
* Request:

```
GET /ncc/inspect-history/nkw-a001-01-000000001234567
```

* Response Body:

```json
{
  "id": "nkw-a001-01-000000001234567",
  "pcInspectComment": [
    {
      "content": "자체 콘텐츠가 충분하지 않은 사이트는 광고할 수 없습니다.",
      "faq": "http://saedu.naver.com/help/faq/ncc/view.nhn?faqSeq=103"
    }
  ],
  "mobileInspectComment": []
}
```
### Retrieve Multiple Inspection Histories
* Retrieve multiple inspection histories using the /ncc/inspect-history API.
* A maximum of 100 records can be retrieved.

* Example:

```
POST /ncc/inspect-history
```

* Request Body:

```json
[
  "bsn-a001-01-000000001234567",
  "nad-a001-01-000000001234567",
  "nkw-a001-01-000000001234567"
]
```
* Response Body:

```json
[
    {
        "id": "bsn-a001-01-000000001234567",
        "pcInspectComment": [
            {
                "content": "비즈채널의 콘텐츠가 충분하지 않습니다.",
                "faq": "http://saedu.naver.com/help/faq/ncc/view.nhn?faqSeq=103"
            }
        ],
        "mobileInspectComment": []
    },
    {
        "id": "nad-a001-01-000000001234567",
        "pcInspectComment": [
            {
                "content": "소재의 콘텐츠가 충분하지 않습니다.",
                "faq": "http://saedu.naver.com/help/faq/ncc/view.nhn?faqSeq=103"
            }
        ],
        "mobileInspectComment": []
    },
    {
        "id": "nkw-a001-01-000000001234567"
    }
]
```
