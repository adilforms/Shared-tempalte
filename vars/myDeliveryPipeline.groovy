def call(Map config) {

 node ('master'){
  try{
  
stage('Checkout'){
 checkout scm 
}
stage('Build'){
    echo 'building'
    sh 'npm install'
 sh 'rm -rf fill'
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
   return true
   echo "Success"
  
  }
  catch (err){
      echo "Failed"
   return false
   }

  
  
}
 }

