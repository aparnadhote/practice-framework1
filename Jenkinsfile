pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

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