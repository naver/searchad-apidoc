---
categories: [release]
---

#### 2024년 11월 13일 플레이스 검색 그룹의 노출 영역 확대로 매체 타겟팅 기능이 변경이 됩니다.


### 광고그룹 타겟팅
* 플레이스 검색 그룹의 매체타겟팅(targetTp=MEDIA_TARGET)에 ‘검색매체와 콘텐츠 매체’, 그리고 ‘네이버 매체와 파트너 매체’ 를 선택할 수 있습니다.

* 매체 타겟팅(targetTp=MEDIA_TARGET) JSON 구조체 예제

  * 모든매체 선택 예제
    ```
    {
        "type": 1,
        "contents": [],
        "search": [],
        "black": {
            "media": null,
            "mediaGroup": null
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
  * 검색매체 전체 선택한 예제
    ```
    {
        "type": 2,
        "contents": [],
        "search": [
            "naver",
            "partner"
        ],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
  * 검색매체 > 네이버 및 검색 포털 매체 선택한 예제
    ```
    {
        "type": 2,
        "contents": [],
        "search": [
            "naver"
        ],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
  * 검색매체 > 파트너 매체 선택한 예제
    ```
    {
        "type": 2,
        "contents": [],
        "search": [
            "partner"
        ],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
  * 콘텐츠 매체만 선택한 예제
    ```
    {
        "type": 2,
        "contents": [
            "naver",
            "partner"
        ],
        "search": [],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```

  * 콘텐츠 매체 > 네이버 및 검색 포털 매체 선택한 예제
    ```
    {
        "type": 2,
        "contents": [
            "naver"
        ],
        "search": [],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
  * 콘텐츠 매체 > 파트너 매체 선택한 예제
    ```
    {
        "type": 2,
        "contents": [
            "partner"
        ],
        "search": [],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
#### On November 13, 2024, the media targeting feature will be updated due to the expansion of the exposure area of the Place Search Adgroup.

### Adgroup Targeting
* For media targeting (targetTp=MEDIA_TARGET) in the Place Search Adgroup, you can select both 'Search Media and Content Media' and 'Naver Media and Partner Media.'
* Example of the media targeting (targetTp=MEDIA_TARGET) JSON structure

  * All media selection example
    ```
    {
        "type": 1,
        "contents": [],
        "search": [],
        "black": {
            "media": null,
            "mediaGroup": null
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
  * All search media Selected examples
    ```
    {
        "type": 2,
        "contents": [],
        "search": [
            "naver",
            "partner"
        ],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
  * Search media > Naver and search portal Selected examples
    ```
    {
        "type": 2,
        "contents": [],
        "search": [
            "naver"
        ],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
  * Search media > Partner media Selected examples
    ```
    {
        "type": 2,
        "contents": [],
        "search": [
            "partner"
        ],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
  * All content media Selected examples
    ```
    {
        "type": 2,
        "contents": [
            "naver",
            "partner"
        ],
        "search": [],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```

  * Content media > Naver and search portal Selected examples
    ```
    {
        "type": 2,
        "contents": [
            "naver"
        ],
        "search": [],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
  * Search media > Partner media Selected examples
    ```
    {
        "type": 2,
        "contents": [
            "partner"
        ],
        "search": [],
        "black": {
            "media": [],
            "mediaGroup": []
        },
        "white": {
            "media": null,
            "mediaGroup": null
        }
    }
    ```
