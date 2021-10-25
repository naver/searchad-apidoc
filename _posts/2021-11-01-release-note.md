---
categories: [release]
---

### Master Report

#### Brand Thumbnail Ad (BrandThumbnailAd)

   * `BrandThumbnailAd` master report has added.
   * provides creatives of type `SHOPPING_BRAND_IMAGE_THUMBNAIL_AD`.

No | Field Name | Value | Max.Length | Description
-- | -- | -- | -- | --
1 | Customer ID | int |  | Customer ID
2 | Ad Group ID | string | 31 | Ad Group ID
3 | Ad ID | string | 31 | Ad Creative ID
4 | Ad Creative Inspect Status | int | | - 10: UNDER_REVIEW- 20: APPROVED- 30: LIMITED_APPROVED- 40: PENDING
5 | ON/OFF | int |  | - 0: ON- 1: OFF
6 | Headlin | string | 256 | Head line text.
7 | description | string | 256 | description text.
8 | extra Description | string | 256 | extra description text.
9 | Logo image path | string | 256 | relative path of logo image
10 | Link URL | string | 256 | Link url 
11 | Thumnail Image path | string | 256 | relative path of thumnail image
12 | regTm | date |  | The time at which information was created(ISO8601)
13 | delTm | date |  | The time at which the campaign was deleted(ISO8601)

#### Brand Banner Ad (BrandBannerAd)

   * `BrandBannerAd` master report has added.
   * provides creatives of type `SHOPPING_BRAND_IMAGE_BANNER_AD`.

No | Field Name | Value | Max.Length | Description
-- | -- | -- | -- | --
1 | Customer ID | int |  | Customer ID
2 | Ad Group ID | string | 31 | Ad Group ID
3 | Ad ID | string | 31 | Ad Creative ID
4 | Ad Creative Inspect Status | int |  | - 10: UNDER_REVIEW- 20: APPROVED- 30: LIMITED_APPROVED- 40: PENDING
5 | ON/OFF | int |  | - 0: ON- 1: OFF
6 | Headlin | string | 256 | Head line text.
7 | description | string | 256 | description text.
8 | Logo image path | string | 256 | relative path of logo image
9 | Link URL | string | 256 | Link url 
10 | Thumnail Image path | string | 256 | relative path of thumnail image
11 | regTm | date |  | The time at which information was created(ISO8601)
12 | delTm | date |  | The time at which the campaign was deleted(ISO8601)
