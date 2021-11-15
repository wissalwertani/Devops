pipeline {

    agent any


    stages {
       stage ('GIT') {
            steps {
               echo "Getting Project from Git"; 
                git branch: "Manel", 
                    url: "https://github.com/wissalwertani/Devops.git",
                    credentialsId: "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"; 
            }
        }

        stage("Build") {
            steps {
                bat "mvn -version"
                bat "mvn clean package"
                
            }
        }
        
        stage("Sonar") {
            steps {
                bat "mvn sonar:sonar"
            }
        }
        
        stage("DEPLOY") {
            steps {
                bat "mvn clean package -DskipTests deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet-ci -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-ci-1.0.jar"
            }
        }
    }
   
    post {
        always {
            cleanWs()
        }
    }
    
}
