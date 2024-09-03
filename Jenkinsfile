pipeline {
    //agent { label 'DevOps-Agent' }
    //agent { label 'Jenkins-Agent' }
      agent any

    tools {
        jdk 'Java21'
        maven 'Maven3'
    }

    stages{
        stage("Cleanup Workspace"){
            steps {
                cleanWs()
            }
        }

        stage("Checkout from SCM"){
           steps {
              git branch: 'main', credentialsId: 'github', url: 'https://github.com/mimaraslan/devops-demo'
           }
        }

        stage("Build Application"){
            steps {
                sh "mvn clean package"
            }
        }

       stage("Test Application"){
           steps {
                 sh "mvn test"
           }
       }


       stage("SonarQube Analysis"){
           steps {
	           script {
		           withSonarQubeEnv(credentialsId: 'jenkins-sonarqube-token') {
                      sh "mvn sonar:sonar"
		           }
	           }
           }
       }

    }
}
