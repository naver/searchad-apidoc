---
categories: [release]
---

#### 2024년 1월 25일, 캠페인 삭제 API가 제공이 됩니다.

* 단일 캠페인과 하위의 모든 광고 요소를 같이 삭제하는 API가 제공이 됩니다.
* 복수의 캠페인과 캠페인 하위의 모든 광고 요소를 같이 삭제하는 API가 제공이 됩니다.
* 캠페인과 하위 광고 요소를 모두 삭제하기 때문에 요청의 응답시간은 길어질수 있습니다.
* 삭제된 캠페인과 광고 요소는 복구가 되지 않습니다.
* API 문서는 추후 업데이트될 예정입니다.

### 단일 캠페인 삭제
* 요청
  ```shell
  DELETE /ncc/campaigns/{campaign id}
  ```
* 응답코드: 
  * 성공: HTTP NO_CONTENT (204)
  * 실패: 각 에러 상황에 맞는 에러 코드

* 예제
   ```
   DELETE /ncc/campaigns/cmp-a001-01-000000000000000
   ```

### 복수 캠페인 삭제
* 요청
  ```shell
  DELETE /ncc/campaigns?ids={campaign id 목록}
  ```
  * 파라미터: ids (삭제 하고자 하는 캠페인 ID 목록)
* 응답코드: 
  * 성공: HTTP NO_CONTENT (204)
  * 실패: 각 에러 상황에 맞는 에러 코드

* 예제
   ```
   DELETE /ncc/campaigns?ids=cmp-a001-01-000000000000000,cmp-a001-01-000000000000000,cmp-a001-01-000000000000000
   ```

#### On January 25, 2024, a campaign deletion API will be available.

* API can delete a single campaign and all of its ad elements together.
* API can delete multiple campaigns and all ad elements under them together.
* The response time of the request may be longer due to the deletion of all campaigns and child ad elements.
* Deleted campaigns and ad elements are not recoverable.
* The API documentation will be updated at a later date.

### Delete a single campaign
* Request
  ```shell
  DELETE /ncc/campaigns/{campaign id}
  ```
* Response code: 
  * Success: HTTP NO_CONTENT (204)
  * Failure: Error code for each error situation

* Example.
   ```
   DELETE /ncc/campaigns/cmp-a001-01-000000000000000
   ```

### Delete multiple campaigns
* Request
  ```shell
  DELETE /ncc/campaigns?ids={campaign id list}
  ```
  * Parameter: ids (list of campaign IDs to delete)
* Response code: 
  * Success: HTTP NO_CONTENT (204)
  * Failure: Error code for each error situation

* Example.
   ```
   DELETE /ncc/campaigns?ids=cmp-a001-01-000000000000000,cmp-a001-01-000000000000000,cmp-a001-01-000000000000000
   ```
