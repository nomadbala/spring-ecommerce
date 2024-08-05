# Spring Ecommerce

## About

This project is a comprehensive e-commerce application built using a microservices architecture. It leverages Spring Boot for backend services, with each service being responsible for a specific domain in the application.

## Features

- **Microservices Architecture**: Each service is independently deployable and scalable.
- **Spring Cloud**: Utilized for service discovery and configuration management.
- **JWT Authentication**: Secure user authentication.
- **Kafka**: For event-driven communication between services.
- **Docker & Kubernetes**: Containerization and orchestration.
- **Monitoring**: Implemented with Grafana and VictoriaMetrics.

## Microservices

1. **API Gateway**: Centralized entry point for client requests.
2. **Auth Service**: Handles user authentication and authorization.
3. **Product Service**: Manages product data.
4. **Order Service**: Manages customer orders.
5. **Payment Service**: Handles payment processing.
6. **Inventory Service**: Manages product inventory.
7. **Notification Service**: Sends notifications to users.
8. **Analytics Service**: Provides analytical insights.
9. **Config Server**: Centralized configuration management.
10. **Eureka Server**: Service registry.

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Application framework.
- **Spring Cloud**: Microservices framework.
- **Docker**: Containerization.
- **Kubernetes**: Container orchestration.
- **PostgreSQL**: Relational database.
- **MongoDB**: NoSQL database.
- **Kafka**: Event streaming platform.
- **Keycloak**: Identity and access management.
- **Grafana & VictoriaMetrics**: Monitoring and observability.

## Getting Started

### Prerequisites

- Docker
- Kubernetes
- Java 11+
- Maven

### Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/nomadbala/spring-ecommerce.git
    cd spring-ecommerce
    ```

2. **Build the project**:
    ```bash
    mvn clean install
    ```

3. **Run Docker containers**:
    ```bash
    docker-compose up -d
    ```

4. **Deploy to Kubernetes**:
    ```bash
    kubectl apply -f kubernetes/
    ```

### Usage

- Access the application via the API Gateway at `http://localhost:8080`.
- Use Swagger UI for API documentation and testing.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- Spring Team for their excellent frameworks.
- Docker and Kubernetes communities for containerization and orchestration tools.
- Contributors and developers for their continuous support.

