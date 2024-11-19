---
categories: [release]
---

#### 2024년 11월 20일, 쇼핑 검색 캠페인에 URL 파라미터 값 변경 기능이 적용됩니다.

### 캠페인
* `추적 URL 커스텀 파라미터 필드(trackingUrlCustomParams`)가 캠페인에 추가됩니다.
* 쇼핑검색 캠페인에만 유효합니다.
* 최대 5개까지 쌍으로 등록 가능합니다.
* 각 key, value는 최대 100byte를 넘을 수 없습니다.
* 중복된 key값을 가질수 없습니다.
* 등록가능 문자는 영어, 한글, 일본어, 숫자, '-', '_' 만 가능합니다.
* JSON 구조체로 아래의 예시와 같이 등록가능합니다.

```json
[
    {
        "key": "파라미터명_1",
        "value": "치환할_값_1"
    },
    {
        "key": "파라미터명_2",
        "value": "치환할_값_2"
    }
]
```
  
  
  

#### On November 20, 2024, the feature to change URL parameter values will be
Applied to Shopping Search campaigns.

### Campaign
* A trackingUrlCustomParams field will be added to the campaign.
* This is only valid for Shopping Search campaigns.
* Up to 5 pairs can be registered.
* Each key and value must not exceed 100 bytes.
* Duplicate key values are not allowed.
* The allowable characters for registration are English, Korean, Japanese, numbers, '-', and '_'.
* It can be registered in JSON format as shown in the example below:
  
```json
[
    {
        "key": "parameter_name_1",
        "value": "replacement_value_1"
    },
    {
        "key": "parameter_name_2",
        "value": "replacement_value_2"
    }
]
```
