### Master Report
   * `Adgroup` : The 9th field has been changed to `PC network bid weighting value`.
     * `before` : Using mobile network bidding weight
     * `after` : PC network bidding weight

No|Field Name|Value|Max.Length|Description
--|----------|-----|----------|-----------
1|Customer ID|int||Customer ID
2|Ad Group ID|string|31|Ad Group ID
3|Campaign ID|string|31|Campaign(which has this Ad Group) ID 
4|Ad Group Name|string|256|The maximum number of characters allowed (regardless of character types) is 30 Korean Hangul, alphanumeric characters can be used.
5|Ad Group Bid amount|int|| Korean Won(KRW), from 70 to 100,000
6|ON/OFF|int|| - 0: ON<br/> - 1: OFF
7|Using contents network bid|int|| - 0: not used <br/> - 1: used
8|Contents network bid|int||Korean Won(KRW), from 70 to 100,000
9|PC network bidding weight|int||percent, from 10 to 500
10|Mobile network bidding weight|int||percent, from 10 to 500
11|Using KeywordPlus|int|| - 0: not used <br/> - 1: used
12|KeywordPlus bidding weight|int||percent, from 1 to 9999
13|Business Channel Id(Mobile)|string|31|The unique ID of the PC business channel containing this ad group 
14|Business Channel Id(PC)|string|31|The unique ID of the mobile business channel containing this ad group
15|regTm|date||The time at which information was created(ISO8601)
16|delTm|date||The time at which the campaign was deleted(ISO8601)

