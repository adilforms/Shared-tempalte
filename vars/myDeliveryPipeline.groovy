 
def call(Map config) {
    pipeline {
     agent any
        
stages {
stage('Checkout'){
  steps{
      
   checkout scm
 
      
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
   def environmnet = branch_to_environment()[env.BRANCH_NAME]
   if(environmnet != null) {
    try {
     if environment ==' master') {
      sh 'echo master'
      sh ' ehco env.BUILD_NUMBER'
     }
     }
     cathc(e) {
      sh 'echo failure'
     }
     finally {
     sh ' echo env.REPO_URL'
     }
   }
   /*
sh '''#!/bin/bash -el
    echo 'publishing'
   docker build -t adilforms/the-example-app.nodejs .
   docker push adilforms/the-example-app.nodejs  
   '''
   */
  }
}
}
}

}


