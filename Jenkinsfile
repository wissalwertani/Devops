pipeline {
    agent any  
    stages{
        stage('GIT Branch wissal'){
            steps{
                echo 'Pulling ...';
                git branch: 'wissal',
                url:'https://github.com/wissalwertani/Devops.git';
            }
        }
        stage('Build and Test'){
            steps{
              bat "mvn package"
              bat "mvn test"
            }
        }
    }

post {
            success {
                emailext body: 'build success' ,subject:'Jenkins' , to : 'wertani.wissal@esprit.tn'
            }
            failure {
                emailext body: 'build failure' ,subject:'Jenkins' , to : 'wertani.wissal@esprit.tn'               
}}
}