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
           script {
               def threads = params.THREADS?.trim() ? params.THREADS : "2"
               def browser = params.BROWSER?.trim() ? params.BROWSER : "chrome"
               def headless = params.HEADLESS?.trim() ? params.HEADLESS : "true"

               bat "mvn clean test -Dthreads=${threads} -Dbrowser=${browser} -Dheadless=${headless}"
           }
       }
   }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**/*.*', fingerprint: true
            }
        }
    }
}