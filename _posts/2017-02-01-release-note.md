### Campaign
 * a new type `POWER_CONTENTS` will be added.

### Channel
 * a new type `CONTENTS` will be added.
   * example businessInfo property
{% highlight json %}
{
	"contentsUrl": "http://blog.naver.com/xxxx",
	"site": "http://www.naver.com",
	"contentsChannelType": "BLOG"
}
{% endhighlight %}

 * Valid items of `contentsChannelType` are
   * `BLOG`
   * `CAFE`
   * `POST`

### Adgroup
 * an adgroup api will be added a new property
   * adgroupAttrJson : For `Power Contents` campaign types, this indicates adgroup type.
     * example json
{% highlight json %}
{ "contentsType": "INFORMATION"}
or
{ "contentsType": "PRODUCT"}
{% endhighlight %}

    
  * a new api will be added for `KEYWORD PLUS` impression-restricted keywords.

### Ad
 * two new types will be added.
   * `CONTENTS_AD_INFORMATION`
     * example ad property (json)
{% highlight json %}
{
  "headline": "파워 컨텐츠 제목",
  "description": "파워  컨텐츠 내용...",
  "pc": {
    "display": "http://blog.naver.com/test",
    "final": "http://blog.naver.com/test"
  },
  "mobile": {
    "display": "http://blog.naver.com/test",
    "final": "http://blog.naver.com/test"
  },
  "imageUrl": "/ncc_file_201612/21/grp-a001-03-000000000047879_7f7c307a-f0f3-4a8e-a5b6-919fd46f0d96.png",
  "companyName": "업체명 입력",
  "contentIssueDate": "2016-12-21"
}
{% endhighlight %}

   * `CONTENTS_AD_PRODUCT`
       * example ad property (json)
{% highlight json %}
{
  "headline": "파워 컨텐츠 제목",
  "description": "파워  컨텐츠 내용...",
  "pc": {
    "display": "http://blog.naver.com/test",
    "final": "http://blog.naver.com/test"
  },
  "mobile": {
    "display": "http://blog.naver.com/test",
    "final": "http://blog.naver.com/test"
  },
  "imageUrl": "/ncc_file_201612/21/grp-a001-03-000000000047879_7f7c307a-f0f3-4a8e-a5b6-919fd46f0d96.png",
  "companyName": "업체명 입력",
  "contentIssueDate": "2016-12-21",
  "releaseDate": "2017-01-01"
}
{% endhighlight %}

### AdKeyword
 * a `managedKeyword` property will be removed.

### ManagedKeyword
 * a `pCPLMaxDepth` property will be `PCPLMaxDepth`.
    * `pCPLMaxDepth` -> `PCPLMaxDepth`
 * a `isShoppingMall` property will be removed. Please check below note.
 * a new `expUiType` property will be added.
    * The type of `expUiType` is `String`.
    * A valid item is
      * `SHOPPING_MALL`
