# Deadline Tracker

Tracks deadlines for you, so you don't have to keep them in your head.

## Tech stack

- Java 21, Spring Boot 4
- PostgreSQL 18
- Docker Compose (local database)

## Prerequisites

- Java 21 (check with `java -version`)
- Docker with Compose (check with `docker compose version`)
- Git

Maven doesn't need to be installed; the project includes the Maven Wrapper (`./mvnw`).

## Running locally

1. Clone the repository:
   ```bash
   git clone https://github.com/ji0610/deadline-tracker.git
   cd deadline-tracker
   ```
2. Start the database:
   ```bash
   docker compose up -d
   ```
   This starts PostgreSQL on `localhost:5432`. The credentials are in `compose.yaml` and are for local development only.
3. Start the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   The first run downloads Maven and all the dependencies, so it takes a minute.
   The app is ready when the log shows `Started DeadlineTrackerApplication`.

## Checking it works

```bash
curl localhost:8080/actuator/health
```
Expected: `{"groups":["liveness","readiness"],"status":"UP"}`

```bash
curl 'localhost:8080/hello?name=Ana'
```
Expected: `{"message":"Hello, Ana"}`

Without `name`, it returns `{"message":"Hello, world."}`.

## Stopping

- The app: `Ctrl+C`
- The database: `docker compose down`. The data is kept in a Docker volume; `docker compose down -v` deletes it.
