 
def call(Map config) {
    pipeline {
     agent any
        
stages {
stage('Checkout'){
  steps{
      
   checkout scm
   sh 'echo GIT_COMMIT %GIT_COMMIT%'
      
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
 
   sh "echo 'publishing"
sh "./docker_build_push.sh"
  }
}
}
}

}


