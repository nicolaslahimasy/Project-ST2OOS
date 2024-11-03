# Project-ST2OOS

This project is a Java project with REST and gRPC services for order management, using Spring Boot, H2, and Swagger documentation.

Enter "./gradlew build" in the root folder to install all dependencies and start the gradle project.
Write "./gradlew runRestServiceApp" To launch the service.

Database is also available at '/h2-console', url=jdbc:h2:mem:testdb, user=SA and password = password.
In the database, make sure to write the table "orders" not "order" which is an existing SQL command


The curl requests : 

- To add a new order : curl -X POST "http://localhost:8080/orders" -H "Content-Type: application/json" -d "{\"description\": \"Nouvelle commande\"}"
- To check the orders : curl -X GET "http://localhost:8080/orders"
  



