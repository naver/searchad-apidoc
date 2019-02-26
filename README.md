# Naver Search AD API

## Notice (2019/2/22)
보고서 데이터에 오류가 있어 공지 드립니다.

1. 오류 발생 보고서

STAT : id 에 확장소재id를 요청한 경우,impCnt 

STAT-REPORT :

- AD extension Report (reportTp : ADEXTENSION) impression


2. 오류 발생 보고서 일자 

2018년 2월 8일  ~ 2019 2월18일 

3. 데이터 복구 시점 

데이터 복구가 불가능 합니다. 

4. 기타 참고 사항 

이미지형 서브링크는, 노출 대상 업종별 키워드가 별도로 정해져 있습니다.
(공지사항 참조 :
https://saedu.naver.com/notice/view.nhn?notiSeq=3317)

확장소재로 이미지형 서브링크를 등록 하고, 노출 대상 키워드가 아닌데
확장소재의 노출로 오집계 되는 오류가 있음을 확인 했습니다. 

이점 참고하여, 업무에 참고 부탁 드리겠습니다. 

 
업무에 불편을 드려 대단히 죄송합니다. 


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
