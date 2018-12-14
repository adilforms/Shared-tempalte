def call(Map config) {

 node ('master'){
  try{
  
stage('Checkout'){
 try{
 checkout scm 
}
 catch(e){
    return false
   echo "system-check-flow failed"
  currentBuild.result = 'FAILURE'
   }
}
stage('Build'){
 try {
    echo 'building'
    sh 'npm install'
 }
 catch(e){

  echo 'failed in Build'
   echo "system-check-flow failed"
  currentBuild.result = 'FAILURE'
 }
}
stage('Test'){ 
 try {
    echo 'version' 
 sh ' sudo cd /'
  build job: 'system-check-flow'
 }
 catch(e) {
 
  echo 'failed in Test'
   echo "system-check-flow failed"
  currentBuild.result = 'FAILURE'
 }
 

}
stage('Publish') { 
 try {
def request = libraryResource 'docker-push.sh'
 sh request
 }
 catch(e){
 
  echo 'failed in Publish'
   echo "system-check-flow failed"
  currentBuild.result = 'FAILURE'
 }
 }
   stage('PostAction') {
    try {
   echo "Cleaning Work Space"
    deleteDir()  
    }
    catch(e){
     echo 'failed in Post Action'
     echo "system-check-flow failed"
  currentBuild.result = 'FAILURE'
    }
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

