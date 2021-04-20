# -*- coding: utf-8 -*-

import os
import csv
import json

def print_times_item(pages):
    _list = []
    _map = {}
    with open(pages, 'r') as f:
        time_values = f.readlines()
        for v in time_values:
            tv = v.replace('\n', '')
            if tv == '' or '```' in tv:
                continue
            time_row.append(tv)
        _map[key_name] = time_row
        _list.append(key_name)
