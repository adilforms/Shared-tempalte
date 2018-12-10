def call(Map config) {
    pipeline {
        agent any
        
stages {
stage('Checkout'){
  steps{

      checkout([$class: 'GitSCM',
            branches: [[name: env.BRANCH_NAME]],
           extensions: [[$class: 'CleanBeforeCheckout']], [[commitId: env.GIT_COMMIT]]
                         
                        ])
  /*
      checkout([$class:'GitSCM', branches: "**"])
      
      checkout scm
      */
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
  
    'commitId'
    
  
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

