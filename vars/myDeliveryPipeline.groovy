def call(Map config) {

 agent any{
 
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
 /*def file = libraryResource 'Dockerfile'
 #sh "cp 'Dockerfile' './Dockerfile' " */
def request = libraryResource 'docker-push.sh'
 sh request
 }
  
  post { 
        always { 
            cleanWs()
        }
    }
}


}

