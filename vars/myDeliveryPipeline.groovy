def call(Map config) {
 node('master'){
  file = readfile('dockerpush.sh')
        
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
 def varfile ="dockerpush.sh"
 echo $file
}

}


}

