### Estimate
   * URI Moved  :   `/estimate/first-page-bid` => `/estimate/exposure-minimum-bid`
   * Required parameter (`period`) added : `/estiamte/median-bid`, `/estimate/exposure-minimum-bid`
     * period
       - DAY : use yesterday statistics
       - MONTH : use last 28 days statistics
     * Example :
{% highlight json %}
{  
   "device":"PC",
   "period":"DAY",
   "items":[  
     "제주여행",
     "자전거여행"
  ]
}
{% endhighlight %}