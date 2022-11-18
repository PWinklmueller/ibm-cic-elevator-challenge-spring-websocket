# ibm-cic-elevator-challenge-spring-websocket
Solution for the DC Tower Elevator Challenge with Spring Boot and WebSocket

This is my second solution to the coding challenge. With this one, I wanted to 
show my skills / understanding for Java.
This program uses Multithreading, just like the one before. But this application
was built using Spring Boot and Maven. Also, you can now send requests to the program via
WebSocket, to connect just use this URL:

ws://localhost:8080/elevator

The Message should look like this:


{
    "startFloor": 0,
    "destinationFloor": 10,
    "direction" : "UP"
}

Also, there are tests now for the program. Just use "mvn test".
