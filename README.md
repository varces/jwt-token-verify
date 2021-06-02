# JWT verifiy Token Application

Application using [`Keycloak`](https://www.keycloak.org/). 


## Applications

- **jwt-token-api**

  `Spring Boot` Web Java backend application that exposes a Rest API. Its verify Keycloak Access Token using Json Web token (JWT).
  

## Prerequisites

- `Docker`

- `Docker-Compose`


## Start environment

- In a terminal and inside root folder run
  ```
  docker-compose up --build -d
  ```

## Applications URLs

| Application      | URL                                   | Credentials                           |
| -----------      | ------------------------------------- | ------------------------------------- |  
| jwt-token-api    | http://localhost:9080/swagger-ui.html | [Access Token](#getting-access-token) | 
| Keycloak         | http://localhost:8080/auth/admin/     | `admin/admin`                         |


### Getting Access Token

- Open a terminal

- Add `keycloak       127.0.0.1` in /etc/hosts

- Run the following commands to get the access token
  ```
  ACCESS_TOKEN="$(curl -s -X POST \
    "http://keycloak:8080/auth/realms/jwt-services/protocol/openid-connect/token" \
    -H "Content-Type: application/x-www-form-urlencoded" \
    -d "username=admin" \
    -d "password=admin" \
    -d "grant_type=password" \
    -d "client_id=jwt-app" | jq -r .access_token)"

  echo $ACCESS_TOKEN
  ```
  ```
    RESULT="$(curl -s -X POST \
    'http://localhost:9080/api/v1/token' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "token" : "access_token"
    }'

  echo $RESULT
  ```

### Calling jwt-token-api endpoints using Swagger

- Access `jwt-token-api` Swagger website, http://localhost:9080/swagger-ui.html

- Send the obtained at [getting-access-token](#getting-access-token)) in /api/v1/token API


## Shutdown

  ```
  docker-compose down -v
  ```
