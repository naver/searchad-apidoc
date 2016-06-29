# Naver SearchAD API - PHP Sample

## Getting started

### Pre-requirements

- PHP 5.4+ : http://php.net/downloads.php
- Git client : https://git-scm.com/downloads

### Issue the API License and the secret key

1. Sign up for NAVER SEARCH ADVERTISER's Center (http://searchad.naver.com)
2. Go to (http://manage.searchad.naver.com)
3. Go to Tools > API Manager
4. Create API license

### Git clone

```bash
$ git clone https://github.com/naver/searchad-apidoc.git
$ cd searchad-apidoc/php-sample/
```

### Modify [sample.ini](sample.ini).
- `API_KEY`
- `SECRET_KEY`
- `CUSTOMER_ID`

### Execute sample codes.
- [ad_management_sample.php](ad_management_sample.php)
- [master_report_sample.php](master_report_sample.php)
- [stat_report_sample.php](stat_report_sample.php)

#### *nix
```bash
$ php -f ad_management_sample.php
```

#### windows
```bat
> php.exe -f ad_management_sample.php
```
