def call(){
  
        
 stage('Logging into AWS ECR') {
steps {
sh "sudo aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | sudo docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com"
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
