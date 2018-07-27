#!/usr/bin/env bash

echo -e "0 - v4_char\n1 - v4_bin\n2 - v1_bin_no_ordered\n3 - v1_bin\n"

python3 create.py
python3 select.py
