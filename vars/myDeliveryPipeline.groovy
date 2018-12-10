 
def call(Map config) {
 node('master'){
        
stage('Checkout'){
  
   checkout scm

 sh 'git remote -v '
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
     
   
   
sh '''#!/bin/bash -el
    echo 'publishing'
   version=$(git rev-parse --short HEAD)
    
    
   docker build -t adilforms/the-example-app.nodejs.$version .
   docker push adilforms/the-example-app.nodejs  
   '''
   
}

}
}
def branch_to_environment(){
 [
  master: 'master',
  test: 'test'
  ]
}





