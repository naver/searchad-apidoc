---
title: Release Note
categories: [release]
---

#### 2026년 9월 16일, 플레이스광고에 'ADVoost 플레이스' 설정과 연동형 소재(ADVOOST_PLACE_AD)가 추가됩니다.

- 플레이스광고 광고그룹(`LOCAL_AD`)의 `adgroupAttrJson`에 **`useAdvoost`**(ADVoost 플레이스 사용 여부) 필드가 추가됩니다.
- `useAdvoost`를 **true**로 설정하면 스마트플레이스 업체 정보를 바탕으로 노출되는 **연동형 소재(`ADVOOST_PLACE_AD`, type 17)** 가 광고그룹에 자동으로 1개 생성됩니다.
- 값을 지정하지 않으면 **false**(미사용)로 처리되며, 기존 플레이스광고 광고그룹의 동작은 변경되지 않습니다.
- ADVoost 플레이스는 스마트플레이스 업체 이미지가 1개 이상 등록된 비즈채널에서만 사용할 수 있으며, **병의원 업종 비즈채널은 사용할 수 없습니다.**

### 광고그룹 등록

* `POST /ncc/adgroups` 요청의 `adgroupAttrJson`에 `useAdvoost` 값을 설정합니다.

#### 예제

* Request

```
POST /ncc/adgroups
```

* Request Body

```json
{
  "nccCampaignId": "cmp-a001-06-000000001234567",
  "name": "플레이스 광고그룹1",
  "adgroupType": "LOCAL_AD",
  "pcChannelId": "bsn-a001-00-000000001234567",
  "mobileChannelId": "bsn-a001-00-000000001234567",
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "adgroupAttrJson": {
    "useAdvoost": true
  }
}
```

* Response Body

```json
{
  "nccAdgroupId": "grp-a001-06-000000001234567",
  "nccCampaignId": "cmp-a001-06-000000001234567",
  "name": "플레이스 광고그룹1",
  "adgroupType": "LOCAL_AD",
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "adgroupAttrJson": "{\"useAdvoost\":true}",
  "userLock": false
}
```

### 광고그룹 조회

* `GET /ncc/adgroups/{adgroupId}` 응답의 `adgroupAttrJson`에 `useAdvoost` 필드가 포함됩니다.

#### 예제

* Request

```
GET /ncc/adgroups/grp-a001-06-000000001234567
```

* Response Body

```json
{
  "nccAdgroupId": "grp-a001-06-000000001234567",
  "nccCampaignId": "cmp-a001-06-000000001234567",
  "name": "플레이스 광고그룹1",
  "adgroupType": "LOCAL_AD",
  "adgroupAttrJson": "{\"useAdvoost\":true}",
  "userLock": false
}
```

### 광고그룹 수정 (ADVoost 플레이스 ON/OFF)

* `PUT /ncc/adgroups/{adgroupId}?fields=useAdvoost` 요청으로 `useAdvoost` 값만 변경할 수 있습니다.
* `PUT /ncc/adgroups/{adgroupId}` 전체 수정 요청의 `adgroupAttrJson`으로도 변경할 수 있습니다.
* OFF → ON 으로 변경하면 연동형 소재가 자동 생성(또는 재활성화)되고, ON → OFF 로 변경하면 연동형 소재가 OFF 처리됩니다.

#### 예제

* Request

```
PUT /ncc/adgroups/grp-a001-06-000000001234567?fields=useAdvoost
```

* Request Body

```json
{
  "nccAdgroupId": "grp-a001-06-000000001234567",
  "adgroupAttrJson": {
    "useAdvoost": true
  }
}
```

### 연동형 소재 (ADVOOST_PLACE_AD)

* 소재 유형(`type`)에 **`ADVOOST_PLACE_AD`** 가 추가됩니다. `GET /ncc/ads?nccAdgroupId=...` 등 소재 조회 API 응답에 포함됩니다.
* 연동형 소재는 별도의 소재 문안을 갖지 않으며(`ad` 필드는 `{}`), 스마트플레이스에 등록된 업체 정보(업체명·업종·주소·이미지)로 노출됩니다.
* 연동형 소재는 시스템이 생성·관리하는 소재입니다. 아래 요청은 허용되지 않습니다.
  * `POST /ncc/ads` 로 `type: ADVOOST_PLACE_AD` 소재를 직접 등록 (3840)
  * 연동형 소재 삭제 — ADVoost 플레이스가 ON 인 동안 (3837)
  * 연동형 소재의 `userLock` 변경 — 광고그룹의 `useAdvoost` 로만 제어됩니다 (3838)

#### 예제

* Request

```
GET /ncc/ads?nccAdgroupId=grp-a001-06-000000001234567
```

* Response Body

```json
[
  {
    "nccAdId": "nad-a001-06-000000001234567",
    "nccAdgroupId": "grp-a001-06-000000001234567",
    "customerId": 1234567,
    "inspectStatus": "APPROVED",
    "type": "ADVOOST_PLACE_AD",
    "ad": {},
    "adAttr": {},
    "userLock": false,
    "referenceKey": "1234567890",
    "status": "ELIGIBLE",
    "statusReason": "ELIGIBLE",
    "regTm": "2026-09-01T00:00:00.000Z",
    "editTm": "2026-09-01T00:00:00.000Z"
  }
]
```

### ADVoost 플레이스 ON 광고그룹의 제약 사항

`useAdvoost: true` 인 광고그룹에는 아래 요청이 허용되지 않으며 `400 Bad Request` 가 반환됩니다.

| 요청 | 오류 코드 |
|---|---|
| `POST /ncc/ads` — 소재 추가 | 3839 |
| `POST /ncc/ad-extensions` — 확장소재 추가 | 4029 |
| 제외 검색어 등록 (`/ncc/adgroups/{adgroupId}/restricted-keywords`) | 3754, 4422 |
| 매체 타겟팅 변경 (`fields=targetMedia` 등) | 4420 |
| 요일/시간 외 타겟팅 변경 (지역·연령·성별·상세위치) | 5117 |
| 고급옵션 변경 (`bidAmt`, `pcNetworkBidWeight`, `mobileNetworkBidWeight`, `contentsNetworkBidAmt`, `useExpSearch`, `adRollingType` 등) | 3755 |

### 신규 오류 코드

| Code | 설명 |
|:---:|---|
| 3749 | 광고그룹 속성(adgroupAttrJson)의 변경할 수 없는 필드를 수정할 수 없습니다. |
| 3752 | 스마트플레이스에 업체 이미지가 없어 광고그룹을 저장할 수 없습니다. ADVoost 플레이스를 적용하려면 스마트플레이스에 업체 이미지를 1개 이상 등록해 주세요. 등록한 이미지가 반영되기까지 최대 10분 정도 소요될 수 있습니다. |
| 3753 | 스마트플레이스 업체 정보를 불러오지 못했습니다. 잠시 후 다시 시도해 주세요. |
| 3754 | 애드부스트 ON 광고그룹에서는 제외 검색어를 등록할 수 없습니다. |
| 3755 | 애드부스트 ON 광고그룹에서는 고급 옵션을 변경할 수 없습니다. |
| 3756 | 병의원 업종 업체는 애드부스트 플레이스 광고를 집행할 수 없습니다. |
| 3837 | 애드부스트 ON 상태에서는 연동형 소재를 삭제할 수 없습니다. |
| 3838 | 연동형 소재는 ON/OFF를 변경할 수 없습니다. |
| 3839 | 애드부스트 ON 광고그룹에서는 소재를 추가할 수 없습니다. |
| 3840 | 연동형 소재는 직접 등록할 수 없습니다. |
| 4029 | 애드부스트 ON 광고그룹에서는 확장 소재를 추가할 수 없습니다. |
| 4420 | 애드부스트 ON 광고그룹에서는 매체를 변경할 수 없습니다. |
| 4421 | 애드부스트 ON 광고그룹에서는 태그를 설정할 수 없습니다. |
| 4422 | 애드부스트 ON 광고그룹에서는 제외 검색어를 등록할 수 없습니다. |
| 5117 | 애드부스트 ON 광고그룹에서는 요일/시간 외 타겟팅을 변경할 수 없습니다. |

---

#### September 16, 2026 – 'ADVoost Place' Setting and Linked Creative (ADVOOST_PLACE_AD) Added to Place Ads

* A **`useAdvoost`** (ADVoost Place on/off) field is added to `adgroupAttrJson` of Place Ad groups (`LOCAL_AD`).
* When `useAdvoost` is set to **true**, one **linked creative (`ADVOOST_PLACE_AD`, type 17)** is created automatically in the ad group. It is served using the business information registered in SmartPlace.
* If no value is specified, it is treated as **false** (disabled). Existing Place Ad groups are not affected.
* ADVoost Place is available only for business channels that have at least one business image registered in SmartPlace. **Medical business channels cannot use ADVoost Place.**

### Create an Ad Group

* Set the `useAdvoost` value in `adgroupAttrJson` of the `POST /ncc/adgroups` request.

#### Example:

* Request:

```
POST /ncc/adgroups
```

* Request Body:

```json
{
  "nccCampaignId": "cmp-a001-06-000000001234567",
  "name": "place adgroup1",
  "adgroupType": "LOCAL_AD",
  "pcChannelId": "bsn-a001-00-000000001234567",
  "mobileChannelId": "bsn-a001-00-000000001234567",
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "adgroupAttrJson": {
    "useAdvoost": true
  }
}
```

* Response Body:

```json
{
  "nccAdgroupId": "grp-a001-06-000000001234567",
  "nccCampaignId": "cmp-a001-06-000000001234567",
  "name": "place adgroup1",
  "adgroupType": "LOCAL_AD",
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "adgroupAttrJson": "{\"useAdvoost\":true}",
  "userLock": false
}
```

### Retrieve an Ad Group

* The `useAdvoost` field is included in `adgroupAttrJson` of the `GET /ncc/adgroups/{adgroupId}` response.

#### Example:

* Request:

```
GET /ncc/adgroups/grp-a001-06-000000001234567
```

* Response Body:

```json
{
  "nccAdgroupId": "grp-a001-06-000000001234567",
  "nccCampaignId": "cmp-a001-06-000000001234567",
  "name": "place adgroup1",
  "adgroupType": "LOCAL_AD",
  "adgroupAttrJson": "{\"useAdvoost\":true}",
  "userLock": false
}
```

### Update an Ad Group (Turn ADVoost Place ON/OFF)

* Use `PUT /ncc/adgroups/{adgroupId}?fields=useAdvoost` to change only the `useAdvoost` value.
* It can also be changed via `adgroupAttrJson` in the full update request `PUT /ncc/adgroups/{adgroupId}`.
* Switching OFF → ON creates (or re-enables) the linked creative; switching ON → OFF turns the linked creative off.

#### Example:

* Request:

```
PUT /ncc/adgroups/grp-a001-06-000000001234567?fields=useAdvoost
```

* Request Body:

```json
{
  "nccAdgroupId": "grp-a001-06-000000001234567",
  "adgroupAttrJson": {
    "useAdvoost": true
  }
}
```

### Linked Creative (ADVOOST_PLACE_AD)

* **`ADVOOST_PLACE_AD`** is added to the ad `type` values. It appears in ad retrieval responses such as `GET /ncc/ads?nccAdgroupId=...`.
* A linked creative has no creative text of its own (`ad` is `{}`); it is served with the business information (name, category, address, images) registered in SmartPlace.
* Linked creatives are created and managed by the system. The following requests are not allowed:
  * Creating an ad with `type: ADVOOST_PLACE_AD` via `POST /ncc/ads` (3840)
  * Deleting a linked creative while ADVoost Place is ON (3837)
  * Changing `userLock` of a linked creative — it is controlled only by the ad group's `useAdvoost` (3838)

#### Example:

* Request:

```
GET /ncc/ads?nccAdgroupId=grp-a001-06-000000001234567
```

* Response Body:

```json
[
  {
    "nccAdId": "nad-a001-06-000000001234567",
    "nccAdgroupId": "grp-a001-06-000000001234567",
    "customerId": 1234567,
    "inspectStatus": "APPROVED",
    "type": "ADVOOST_PLACE_AD",
    "ad": {},
    "adAttr": {},
    "userLock": false,
    "referenceKey": "1234567890",
    "status": "ELIGIBLE",
    "statusReason": "ELIGIBLE",
    "regTm": "2026-09-01T00:00:00.000Z",
    "editTm": "2026-09-01T00:00:00.000Z"
  }
]
```

### Restrictions for Ad Groups with ADVoost Place ON

The following requests are rejected with `400 Bad Request` for ad groups with `useAdvoost: true`.

| Request | Error Code |
|---|---|
| `POST /ncc/ads` — add an ad | 3839 |
| `POST /ncc/ad-extensions` — add an ad extension | 4029 |
| Register negative keywords (`/ncc/adgroups/{adgroupId}/restricted-keywords`) | 3754, 4422 |
| Change media targeting (`fields=targetMedia`, etc.) | 4420 |
| Change targeting other than schedule (region, age, gender, proximity) | 5117 |
| Change advanced options (`bidAmt`, `pcNetworkBidWeight`, `mobileNetworkBidWeight`, `contentsNetworkBidAmt`, `useExpSearch`, `adRollingType`, etc.) | 3755 |

### New Error Codes

| Code | Description |
|:---:|---|
| 3749 | Cannot modify immutable field in adgroup attribute JSON. |
| 3752 | Cannot save the ad group because the SmartPlace business has no images. To apply ADVoost Place, please register at least one business image in SmartPlace. It may take up to 10 minutes for the registered image to be reflected. |
| 3753 | Failed to load the SmartPlace business information. Please try again later. |
| 3754 | Restricted keywords cannot be registered for an AdVoost-on ad group. |
| 3755 | Advanced options cannot be changed when AdVoost is ON. |
| 3756 | Medical businesses cannot run AdVoost Place ads. |
| 3837 | Connected creatives cannot be deleted while AdVoost is ON. |
| 3838 | The connected creative cannot be turned on or off. |
| 3839 | Ads cannot be added when AdVoost is ON. |
| 3840 | Connected creatives are created automatically and cannot be added manually. |
| 4029 | Ad extensions cannot be added when AdVoost is ON. |
| 4420 | Media cannot be changed for an AdVoost-on ad group. |
| 4421 | Tags cannot be set for an AdVoost-on ad group. |
| 4422 | Restricted keywords cannot be registered for an AdVoost-on ad group. |
| 5117 | Targeting other than schedule cannot be changed for an AdVoost-on ad group. |
