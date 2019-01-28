# Naver Search AD API

## Emergency Inspection Notice (2018/10)

Date: October, 18, 2018 (thursday) 03:00 AM - October, 18, 2018 (thursday) 07:00 AM 

(Korea Standard Time, The inspection time may vary depending on the conditions.)

API service will be suspended during the inspection period.

## Notice (2019/1/28)

Notice of the data type of the COST field in the report

The data type of the COST field in the report file of STATREPORT is REAL. However, there was a problem that the actual value provided was provided in INTGER format. So, it was changed to REAL type at 5:00 pm on January 24, 2019.

한글 공지 사이트 서비스가 현재 잠시 중단되어 복구 중에 있어 
예외적으로 이 페이지에서 한글 공지를 드립니다. 

지난 2019년 1월 24일 오후 5시 real 형으로 제공되어야하는 STATREPORT의 COST 필드가 integer 형태로 제공되고 있는 것이 확인 되어 
긴급하게 REAL 형으로 변경하였습니다. 이는 기존의 제공되던 값에 소수점 값도 표기 됨을 의미 합니다. 
예를 들어 2200으로 광고비가 표기되던 항목이 2200.0 으로 표기 되게 됩니다. 영향성에 대한 저희 판단 오류가 있어 
미리 공지를 드리지 못한점 사과의 말씀 드립니다. 

## API Specification
http://naver.github.io/searchad-apidoc/

Error Code : https://github.com/naver/searchad-apidoc/blob/master/NaverSA_API_Error_Code_MAP.md

## Notice (KOR)
http://doc.api.naver.com/searchad/ko/notice_all

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
