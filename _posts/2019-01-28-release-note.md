### Master Report

#### Catalog Contents (CatalogAd)

   * `CatalogAd` master report has added. 


No | Field Name | Value | Max.Length | Description
-- | -- | -- | -- | --
1 | Customer ID | int |   | Customer ID
2 | Ad Group ID | string | 31 | Ad Group ID
3 | Ad ID | string | 31 | Ad Creative ID
4 | Ad Creative Inspect   Status | int |   | - 10: UNDER_REVIEW<br/> - 20: APPROVED<br/> - 30: LIMITED_APPROVED<br/> - 40: PENDING
5 | ON/OFF | int |   | -   0: ON<br/> - 1: OFF
6 | Bid | int |   | Korean Won(KRW), from   50 to 100,000
7 | Using Ad Group Bid   Amount | boolean |   | - false: not used<br/> - true: used
8 | Ad Link Status | int |   | 0:   Disable<br/>   1: Enable<br/>
9 | regTm | date |   | The time at which   information was created(ISO8601)
10 | delTm | date |   | The time at which the campaign was deleted(ISO8601)
11 | Product ID | string | 256 | Unique key of Shopping Product
12 | productName | string | 256 | Product name
13 | Product Title | string | 256 | Product name
14 | Brand | string | 256 | Brand Name
15 | Maker | string | 256 | Maker Name
16 | openDate | string | 256 | open date
17 | Product Image URL | string | 256 | Product Image URL
18 | Landing URL(PC) | string | 256 | Product landing page(PC)
19 | Lowest Price(PC) | string | 256 | Low Price(PC)
20 | Lowest Price(Mobile) | string | 256 | Low Price(Mobile)
21 | mallCount | int |   | number of registed mall
22 | reviewCount | int |   | number of review
23 | scoreInfo | string | 256 | rating of product
24 | NAVER Shopping   Category Name 1 | string | 256 | Category Name 1
25 | NAVER Shopping   Category Name 2 | string | 256 | Category Name 2
26 | NAVER Shopping   Category Name 3 | string | 256 | Category Name 3
27 | NAVER Shopping   Category Name 4 | string | 256 | Category Name 4
28 | NAVER Shopping   Category ID 1 | string | 256 | Category ID 1
29 | NAVER Shopping   Category ID 2 | string | 256 | Category ID 2
30 | NAVER Shopping   Category ID 3 | string | 256 | Category ID 3
31 | NAVER Shopping   Category ID 4 | string | 256 | Category ID 4
