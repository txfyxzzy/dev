#!/bin/sh

TODAY=`date +"%Y%m%d"`

index=1

count=6

sleep_time=10

pid=10292

while [ $index -le $count ]

do
  echo "---" $index "---"

  sleep $sleep_time

  ps h -p $pid -o  rss,vsz,%mem,%cpu >>~/ps_${pid}_${TODAY}.txt

  index=$(($index +1))

done