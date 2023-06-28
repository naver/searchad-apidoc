---
categories: [release]
---

### Master Report

#### Ad Group (AdGroup)

   * Column `Using CloseVariant` has added.

No|Field Name|Value|Max.Length|Description
----|---|---|---|---
1|Customer ID|int||Customer ID
2|Ad Group ID|string|31|Ad Group ID
3|Campaign ID|string|31|Campaign(which has this Ad Group) ID 
4|Ad Group Name|string|256|The maximum number of characters allowed (regardless of character types) is 30 Korean Hangul, alphanumeric characters can be used.
5|Ad Group Bid amount|int|| Korean Won(KRW), from 70 to 100,000
6|ON/OFF|int|| - 0: ON<br/> - 1: OFF
7|Using contents network bid|int|| - 0: not used <br/> - 1: used
8|Contents network bid|int||Korean Won(KRW)<br/>For the minimum and maximum prices according to the [AdGroup Type], please refer to the product-specific advertisement management section of the link below.<br/>https://saedu.naver.com/help/faq/ncc/index.nhn
9|PC network bidding weight|int||percent, from 10 to 500
10|Mobile network bidding weight|int||percent, from 10 to 500
11|Using KeywordPlus|int|| - 0: not used <br/> - 1: used
12|KeywordPlus bidding weight|int||percent, from 1 to 9999
13|Business Channel Id(Mobile)|string|31|The unique ID of the Mobile business channel containing this ad group 
14|Business Channel Id(PC)|string|31|The unique ID of the PC business channel containing this ad group
15|regTm|date||The time at which information was created(ISO8601)
16|delTm|date||The time at which the campaign was deleted(ISO8601)
17|Content Type|string|32|Content type information. Only if the campaign type is 3.<br/>- INFORMATION : Contents  Ad Type is Information Type.<br/>- PRODUCT : Contents Ad Type is Product Type.
18|AdGroup Type|int||- 1: NAVER PowerLink<br/>- 2: NAVER Shopping Product Ad<br/>- 3: NAVER PowerContents Information<br/>- 4: NAVER PowerContents Product<br/>- 5: NAVER Brand SearchAd<br/>- 6: Local SMB Ad<br/>- 7: NAVER Catalog Ad<br/>- 8: NAVER Brand SearchAd Brand Zone<br/>- 9: NAVER Brand Shopping SearchAd<br/>- 10 Place ad<br/>-11: New product search ad
19| Shared Budget ID | string | 31 | Share Budget ID
20| Using CloseVariant | int | - 0: not used<br/> - 1: used
