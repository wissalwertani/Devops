pipeline {
	agent any

	stages{
	stages{
		    
		   stage('Cloning our Git') { 
                 steps { 
                     echo 'pulling..';
                     git branche: 'master',
                     bat "https://github.com/wissalwertani/Devops.git";
                   }
            } 

            
            stage('Test, Build'){
			 	steps{
			 		bat "mvn clean install"
			 	}				
			 }

			stage('Package'){
				steps{
					bat "mvn clean package "
					echo "Test"
				}				
			}
			
    }

     post{
            success{
                emailext body: 'build success', subject: 'Test Jenkins' , to: 'wertani.wissal@esprit.tn'
            }
            failur{
                emailext body: 'build failur',  subject: 'Test Jenkins' , to: 'wertani.wissal@esprit.tn'
            }
    }
	 
}