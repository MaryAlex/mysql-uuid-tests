import datetime as datetime
import requests as requests

GET_UUID_URL = "/getUuid"
SELECT_URL = "/select"

for i in range(4):
    uuid_response = requests.get("http://localhost:1210" + str(i) + GET_UUID_URL)
    before = datetime.datetime.now()
    requests.get("http://localhost:1210" + str(i) + SELECT_URL)
    delta = datetime.datetime.now() - before
    print('Selection ', i, ':', delta)
