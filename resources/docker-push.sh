    echo 'publishing'
    curl https://raw.githubusercontent.com/adilforms/Shared-tempalte/test/Dockerfile > Dockerfile
   version=$(git rev-parse --short HEAD)
   Branch=$BRANCH_NAME
   PNAME=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
   echo $PNAME
   PACKAGENAME=${PNAME//$Branch/}
   docker build -t adilforms/$PACKAGENAME$version:$Branch .
   docker push adilforms/$$PACKAGENAME$version:$Branch
  
