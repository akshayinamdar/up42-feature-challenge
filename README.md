# UP42-feature-challenge
A simple REST API service built with Kotlin and Spring Boot framework. It allows you to perform read operations of features and images from stored JSON data via API. The application has two main endpoints, one to retrieve feature data and the other to retrieve feature images.

## Technologies Used
Kotlin
Spring Boot

## Features
REST API endpoint to retrieve feature data present in the resource file
REST API endpoint to retrieve feature image for a given feature ID

## Project Structure
The project has the following main folders:

Controllers - REST controller to handle HTTP requests
Exceptions - Centralized exception handling files
Repositories - JPA related files. Currently, we have an interface that allows reading data from the resource folder
Constants - Centralized string constants
Services - Business logic layer for a given functionality
The application also includes a test framework for testing purposes and has been dockerized for easy deployment to any cloud.

## Installation
Run the application using Gradle:
~~~~
cd backend-coding-challenge
./gradlew build
./gradlew bootrun
~~~~

## Assumptions
1. The features are represented as a list of Features, and each feature has an ID, timestamp, begin viewing date, end viewing date, mission name, and quick look.
2. The quick look is a Base64-encoded image in PNG format.
3. The source data is stored in a static JSON file located at "/static/source-data.json".
4. The JSON file is expected to be in a specific format that can be deserialized into a list of Features.
5. The application assumes that the JSON file exists, is accessible, and can be read successfully.
6. The application assumes that the quick look can be successfully decoded from Base64 to a byte array.

## Trade-offs
### Simplicity vs. flexibility: 
The application uses a simple approach to read data from a JSON file and return it as a list of features. While this makes the application easy to understand and implement, it may not be the most flexible or scalable solution for handling large amounts of data. For example, if the application needed to handle terabytes of satellite imagery data, it may need a more advanced data processing pipeline or database storage solution.

### Readability vs. efficiency: 
The application uses the Jackson JSON library to parse JSON data into objects. While this library is widely used and easy to work with, it may not be the most efficient solution for handling large JSON files or frequent updates to the data. Other libraries like Gson or custom parsers may be faster and more efficient, but potentially less readable or more complex.

### Security vs. usability: 
The application uses Base64 encoding to securely transmit image data to clients. While this method provides some level of security, it may not be the most user-friendly or efficient solution for large amounts of image data. Additionally, it's worth noting that Base64 encoding does not actually encrypt data, so it may be vulnerable to attacks if the data is intercepted.
