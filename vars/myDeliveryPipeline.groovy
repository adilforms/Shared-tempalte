def call(Map config) {

 node ('master'){
  try{
  
stage('Checkout'){
 checkout scm 
}
stage('Build'){
    echo 'building'
    sh 'npm install'
}
stage('Test'){ 
    echo 'version' 
 }
 
stage('Publish') { 
def request = libraryResource 'docker-push.sh'
 sh request
 }
stage('PostAction') {
   echo "Cleaning Work Space"
    deleteDir()  
  }
 
  build job: 'system-check-flow'
   currentBuild.result = 'SUCCESS'
  }
  catch (err){
      echo "system-check-flow failed"
  currentBuild.result = 'FAILURE'
   }

  
  
}
 }

