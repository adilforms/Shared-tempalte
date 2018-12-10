 
def call(Map config) {
 node('master'){
        
stage('Checkout'){
  
   checkout scm
}
stage('Build'){

    echo 'building'
   sh 'npm config set unsafe-perm=true'
   sh 'npm install'
}
stage('Test'){ 
    echo 'version'  
}
stage('Publish') {  
 def environment = branch_to_environment()[env.BRANCH_NAME]
   if(environment != null) {
    try {
     if (environment ==' master') {
      sh 'echo master'
      sh ' ehco env.BUILD_NUMBER'
     }
     }
     catch(e) {
      sh 'echo failure'
      throw e
     }
    finally {
     echo 'env.REPO_URL'
     
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





