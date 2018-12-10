 
def call(Map config) {
    pipeline {
     agent {
      Docker {
       FROM node:7 }
     }
        
stages {
stage('Checkout'){
  steps{
/*
      checkout([$class: 'GitSCM',
            
          extensions: [[$class: 'CleanBeforeCheckout']], 
                commitID: [[version: env.GIT_COMMIT]]
                         
                        ])
 
      checkout([$class:'GitSCM', branches: "**"])
      */
      
   checkout scm
      
  }
}
stage('Build'){
  steps {
    echo 'building'
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


