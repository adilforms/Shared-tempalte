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
 def request = libraryResource 'Dockerfile'
 sh cat Dockerfile > Dockerfile
def request = libraryResource 'docker-push.sh'
 sh request
 }

}


}

