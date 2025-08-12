---
title: Release Note
categories: [release]
---


#### 2025년 9월 1일 [광고 계정 통합](https://ads.naver.com/notice/23921?categoryId=226&searchValue=&page=1L) 구조에 맞는 새로운 광고 계정, 관리 계정 API 가 추가 됩니다.

### 광고계정 API


#### 권한을 가지고 있는 광고계정 목록 조회
```
GET /ad-accounts
```
- [AdAccounts: list](https://naver.github.io/searchad-apidoc/#/operations/GET/~2Fad-accounts)
- 자신이 구성원으로 포함되어있는 광고계정의 목록을 조회합니다.

#### 특정 광고 계정의 구성원 목록 조회
```
GET /ad-accounts/{adAccountNo}/members
```
- [AdAccounts: Retrieve Ad Account Member List](https://naver.github.io/searchad-apidoc/#/operations/GET/~2Fad-accounts~2F%7BadAccountNo%7D~2Fmembers)
- 자신의 구성원으로 포함되어있는 특정 계정의 구성원 전체 목록을 조회합니다.

### 관리 계정 API 

#### 권한을 가지고 있는 관리 계정 목록 조회 
```
GET /manager-accounts
```
- [ManagerAccounts: list](https://naver.github.io/searchad-apidoc/#/operations/GET/~2Fmanager-accounts)
- 자신이 구성원으로 포함되어있는 관리계정의 목록을 조회합니다.

#### 특정 권한을 가진 관리 계정의 하위 광고 계정 목록 조회 

```
GET /manager-accounts/{managerAccountNo}/child-ad-accounts
```

- [ManagerAccounts: Retrieve Child Ad Account List](https://naver.github.io/searchad-apidoc/#/operations/GET/~2Fmanager-accounts~2F%7BmanagerAccountNo%7D~2Fchild-ad-accounts)
- 자신이 구성원으로 포함되어있는 관리계정의 전체 하위 광고계정 (관리 가능한 광고계정) 목록을 조회합니다.
 
### 안내 

- 각각 API 의 자세한 응답값은 문서를 확인 부탁드리겠습니다.
- 추가되는 API 는 2025년 9월 1일 네이버 광고 플랫폼 개편 오픈 이후 사용이 가능합니다. 
- 해당 API의 응답 필드는 추후 변경될 수 있으며, 변경 시 별도 공지를 통해 안내드릴 예정입니다.
* \* 관리 계정 체계에 대한 추가 설명 및 실제 CMS 화면 구성은 추후 광고주 공지로 진행 예정입니다.
* \* 대행사 Agent 관리 방식 및 기존 영업권 관리계정 체계 전환 방식은 추후 가이드 및 설명회 진행 예정입니다.



---

#### New Ad Account and Manager Account APIs will be added according to the [Ad Account Integration](https://ads.naver.com/notice/23921?categoryId=226&searchValue=&page=1L) structure on September 1, 2025.

### Ad Account API

#### Retrieve List of Ad Accounts with Access Rights
```
GET /ad-accounts
```
- [AdAccounts: list](https://naver.github.io/searchad-apidoc/#/operations/GET/~2Fad-accounts)
- Retrieves a list of ad accounts in which you are included as a member.

#### Retrieve Member List of a Specific Ad Account
```
GET /ad-accounts/{adAccountNo}/members
```
- [AdAccounts: Retrieve Ad Account Member List](https://naver.github.io/searchad-apidoc/#/operations/GET/~2Fad-accounts~2F%7BadAccountNo%7D~2Fmembers)
- Retrieves the full list of members for a specific ad account in which you are included as a member.

### Manager Account API

#### Retrieve List of Manager Accounts with Access Rights
```
GET /manager-accounts
```
- [ManagerAccounts: list](https://naver.github.io/searchad-apidoc/#/operations/GET/~2Fmanager-accounts)
- Retrieves a list of manager accounts in which you are included as a member.

#### Retrieve List of Child Ad Accounts for a Specific Manager Account

```
GET /manager-accounts/{managerAccountNo}/child-ad-accounts
```

- [ManagerAccounts: Retrieve Child Ad Account List](https://naver.github.io/searchad-apidoc/#/operations/GET/~2Fmanager-accounts~2F%7BmanagerAccountNo%7D~2Fchild-ad-accounts)
- Retrieves the full list of child ad accounts (manageable ad accounts) under a manager account in which you are included as a member.

### Notice

- Please refer to the documentation for detailed response fields of each API.
- The new APIs will be available after the Naver Ads Platform renewal opens on September 1, 2025.
- The response fields of these APIs are subject to change, and any changes will be announced separately.
* \* Additional explanations about the manager account structure and the actual CMS screen configuration will be provided in a future advertiser notice.
* \* The agency Agent management method and the transition method for the existing sales right manager account structure will be guided and explained in future sessions.



