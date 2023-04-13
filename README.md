# Souvenir Shop (CassandraDB)

![image](https://user-images.githubusercontent.com/70757499/216840726-5a6609da-6182-43f7-af32-2a1c38f9d627.png)

### To view the frontend of this project, please refer to this [link](https://github.com/PetarRan/cassandra-frontend)

This is a web application built using Spring Boot and Cassandra as the database. The main focus of the project is to showcase the ability of Cassandra's clustering and partitioning keys in handling large amounts of data.

## Features
- Browse through a wide range of souvenirs available in the shop
- Search for specific items using keywords
- Add items to your cart and proceed to checkout
- Securely handle user authentication and authorization
- Utilize Cassandra's powerful NoSQL capabilities for efficient data management

## Getting Started

### Prerequisites
- Java 8 or later
- Cassandra 3.11 or later

### Installation
1. Clone the repository

`git clone https://github.com/PetarRan/cassandra-project.git`

2. Set up a Cassandra cluster and configure the application to connect to it by modifying the application.properties file
3. Build the project using Gradle or Maven

`./gradlew build` or `mvn clean install`

4. Run the Spring Boot application

`./gradlew bootRun` or `java -jar target/souvenir-shop-0.0.1-SNAPSHOT.jar

5. Access the application by navigating to http://localhost:8080 in your browser

## Built With
- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Cassandra](http://cassandra.apache.org/) - The database used

## Contributing

Please read [CONTRIBUTING.md](https://github.com/PetarRan/cassandra-project/blob/main/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

- **Petar Randjelovic** - [PetarRan](https://github.com/PetarRan)

See also the list of [contributors](https://github.com/PetarRan/cassandra-project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/PetarRan/cassandra-project/blob/main/Licence.md) file for details.

## Acknowledgments

- Hat tip to anyone whose code was used
- Inspiration
- etc

#### Note
Make sure you fill the appropriate details and also update the readme as per your project requirements.


| **Tech Choice 1** | **Tech Choice 2** | **IDE** | **DataBase** |
| --- | --- | --- | --- |
| ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) | ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) | ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white) | ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white) | ![ApacheCassandra](https://img.shields.io/badge/cassandra-%231287B1.svg?style=for-the-badge&logo=apache-cassandra&logoColor=white) |

