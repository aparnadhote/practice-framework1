pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    parameters {
        string(name: 'THREADS', defaultValue: '2', description: 'Number of parallel threads')
        string(name: 'BROWSER', defaultValue: 'chrome', description: 'Browser to run tests')
        string(name: 'HEADLESS', defaultValue: 'true', description: 'Run in headless mode')
    }

    stages {

        stage('Build & Test') {
            steps {
                bat "mvn clean test -Dthreads=%THREADS% -Dbrowser=%BROWSER% -Dheadless=%HEADLESS%"
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**/*.*', fingerprint: true
            }
        }
    }
}