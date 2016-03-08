#!/usr/bin/env python

import requests
import json

url = 'https://dojo-opencv.appspot.com/_ah/api/myApi/v1/test/content/1'
payload = {}
headers = {}
#payload = {'content': {'teste':'teste'}, 'firmwareVersion' : '1.0'}
#headers = {'Content-type': 'application/json', 'id':'fc:c2:de:40:db:0f', 'access_token' : 'rOxsxbXsj5Zm'}

r = requests.post(url, data=json.dumps(payload), headers=headers)

print r.status_code
print r.text