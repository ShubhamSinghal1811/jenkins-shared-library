def call(){
sh "aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 982923341761.dkr.ecr.ap-south-1.amazonaws.com"
sh 'docker build -t "demoappf311c80d/helloworldfunction19d43fc4repo:latest1" ./hello-world'
sh "docker tag demoappf311c80d/helloworldfunction19d43fc4repo:latest1 982923341761.dkr.ecr.ap-south-1.amazonaws.com/demoappf311c80d/helloworldfunction19d43fc4repo:latest1"
sh "docker push 982923341761.dkr.ecr.ap-south-1.amazonaws.com/demoappf311c80d/helloworldfunction19d43fc4repo:latest1"
}



 
    
