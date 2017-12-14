### AdExtension
 * new types under `WEB_SITE` campaign will be added
   * here are new types.
     * `POWER_LINK_IMAGE`
     * `IMAGE_SUB_LINKS`
   * these types are able to be registered under **adgroup** only.
   * for each new type, you can register **two** ad extension  under adgroup with respectively.
   * here are json sample.
   
   
{% highlight json %}

POWER_LINK_IMAGE
{
  "imagePath":"/MjAxNzEyMTRfMTA0/MDAxNTEzMjE2NjE5MTA1.9Mowi4BmtOFntxFsq_DV6kj5g7DW2D0zoAR2Eqi76bsg.vYCD3m3YzNC89rZFZRsRFiRsZL0pBil8qOP6cWhXzzsg.PNG/729070-8162c2b0-00b8-45f7-8609-e1a9b84d54f7.png"
}

IMAGE_SUB_LINKS
[
  {
    "name": "이미지링크1",
    "final": "http://searchad.naver.com",
    "imagePath": "/MjAxNzEyMTRfNDYg/MDAxNTEzMjE2NzM2MjI1.Nk2UFD1pkaZpTUuMzhiantazKh4uEzKw-JGUuces9TUg.eCTwCuTP9eTZze3KSghG6cpjt8cQ0Ieal5cOcCAeL9Yg.JPEG/729070-3cd52ecb-9641-4930-87e0-1cce63c9c538.jpg"
  },
  {
    "name": "이미지링크2",
    "final": "http://www.naver.com",
    "imagePath": "/MjAxNzEyMTRfMzAg/MDAxNTEzMjE2NzM2MjQz.HSGwNvutTUBwZIpMv7NAATBJZfKcCb9Nav1Lu64VHEcg.7rErVr9Nhy_906U7B1uQyTRsITT8AlZgun3O7AoDoT4g.PNG/729070-117565a3-9359-456e-b5a1-8457c2c13350.png"
  },
  {
    "name": "이미지링크3",
    "final": "http://blog.naver.com",
    "imagePath": "/MjAxNzEyMTRfMTQ3/MDAxNTEzMjE2NzM2Mjcx.hmtBAraANihxJqlnuPZbS3kNP7vDP1_uLApI55BFTisg.pnXo7qkNz_D6sxRhMuYd5AbuxyDmlhKWTM7AIKWds78g.PNG/729070-988628f4-07fa-4ded-ad32-54c4934a0096.png"
  }
]

{% endhighlight %}
