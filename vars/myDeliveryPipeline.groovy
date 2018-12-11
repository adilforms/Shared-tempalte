def call(Map config) {

 node('master'){
 sh 'ls'
stage('Checkout'){
  
   checkout scm
 dir('configfiles'){
  ('checkout ([$class: 'SCM', branches: [[name: '*/master']], url: 'https://github.com/adilforms/JenkinsCentral.git' )
   }
 


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

 echo 'Executing shell script to push package to Docker'
 }

}


}

