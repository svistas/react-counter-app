# React Counter App - Dockerized Demo

A simple, beautiful React counter application ready for quick deployment demos.

## Features

- ✨ Modern, gradient UI design
- ⚡ Built with React + Vite
- 🐳 Fully Dockerized with multi-stage build
- 📦 Optimized production build with Nginx
- 🚀 Ready for Docker Hub deployment

## Local Development

### Prerequisites
- Node.js 18+ (for local development)
- Docker (for containerized deployment)

### Run Locally (without Docker)

```bash
# Install dependencies
npm install

# Start development server
npm run dev
```

Visit `http://localhost:3000`

## Docker Deployment

### Build Docker Image

```bash
# Build the image
docker build -t react-counter-app .

# Or build with your Docker Hub username
docker build -t YOUR_DOCKERHUB_USERNAME/react-counter-app:latest .
```

### Run Docker Container

```bash
# Run the container
docker run -d -p 8080:80 --name counter-app react-counter-app

# Or with your Docker Hub image
docker run -d -p 8080:80 --name counter-app YOUR_DOCKERHUB_USERNAME/react-counter-app:latest
```

Visit `http://localhost:8080`

### Push to Docker Hub

```bash
# Login to Docker Hub
docker login

# Tag your image (if not already tagged)
docker tag react-counter-app YOUR_DOCKERHUB_USERNAME/react-counter-app:latest

# Push to Docker Hub
docker push YOUR_DOCKERHUB_USERNAME/react-counter-app:latest
```

### Pull and Run from Docker Hub

```bash
# Pull from Docker Hub
docker pull YOUR_DOCKERHUB_USERNAME/react-counter-app:latest

# Run the pulled image
docker run -d -p 8080:80 YOUR_DOCKERHUB_USERNAME/react-counter-app:latest
```

## CI/CD Deployment to AWS EC2

This project uses **Jenkins** for automated deployment to AWS EC2.

### Pipeline Overview

The Jenkins pipeline (`Jenkinsfile`) automatically:
1. Builds the Docker image using multi-stage build
2. Pushes to Docker Hub (`sofiavistas/react-counter-app:latest`)
3. Deploys to EC2 server using SSH

### Prerequisites

- **Jenkins** with the SSH Agent plugin installed
- **EC2 instance** with Docker installed
- **Jenkins credentials** configured:
  - `github-credentials`: GitHub access token
  - `dockerhub-credentials`: Docker Hub login (used by shared library)
  - `ec2-server-credentials`: SSH private key for EC2 access

### Deployment Process

The `script.groovy` uses Jenkins' `sshagent` to deploy to EC2:

```groovy
sshagent(['ec2-server-credentials']) {
    sh "ssh -o StrictHostKeyChecking=no ec2-user@YOUR_EC2_IP '${dockerCmd}'"
}
```

### EC2 Security Group

Ensure your EC2 security group allows:
- **Port 8080** (inbound) - for web access
- **Port 22** (inbound) - for SSH from Jenkins server

### Access the App

After deployment, access at: `http://YOUR_EC2_IP:8080`

## Project Structure

```
react-counter-app/
├── src/
│   ├── App.jsx          # Main counter component
│   ├── App.css          # Styling
│   ├── main.jsx         # React entry point
│   └── index.css        # Global styles
├── index.html           # HTML template
├── package.json         # Dependencies
├── vite.config.js       # Vite configuration
├── Dockerfile           # Multi-stage Docker build
├── Jenkinsfile          # CI/CD pipeline definition
├── script.groovy        # Jenkins deployment script
└── README.md            # This file
```


## License

MIT - Feel free to use for demos and learning!

