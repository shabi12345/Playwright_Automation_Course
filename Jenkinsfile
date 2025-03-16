pipeline {
    agent any
    
    environment {
        MVN_HOME = "C://apache-maven-3.9.9"  // Use correct path format
        JAVA_HOME = "C://Program Files//Java//jdk-17"
    }
    
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: 'github-token', url: 'https://github.com/shabi12345/Playwright_Automation_Course.git
            }
        }

        stage('Build') {
            steps {
                bat '"%MVN_HOME%/bin/mvn" clean install'
            }
        }

        stage('Test') {
            steps {
                bat '"%MVN_HOME%/bin/mvn" test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying Application... (Placeholder Step)"
            }
        }
    }
}
