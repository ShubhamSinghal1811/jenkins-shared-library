def call(){

sh "aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 982923341761.dkr.ecr.ap-south-1.amazonaws.com"


   
}



 
    
