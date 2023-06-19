pipeline 
{
    agent any
    
    tools{
        maven 'maven'
        }

    stages 
    {
        
        stage("Deploy to QA"){
            steps{
                echo("Automation Code deployed to qa")
            }
        }
        
         stage('Sanity Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/Avinash-45/OpenCart.git'
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=src/main/resources/testrunners/testng_sanity.xml"
                    
                }
            }
        }
        
                
        stage('Publish Allure Reports for regression tests') {
           steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: '/allure-results']]
                    ])
                }
            }
        }
        
        
        
        
       
        
        
        
    
        
        
    }
}