import datetime as datetime
import requests as requests

GET_UUID_URL = "/getUuid"
SELECT_URL = "/select"

for i in range(3):
    uuid_response = requests.get("http://localhost:1210" + str(i) + GET_UUID_URL)
    uuid = {'uuid': uuid_response.text}
    before = datetime.datetime.now()
    requests.get("http://localhost:1210" + str(i) + SELECT_URL, params=uuid)
    delta = datetime.datetime.now() - before
    print('Selection ', i, ':', delta, '(with uuid: ', uuid_response.text, ')')
