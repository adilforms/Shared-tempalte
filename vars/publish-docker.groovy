def call(Map config) {
stage('Publish') {
  steps {

    echo 'publishing'
       sh 'docker push adilforms/the-example-app.nodejs:latest'
   
 
  }
}
}
