 
def call(Map config) {
 node('master'){
        
stage('Checkout'){
  
   checkout scm
 
sh 'printenv'

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
   branch=$BRANCH_NAME
      
    
   docker build -t adilforms/the-example-app.nodejs.$version:$branch.
   docker push adilforms/the-example-app.nodejs.$version:$branch
   '''
   
}

}


}





