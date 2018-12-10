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
}
}

}

