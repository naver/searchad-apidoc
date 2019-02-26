---
categories: [release]
---

### Estimate
   * `/estimate/performance-bulk` added
   * you can estimate max 200 of items of performance data.
   * Example :
     - Request
{% highlight json %}
{  
  "items":[  
    {  
      "keyword":"제주여행",
      "bid":70,
      "device":"PC",
      "keywordplus":false
    },
    {  
      "keyword":"제주도",
      "bid":70,
      "device":"PC",
      "keywordplus":false
    },
    {  
      "keyword":"맛집",
      "bid":70,
      "device":"PC",
      "keywordplus":false
    },
    {  
      "keyword":"여행",
      "bid":70,
      "device":"PC",
      "keywordplus":false
    }
  ]
}
{% endhighlight %}

     - Response
{% highlight json %}
{  
  "items":[  
    {  
      "keyword":"제주여행",
      "bid":70,
      "device":"PC",
      "keywordPlus":false,
      "clicks":1,
      "impressions":28570,
      "cost":70
    },
    {  
      "keyword":"제주도",
      "bid":70,
      "device":"PC",
      "keywordPlus":false,
      "clicks":1,
      "impressions":150107,
      "cost":70
    },
    {  
      "keyword":"맛집",
      "bid":70,
      "device":"PC",
      "keywordPlus":false,
      "clicks":1,
      "impressions":19754,
      "cost":70
    },
    {  
      "keyword":"여행",
      "bid":70,
      "device":"PC",
      "keywordPlus":false,
      "clicks":1,
      "impressions":48932,
      "cost":70
    }
  ]
}
{% endhighlight %}
