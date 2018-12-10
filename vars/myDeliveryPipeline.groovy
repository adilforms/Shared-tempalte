 
def call(Map config) {
 node('master'){
        
stage('Checkout'){
  
   checkout scm
 $GIT_BRANCH
 branch=$GIT_BRANCH
 branch

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
      
    
   docker build -t adilforms/the-example-app.nodejs.$version:master .
   docker push adilforms/the-example-app.nodejs.$version:master
   '''
   
}

}


}





