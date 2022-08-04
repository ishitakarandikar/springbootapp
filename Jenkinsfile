pipeline {
    agent any
 tools{
    maven 'maven3.6'
 }
    stages {
       stage('Clone')
       {
           steps{
  git url: 'https://github.com/ishitakarandikar/springbootapp' , branch : 'main'
           }
       }
        stage('Build') {
            steps {
                
        sh 'mvn package'
        //dir("${env.WORKSPACE}//var/lib/jenkins/workspace/springapp/target"){
    //sh "pwd"
   
//}
       
      // sh "mv target/*.war target/springapp.war"
    
            }
        }
         stage('Deploy') {
            steps {
          
       sshagent(credentials : ['deploy-ser']) {
    // some block
   
          
   sh 'scp  /var/lib/jenkins/workspace/abc/target/MyWebApp-0.0.1-SNAPSHOT.war  ishitakarandikar@ip-192.168.29.1:/opt/tomcat/webapps'
            
        }
     
            }
            }
        }
    }

