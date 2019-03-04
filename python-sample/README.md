# Naver SearchAD API - Python Sample

## Getting started

### Pre-requirements

- Python 3.0+ : https://www.python.org/
- Git client : https://git-scm.com/downloads
- python requests : http://docs.python-requests.org

### Issue the API License and the secret key

1. Sign up for NAVER SEARCH ADVERTISER's Center (http://searchad.naver.com)
2. Go to (http://manage.searchad.naver.com)
3. Go to Tools > API Manager
4. Create API license

### Git clone

```bash
$ git clone https://github.com/naver/searchad-apidoc.git
$ cd searchad-apidoc/python-sample/
$ pip install -r requirements.txt 
$ cd examples/
```

### Modify [ad_management_sample.py](examples/ad_management_sample.py).
- `<API_KEY>`
- `<SECRET_KEY>`
- `<CUSTOMER_ID>`

### Execute sample codes.
- [ad_management_sample.py](examples/ad_management_sample.py)

#### *nix
```bash
$ python ad_management_sample.py
```

#### windows
```bat
> python ad_management_sample.py
```
