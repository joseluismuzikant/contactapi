# Contact API

This is a Java Spring Boot application that provides a RESTful API for managing contacts. The application uses Maven for
dependency management.

## Prerequisites

- Java 8 or higher
- Maven
- Docker
- PostgreSQL

## Getting Started

1. Clone the repository:
    ```
    git clone https://github.com/jose-muzikant-kinandcarta/contactapi.git
    ```
2. Navigate to the project directory:
    ```
    cd contactapi
    ```
3. Start the PostgreSQL database using Docker:
    ```
    docker-compose up
    ```
4. Run the application:
    ```
    mvn spring-boot:run
    ```
   Alternatively, you can start the application using IntelliJ IDEA.

## API Endpoints

- `POST /contacts`: Create a new contact
- `GET /contacts`: Get a list of all contacts
- `GET /contacts/{id}`: Get a specific contact by ID
- `PUT /contacts/photo`: Upload a photo for a contact
- `GET /contacts/image/{filename}`: Get a contact's photo

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull
requests to us.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details