from src.utils.GarageUtils import GarageApi
from random import randint

api = GarageApi()

payload = {'ipAddress': '200.145.1.122',
           'ssid': 'Hello World',
           'content': {}}

for i in range(0, 50):
    payload['content']['Atribute-'+str(i)] = randint(1000, 9999)

api.post(payload)

print(api.get_last())


