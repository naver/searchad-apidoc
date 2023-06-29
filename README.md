# Naver Search AD API


## [긴급]유사 검색어 기능(beta) 제공에 따른 마스터(Master-Report) 변경 일정 변경 ##

지난 2023년 5월 29일 공지 드린 "유사 검색어 기능(beta) 제공에 따른 마스터(Master-Report) 변경" 
건의 적용 시점이 변경 되어 공지 드립니다. 

변경 내용은 아래와 같습니다. 
* 변경 마스터  및 변경 사항<br>
대상 마스터 : Ad group MASTER(ITEM :Adgroup)<br>
변경 사항 : 20번째 열로 유사 검색어 사용 여부를 표시하는 Using CloseVariant 항목추가, 데이터형은 int이며 값은 0:사용하지 않음, 1:사용함 입니다.
 
* 변경 반영 일정(KST기준)<br>
**2023년 6월 29일 17시~18시 사이**

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
