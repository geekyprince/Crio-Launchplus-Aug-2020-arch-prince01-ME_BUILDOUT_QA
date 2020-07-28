#!/bin/bash

####################################################
# DO NOT CHANGE THE GRADLE OPTIONS IN THE BLOCK    #
# BELOW, IT WILL HAVE IMPACT ON THE PERFORMANCE    #
# OF YOUR APPLICATION                              #
####################################################
GRADLE_OPTS="-Dgradle.user.home=~/gradle_cache"    #
####################################################



gradlew clean bootrun &

while ! netstat -tna | grep 'LISTEN\>' | grep -q ':8081\>'; do
  echo "waiting for spring application to start"
  sleep 2 # time in seconds, tune it as needed
done

pip3 install pymongo

# Load quiz data
echo "Loading quiz data"
python3 python_script.py
# If you have any script to load the data make sure that its part of this bash script.

