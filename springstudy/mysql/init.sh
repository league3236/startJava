#!/bin/bash
pwd -P

DIR="$( cd "$( dirname "$0" )" && pwd -P )"
echo $DIR

#docker build --tag leaguemysql:1.0 .
#docker-compose up -d

exit 0