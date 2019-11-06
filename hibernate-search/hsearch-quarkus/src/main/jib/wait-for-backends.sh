#!/bin/sh
# wait-for-backends.sh

set -e

for ES_HOST in ${ES_HOSTS//,/ }
do
    ES_HOST_NO_PORT=$(echo "$ES_HOST" | cut -d ':' -f1)
    ES_PORT=$(echo "$ES_HOST" | cut -d ':' -f2)
    until $(nc -z "${ES_HOST_NO_PORT}" "${ES_PORT}" >&2 2>/dev/null)
    do
        echo "$ES_HOST is not available, waiting..." >&2
        sleep 2
    done
done

until $(>&2 2>/dev/null nc -z "$POSTGRES_HOST" 5432)
do
    >&2 echo "$POSTGRES_HOST:5432 is not available, waiting..."
    sleep 2
done
