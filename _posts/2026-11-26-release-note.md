---
title: Release Note
categories: [release]
---

#### 2026년 11월 26일, 제외검색어에 '단어 포함' 유형(EXP_SEARCH_SUBSTRING)이 추가됩니다.

- 파워링크 광고그룹의 제외검색어 `type`에 **`EXP_SEARCH_SUBSTRING`**(단어 포함) 값이 추가됩니다.
- `EXP_SEARCH_SUBSTRING`은 확장 검색(`EXP_SEARCH`)과 같은 노출 범위에 적용됩니다.
- 등록 개수 한도는 `type`별로 따로 계산하며 합산하지 않습니다. `EXP_SEARCH_SUBSTRING`은 광고그룹당 최대 140개까지 등록할 수 있습니다.
- 등록 시 `type`은 필수입니다. `type`을 지정하지 않으면 오류(1002)가 반환됩니다.

| type | 설명 | 광고그룹당 최대 개수 |
|------|------|------|
| `KEYWORD_PLUS_RESTRICT` | 스마트블록 및 유사검색어 | 50개 |
| `EXP_SEARCH` | 확장 검색 | 950개 |
| `EXP_SEARCH_SUBSTRING` | 단어 포함 (신규, 확장 검색과 같은 노출 범위에 적용) | 140개 |

### 제외검색어 등록

* `POST /ncc/adgroups/{adgroupId}/restricted-keywords` 요청 본문의 `type`에 `EXP_SEARCH_SUBSTRING`을 지정합니다.
* 등록한 키워드의 영문은 대문자로 변환되어 저장됩니다.

#### 등록 제한

| 항목 | 제한 | 오류 코드 |
|------|------|------|
| 등록 개수 | 광고그룹당 최대 140개 | 3716 |
| 키워드 길이 | 2자 이상 30자 이하 | 1자: 3759, 30자 초과: 3722 |
| 광고그룹 유형 | 파워링크(웹사이트) 광고그룹만 등록 가능 | 3728 |

#### 예제

* Request

```
POST /ncc/adgroups/grp-a001-01-000000001234567/restricted-keywords
```

* Request Body

```json
[
  {
    "nccAdgroupId": "grp-a001-01-000000001234567",
    "keyword": "대출",
    "type": "EXP_SEARCH_SUBSTRING"
  }
]
```

### 제외검색어 조회

* `GET /ncc/adgroups/{adgroupId}/restricted-keywords?type=EXP_SEARCH_SUBSTRING`으로 '단어 포함' 유형의 제외검색어만 조회할 수 있습니다.
* `type`을 지정하지 않으면 모든 유형의 제외검색어가 조회됩니다.

#### 예제

* Request

```
GET /ncc/adgroups/grp-a001-01-000000001234567/restricted-keywords?type=EXP_SEARCH_SUBSTRING
```

* Response Body

```json
[
  {
    "nccAdgroupRestrictKwdId": "rst-a001-00-000000001234567",
    "nccAdgroupId": "grp-a001-01-000000001234567",
    "keyword": "대출",
    "type": "EXP_SEARCH_SUBSTRING",
    "regTm": "2026-11-26T02:00:00.000Z"
  }
]
```

### 제외검색어 삭제

* 기존과 동일하게 `DELETE /ncc/adgroups/{adgroupId}/restricted-keywords?ids={ids}`로 삭제합니다.
* `ids`에는 조회 응답의 `nccAdgroupRestrictKwdId`를 지정합니다.

---

#### November 26, 2026 – 'Substring' Type (EXP_SEARCH_SUBSTRING) Added to Negative Search Terms

- **`EXP_SEARCH_SUBSTRING`** (substring) is added to the `type` of negative search terms for Power Link ad groups.
- `EXP_SEARCH_SUBSTRING` applies to the same exposure scope as extension search (`EXP_SEARCH`).
- Registration count limits are counted separately for each `type` and are not combined. Up to 140 `EXP_SEARCH_SUBSTRING` terms can be registered per ad group.
- `type` is required when registering. If `type` is not specified, an error (1002) is returned.

| type | Description | Max per ad group |
|------|-------------|------|
| `KEYWORD_PLUS_RESTRICT` | Smart Block and Close Variant | 50 |
| `EXP_SEARCH` | Extension search | 950 |
| `EXP_SEARCH_SUBSTRING` | Substring (new, same exposure scope as extension search) | 140 |

### Register Negative Search Terms

* Set `type` to `EXP_SEARCH_SUBSTRING` in the request body of `POST /ncc/adgroups/{adgroupId}/restricted-keywords`.
* English letters in registered keywords are converted to uppercase when stored.

#### Registration Limits

| Item | Limit | Error code |
|------|-------|------|
| Count | Up to 140 per ad group | 3716 |
| Keyword length | 2 to 30 characters | 1 character: 3759, over 30 characters: 3722 |
| Ad group type | Power Link (website) ad groups only | 3728 |

#### Example:

* Request

```
POST /ncc/adgroups/grp-a001-01-000000001234567/restricted-keywords
```

* Request Body

```json
[
  {
    "nccAdgroupId": "grp-a001-01-000000001234567",
    "keyword": "loan",
    "type": "EXP_SEARCH_SUBSTRING"
  }
]
```

### Retrieve Negative Search Terms

* Use `GET /ncc/adgroups/{adgroupId}/restricted-keywords?type=EXP_SEARCH_SUBSTRING` to retrieve only negative search terms of the substring type.
* If `type` is not specified, negative search terms of all types are returned.

#### Example:

* Request

```
GET /ncc/adgroups/grp-a001-01-000000001234567/restricted-keywords?type=EXP_SEARCH_SUBSTRING
```

* Response Body

```json
[
  {
    "nccAdgroupRestrictKwdId": "rst-a001-00-000000001234567",
    "nccAdgroupId": "grp-a001-01-000000001234567",
    "keyword": "LOAN",
    "type": "EXP_SEARCH_SUBSTRING",
    "regTm": "2026-11-26T02:00:00.000Z"
  }
]
```

### Delete Negative Search Terms

* Delete as before with `DELETE /ncc/adgroups/{adgroupId}/restricted-keywords?ids={ids}`.
* Set `ids` to the `nccAdgroupRestrictKwdId` values from the retrieve response.
