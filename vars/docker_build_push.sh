#!/bin/bash -el

docker build -t adilforms/the-example-app.nodejs .
docker push adilforms/the-example-app.nodejs
