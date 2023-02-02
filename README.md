# ZOO Manager

Welcome to the Animals in the Zoo App! This app is written in Java with the SpringBoot framework and contains an intuitive API and web interface. 

This app allows you to manage animals in a zoo, from adding species to managing keepers. You can add animals and keepers to the zoo, view a list of animals and keepers, edit existing animal entries, and search for animals by name. The app also contains a web interface that allows you to manage the animals and keepers in the zoo, as well as create reports on the different species and keepers. The app also contains a simple user authentication system to ensure secure access and a logging system to track any changes made.

## Stack 

| Technology | Description | 
| --- | --- |
| Java | General-purpose computer programming language | 
| Gradle | Open-source build automation system |
| SpringBoot | Open-source Java-based framework used to create a Micro Service |
| Thymeleaf | Modern server-side Java template engine for both web and standalone environments |
| JPA | Java Persistence API which is an API used to access data from databases |
| PostgresDB | Open-source relational database management system |
| HsqlDB | Relational database management system written in Java |

## DB Set Up

Make sure to have a PostgresDB set up and check if login data are the same as in `./src/main/resources/application.properties`

```
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/zoo
spring.datasource.username=postgres
spring.datasource.password=postgres
```

If you prefere to use HsqleDB, modify the `application.properties` file and `gradle.build`. Run the db with `./startServer.sh`

## Build and Run

The app is built on gradle so running it is pretty easy. You need to have JAVA-11 installed as well as gradle. Then just run a command: 

`gradle build && gradle run`

## Usage

The app is running on `localhost:5000` so you can just go to your browser and type that address. The api is running on `localhost:5000/api`. Examlple endpoint: 

- Get all animals - `GET 127.0.0.1:5000/api/animals`
- Get animal by id - `GET 127.0.0.1:5000/api/animals/{id}`
- Create animal - `POST 127.0.0.1:5000/api/animals`

Example body (JSON):

```json
{
    "name": "Big E",
    "adoptDate": "1979-03-15",
    "description": "Pretty old elephant"
}
```

## Todo:
- [X] Fix all "delete" endpoints
- [ ] Add tests
- [ ] Add more templates
- [ ] Add validation
- [ ] Make a docker image

## Disclaimer 

The app is not ready and probably will never be. It was created as a study project and contains few bugs because it was my first time working with SpringBoot.
