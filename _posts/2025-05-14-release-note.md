---
categories: [release]
---

#### 2025년 5월 14일, 사이트검색광고 '웹사이트정보' 확장소재 등록이 오픈됩니다.([공지사항](https://ads.naver.com/notice/21438?searchValue=&page=2))

### 웹사이트정보(WEBSITE_INFO)
* /ncc/ad-extensions API에서 웹사이트정보(WEBSITE_INFO)가 추가됩니다.
* 웹사이트정보(WEBSITE_INFO) 확장소재는 해당 유형의 확장소재 노출을 위한 네이버 광고의 사이트 정보 수집 및 활용에 동의해야 생성할 수 있습니다. 따라서 API를 통한 해당 유형의 확장소재 등록은 이에 동의한 것으로 간주하며, 확장소재로 노출되는 정보의 정확성 및 적법성에 대한 책임은 광고주에게 있습니다. 

example
```
POST /ncc/ad-extensions

WEBSITE_INFO
{
  "agree": true
}
```

### 소재
* 소재 유형에 `병의원 업종 특화(MEDICAL_AD)` 유형 소재가 추가 되었습니다.
* `병의원 업종 특화(MEDICAL_AD)` 유형의 소재는 API를 이용하여 등록할 수 없습니다.



#### On May 14, 2025, the "WEBSITE_INFO" extension for powerlink ads is now available for registration. ([Notice](https://ads.naver.com/notice/21438?searchValue=&page=2))

### WEBSITE INFO(WEBSITE_INFO)
* Web site information (WEBSITE_INFO) type will be added to the /ncc/ad-extensions API.
* Web site information (WEBSITE_INFO) ad extension can be generated only when they agree to collect and utilize the site information of NAVER ads for the exposure of such types of ad extension. Therefore, the registration of such types of ad extension through API is considered to have been agreed upon, and the advertiser is responsible for the accuracy and legality of the information exposed to the ad extension.

example
```
POST /ncc/ad-extensions

WEBSITE_INFO
{
  "agree": true
}
```

### Ad
* Added `MEDICAL_AD` to ad type.
* Ad of type `MEDICAL_AD` cannot be registered using API.

