 
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
   P_Name=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
   Package_Name=${P_Name//$BRANCH_NAME/''}
   
      
    
   docker build -t adilforms/$Package_Name$version:$BRANCH_NAME .
   docker push adilforms/$Package_Name$version:$BRANCH_NAME
   '''
   
}

}


}





