import datetime as datetime
import requests as requests

CREATE_URL = "/create"

for i in range(3):
    before = datetime.datetime.now()
    requests.get("http://localhost:1210" + str(i) + CREATE_URL)
    delta = datetime.datetime.now() - before
    print('Creating ', i, ':', delta.microseconds)
