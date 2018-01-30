### Estimate
 * new Naver-PowerContents estimation service will be added.
   * path: `/npc-estimate/performance`
   * desc: estimate performance data by keyword
   * here are json sample.
   
{% highlight json %}

Request: /npc-estimate/performance
{
  "device": "PC",
  "keywords": [
    "제주숙소",
    "제주도에어카텔",
    "제주도렌터카",
    "제주도리조트"
  ],
  "level": 1
}

Response: 
{  
   "device": "PC",
   "level": 1,
   "items":[  
      {  
         "keyword":"제주숙소",
         "clicks":63844,
         "impressions":503,
         "cost":79280
      },
      {  
         "keyword":"제주도에어카텔",
         "clicks":10834,
         "impressions":106,
         "cost":16530
      },
      {  
         "keyword":"제주도렌터카",
         "clicks":5901,
         "impressions":81,
         "cost":5950
      },
      {  
         "keyword":"제주도리조트",
         "clicks":17978,
         "impressions":240,
         "cost":51620
      }
   ]
}{% endhighlight %}
