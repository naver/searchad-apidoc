### Estimate
  * NPLA estimation service added
  * /npla-estimate/average-position-bid/{type}
  
{% highlight json %}
==>
POST /npc-estimate/average-position-bid/id
{  
  "device":"PC",
  "items":[  
    {  
      "key":"nkw-a001-03-000000000XXXXXX",
      "position":1
    },
    {  
      "key":"nkw-a001-03-000000000XXXXXX",
      "position":1
    }
  ]
}

<==
{  
  "device":"PC",
  "items":[  
    {  
      "keyword":"청첩장",
      "key":"nkw-a001-03-000000000XXXXXX",
      "position":1,
      "bid":200
    },
    {  
      "keyword":"기숙학원",
      "key":"nkw-a001-03-000000000XXXXXX",
      "position":1,
      "bid":15190
    }
  ]
}
{% endhighlight %}

  * /npla-estimate/exposure-minimum-bid/{type}
  
{% highlight json %}
==>
POST /npla-estimate/exposure-minimum-bid/product
{  
  "device":"PC",
  "items":[  
    "6746083685",
    "99746066682"
  ]
}

<==
{  
  "device":"PC",
  "items":[  
    {  
      "productId":"6746083685",
      "bid":220
    },
    {  
      "productId":"99746066682",
      "bid":5190
    }
  ]
}
{% endhighlight %}
