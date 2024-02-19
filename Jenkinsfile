pipeline {
    agent any
    tools{
        maven 'maven_3_9_4'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/mimaraslan/devops-automation']]])
                //sh 'mvn clean install'
                bat 'mvn clean install'
            }
        }

        stage('Build docker image'){
            steps{
                script{
                      //sh 'docker build -t mimaraslan/devops-automation . '
                      bat 'docker build -t mimaraslan/devops-automation:latest . '
                }
            }
        }

        stage('Push image to Hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                /*
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                        echo "This works:  $USERNAME $PASSWORD"
                        bat 'docker login --username $USERNAME --password-stdin $PASSWORD'
                        bat "echo ${PASSWORD} | docker login -u ${USERNAME} --password-stdin"
                */
                    bat 'echo docker login -u mimaraslan -p ${dockerhubpwd}'
                    bat 'docker push mimaraslan/devops-automation:latest'
                    }
                }
            }
        }

        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'deploymentservice.yaml', kubeconfigId: 'k8sconfigpwd')
                }
            }
        }


    }
}