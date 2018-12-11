def call(Map config) {

 node('master'){
 sh 'ls'
stage('Checkout'){
  
   checkout scm
 


 sh 'git remote -v '
}
stage('Build'){

    echo 'building'
    sh 'npm install'
}
stage('Test'){ 
    echo 'version'  
}
stage('Publish') { 
     
   echo 'Publishing' 
 echo 'Injecting Dockerfile in Workspace'
 @library('docker-push.sh')
 sh 'ls'
 echo 'Executing shell script to push package to Docker'
 }

}


}

