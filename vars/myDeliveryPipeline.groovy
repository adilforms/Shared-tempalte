 
def call(Map config) {
 node('master'){
        
stage('Checkout'){
  
   checkout scm

 sh 'git remote -v '
}
stage('Build'){

    echo 'building'
    sh 'npm install'
}
stage('Test'){ 
    echo 'version'  
}
stage('Publish') { 
     
   
   
sh '''#!/bin/bash -el
    echo 'publishing'
   version=$(git rev-parse --short HEAD)
   branch=$(git branch | sed -n -e "s/^\* \(.*\)/\1/p")
    
    
   docker build -t adilforms/the-example-app.nodejs.$version:$branch .
   docker push adilforms/the-example-app.nodejs.$version:$branch
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





