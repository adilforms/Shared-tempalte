def call(Map config) {

 node('master'){
 
stage('Checkout'){
  
   checkout scm
 
sh 'printenv'

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
 echo 'Executing shell script to push package to Docker'
 }

}


}

