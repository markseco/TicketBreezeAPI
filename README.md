# TicketBreezeAPI

This is a RESTful API for a ticket management system where you can create users, events, book tickets for the events and add reviews for them as well. 
It is built using Java Spring Boot, MySQL, JPA, and Hibernate. It has been deployed on AWS using RDS for the database and Docker containers managed by AWS ECS.

## Table of Contents

- [Deployment](#deployment)
- [API Endpoints](#api-endpoints)
- [Testing with Postman](#testing-with-postman)

## Deployment

### AWS RDS (Relational Database Service)

The API uses AWS RDS to host the MySQL database. The database connection properties can be configured in the `application.properties` file. Make sure to update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` to point to your AWS RDS instance.

### AWS ECS (Elastic Container Service)

This API has been containerized using Docker and deployed on AWS ECS.

## API Endpoints

Below are the endpoints provided by the API:

- `GET /users`: Retrieve all the users information

- `GET /users/{id}`: Retrieve a specific user by its ID.

- `POST /add-user`: Create a new user. Send a JSON payload with the necessary data.

- `PUT /update-user`: Update an existing user by its ID. Send a JSON payload with the updated data.

- `DELETE /delete-user/{id}`: Delete a user by its ID.

- `GET /events`: Retrieve all the events information

- `GET /event/{id}`: Retrieve a specific event by its ID.

- `POST /add-event`: Create a new event. Send a JSON payload with the necessary data.

- `PUT /update-event`: Update an existing event by its ID. Send a JSON payload with the updated data.

- `DELETE /delete-event/{id}`: Delete a event by its ID.

- `GET /user/{userId}/bookings`: Get all bookings from a specific user.

- `GET /user/{userId}/bookings/{bookingId}`: Get a specific booking for a user.

- `POST /add-event`: Create a new booking. Send a JSON payload with the necessary data.

- `DELETE /user/{userId}/delete-booking/{bookingId}`: Delete a booking by its ID.

- `GET /event/{eventId}/tickets`: Get tickets for an event.

- `GET /event/{eventId}/tickets/{ticketId}`: Get a specific ticket from an event.

- `GET /event/{eventId}/reviews`: Retrieve all the reviews for an event.

- `GET /event/{eventId}/review/{reviewId}`: Retrieve a specific review for an event.

- `POST /event/{eventId}/review/{userId}`: Create a new review for an event. Send a JSON payload with the necessary data.

- `PUT /update-review/{reviewId}`: Update an existing review by its ID. Send a JSON payload with the updated data.

- `DELETE /delete-review/{reviewId}`: Delete a review by its ID.


## Testing with Postman

You can test the API endpoints using Postman. Here's how to do it:

1. Open Postman.

2. Create a new request collection for your API testing.

3. Add a request for each of the endpoints mentioned above (GET, POST, PUT, DELETE, search, and filter).

4. Set the request method, URL, and request body (if required) based on the API documentation.

5. Send the request and inspect the response to ensure that the API is working as expected.
