---
categories: [release]
---

### Master/Stat Report supports compressed files
  * When you request '/report-download' with custom http header, you can receive stream content of zip file
    - Custom Http Header : `X-Accept-Encoding: zip`
