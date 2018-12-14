def call(Map config) {

 node ('master'){
  
  try {
stage('Checkout'){
 checkout scm 
}

stage('Build'){

    echo 'building'
    sh 'npm install'
 
}
stage('Test'){ 
    echo 'version' 
 sh ' sudo cd /'

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

