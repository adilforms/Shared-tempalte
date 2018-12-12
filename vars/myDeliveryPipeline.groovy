def call(Map config) {

 node('master'){
stage('Checkout'){

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

