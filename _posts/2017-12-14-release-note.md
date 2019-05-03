---
categories: [release]
---

### AdExtension
 * new types under `WEB_SITE` campaign will be added
   * here are new types.
     * `POWER_LINK_IMAGE`
     * `IMAGE_SUB_LINKS`
   * these types are able to be registered under **adgroup** only.
   * for each new type, you can register **two** ad extension  under adgroup with respectively.
   * here are json sample.
     * `POWER_LINK_IMAGE`
     ```json
     {
        "imagePath" : "/MjAxNzExMjJfMTEw/MDAxNTExMzM5NzYwODk1.QnHcPp6mAr3I-Kkx18IjxoWIAJNrvTgx7NTqXQTfd9kg.Y6csE9Q37Wph49njzVczrmjJWxSkpRPXehxDxpBvlw4g.PNG/mong1.PNG"
     }
     ```
     * `IMAGE_SUB_LINKS`
     ```json
     [
      { "name" : "이미지 서브링크1", "final" : "http://www.naver.com", "imagePath": "/MjAxNzExMjJfMTEw/MDAxNTExMzM5NzYwODk1.QnHcPp6mAr3I-Kkx18IjxoWIAJNrvTgx7NTqXQTfd9kg.Y6csE9Q37Wph49njzVczrmjJWxSkpRPXehxDxpBvlw4g.PNG/mong1.PNG"},
      { "name" : "이미지 서브링크2", "final" : "http://manage.searchad.naver.com", "imagePath": "/MjAxNzExMjJfMTEw/MDAxNTExMzM5NzYwODk1.QnHcPp6mAr3I-Kkx18IjxoWIAJNrvTgx7NTqXQTfd9kg.Y6csE9Q37Wph49njzVczrmjJWxSkpRPXehxDxpBvlw4g.PNG/mong1.PNG" },
      { "name" : "이미지 서브링크3", "final" : "http://searchad.naver.com", "imagePath": "/MjAxNzExMjJfMTEw/MDAxNTExMzM5NzYwODk1.QnHcPp6mAr3I-Kkx18IjxoWIAJNrvTgx7NTqXQTfd9kg.Y6csE9Q37Wph49njzVczrmjJWxSkpRPXehxDxpBvlw4g.PNG/mong1.PNG" },
     ]
     ```
