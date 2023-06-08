pipeline 
{
    agent any
    stages 
    {
       stage("Build"){
           steps{
               echo("Build the project")
           }
       }
        
        
        
        stage("Deploy to QA"){
            steps{
                echo("deploy to QA")
            }
        }
        
        
                
        stage("Regression Automation Test") {
            steps {
               echo("Regression Automation Test")
                    
                }
            }
        
                
     
        stage("Publish Allure Reports for Regression") {
           steps {
               echo("Allure Reports for regression")
            }
        }
        
        
    }
}