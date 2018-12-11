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
def request = libraryResource 'resources/docker-push.sh'
 writeFile file: 'functions.sh', text: functions
 sh "source functions.sh"

 }

}


}

