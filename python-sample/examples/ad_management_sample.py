import time
import random
import requests

import signaturehelper


def get_header(method, uri, api_key, secret_key, customer_id):
    timestamp = str(round(time.time() * 1000))
    signature = signaturehelper.Signature.generate(timestamp, method, uri, SECRET_KEY)
    return {'Content-Type': 'application/json; charset=UTF-8', 'X-Timestamp': timestamp, 'X-API-KEY': API_KEY, 'X-Customer': str(CUSTOMER_ID), 'X-Signature': signature}


BASE_URL = 'https://api.naver.com'
API_KEY = '<API_KEY>'
SECRET_KEY = '<SECRET_KEY>'
CUSTOMER_ID = '<CUSTOMER_ID>'

# ManageCustomerLink Usage Sample

uri = '/customer-links'
method = 'GET'
r = requests.get(BASE_URL + uri, params={'type': 'MYCLIENTS'}, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))


# BusinessChannel Usage Sample

uri = '/ncc/channels'
method = 'GET'
r = requests.get(BASE_URL + uri, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))


# Adgroup Usage Sample

# 1. GET adgroup Usage Sample

uri = '/ncc/adgroups'
method = 'GET'
r = requests.get(BASE_URL + uri, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))
target_adgroup = r.json()[0]

# 2. CREATE adgroup Usage Sample

uri = '/ncc/adgroups'
method = 'POST'
payload = {'name': 'TEST#' + str(random.randrange(1000, 9999)), 'nccCampaignId' : target_adgroup['nccCampaignId'], 'pcChannelId' : target_adgroup['pcChannelId'], 'mobileChannelId': target_adgroup['mobileChannelId']}
r = requests.post(BASE_URL + uri, json=payload, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))

created_adgroup = r.json()

# 3. UPDATE Adgroup Usage Sample

uri = '/ncc/adgroups/' + created_adgroup['nccAdgroupId']
method = 'PUT'
created_adgroup['userLock'] = 0
r = requests.put(BASE_URL + uri, params={'fields': 'userLock'}, json=created_adgroup, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))

# 4. DELETE Adgroup

uri = '/ncc/adgroups/' + created_adgroup['nccAdgroupId']
method = 'DELETE'
r = requests.delete(BASE_URL + uri, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.content))

# AdKeyword Usage Sample

# 1. CREATE AdKeyword

uri = '/ncc/keywords'
method = 'POST'
r = requests.post(BASE_URL + uri, params={'nccAdgroupId': created_adgroup['nccAdgroupId']}, json=[{'keyword': 'hello'}], headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))

created_adkeyword = r.json()[0]

# 2. GET AdKeyword

uri = '/ncc/keywords'
method = 'GET'
r = requests.get(BASE_URL + uri, params={'nccAdgroupId': created_adgroup['nccAdgroupId']}, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))

# 3. UPDATE AdKeyword

uri = '/ncc/keywords'
method = 'PUT'
created_adkeyword['userLock'] = 0
r = requests.put(BASE_URL + uri, params={'fields': 'userLock'}, json=[created_adkeyword], headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))


# 4. GET and UPDATE AdKeyword (BidAmt)

uri = '/ncc/keywords/' + created_adkeyword['nccKeywordId']
method = 'GET'
r = requests.get(BASE_URL + uri, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))

retrieved_adkeyword = r.json()

uri = '/ncc/keywords'
method = 'PUT'
retrieved_adkeyword['bidAmt'] = 300
retrieved_adkeyword['useGroupBidAmt'] = 0
r = requests.put(BASE_URL + uri, params={'fields': 'bidAmt'}, json=[retrieved_adkeyword], headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))


# 5. DELETE AdKeyword

uri = '/ncc/keywords/' + created_adkeyword['nccKeywordId']
method = 'DELETE'
r = requests.delete(BASE_URL + uri, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.content))


# Estimate Usage Sample

# 1. average-position-bid

uri = '/estimate/average-position-bid/keyword'
method = 'POST'
r = requests.post(BASE_URL + uri, json={'device': 'PC', 'items': [{'key': '제주여행', 'position': 1}, {'key': '게스트하우스', 'position': 2}, {'key': '자전거여행', 'position': 3}]}, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("#response status_code = {}".format(r.status_code))
print("#response body = {}".format(r.json()))


# 2. exposure-minimum-bid

uri = '/estimate/exposure-minimum-bid/keyword'
method = 'POST'
r = requests.post(BASE_URL + uri, json={'device': 'PC', 'period': 'MONTH', 'items': ['제주여행', '게시트하우스', '자전거여행']}, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))

# 3. median-bid

uri = '/estimate/median-bid/keyword'
method = 'POST'
r = requests.post(BASE_URL + uri, json={'device': 'PC', 'period': 'MONTH', 'items': ['제주여행', '게시트하우스', '자전거여행']}, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))


# 4. performance

uri = '/estimate/performance/keyword'
method = 'POST'
r = requests.post(BASE_URL + uri, json={'device': 'PC', 'keywordplus': True, 'key': '중고차', 'bids': [100, 500, 1000, 1500, 2000, 3000, 5000]}, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))

# 5. performance-bulk

uri = '/estimate/performance-bulk'
method = 'POST'
r = requests.post(BASE_URL + uri, json={'items': [{'device': 'PC', 'keywordplus': True, 'keyword': '제주여행', 'bid': 70}, {'device': 'PC', 'keywordplus': True, 'keyword': '제주도', 'bid': 80}, {'device': 'PC', 'keywordplus': True, 'keyword': '제주도맛집', 'bid': 90}, ]}, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))

# Stat Usage Sample

# 1. GET Summary Report per multiple entities 

uri = '/stats'
method = 'GET'
stat_ids = [target_adgroup['nccCampaignId'], target_adgroup['nccAdgroupId']]
r = requests.get(BASE_URL + uri, params={'ids': stat_ids, 'fields': '["clkCnt","impCnt","salesAmt", "ctr", "cpc", "avgRnk", "ccnt"]', 'timeRange': '{"since":"2019-06-01","until":"2019-06-25"}'}, headers=get_header(method, uri, API_KEY, SECRET_KEY, CUSTOMER_ID))

print("response status_code = {}".format(r.status_code))
print("response body = {}".format(r.json()))
