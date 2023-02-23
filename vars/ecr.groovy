def call(){
   pipeline {
    agent any
    environment {
AWS_ACCOUNT_ID="982923341761"
AWS_DEFAULT_REGION="ap-south-1"
IMAGE_REPO_NAME="demoappf311c80d/helloworldfunction19d43fc4repo"
IMAGE_TAG="latest"
REPOSITORY_URI = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
}
    stages {
        
        stage('checkout') {
          steps {
            checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '2c887006-6623-4ea4-8103-3ac3e9dfccfb', url: 'https://github.com/ShubhamSinghal1811/aws-sam-demo']])
          }
       }
        
        stage('Logging into AWS ECR') {
steps {
sh "sudo aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com"
}
}

stage('Building image') {
steps{
script {
sh 'sudo docker build -t "${IMAGE_REPO_NAME}:${IMAGE_TAG}" ./hello-world'
}
}
}

stage('Pushing to ECR') {
steps{
script {
sh "sudo docker tag ${IMAGE_REPO_NAME}:${IMAGE_TAG} ${REPOSITORY_URI}:$IMAGE_TAG"
sh "sudo docker push ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}:${IMAGE_TAG}"
}
}
}



 
    
    }
}   
}



 
    
