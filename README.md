# Request-Reply Pattern with RabbitMQ RPC

Demonstrate the request-reply pattern or RPC using RabbitMQ in Java

Overview

The Request-Reply pattern is a fundamental messaging pattern that enables two-way communication between components in distributed systems. Here's a clear explanation with a visual representation:

How It Works

Request: A client sends a message (request) to a server or service through RabbitMQ. the client will publish the data to test Queue
Processing: The server processes the request. the server is listening to test queue.
Reply: The server sends a response message back to the client through RabbitMQ

Request Key Characteristics

1. Synchronous-like behavior: While messaging is typically asynchronous, this pattern provides a way to simulate synchronous communication.
2. Correlation ID: Each request includes an identifier that ties the reply to the original request. The client knows his reply from Correlation ID.


What is in This Project?
1. A client that asks for Fibonacci numbers.
2. A server that calculates and answers.
3. Docker-compose file to run the project

What You Need (If you plan to debug the code)
1. Java: Version 22. 
2. RabbitMQ: A running RabbitMQ server.
3. Maven
4. Docker

Project Setup and Testing Guide

1. Start the Application
Run the following command to build and launch the Docker containers: docker compose up --build

3. Configure RabbitMQ
Access the RabbitMQ management console at:
http://localhost:15672
(Credentials: username guest, password guest)
Navigate to:
  -> Queues and streams
     Create a new queue named test
3. Test the Application
Import the Postman collection from the project repository
Execute the available API requests to verify functionality
