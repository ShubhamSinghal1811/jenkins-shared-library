def call(){

  stages {
        
        stage('Logging into AWS ECR') {
steps {
sh "aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com"
}
}

stage('Building image') {
steps{
script {
sh 'docker build -t "${IMAGE_REPO_NAME}:${IMAGE_TAG}" ./hello-world'
}
}
}

stage('Pushing to ECR') {
steps{
script {
sh "docker tag ${IMAGE_REPO_NAME}:${IMAGE_TAG} ${REPOSITORY_URI}:$IMAGE_TAG"
sh "docker push ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}:${IMAGE_TAG}"
}
}
}



 
    
    }
}
