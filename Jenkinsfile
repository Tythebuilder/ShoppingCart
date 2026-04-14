pipeline {
    agent any
    environment {
        DOCKER_IMAGE = "sabarishselva23/ShoppingCart:latest"
    }
    stages {
        stage("Clone Repository") {
            steps {
                git branch: "main",
                    url: "https://github.com/Tythebuilder/ShoppingCart.git"
            }
        }
        stage("Build with Maven") {
            steps { bat "mvn clean package" }
        }
        stage("Run JUnit Tests") {
            steps { bat "mvn test" }
        }
        stage("Build Docker Image") {
            steps { bat "docker build -t %DOCKER_IMAGE% ." }
        }
        stage("Push to DockerHub") {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: "dockerhub-creds",
                    passwordVariable: "DOCKER_PASS",
                    usernameVariable: "DOCKER_USER")]) {
                    bat "docker login -u %DOCKER_USER% -p %DOCKER_PASS%"
                    bat "docker push %DOCKER_IMAGE%"
                }
            }
        }
        stage("Deploy to Kubernetes") {
            steps {
                bat "kubectl apply -f deployment.yaml"
                bat "kubectl rollout restart deployment/ShoppingCart"
            }
        }
    }
}
