#!/usr/bin/env groovy
library identifier: 'jenkins-shared-library@master', retriever: modernSCM(
        [$class: 'GitSCMSource',
        remote: 'https://github.com/svistas/jenkins-shared-library.git',
        credentialsId: 'github-credentials'])

def gv

pipeline {   
    agent any
    
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build and push image") {
            steps {
                script {
                    echo 'Building and pushing Docker image...'
                    buildDockerImage 'sofiavistas/react-counter-app', 'latest'
                }
            }
        }
        
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }               
    }
}

