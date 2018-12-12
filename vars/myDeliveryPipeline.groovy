def call(Map config) {

 node ('master'){
  try{
 
stage('Checkout'){
 checkout scm 
 sh 'printenv'
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
  
 
  }
  catch(err){
  echo 'catch'}
  finally{
   stage('PostAction') {
   echo "Cleaning Work Space"
    sh 'rm -rf *'
 
       
  }
  
}
 }
}
