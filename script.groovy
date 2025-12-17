def deployApp() {
    echo 'Deploying React Counter App in AWS EC2...'
    
    def dockerCmd = """
        docker stop react-counter-app || true
        docker rm react-counter-app || true
        docker pull sofiavistas/react-counter-app:latest
        docker run -d -p 8080:80 --name react-counter-app sofiavistas/react-counter-app:latest
    """

    sshagent(['ec2-server-key']) {
        sh "ssh -o StrictHostKeyChecking=no ec2-user@13.61.146.89 '${dockerCmd}'"
    }
    
    echo 'Deployment completed!'
}

return this

