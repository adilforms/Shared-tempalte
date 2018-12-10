
def call(Map config) {
    pipeline {
        agent any
        
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
      def dock(){
          try {
    Map Dockerfile = read{file: "${WORKSPACE}/Dockerfile"
                      return Dockerfile
                         }
              catch(e) {
                  exit(1);
              }
}

    
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
}

