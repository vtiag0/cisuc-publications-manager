# cisuc-publications-manager

This project is a replication of the one developed within the scope of the Object-Oriented Programming (OOP) course during the second year of the bhacelor's degree program in Informatics Engineering at the University of Coimbra. It consists on a simple Java application that manages CISUC research groups, researchers and publications. The assignment requests an application where interaction is done through the command line, with the following features listed below:

- Present the general indicators of CISUC:
  - [x] Total number of members
  - [x] Number of members in each category
  - [x] Total publications in the last 5 years
  - [x] Number of publications of each type
- [] List the publications of a research group from the last 5 years, organized by year, publication type, and impact factor.
- [] List the members of a research group grouped by category.
- [] List the publications of a researcher grouped by year, publication type, and impact factor.
- List all research groups and present for each group:
  - [] Total number of members
  - [] Number of members in each category
  - [] Total publications in the last 5 years
  - [] Number of publications from the last 5 years, grouped by year, publication type, and impact factor.

## Project organization

The project is organized as follows:

- db: text files for testing
- src: source code with all the implemented classes
- diagrams: UML diagram class picture

## UML class diagram

## Run

Run directly in Visual Studio Code by installing this [extension](https://code.visualstudio.com/docs/languages/java) or compile and run with the following commands:

```
javac -d bin\ src\*.java
java -cp bin Main
```
