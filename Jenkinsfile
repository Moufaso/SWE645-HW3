// Author: Saman Hosseini

pipeline {
   agent any

   environment {
      DOCKERHUB_CRED = credentials('dockerhub-id')
   }

   stages {
      stage('Build Application') {
         steps {
            checkout scm
            script {
               sh './mvnw clean package'
               sh 'echo "$DOCKERHUB_CRED_PSW" | docker login --username $DOCKERHUB_CRED_USR --password-stdin'
               sh 'docker build -t moufaso/studentsurvey645hw3:0.${BUILD_ID} .'
            }
         }
      }

      stage('Push Docker Image') {
         steps {
            script {
               sh 'docker push moufaso/studentsurvey645hw3:0.${BUILD_ID}'
            }
         }
      }

      stage('Deployment to rancher') {
         steps {
            script {
               sh 'kubectl --namespace student-survey set image deployment/hw2-deployment studentsurvey=moufaso/studentsurvey645hw3:0.${BUILD_ID}'
            }
         }
      }
   }

   post {
      always {
         echo 'Cleaning up...'
         sh 'docker rmi moufaso/studentsurvey645hw3:0.${BUILD_ID}'
      }
      success {
         echo 'Deployment successful.'
      }
      failure {
         echo 'Deployment failed!'
      }
   }
}