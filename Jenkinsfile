pipeline {
    agent any

    environment {
        registryUrl= "192.168.1.110:5000"
        registry_user= "xxx"
        registry_pass= "xxx"
    }

    options {
        timestamps()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }

    stages{
        stage('Print Message') {
            steps {
                echo "workspace: ${WORKSPACE}  build_id: ${BUILD_ID}  branch(gitlab分支名): ${env.BRANCH_NAME}"
                echo "registryUrl: ${registryUrl}"
           }
        }

        stage('Delete Workspace') {
            steps {
                echo "clean workspace: ${WORKSPACE}"
                deleteDir()
            }
        }
        stage('Maven Build') {
            steps {
                echo 'build project with maven'
                script {
                    sh 'mvn clean package -Dmaven.test.skip=true'     //springboot maven 多模块 jenkins 单独打包子项目
                }
            }
        }
        stage('Build & Push Image') {
            steps {
                echo 'build and push docker image'
                dir ('./') {
                    script {
                        sh 'mv ${JOB_NAME%%/*}/Dockerfile  ./'
                        sh 'docker login  --username=${registry_user} --password=${registry_pass}   ${registryUrl}'
                        def app = docker.build('${registryUrl}/${JOB_NAME%%/*}:${env}')
                        app.push('${env}')
                        sh 'docker rmi ${registryUrl}/${JOB_NAME%%/*}:${env}'
                    }
                }
                sh '''rm -rf `ls | egrep -v '(Jenkinsfile|start.sh)'`'''
            }
        }

        stage('Deploy to Server') {
            //when {
            //    beforeAgent true
            //    branch "${env.BRANCH_NAME}"
            //}
            steps {
                timeout(time: 40, unit: 'SECONDS') {
                    //部署到${env}环境
                    sh 'bash ./startup.sh ${JOB_NAME%%/*} ${registryUrl}/${JOB_NAME%%/*}:${env}　${env}'
                }
            }
        }

    }
}