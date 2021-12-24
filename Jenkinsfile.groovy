node {
    def ant
    stage('Clone the code') {
        git 'https://github.com/HaneesH1994/ant_proj.git'
        ant = tool 'Ant'
    }
    stage('Build') {
        withEnv(["Ant=$ant"]) {
                sh "$Ant/bin/ant"
        }
    }
    stage('Deploy the code') {
        sh '''
        pwd
        ls -l
        sudo cp /var/lib/jenkins/workspace/ant-scrptd/dist/AntExample.war /var/lib/tomcat8/webapps/
        '''
    }
}
