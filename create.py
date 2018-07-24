import requests
import datetime

# UUID first version as varbinary
before_v1_bin = datetime.datetime.now()
requests.get("http://localhost:12102/create")
delta_v1_bin = datetime.datetime.now() - before_v1_bin
print(delta_v1_bin.microseconds)

# UUID forth version as varbinary
before_v4_bin = datetime.datetime.now()
requests.get("http://localhost:12101/create")
delta_v4_bin = datetime.datetime.now() - before_v4_bin
print(delta_v4_bin.microseconds)

# UUID forth version as varchar
before_v4_char = datetime.datetime.now()
requests.get("http://localhost:12100/create")
delta_v4_char = datetime.datetime.now() - before_v4_char
print(delta_v4_char.microseconds)
