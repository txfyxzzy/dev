#!/usr/bin/env python

'''usage:
./httpStats.pike --rrddir ${rrddir} --statsdir ${statsdir} --days 1 --summary >> ${statslog} 2>&1
./httpStats.pike --rrddir ./minirrd/rrd/history-20150301/turbo2sdk-china/cluster/ --statsdir ./minirrd/stats/turbo2sdk-china/cluster/ --end 1425168000 --summary >> ./minirrd/stats/stats.log 2>&1
./httpStats.pike --rrddir ./minirrd/rrd/20150318/turbo2sdk-china/cluster/ --statsdir ./minirrd/stats/turbo2sdk-china/cluster/ --days 17 --summary >> ./minirrd/stats/stats.log 2>&1
'''

import os
import sys
import getopt

def main(argv):
    print "---main<---"
    for arg in argv:
        print arg

if __name__ == '__main__':
    main(sys.argv)
