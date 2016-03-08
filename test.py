#!/usr/bin/env python

import requests
import json

url = 'http://api.iot.ciandt.com/v2/data'
payload = {'content': {'teste':'teste'}, 'firmwareVersion' : '1.0'}
headers = {'Content-type': 'application/json', 'id':'fc:c2:de:40:db:0f', 'access_token' : 'rOxsxbXsj5Zm'}

r = requests.post(url, data=json.dumps(payload), headers=headers)

print (r.status_code)
print (r.text)