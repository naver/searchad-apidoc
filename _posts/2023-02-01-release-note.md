---
categories: [release]
---

#### 2023년 2월 1일에 신제품검색광고가 추가 됩니다. ([공지사항](https://saedu.naver.com/notice/view.naver?notiSeq=4019))


### 광고 그룹
* 광고 그룹 유형에 `신제품검색(BRAND_NEW)` 유형이 추가 됩니다.
* 신제품검색 유형 광고 그룹은 API를 이용하여 등록할 수 없습니다.
* 광고그룹 정보 조회시 신제품검색광고 유형의 광고그룹은 아래의 내용이 변경됩니다.
* adgroupType: BRAND_NEW
* adgroupAttrJson: 
```javascript
{
  campaignTp: 4, // 켐페인 유형 코드
  keywordGroupCategoryId: "b15ed6c1-a72b-4615-adae-e7df05519463", // 키워드 그룹 카테고리 ID
  keywordGroupCategoryName: "골프모자", // 키워드 그룹 카테고리 이름
  media: "MOBILE", // 메체
  templateId: "newproductad_m_newproduct", // 소재 템플릿 번호
  templateName: : "모바일 신제품소개" // 소재 템플릿 이름
}
```


### 소재
* 소재 유형에 `신제품검색(BRAND_SEARCH_NEW_AD)`유형 소재가 추가 되었습니다.
* `신제품검색(BRAND_SEARCH_NEW_AD)` 유형의 소재는 API를 이용하여 등록할 수 없습니다.


---


#### A new product search advertisement will be added on February 1, 2023. ([Notice](https://saedu.naver.com/notice/view.naver?notiSeq=4019))

### Adgroup
* The 'New Product Search (BRAND_NEW)' type is added to the adgroup type.
* New product search type adgroups cannot be registered using the API.
* When inquiring ad group information, the following changes will be made to the adgroup of the new product search advertisement type.
* * adgroupType: BRAND_NEW
* * adgroupAttrJson:
```javascript
{
  campaignTp: 4, // campaign type code
  keywordGroupCategoryId: "b15ed6c1-a72b-4615-adae-e7df05519463", // category id of keyword group
  keywordGroupCategoryName: "골프모자", // name of keyword group
  media: "MOBILE", // media
  templateId: "newproductad_m_newproduct", // creative template id
  templateName: : "모바일 신제품소개" // creative template name
}
```


### Ad
* The 'New Product Search (BRAND_SEARCH_NEW_AD)' type has been added to the Ad type.
* Ad of 'New Product Search (BRAND_SEARCH_NEW_AD)' type cannot be registered using API.
