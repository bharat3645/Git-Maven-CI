pipeline {

    agent any

    // 'Maven3' must match the name given to the Maven installation under
    // Manage Jenkins -> Tools -> Maven installations.
    tools {
        maven 'Maven3'
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn -B clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn -B test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn -B package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                sh 'echo "Deploying demo-app to the test environment..."'
            }
        }
    }

    post {
        success {
            echo 'Pipeline finished: all stages green.'
        }
        failure {
            echo 'Pipeline failed. Open the red stage above to see why.'
        }
    }
}
