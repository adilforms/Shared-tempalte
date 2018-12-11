def call(Map config) {

 node('master'){
 sh 'ls'
stage('Checkout'){

}
stage('Build'){

    echo 'building'
    sh 'npm install'
}
stage('Test'){ 
    echo 'version'  
}
stage('Publish') { 
     
 
sh '''#!/bin/bash -el
    echo 'publishing'
    curl https://raw.githubusercontent.com/adilforms/Shared-tempalte/test/Dockerfile > Dockerfile
   version=$(git rev-parse --short HEAD)
   P_Name=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
   Package_Name=${P_Name//$BRANCH_NAME/''}
   docker build -t adilforms/$Package_Name$version:$BRANCH_NAME .
   docker push adilforms/$Package_Name$version:$BRANCH_NAME
   '''
 }

}


}

