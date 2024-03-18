# n11 TalentHub Backend Bootcamp

## Architecture

![Service Architecture](/images/service-architecture.png)

## Running

All services are dockerized with `docker-compose.yml`

```bash
docker-compose up -d
```

**PostgreSQL**
- username: *myoluk*
- password: *password*
- db: *n11_db*

## Services

### user-review-service

- **docker-image**: user-review-service
- **swagger**: [localhost:8080](http://localhost:8080/swagger-ui.html)
- Handles operations for reviewing: creation, deletion, and updating
- Retrieves user information via `user-service` using @FeignClient
- Retrieves recommended restaurant information via `restaurant-service` using @FeignClient
- Produces logs for `kafka-logger-service`

> `application.properties` should contain PostgreSQL credentials

### user-service

- **docker-image**: user-service
- **swagger**: [localhost:8081](http://localhost:8081/swagger-ui.html)
- Manages user operations: creation, deletion, and updating
- Produces logs for `kafka-logger-service`

> `application.properties` should contain PostgreSQL credentials


### restaurant-service

- **docker-image**: restaurant-service
- **swagger**: [localhost:8082](http://localhost:8082/swagger-ui.html)
- **solr**: [localhost:8983](http://localhost:8983/solr)
- Manages restaurant operations: creation, deletion, and updating
- Produces logs for `kafka-logger-service`


### kafka-logger-service

- **docker-image**: kafka-logger-service
- **kafka-topic**: log-events
- Stores log information from other services

> `application.properties` should contain PostgreSQL credentials