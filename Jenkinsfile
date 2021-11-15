pipeline {
    agent any 
    stages {
        stage('Checkout GIT') { 
            steps {
			    echo 'Pulling...'
				git branch: 'main',
				url : 'https://github.com/nabilChemkhi/ProjetDevOps.git';
            }
        }
        stage("Test, Build") {
            steps {
				bat """mvn clean install"""
            }
        }
		        stage("Package") {
            steps {
				bat """mvn clean package""";
				echo'test'
            }
        }
		stage("Sonar") {
            steps {
				bat """mvn sonar:sonar""";
				echo'sonar'
            }
        }
		stage("Nexus") {
            steps {
				bat """mvn deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=1.5 -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.5.jar""";
				echo'nexus'
            }
			}
		}
		post{
		success{
		emailext body: 'build success', subject: 'Jenkins', to: 'nabil.chemkhi@esprit.tn'
		}
		failure{
		emailext body: 'build failure', subject: 'Jenkins', to: 'nabil.chemkhi@esprit.tn'
		}
		
    }
}