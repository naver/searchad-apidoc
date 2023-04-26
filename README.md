# Naver Search AD API
## 공유 예산 기능 반영에 따른 대용량 보고서 변경 안내 (23/4/26반영)

공유 예산 기능이 추가됨에 따라 마스터(MASTER-REPORT)에 수정 및 추가 사항이 있어 이에 공지드립니다.<br>
변경 사항에 대해 미리 공지를 드리지 못한점 사과 말씀드립니다.<br>
관련 공지 : https://saedu.naver.com/notice/view.naver?notiSeq=4064<br>
릴리즈 노트 : https://naver.github.io/searchad-apidoc/#/release-notes<br>

* 변경 마스터 및 변경 사항<br>
Campaign MASTER(ITEM :Campaign) : 12번째열로 shared_budget_id 항목추가, string(31), nullable<br>
Ad group MASTER(ITEM :Adgroup) : 19번째열로 shared_budget_id 항목추가, string(31), nullable<br>
shared_budget_id는 공유 예산을 사용하는 경우에만 공유 예산 아이디가 표기 되며<br>
공유 예산을 사용하지 않는 경우 null 입니다.<br>

* 신규 마스터<br>
공유 예산 마스터 (ITEM : SharedBudget)<br>

* 적용 시점(KST 기준)<br>
2023년 4월 26일 17시에서 동일 17시 30분 사이<br>

세부사항은 레퍼런스 페이지의 공지 항목을 참고 부탁드립니다. <br>
https://naver.github.io/searchad-apidoc/#/notice<br>

감사합니다. <br>

## 네이버 검색광고 API 접속 도메인 변경 안내



안녕하십니까 네이버 검색광고 API 담당자입니다. <br>

네이버 검색광고 API의 서비스 도메인 변경이 예정되어 있어 공지 드립니다. <br>
<br>
1. 변경 내역<br> 
 현재 도메인 : api.naver.com<br>
 변경도메인 : api.searchad.naver.com<br>

2. 변경 일정 (모든 시간 KST 기준)<br>
   **api.naver.com 도메인 서비스 중단 :  2023년 3월 22일**  <br>
   api.searchad.naver.com 도메인 서비스 베타  테스트 시작 : 2022년 9월 21일  오후 중 <br>
   api.searchad.naver.com 도메인 서비스 베타 테스트 종료 : 2022년 12월 22일 <br>
   api.searchad.naver.com 도메인 정식 서비스 시작 : 2022년 12월 22일 오후<br>
   api.naver.com 도메인 서비스 중단 : 2023년 3월 22일 오후<br>
   <br>
   api.naver.com 도메인은 서비스 중단 시점인 2023년 3월 22일 오후까지는 계속 사용하실수 있으며 서비스 중단 시점 이후에는 
   사용하실 수 없습니다. <br>
<br>
감사합니다. <br><br>

Hello,This is Naver Search Ads API serive team. <br>

We will inform you that the service domain of the Naver Search Ads API is scheduled to be changed. <br>
<br>
1. Changes<br>
 Current domain: api.naver.com<br>
 Changed domain: api.searchad.naver.com<br>

2. Change schedule (all date and times KST)<br>
   **  Discontinuation of api.naver.com domain service: March 22, 2023 **  <br>
   api.searchad.naver.com Domain Services Beta Testing Begins: September 21, 2022 in the afternoon <br>
   api.searchad.naver.com Domain Services Beta Test Ended: December 22, 2022 <br>
   api.searchad.naver.com domain official service start: December 22, 2022<br>
   api.naver.com domain end of service : March 22, 2023<br>
   <br>
   You can continue to use the api.naver.com domain until March 22, 2023, when the service is stopped, and after the service is stopped,
   It cannot be used. <br>
<br>
thank you<br>

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
