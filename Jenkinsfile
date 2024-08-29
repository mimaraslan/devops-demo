pipeline {
    agent { label 'DevOps-Agent' }
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
    }
}
