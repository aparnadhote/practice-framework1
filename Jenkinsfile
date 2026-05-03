pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/aparnadhote/practice-framework1.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test -Dheadless=true'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**/*.*', fingerprint: true
            }
        }
    }
}