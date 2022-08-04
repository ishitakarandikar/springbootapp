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
              
              // sh 'chmod +x /var/lib/jenkins/workspace/abc/target/MyWebApp-0.0.1-SNAPSHOT.war'
            //scp  '/var/lib/jenkins/workspace/abc/target/MyWebApp-0.0.1-SNAPSHOT.war  /opt/tomcat/webapps'
       sshagent(['deploy_user']) {
    // some block
       ssh -o    StrictHostKeyChecking=no ishitakarandikar@192.168.29.1 
   sh 'scp  /var/lib/jenkins/workspace/abc/target/MyWebApp-0.0.1-SNAPSHOT.war  ishitakarandikar@192.168.29.1:/opt/tomcat/webapps'
            
        }
     
            }
            }
        }
    }

