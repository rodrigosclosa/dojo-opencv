import requests
import json

class GarageApi:
    def __init__(self, address='fc:c2:de:40:db:0f', token='rOxsxbXsj5Zm'):
        self.BASE_URL = 'http://api.iot.ciandt.com/v2/data/'
        self.ADDRESS = address
        self.TOKEN = token

    def post(self, payload):
        headers = {'Content-type': 'application/json', 'id': self.ADDRESS, 'access_token': self.TOKEN}
        req = requests.post(self.BASE_URL, data=json.dumps(payload), headers=headers)
        return req.status_code, req.text

    def get_last(self):
        return requests.get(self.BASE_URL + self.ADDRESS + '/last').content

    def get(self):
        return requests.get(self.BASE_URL + self.ADDRESS).content
