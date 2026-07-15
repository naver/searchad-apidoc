---
title: Release Note
categories: [release]
---

#### 2026년 7월 15일, 광고그룹에 ADVoost Max(aiAdsOptIn) 설정이 추가됩니다.
- 광고그룹 조회 응답과 수정 요청에 **`aiAdsOptIn`**(ADVoost Max 설정) 필드가 추가됩니다.
- **파워링크 + 확장검색**을 사용하는 광고그룹만 설정/활성화할 수 있습니다.
- 값을 지정하지 않으면 **true**(사용)로 처리됩니다.

### 광고그룹 조회
* `GET /ncc/adgroups/{adgroupId}` 응답에 `aiAdsOptIn` 필드가 포함됩니다.

#### 예제
* Request

```
GET /ncc/adgroups/grp-a001-01-000000001234567
```

* Response Body

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "광고그룹1",
  "useExpSearch": true,
  "aiAdsOptIn": true,
  "userLock": false
}
```

### 광고그룹 수정
* `PUT /ncc/adgroups/{adgroupId}` 요청으로 `aiAdsOptIn` 값을 설정합니다.

#### 예제
* Request

```
PUT /ncc/adgroups/grp-a001-01-000000001234567
```

* Request Body

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "useExpSearch": true,
  "aiAdsOptIn": true
}
```

#### July 15, 2026 – ADVoost Max (aiAdsOptIn) Setting Added to Ad Groups
* An **`aiAdsOptIn`** (ADVoost Max) field is added to the Ad Group retrieval response and update request.
* It can be set or enabled only for ad groups using **PowerLink and Extended Search**.
* If no value is specified, it is treated as **true** (enabled).

### Retrieve an Ad Group
* The `aiAdsOptIn` field is included in the `GET /ncc/adgroups/{adgroupId}` response.

#### Example:
* Request:

```
GET /ncc/adgroups/grp-a001-01-000000001234567
```

* Response Body:

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "adgroup1",
  "useExpSearch": true,
  "aiAdsOptIn": true,
  "userLock": false
}
```

### Update an Ad Group
* Set the `aiAdsOptIn` value with the `PUT /ncc/adgroups/{adgroupId}` request.

#### Example:
* Request:

```
PUT /ncc/adgroups/grp-a001-01-000000001234567
```

* Request Body:

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "useExpSearch": true,
  "aiAdsOptIn": true
}
```
