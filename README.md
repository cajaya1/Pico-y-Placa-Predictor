# Pico-y-Placa-Predictor

This project is a system that can predict if a car or a motorcycle (based on its license number plate) can be on the road in Quito at a set time and date without breaking the Pico y Placa decree. It is developed in Java and uses a MVC architechture and a Factory design pattern.

## Business Rules Taken into consideration:

The app evaluates circulation based on the "Ordenanza Metropolitana 305" which considers:

* **Morning Peak hours**: 07:00 - 09:30
* **Afternoon Peak hours**: 16:00 - 19:30
* The restricted days are mapped to the last digit of the vehicle´s license plate.
* Weekends, holidays are exceptions to this decree, as well as diplomatic missions' cars

## Architecture and design patters

This project was built (mostly) focusing on clean code principles.
It is written in a java and OOP classic semantic and conventions.

It uses an MVC architechture, using a swing based UI for the view, 
input parsing and validation done on the controller, and it has an additional service layer that does the business logic for this app.

Aditionally, it uses a Factory Design Pattern that dynamically instantiates the correct analyzer (since the system detects if the plate
belongs to a car or a motorcycle based on its plate number). There are two interfaces for this pattern to work as intended.

There are also two "Enum" type classes that work as a "library" of sorts, one for the vehicle type and another for the list of holidays that represent an exception to the decree.

## Tech Stack:

*  **Language**: Java
*  **UI Framework**: Java Swing
*  **Testing Tool**: JUnit 5 with parameterized tests
*  **Build Tool**: Maven
*  **IDE**: Netbeans 29

## Testing approach: 
Test Driven Development (TDD) was mostly used to develop this app. The project includes unit cases for each service class, given test cases for the dates, time and vehicle plates.

## How to run the app?

### System Requirements:

JDK (Java Development Kit) 23 with maven installed.

### Execution:

Clone this repository, then navigate to the root directory (containing the pom.xml) and then compile and run using maven 
On the command line: 
```bash
mvn clean compile exec:java -Dexec.mainClass="com.cajaya.picoyplaca.Main" 
```
(Alternatively, you can open and run the project directly using netbeans)

For the automated test just use the command: 

```bash
mvn test