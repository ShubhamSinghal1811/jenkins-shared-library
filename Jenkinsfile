@Library('jenkins-shared-library')_

pipeline{
    agent any
    stages{
        stage('Get Branch Name') {
          steps {
            script { 
              properties([
                parameters([
                  string(
                    defaultValue: "2", 
                      name: 'var1', 
                        trim: true
                    ),
                    string(
                    defaultValue: "2", 
                      name: 'var2', 
                        trim: true
                    ),
                    string(
                    defaultValue: "+", 
                      name: 'ch', 
                        trim: true
                    )
                  ])
                  
                ])
            }
          }
        }
        stage('demo'){
               steps{
                   calculator("${params.var1}","${params.var2}","${params.ch}") 
               }           
        }
    }
}
