### Master Report
   * `Media` : The 11th field has been added `Group Id`. `Group Id` is a superordinate id. If media doesn't belong to Group, `Group Id` is empty.

No|Field Name|Value|Max.Length|Description
----|---|---|---|---
1|Type|string|20|Media Type.<br/> - `media` : media type<br/> - `group` : group type
2|ID|int||The unique ID of the same type media.
3|Media name|string|256|Media name
4|URL|string|1024|Media URL
5|NAVER Ad Networks|boolean|| true: this Media belongs to "NAVER Ad Networks", false : this Media dose not belong to "NAVER Ad Networks"
6|Portal Site|boolean|| true: this Media is a portal site, false : this Media isn't a portal site
7|PC Media|boolean|| true: This Media can be exposed by advertising sector is PC, false : This Media cannot be exposed by advertising sector is PC
8|Mobile Media|boolean||This Media can be exposed by advertising sector is Mobile, false : This Media cannot be exposed by advertising sector is Mobile
9|Search Ad Networks|boolean||true:  this Media belongs to "Search Ad Networks", false : this Media dose not belong to "Search Ad Networks"
10|Contents Ad Networks|boolean||true: this Media belongs to "Contents Ad Networks", false : this Media dose not belong to "Contents Ad Networks"
11|Group Id|int||Superordinate group Id
