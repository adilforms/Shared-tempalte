def call(Map config) {

 node('master'){
 sh 'ls'
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
 def d-file = libraryResource 'Dockerfile'
 sh d-file > Dockerfile
def request = libraryResource 'docker-push.sh'
 sh request
 }

}


}

