pipeline {
    agent any
    
    environment {
        registry_space = 'lnsoftware'
    }

    options {
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }

    stages{

        stage('Maven Build') {
            steps {
                echo 'build project with maven'
                script {
                    sh 'mvn clean package -Dmaven.test.skip=true'
                }
            }
        }
        stage('Build & Push Image') {
            steps {
                echo 'build and push docker image'
                dir ('./') {
                    withCredentials([usernamePassword(credentialsId: 'hub.docker.com', passwordVariable: 'password', usernameVariable: 'username')]) {
                        script {
                            sh 'docker login --username=${username} --password=${password}'
                            def app = docker.build('${registry_space}/${JOB_NAME%%/*}', '-f deploy/Dockerfile .')
                            app.push('latest')
                            sh 'docker rmi ${registry_space}/${JOB_NAME%%/*}'
                        }
                    }
                }
            }
        }

        stage('Deploy to Server') {
            steps {
                timeout(time: 40, unit: 'SECONDS') {
                    withCredentials([usernamePassword(credentialsId: 'hub.docker.com', passwordVariable: 'password', usernameVariable: 'username')]) {
                        sh 'bash deploy/startup.sh ${username} ${password}'
                    }
                }
            }
        }

    }
}