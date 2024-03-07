---
categories: [release]
---

#### 2024년 3월 20일, 사이트 검색광고 반응형 소재가 추가됩니다. ([공지사항](https://saedu.naver.com/notice/view.naver?notiSeq=4273&catg=&fixYn=Y&searchOpt=all&keyword=))

* 반응형 소재는 파워링크 캠페인의 광고그룹에 등록가능합니다.
* 소재 유형에 `RSA_AD` 유형이 추가됩니다.
* 기존 `TEXT_45`유형 소재 조회/등록에 사용하는 API를 그대로 사용할수 있습니다.
* `RSA_AD` 소재 유형을 등록할 경우 `assets` 프로퍼티에 관련 애셋 목록이 같이 포함되어야 합니다.
* `RSA_AD` 소재 유형를 조회할 경우 `assets` 프로퍼티가 추가됩니다.
* `pin`은 선택적 사항으로 위치 고정 필요 문안에만 사용 바랍니다.(핀고정은 노출 조합의 개수를 감소시키므로 고정하지 않는 것을 추천합니다.)

### 반응형 소재 등록시 사용할 assets(array) 프로퍼티 정보
```javascript
{
    "linkType": String // "HEADLINE", "DESCRIPTION"
    "assetData": {
        "text": String // linkType이 "HEADLINE"일 경우 1자 ~ 15자, "DESCRIPTION"일 경우 20자 ~ 45자
    },
    "pin": String // 선택사항. linkType이 "HEADLINE"일 경우 "1", "2", "3" 만 유효. "DESCRIPTION"일 경우 "1", "2" 값만 유효
}
```
### 반응형 소재 등록 예제
```json
{
    "customerId": 123456789,
    "type": "RSA_AD",
    "nccAdgroupId": "grp-a001-01-000000000000000",
    "userLock": false,
    "ad": {
        "pc": {
            "display": "http://www.naver.com",
            "final": "http://www.naver.com"
        },
        "mobile": {
            "display": "http://www.naver.com",
            "final": "http://www.naver.com"
        }
    },
    "assets": [
        {
            "linkType": "HEADLINE",
            "assetData": {
                "text": "제목용 애셋 15 글자1"
            },
            "pin": "1"
        },
        {
            "linkType": "HEADLINE",
            "assetData": {
                "text": "제목용 애셋 15 글자2"
            }
        },
        {
            "linkType": "HEADLINE",
            "assetData": {
                "text": "제목용 애셋 15 글자3"
            }
        },
        {
            "linkType": "DESCRIPTION",
            "assetData": {
                "text": "설명 애셋은 20자 이상 입력해야 합니다. 1"
            }
        },
        {
            "linkType": "DESCRIPTION",
            "assetData": {
                "text": "설명 애셋은 20자 이상 입력해야 합니다. 2"
            }
        }
    ]
}
```

### 반응형 소재 조회 결과 예제
  ```json
     {
        "nccAdId": "nad-a001-01-000000000000000",
        "nccAdgroupId": "grp-a001-01-000000000000000",
        "customerId": 123456789,
        "inspectStatus": "UNDER_REVIEW",
        "type": "RSA_AD",
        "ad": {
            "mobile": {
                "display": "http://www.naver.com",
                "final": "http://www.naver.com",
                "punyCode": "http://www.naver.com"
            },
            "pc": {
                "display": "http://www.naver.com",
                "final": "http://www.naver.com",
                "punyCode": "http://www.naver.com"
            }
        },
        "adAttr": {},
        "userLock": true,
        "enable": true,
        "delFlag": false,
        "editTm": "2024-02-29T01:31:37.000Z",
        "regTm": "2024-02-27T07:21:47.000Z",
        "status": "PAUSED",
        "statusReason": "AD_UNDER_REVIEW",
        "assets": [
            {
                "nccAssetId": "ast-a001-000-000000000000000",
                "customerId": 123456789,
                "assetType": "TEXT",
                "assetData": {
                    "text": "제목용 애셋 15 글자1"
                },
                "inspectStatus": "APPROVED",
                "nccAdAssetLinkId": "alk-a001-01-000000000000000",
                "nccAdId": "nad-a001-01-000000000000000",
                "linkType": "HEADLINE",
                "regTm": "2024-02-27T16:21:47.000Z",
                "editTm": "2024-02-27T16:21:47.000Z"
            },
            {
                "nccAssetId": "ast-a001-000-000000000000000",
                "customerId": 123456789,
                "assetType": "TEXT",
                "assetData": {
                    "text": "제목용 애셋 15 글자2"
                },
                "inspectStatus": "APPROVED",
                "nccAdAssetLinkId": "alk-a001-01-000000000000000",
                "nccAdId": "nad-a001-01-000000000000000",
                "linkType": "HEADLINE",
                "regTm": "2024-02-27T16:21:47.000Z",
                "editTm": "2024-02-27T16:21:47.000Z"
            },
            {
                "nccAssetId": "ast-a001-000-000000000000000",
                "customerId": 123456789,
                "assetType": "TEXT",
                "assetData": {
                    "text": "제목용 애셋 15 글자3"
                },
                "inspectStatus": "APPROVED",
                "nccAdAssetLinkId": "alk-a001-01-000000000000000",
                "nccAdId": "nad-a001-01-000000000000000",
                "linkType": "HEADLINE",
                "regTm": "2024-02-27T16:21:47.000Z",
                "editTm": "2024-02-27T16:21:47.000Z"
            },
            {
                "nccAssetId": "ast-a001-000-000000000000000",
                "customerId": 123456789,
                "assetType": "TEXT",
                "assetData": {
                    "text": "설명 애셋은 20자 이상 입력해야 합니다. 1"
                },
                "inspectStatus": "APPROVED",
                "nccAdAssetLinkId": "alk-a001-01-000000000000000",
                "nccAdId": "nad-a001-01-000000000000000",
                "linkType": "DESCRIPTION",
                "regTm": "2024-02-27T16:21:47.000Z",
                "editTm": "2024-02-27T16:21:47.000Z"
            },
            {
                "nccAssetId": "ast-a001-000-000000000000000",
                "customerId": 123456789,
                "assetType": "TEXT",
                "assetData": {
                    "text": "설명 애셋은 20자 이상 입력해야 합니다. 2"
                },
                "inspectStatus": "APPROVED",
                "nccAdAssetLinkId": "alk-a001-01-000000000000000",
                "nccAdId": "nad-a001-01-000000000000000",
                "linkType": "DESCRIPTION",
                "regTm": "2024-02-27T16:21:47.000Z",
                "editTm": "2024-02-27T16:21:47.000Z"
            }
        ]
    } 
  ```

#### On March 20, 2024, Site Search Ads responsive text ad will be added. ([Announcement](https://saedu.naver.com/notice/view.naver?notiSeq=4273&catg=&fixYn=Y&searchOpt=all&keyword=))

* Responsive text ad can be added to adgroups in PowerLink campaigns.
* The `RSA_AD` type is added to the ad types.
* You can use the same API to retrieve/register the existing `TEXT_45` type ads.
* When registering the `RSA_AD` ad type, the `assets` property must include a list of related assets.
* When the `RSA_AD` ad type is retrieved, the `assets` property is added.
* `pin` is optional and should only be used for statements that require position pinning (pinning reduces the number of exposure combinations and is not recommended).

### About the assets(array) property to use when registering responsive text ads
```javascript
{
    "linkType": String // "HEADLINE", "DESCRIPTION"
    "assetData": {
        "text": String // 1 to 15 characters if linkType is "HEADLINE", 20 to 45 characters if "DESCRIPTION"
    },
    "pin": String // Optional. If linkType is "HEADLINE", only values "1", "2", and "3" are valid. If "DESCRIPTION", only values "1", "2" are valid
}
```
### Responsive text ad registration example
```json
{
    "customerId": 123456789,
    "type": "RSA_AD",
    "nccAdgroupId": "grp-a001-01-000000000000000",
    "userLock": false,
    "ad": {
        "pc": {
            "display": "http://www.naver.com",
            "final": "http://www.naver.com"
        },
        "mobile": {
            "display": "http://www.naver.com",
            "final": "http://www.naver.com"
        }
    },
    "assets": [
        {
            "linkType": "HEADLINE",
            "assetData": {
                "text": "제목용 애셋 15 글자1"
            },
            "pin": "1"
        },
        {
            "linkType": "HEADLINE",
            "assetData": {
                "text": "제목용 애셋 15 글자2"
            }
        },
        {
            "linkType": "HEADLINE",
            "assetData": {
                "text": "제목용 애셋 15 글자3"
            }
        },
        {
            "linkType": "DESCRIPTION",
            "assetData": {
                "text": "설명 애셋은 20자 이상 입력해야 합니다. 1"
            }
        },
        {
            "linkType": "DESCRIPTION",
            "assetData": {
                "text": "설명 애셋은 20자 이상 입력해야 합니다. 2"
            }
        }
    ]
}
```

### Example of responsive text ad inquiry results
  ```json
     {
        "nccAdId": "nad-a001-01-000000000000000",
        "nccAdgroupId": "grp-a001-01-000000000000000",
        "customerId": 123456789,
        "inspectStatus": "UNDER_REVIEW",
        "type": "RSA_AD",
        "ad": {
            "mobile": {
                "display": "http://www.naver.com",
                "final": "http://www.naver.com",
                "punyCode": "http://www.naver.com"
            },
            "pc": {
                "display": "http://www.naver.com",
                "final": "http://www.naver.com",
                "punyCode": "http://www.naver.com"
            }
        },
        "adAttr": {},
        "userLock": true,
        "enable": true,
        "delFlag": false,
        "editTm": "2024-02-29T01:31:37.000Z",
        "regTm": "2024-02-27T07:21:47.000Z",
        "status": "PAUSED",
        "statusReason": "AD_UNDER_REVIEW",
        "assets": [
            {
                "nccAssetId": "ast-a001-000-000000000000000",
                "customerId": 123456789,
                "assetType": "TEXT",
                "assetData": {
                    "text": "제목용 애셋 15 글자1"
                },
                "inspectStatus": "APPROVED",
                "nccAdAssetLinkId": "alk-a001-01-000000000000000",
                "nccAdId": "nad-a001-01-000000000000000",
                "linkType": "HEADLINE",
                "regTm": "2024-02-27T16:21:47.000Z",
                "editTm": "2024-02-27T16:21:47.000Z"
            },
            {
                "nccAssetId": "ast-a001-000-000000000000000",
                "customerId": 123456789,
                "assetType": "TEXT",
                "assetData": {
                    "text": "제목용 애셋 15 글자2"
                },
                "inspectStatus": "APPROVED",
                "nccAdAssetLinkId": "alk-a001-01-000000000000000",
                "nccAdId": "nad-a001-01-000000000000000",
                "linkType": "HEADLINE",
                "regTm": "2024-02-27T16:21:47.000Z",
                "editTm": "2024-02-27T16:21:47.000Z"
            },
            {
                "nccAssetId": "ast-a001-000-000000000000000",
                "customerId": 123456789,
                "assetType": "TEXT",
                "assetData": {
                    "text": "제목용 애셋 15 글자3"
                },
                "inspectStatus": "APPROVED",
                "nccAdAssetLinkId": "alk-a001-01-000000000000000",
                "nccAdId": "nad-a001-01-000000000000000",
                "linkType": "HEADLINE",
                "regTm": "2024-02-27T16:21:47.000Z",
                "editTm": "2024-02-27T16:21:47.000Z"
            },
            {
                "nccAssetId": "ast-a001-000-000000000000000",
                "customerId": 123456789,
                "assetType": "TEXT",
                "assetData": {
                    "text": "설명 애셋은 20자 이상 입력해야 합니다. 1"
                },
                "inspectStatus": "APPROVED",
                "nccAdAssetLinkId": "alk-a001-01-000000000000000",
                "nccAdId": "nad-a001-01-000000000000000",
                "linkType": "DESCRIPTION",
                "regTm": "2024-02-27T16:21:47.000Z",
                "editTm": "2024-02-27T16:21:47.000Z"
            },
            {
                "nccAssetId": "ast-a001-000-000000000000000",
                "customerId": 123456789,
                "assetType": "TEXT",
                "assetData": {
                    "text": "설명 애셋은 20자 이상 입력해야 합니다. 2"
                },
                "inspectStatus": "APPROVED",
                "nccAdAssetLinkId": "alk-a001-01-000000000000000",
                "nccAdId": "nad-a001-01-000000000000000",
                "linkType": "DESCRIPTION",
                "regTm": "2024-02-27T16:21:47.000Z",
                "editTm": "2024-02-27T16:21:47.000Z"
            }
        ]
    } 
  ```
