HW3 Documentation
Saman Hosseini

Steps:
1. Created MySQL database in Amazon RDS
2. Created the Spring Boot project and connected it to DB
3. Implemented the CRUD operations
    - post survey: "/api/survey" + post
    - list surveys: "/api/list" + get
    - get survey: "api/list/id" + get 
    - update survey: "api/list/id" + put
    - delete survey: "api/list/id" + delete
4. Tested the project using postman
5. Created Dockerfile
6. Created Jenkinsfile with 3 stages:
    - Build Application: ./mvn clean package
    - Push Docker Image: docker push ...
    - Deployment to rancher: update hw3-deployment.yaml file to update the docker image
7. Uploaded project to GitHub
8. Pushed docker to dockerhub
9. Created hw3-deployment in Rancher
    - container name: studentsurvey
    - replicas: 3
    - container image: moufaso/studentsurvey645hw3:0.3
    - Node port: hw3nodeport
10. Created hw3-pipline in Jenkins
    - Poll SCM: * * * * *
    - Pipline script from SCM: git
11. Tested the CRUD operations using postman

Database Host: student-survey.c3zwolded1mc.us-east-1.rds.amazonaws.com:3306/studentsurvey
GitHub Repo: https://github.com/Moufaso/SWE645-HW3.git
DockerHub Repo: https://hub.docker.com/repository/docker/moufaso/studentsurvey645hw3
Rancher: http://23.21.203.160
Jenkins: http://23.21.203.160:8080

Student Survey URL: http://98.81.232.26:30966