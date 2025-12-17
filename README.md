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

## Quick Demo Commands

```bash
# Build, run, and test locally
docker build -t react-counter-app . && docker run -d -p 8080:80 react-counter-app

# Stop and remove container
docker stop counter-app && docker rm counter-app

# View logs
docker logs counter-app
```

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
├── .dockerignore        # Docker ignore rules
└── README.md           # This file
```

## Technologies Used

- **React 18** - UI library
- **Vite** - Build tool and dev server
- **Docker** - Containerization
- **Nginx** - Production web server

## License

MIT - Feel free to use for demos and learning!

