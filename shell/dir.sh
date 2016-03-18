#!/bin/sh
# usage : dir.sh [directory] [indent]

DIR=${1:-pwd}
INDENT="$2"
echo "$DIR $INDENT"
cd $DIR
for D in 'ls'; do
	if [ -d "$D" ]; then
		INDENT1="  $INDENT"
		dir.sh $D "$INDENT1"
	fi
done