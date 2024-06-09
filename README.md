# CODERHACK



## Introduction

This is a RESTful API service built using Spring Boot to manage the leaderboard for a coding platform. It uses MongoDB to persist data. The platform also gives virtual awards to the users called Badges based on their score.



## Features

- CRUD operations
- Badge Assignment
- Sorting of users


## API Endpoints
- GET /users: Retrieve a list of all registered users.
- GET /users/{userId}: Retrieve the details of a specific user.
- POST /users: Register a new user.
- PUT /users/{userId}: Update the score of a specific user.
- DELETE /users/{userId}: Deregister a specific user.

## Installation



### 1. Add repository
```
git clone [repository]
```


### 2. Add dependencies
```
	implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
```



### 3. Run softwares
```
- Java 21
- MongoDB
- Gradle
``` 


### 4. Execute
```
./gradlew test
./gradlew build
./gradlew bootrun
```


**The server will start and be accessible at http://localhost:8080**

To know more Navigate : [Postman API Documentation](https://www.postman.com/technical-cosmonaut-13105159/workspace/my-workspace/collection/36174974-09f43d36-3e2f-4a60-b506-de85d6b821a5)

___