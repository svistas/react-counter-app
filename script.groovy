def deployApp() {
    echo 'Deploying React Counter App to AWS EC2...'
    
    def dockerCmd = """
        # Stop and remove any existing containers using this image
        docker ps -a -q --filter ancestor=sofiavistas/react-counter-app:latest | xargs -r docker stop
        docker ps -a -q --filter ancestor=sofiavistas/react-counter-app:latest | xargs -r docker rm
        
        # Stop and remove container by name if it exists
        docker stop react-counter-app 2>/dev/null || true
        docker rm react-counter-app 2>/dev/null || true
        
        # Remove old image to force fresh pull
        docker rmi sofiavistas/react-counter-app:latest 2>/dev/null || true
        
        # Pull latest image and run
        docker pull sofiavistas/react-counter-app:latest
        docker run -d -p 8080:80 --name react-counter-app sofiavistas/react-counter-app:latest
        
        echo "Deployment successful! App running on port 8080"
    """

    sshagent(['ec2-server-key']) {
        sh "ssh -o StrictHostKeyChecking=no ec2-user@13.61.146.89 '${dockerCmd}'"
    }
    
    echo 'Deployment completed!'
}

return this

