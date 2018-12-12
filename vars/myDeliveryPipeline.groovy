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
 def file = libraryResource 'Dockerfile'
 sh cp 'Dockerfile' './Dockerfile' 
def request = libraryResource 'docker-push.sh'
 sh request
 }

}


}

