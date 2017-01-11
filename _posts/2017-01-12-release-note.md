### Estimate
  * NPLA estimation service added
  * /npla-estimate/average-position-bid/{type}
{% highlight json %}
==>
POST /npla-estimate/average-position-bid/id
{  
  "device":"PC",
  "items":[  
    {  
      "key":"nad-a001-01-00000000000xxxx",
      "position":1
    },
    {  
      "key":"nad-a001-01-00000000000xxxx",
      "position":1
    }
  ]
}

<==
{  
  "device":"PC",
  "items":[  
    {  
      "product":"67460836xx",
      "key":"nad-a001-01-00000000000xxxx",
      "position":1,
      "bid":220
    },
    {  
      "keyword":"997460666xx",
      "key":"nad-a001-01-00000000000xxxx",
      "position":1,
      "bid":5190
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
