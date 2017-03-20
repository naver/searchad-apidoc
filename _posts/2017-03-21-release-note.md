### AdExtension
 * new properties will be added.
   * name: `usePeriod`, type: boolean
     * this property is **required** when ad extension is created.
   * name: `periodStartDt`, type: datetime
   * name: `periodEndDt`, type: datetime

 * modifying `usePeriod, periodStartDt, periodEndDt` operation will be added.
   * you can just set `fields=period`

 * new types under `WEB_SITE` campaign will be added
   * here are new types.
     * `HEADLINE`
     * `DESCRIPTION`
     * `SUB_LINKS`
     * `PRICE_LINKS`
   * these types are able to be registered under **adgroup** only.
   * for each new type, you can register **two** ad extension  under adgroup with respectively.
   * here are json sample.
{%highlight json %}
HEADLINE
{
  "headline": "세일 하는 지금이 기회야!"
}

DESCRIPTION
{
  "heading": "추가할인",
  "description": "5만원 이상 구매시 10% 할인"
}

SUB_LINKS
[
  {
    "name": "변호사 소개",
    "final": "http://www.naver.com"
  },
  {
    "name": "질문과 답변",
    "final": "http://www.naver.com"
  },
  {
    "name": "온라인 상담",
    "final": "http://www.naver.com"
  }
]

PRICE_LINKS
[
  {
    "name": "1박2일 패키지",
    "price": 149000,
    "final": "http://www.naver.com"
  }
]
{%endhighlight %}
