---
title: Release Note
categories: [release]
---

#### 2026년 11월 18일, 파워링크 광고그룹에 'AI 요약텍스트' 사용 설정(powerLinkAutomatedTextOptOut)이 추가됩니다.

- 파워링크 광고그룹(`WEB_SITE`)의 `adgroupAttrJson`에 **`powerLinkAutomatedTextOptOut`**(AI 요약텍스트 사용 안 함) 필드가 추가됩니다.
- AI 요약텍스트는 광고주님께서 등록·제공하신 자료(광고 소재, 랜딩페이지, 비즈채널 정보 등)를 기반으로 네이버 AI 모델이 자동으로 생성하는 문구입니다.
- 값을 **true**로 설정하면 해당 광고그룹에 AI 요약텍스트를 **사용하지 않습니다(OFF)**. **false**이거나 값을 지정하지 않으면 AI 요약텍스트를 **사용합니다(ON)**.
- 값은 boolean(`true`/`false`)만 허용됩니다. `1`, `"true"`와 같은 숫자·문자열 값을 보내면 오류(3749)가 반환됩니다.
- 기본값을 따로 저장하지 않으므로, 값을 지정하지 않은 광고그룹의 `adgroupAttrJson`에는 `powerLinkAutomatedTextOptOut` 필드가 없습니다. 필드가 없으면 **false**(사용)로 처리됩니다.
- 파워링크 외 유형의 광고그룹에서는 이 필드를 보내도 무시되며 저장되지 않습니다.

### 광고그룹 등록

* `POST /ncc/adgroups` 요청의 `adgroupAttrJson`에 `powerLinkAutomatedTextOptOut` 값을 설정합니다.

#### 예제

* Request

```
POST /ncc/adgroups
```

* Request Body

```json
{
  "customerId": 1234567,
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "파워링크 광고그룹1",
  "adgroupType": "WEB_SITE",
  "pcChannelId": "bsn-a001-00-000000001234567",
  "mobileChannelId": "bsn-a001-00-000000001234567",
  "bidAmt": 70,
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "adgroupAttrJson": {
    "powerLinkAutomatedTextOptOut": true
  }
}
```

* Response Body

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "customerId": 1234567,
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "파워링크 광고그룹1",
  "adgroupType": "WEB_SITE",
  "bidAmt": 70,
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "adgroupAttrJson": "{\"campaignTp\":1,\"powerLinkAutomatedTextOptOut\":true}",
  "userLock": false
}
```

### 광고그룹 조회

* 값이 설정된 광고그룹은 `GET /ncc/adgroups/{adgroupId}` 응답의 `adgroupAttrJson`에 `powerLinkAutomatedTextOptOut` 필드가 포함됩니다.
* 값을 설정한 적이 없는 광고그룹은 필드가 포함되지 않으며, 이 경우 **false**(사용)로 판단하시면 됩니다.

#### 예제

* Request

```
GET /ncc/adgroups/grp-a001-01-000000001234567
```

* Response Body

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "customerId": 1234567,
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "파워링크 광고그룹1",
  "adgroupType": "WEB_SITE",
  "adgroupAttrJson": "{\"campaignTp\":1,\"powerLinkAutomatedTextOptOut\":true}",
  "userLock": false
}
```

### 광고그룹 수정 (AI 요약텍스트 ON/OFF)

* `PUT /ncc/adgroups/{adgroupId}` 전체 수정 요청의 `adgroupAttrJson`으로 값을 변경합니다.
* 요청에 `powerLinkAutomatedTextOptOut`을 포함하지 않으면 기존 값이 유지됩니다.
* 필드가 없는 광고그룹에 `false`를 요청하면 이미 같은 상태(사용)이므로 저장되지 않으며, 응답의 `adgroupAttrJson`에도 필드가 추가되지 않습니다.
* 개별 항목 수정(`PUT /ncc/adgroups/{adgroupId}?fields=powerLinkAutomatedTextOptOut`)은 지원하지 않으며, 요청하면 오류(3726)가 반환됩니다.
* 전체 수정 요청이므로 광고그룹 조회 응답의 값을 그대로 포함하고 `adgroupAttrJson`만 변경하여 요청하시기 바랍니다.

#### 예제

* Request

```
PUT /ncc/adgroups/grp-a001-01-000000001234567
```

* Request Body

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "customerId": 1234567,
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "파워링크 광고그룹1",
  "adgroupType": "WEB_SITE",
  "pcChannelId": "bsn-a001-00-000000001234567",
  "mobileChannelId": "bsn-a001-00-000000001234567",
  "bidAmt": 70,
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "useExpSearch": false,
  "adRollingType": "PERFORMANCE",
  "adgroupAttrJson": {
    "powerLinkAutomatedTextOptOut": false
  }
}
```

* Response Body

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "customerId": 1234567,
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "파워링크 광고그룹1",
  "adgroupType": "WEB_SITE",
  "bidAmt": 70,
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "useExpSearch": false,
  "adRollingType": "PERFORMANCE",
  "adgroupAttrJson": "{\"campaignTp\":1,\"powerLinkAutomatedTextOptOut\":false}",
  "userLock": false
}
```

### 오류 코드

| Code | 발생 조건 | 메시지 |
|:---:|---|---|
| 3726 | `fields=powerLinkAutomatedTextOptOut` 개별 항목 수정 요청 | 수정 요청한 필드는 개별 필드 수정을 지원하지 않습니다. |
| 3749 | `powerLinkAutomatedTextOptOut`에 boolean 외의 값(`1`, `"true"` 등)을 지정 | 광고그룹 속성 JSON의 불변 필드는 변경할 수 없습니다. (상세: `powerLinkAutomatedTextOptOut 은 true/false 만 허용합니다.`) |

---

#### November 18, 2026 – 'AI Summary Text' Setting (powerLinkAutomatedTextOptOut) Added to PowerLink Adgroups

* A **`powerLinkAutomatedTextOptOut`** (opt out of AI Summary Text) field is added to `adgroupAttrJson` of PowerLink adgroups (`WEB_SITE`).
* AI Summary Text is text generated automatically by NAVER's AI model based on the ad registered and provided by the advertiser (ad creatives, landing pages, business channel information, etc.).
* When set to **true**, AI Summary Text is **not used (OFF)** for the adgroup. When set to **false** or not specified, AI Summary Text is **used (ON)**.
* Only boolean values (`true`/`false`) are allowed. Numeric or string values such as `1` or `"true"` are rejected with an error (3749).
* No default value is stored. Adgroups without a specified value have no `powerLinkAutomatedTextOptOut` field in `adgroupAttrJson`. A missing field is treated as **false** (used).
* For adgroups of types other than PowerLink, this field is ignored and not saved.

### Create an Adgroup

* Set the `powerLinkAutomatedTextOptOut` value in `adgroupAttrJson` of the `POST /ncc/adgroups` request.

#### Example:

* Request:

```
POST /ncc/adgroups
```

* Request Body:

```json
{
  "customerId": 1234567,
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "powerlink adgroup1",
  "adgroupType": "WEB_SITE",
  "pcChannelId": "bsn-a001-00-000000001234567",
  "mobileChannelId": "bsn-a001-00-000000001234567",
  "bidAmt": 70,
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "adgroupAttrJson": {
    "powerLinkAutomatedTextOptOut": true
  }
}
```

* Response Body:

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "customerId": 1234567,
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "powerlink adgroup1",
  "adgroupType": "WEB_SITE",
  "bidAmt": 70,
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "adgroupAttrJson": "{\"campaignTp\":1,\"powerLinkAutomatedTextOptOut\":true}",
  "userLock": false
}
```

### Retrieve an Adgroup

* For adgroups with a specified value, the `powerLinkAutomatedTextOptOut` field is included in `adgroupAttrJson` of the `GET /ncc/adgroups/{adgroupId}` response.
* For adgroups where the value has never been set, the field is not included. In this case, treat it as **false** (used).

#### Example:

* Request:

```
GET /ncc/adgroups/grp-a001-01-000000001234567
```

* Response Body:

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "customerId": 1234567,
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "powerlink adgroup1",
  "adgroupType": "WEB_SITE",
  "adgroupAttrJson": "{\"campaignTp\":1,\"powerLinkAutomatedTextOptOut\":true}",
  "userLock": false
}
```

### Update an Adgroup (Turn AI Summary Text ON/OFF)

* Change the value via `adgroupAttrJson` in the full update request `PUT /ncc/adgroups/{adgroupId}`.
* If `powerLinkAutomatedTextOptOut` is not included in the request, the existing value is kept.
* Requesting `false` for an adgroup without the field changes nothing, because it is already in the same state (used). The field is not added to `adgroupAttrJson` in the response.
* Updating by fields (`PUT /ncc/adgroups/{adgroupId}?fields=powerLinkAutomatedTextOptOut`) is not supported and returns an error (3726).
* Since this is a full update request, please send all values from the adgroup retrieval response as they are, changing only `adgroupAttrJson`.

#### Example:

* Request:

```
PUT /ncc/adgroups/grp-a001-01-000000001234567
```

* Request Body:

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "customerId": 1234567,
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "powerlink adgroup1",
  "adgroupType": "WEB_SITE",
  "pcChannelId": "bsn-a001-00-000000001234567",
  "mobileChannelId": "bsn-a001-00-000000001234567",
  "bidAmt": 70,
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "useExpSearch": false,
  "adRollingType": "PERFORMANCE",
  "adgroupAttrJson": {
    "powerLinkAutomatedTextOptOut": false
  }
}
```

* Response Body:

```json
{
  "nccAdgroupId": "grp-a001-01-000000001234567",
  "customerId": 1234567,
  "nccCampaignId": "cmp-a001-01-000000001234567",
  "name": "powerlink adgroup1",
  "adgroupType": "WEB_SITE",
  "bidAmt": 70,
  "dailyBudget": 30000,
  "useDailyBudget": true,
  "useExpSearch": false,
  "adRollingType": "PERFORMANCE",
  "adgroupAttrJson": "{\"campaignTp\":1,\"powerLinkAutomatedTextOptOut\":false}",
  "userLock": false
}
```

### Error Codes

| Code | Condition | Message |
|:---:|---|---|
| 3726 | Updating by `fields=powerLinkAutomatedTextOptOut` | Not support modify field. |
| 3749 | A non-boolean value (`1`, `"true"`, etc.) is set for `powerLinkAutomatedTextOptOut` | Cannot modify immutable field in adgroup attribute JSON. (detail: `powerLinkAutomatedTextOptOut 은 true/false 만 허용합니다.`) |
