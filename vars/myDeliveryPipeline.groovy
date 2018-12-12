def call(Map config) {

 node ('master'){
 
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
    sh 'rm -rf *'
  }
 
 }

}

