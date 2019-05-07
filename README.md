# Naver Search AD API

## Inspection Notice (2019/5)
Date: May, 16, 2019 (thursday) 03:00 AM - May, 16, 2019 (thursday) 07:00 AM

(Korea Standard Time, The inspection time may vary depending on the conditions.)

API service will be suspended during the inspection period.

## Notice (2019/4/30)
## 대용량보고서 변경 공지 예정 

안녕하세요. 검색광고 API입니다. 
대용량보고서에 조회수(‘View’)지표가 추가될 예정이어서 이에 공지 드립니다.

1.대상 오퍼레이션

StatReport

2.변경 사항 
‘View’ 지표 추가. 
(View 는 기준일자의 과금되는 동영상 조회수 입니다.)

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
View|int| 기준일자의 과금되는 동영상 조회수 입니다.

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
