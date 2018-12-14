def call(Map config) {

 node ('master'){
  
  try {
stage('Checkout'){
 checkout scm 
}
   catch(e){
    echo 'failed in Checkout'
    return false
   }
stage('Build'){
 try {
    echo 'building'
    sh 'npm install'
 }
 catch(e){
  return false
  echo 'failed in Build'
 }
}
stage('Test'){ 
 try {
    echo 'version' 
 sh ' sudo cd /'
 }
 catch(e) {
  return false
  echo 'failed in Test'
 }
 

}
stage('Publish') { 
 try {
def request = libraryResource 'docker-push.sh'
 sh request
 }
 catch(e){
  return false
  echo 'failed in Publish'
 }
 }
   stage('PostAction') {
    try {
   echo "Cleaning Work Space"
    deleteDir()  
    }
    catch(e){
     echo 'failed in Post Action'
     return false
    }
  }
 
  

  
  
}
 }

