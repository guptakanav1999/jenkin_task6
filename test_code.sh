#!/bin/bash
status=$(curl -o /dev/null -s -w "{%http_code}" http://192.168.99.100:30570)
if [[ $status==200 ]]
then
python3 /code/mail.py
else
python3 /code/failed_mail.py
fi
