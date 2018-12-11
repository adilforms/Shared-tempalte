    echo 'publishing'
    curl https://raw.githubusercontent.com/adilforms/Shared-tempalte/test/Dockerfile > Dockerfile
   version=$(git rev-parse --short HEAD)
   echo $BRANCH_NAME
   PNAME=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
   echo $PNAME
   PACKAGENAME=${PNAME//$BRANCH_NAME/''}
   docker build -t adilforms/$PACKAGENAME$version:$BRANCH_NAME .
   docker push adilforms/$$PACKAGENAME$version:$BRANCH_NAME
  
