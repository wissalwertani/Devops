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
          stage('Sonar'){
            steps{
                bat "mvn sonar:sonar";
            }
        }
         stage('Nexus'){
            steps{
                bat "mvn clean package -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=0.0.2-SNAPSHOT -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-snapshots/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-0.0.2-SNAPSHOT.war"
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