def call(Map config) {
 node('master'){
  stage('load-configs'){
  env.file = shell(readFileFromWorkspace('dockerpush.sh')
                   }
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

 echo $file
}

}


}

