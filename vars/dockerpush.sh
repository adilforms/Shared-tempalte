sh '''#!/bin/bash -el
    echo 'publishing'
   version=$(git rev-parse --short HEAD)
   P_Name=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
   Package_Name=${P_Name//$BRANCH_NAME/''}
   docker build -t adilforms/$Package_Name$version:$BRANCH_NAME .
   docker push adilforms/$Package_Name$version:$BRANCH_NAME
   '''
