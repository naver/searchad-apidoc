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
{% endhighlight %}

