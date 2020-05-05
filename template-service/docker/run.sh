#!/bin/bash

set -xe

exec java -jar /usr/local/template-service.jar "$@"
