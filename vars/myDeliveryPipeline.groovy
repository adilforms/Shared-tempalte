def call(Map config) {

 node ('master'){
  
  try {
stage('Checkout'){
 checkout scm 
}

stage('Build'){

    echo 'building'
    sh 'npm install'
 sh ' rm -rf ters'
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
  }
  catch(e){
   return false
  }
  
  
}
 }

