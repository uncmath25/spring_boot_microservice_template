# Spring Boot Microservice Template

### Description:
This project provides a Spring Boot Microservice template via Maven

### Features
* Multi-module maven project with separate model and micro-service maven modules
* MVC Controller-Delegate-Service-Repo-Model framework skeleton facilitating separation of concerns when developing the api specification and business logic for the domain model in accordance with appropriate persistance
* Maven Swagger integration which hosts an attractive and helpful UI at http://localhost:8080/swagger-ui.html and also generates a yaml specification at **template-service/src/main/resources/swagger_generated.yaml**
* Basic JUnit testing stubs utilizing Spring Boot Dependency Injection for service unit testing and micro-service "smoke" tests
* Multiple repo implementations for testing with mock data, storing data locally and a production stub for S3 storage: these implementations are controlled by maven profiles according to desired usage
* Maven Docker integration which produces a local Docker image **uncmath25/spring-boot-microservice-template** which wraps the generated micro-service jar in a light-weight and portable JRE
* Model template which highlights how Spring Boot build-in Jackson ObjectMapper can readily convert Java POJOs to JSON
* Jackson annotation examples demonstrating how to polymorphically leverage a shared JSON data model via different child node implementations

### Local Usage
1. Build and locally install the maven project from the root directory using ` mvn clean install `
2. Run the Spring Boot micro-service locally from the **template-service** directory using ` mvn spring-boot:run `

### Notes
* The Docker image could be deployed to ECR for use with ECS; appropriate AWS CodeBuild and CodePipeline CloudFormation artifacts could also be added for developing a full CI / CD pipeline for this microservice-template

### CURL Client Stub
``` bash
curl -X GET \
  http://localhost:8080/api/v1/template/parks/MockPark

curl -X PUT \
  -H 'Content-Type: application/json' \
  -d '{"name": "MockPark", "parkType": "ZOO", "parkData": null}' \
  http://localhost:8080/api/v1/template/parks/MockPark
```
