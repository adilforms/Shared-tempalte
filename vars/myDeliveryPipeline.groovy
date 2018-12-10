 
def call(Map config) {
    pipeline {
     agent any
        
stages {
stage('Checkout'){
  steps{
      
   checkout scm
 env
      
  }
}
stage('Build'){
  steps {
    echo 'building'
   sh 'npm config set unsafe-perm=true'
   sh 'npm install'
  }
}
stage('Test'){ 
    steps {
  
   echo 'version'
    
  
  }
  
}
    stage('Publish') {
  steps {
sh '''#!/bin/bash -el
    echo 'publishing'
   docker build -t adilforms/the-example-app.nodejs .
   docker push adilforms/the-example-app.nodejs  
   '''
  }
}
}
}

}


