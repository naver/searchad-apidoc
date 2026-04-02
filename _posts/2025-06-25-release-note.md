---
categories: [release]
---

#### 2025년 6월 25일, 검색광고 확장소재 파워링크 이미지와 이미지 서브링크 확장소재 등록이 API로 지원이 됩니다.
확장소재 생성 요청하는 adExtension JSON 필드 하부의 imagePath에 Base64 인코딩된 이미지 스트링을 등록하여 이미지를 등록하게 지원이 됩니다.
- 지원되는 Base64 이미지: JPEG, PNG
- Base64 이미지 크기: 최대 5MB
- 확장소재용 Base64 이미지 (폭 x 높이): 고정 214x214

imagePath에 저장되는 Base64 등록 헤더 규칙 (data:MIME TYPE;filename:등록파일명.jpg;base64)
- "data:"로 시작되며 이후 mime 유형(image/jpeg, image/jpg, image/png) 지장
- "filename:" 이후에는 등록하는 파일명을 지정 (예제: test.jpg)
- "base64,"로 헤더 끝
- "data", "filename", "base64" 과의 구분자는 ";"을 지정함
- Base64 이미지는 헤더 이후 "," 다음 부터 이미지 데이터를 지정함
- 예제: "data:image/jpeg;filename:등록파일명.jpg;base64,/9j/4AAQSkZJRgABAQA................."

### 파워링크 이미지 확장소재(POWER_LINK_IMAGE)
* /ncc/ad-extensions/create API에서 파워링크 이미지 확장소재(POWER_LINK_IMAGE)가 추가됩니다.
* request body의 adExtension 필드의 imagePath에 Base64 인코딩된 이미지와 헤더를 지정함.
* imagePath는 최대 1개의 Base64 이미지를 지정.

#### 예제
* Request Body
```
{
  "adExtension":{
      "imagePath": "data:image/jpeg;filename:image-test1.jpg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAMCAgICAgMCAgIDAwMDBAYEBAQEBAgGBgUGCQgK........";
  },
  "customerId": 274865,
  "delFlag": false,
  "pcChannelId": "bsn-m002-00-000000000936100",
  "mobileChannelId": "bsn-m002-00-000000000936100",
  "nccAdExtensionId": "",
  "ownerId": "grp-a001-01-000000000063824",
  "type": "POWER_LINK_IMAGE",
  "usePeriod": false,
  "userLock": false
} 
```

* Request
```
POST /ncc/ad-extensions/create
```

### 이미지 서브링크 확장소재(IMAGE_SUB_LINKS)
* /ncc/ad-extensions/create API에서 이미지 서브링크 확장소재(IMAGE_SUB_LINKS)가 추가됩니다.
* request body의 adExtension 필드의 배열(array) 정보내 imagePath에 Base64 인코딩된 이미지와 헤더를 지정함.
* 배열은 최대 최대 3개이며 배열내 imagePath에 Base64 이미지를 지정.

#### 예제
* Request Body
```
{
  "adExtension": [
    {
      "name": "test1",
      "final": "https://searchad.naver.com",
      "imagePath": "data:image/jpeg;filename:image-test1.jpg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAMCAgICAgMCAgIDAwMDBAYEBAQEBAgGBgUGCQgK........";
    },
    {
      "name": "test2",
      "final": "https://blog.naver.com",
      "imagePath": "data:image/jpeg;filename:image-test2.jpg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAMCAgICAgMCAgIDAwMDBAYEBAQEBAgGBgUGCQgK........";
    },    
    {
      "name": "test3",
      "final": "https://www.naver.com",       
      "imagePath": "data:image/jpeg;filename:image-test3.jpg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAMCAgICAgMCAgIDAwMDBAYEBAQEBAgGBgUGCQgK........";
     }   
  ],
  "customerId": 274865,
  "delFlag": false,
  "pcChannelId": "bsn-m002-00-000000000936100",
  "mobileChannelId": "bsn-m002-00-000000000936100",
  "nccAdExtensionId": "",
  "ownerId": "grp-a001-01-000000000063824",
  "type": "IMAGE_SUB_LINKS",
  "usePeriod": false,
  "userLock": false
} 
```

* Request
```
POST /ncc/ad-extensions/create
```


#### On June 25, 2025, registration of searchAd adExtension (power link image and image sublink adExtension) will be supported via API.
Registering an image is supported by registering a Base64 encoded image string in the imagePath field under the adExtension JSON field that requests the creation of anExtension material.
- Supported Base64 images: JPEG, PNG
- Base64 image size: up to 5MB
- Base64 image for AdExtension material (width x height): fixed 214x214

Base64 registration header rules stored in imagePath (data:MIME TYPE;filename:registered file name.jpg;base64)
- Starts with "data:" and then mime type (image/jpeg, image/jpg, image/png)
- After "filename:", specify the file name to be registered (example: test.jpg)
- End header with "base64,"
- Specify ";" as the separator between "data", "filename", and "base64"
- Base64 images specify image data starting from "," after the header.
- Example: "data:image/jpeg;filename:registered file name.jpg;base64,/9j/4AAQSkZJRgABAQA.........

### Power Link Image AdExtension (POWER_LINK_IMAGE)
* Power Link Image AdExtension (POWER_LINK_IMAGE) is added in /ncc/ad-extensions/create API.
* Specify a Base64 encoded image and header in the imagePath of the adExtension field of the request body.
* imagePath specifies up to 1 Base64 image.

#### example
* Request Body
```
{
  "adExtension":{
      "imagePath": "data:image/jpeg;filename:image-test1.jpg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAMCAgICAgMCAgIDAwMDBAYEBAQEBAgGBgUGCQgK........";
  },
  "customerId": 274865,
  "delFlag": false,
  "pcChannelId": "bsn-m002-00-000000000936100",
  "mobileChannelId": "bsn-m002-00-000000000936100",
  "nccAdExtensionId": "",
  "ownerId": "grp-a001-01-000000000063824",
  "type": "POWER_LINK_IMAGE",
  "usePeriod": false,
  "userLock": false
} 
```

* Request
```
POST /ncc/ad-extensions/create
```

### Image Sublink AdExtension (IMAGE_SUB_LINKS)
* Image Sublink AdExtension (IMAGE_SUB_LINKS) is added in /ncc/ad-extensions/create API.
* Specify Base64 encoded image and header in imagePath in array information of adExtension field of request body.
* Array can be up to 3, and specify Base64 image in imagePath in array.


#### example
* Request Body
```
{
  "adExtension": [
    {
      "name": "test1",
      "final": "https://searchad.naver.com",
      "imagePath": "data:image/jpeg;filename:image-test1.jpg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAMCAgICAgMCAgIDAwMDBAYEBAQEBAgGBgUGCQgK........";
    },
    {
      "name": "test2",
      "final": "https://blog.naver.com",
      "imagePath": "data:image/jpeg;filename:image-test2.jpg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAMCAgICAgMCAgIDAwMDBAYEBAQEBAgGBgUGCQgK........";
    },    
    {
      "name": "test3",
      "final": "https://www.naver.com",       
      "imagePath": "data:image/jpeg;filename:image-test3.jpg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAMCAgICAgMCAgIDAwMDBAYEBAQEBAgGBgUGCQgK........";
     }   
  ],
  "customerId": 274865,
  "delFlag": false,
  "pcChannelId": "bsn-m002-00-000000000936100",
  "mobileChannelId": "bsn-m002-00-000000000936100",
  "nccAdExtensionId": "",
  "ownerId": "grp-a001-01-000000000063824",
  "type": "IMAGE_SUB_LINKS",
  "usePeriod": false,
  "userLock": false
} 
```

* Request
```
POST /ncc/ad-extensions/create
```
