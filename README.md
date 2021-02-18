# Naver Search AD API


## 검색광고 보고서 API 점검 공지 / Search Ads Report API Inspection Notice (2020/2/12 14:00~16:00 KST)
작업 기간 (2020년 2월 12일 14:00-16:00) 동안 검색광고 API 보고서 작업이 예정 되어 있습니다. 
작업 기간 동안에 서비스 중단 등은 없을 예정이오나, 해당 작업 시간에 API 요청시 응답이 실패 할 수도 있습니다. 
이점 참고하여 주시기 바랍니다.  감사합니다. 

Due to internal inspection within date, There will be NO API SERVICE INTERRUPTIONS on below date.
But during the inspection schedule (about 2 hours), Some report API request could be fail.
Please refer to these information. Thanks.

Inspection date: Feb, 12, 2020 (Wed) 14:00~16:00 (KST)
(Korea Standard Time, The inspection time may vary depending on the conditions.)

## Inspection Notice (2019/5)
Date: May, 16, 2019 (thursday) 03:00 AM - May, 16, 2019 (thursday) 07:00 AM

(Korea Standard Time, The inspection time may vary depending on the conditions.)

API service will be suspended during the inspection period.

## Notice (2019/4/30)
## 대용량보고서 변경 공지 예정 

*기존 4/30 조회수 영문 지표명을 'View' 에서 'View count' 로 수정 하였습니다. (5/16) 

안녕하세요. 검색광고 API입니다. 
대용량보고서에 조회수(‘View count’)지표가 추가될 예정이어서 이에 공지 드립니다.

1.대상 오퍼레이션

StatReport

2.변경 사항 
‘View count’ 지표 추가. 
(View count 는 기준일자의 과금되는 동영상 조회수 입니다.)

* 적용 지표 
 
ReportType | 보고서 이름
-----------| -------|
AD|광고효과보고서
AD_DETAIL|광고효과상세보고서
ADEXTENSION|확장소재효과보고서
EXPKEYWORD|키워드확장광고효과보고서
SHOPPINGKEYWORD_DETAIL|쇼핑검색광고키워드상세보고서

* 추가 프로퍼티

Property name | Data type | Description
-----------| -------| -------|
View count|int| 기준일자의 과금되는 동영상 조회수 입니다.

3.변경 적용 시점

2019년 5월 30일 오전 1시 적용 예정 (5월 29일 지표 부터 조회 가능)

업무에 참고 부탁 드립니다.

감사합니다.



## API Specification
http://naver.github.io/searchad-apidoc/

Error Code : https://github.com/naver/searchad-apidoc/blob/master/NaverSA_API_Error_Code_MAP.md

## Notice (KOR)
http://naver.github.io/searchad-apidoc/#/notice

## NAVER SEARCH ADVERTISER's Center
http://manage.searchad.naver.com

### Issue the API License and the secret key

1. Sign up for NAVER SEARCH ADVERTISER's Center (http://searchad.naver.com)
2. Go to (http://manage.searchad.naver.com)
3. Go to Tools > API Manager
4. Create API license


## API Sample Code

### [Java Sample](java-sample)
### [PHP Sample](php-sample)
### [Python Sample](python-sample)
