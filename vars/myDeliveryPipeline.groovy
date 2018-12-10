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
      
    checkout([$class:'GitSCM', branches: "**", $class: 'CleannBeforeCheckout'])
      
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

    echo 'publishing'
       sh 'docker push adilforms/the-example-app.nodejs:latest'
   
 
  }
}}
}

}

