### Estimate
  * NPC estimation service added
  * /npc-estimate/average-position-bid/{type}

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

  * /npc-estimate/exposure-minimum-bid/{type}
  
