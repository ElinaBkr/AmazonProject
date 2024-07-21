Objective:
This project is a take-home exercise completed for a manual QA Engineer role. The objective was to develop an automated testing framework using Selenium WebDriver and Java to test the search functionality of an e-commerce website.

Technologies Used:

- Selenium WebDriver
- Java
- Cucumber for BDD
- Maven for dependency management
  
Key Features:

- Implemented Page Object Model (POM) design pattern to enhance maintainability and readability.
- Integrated Cucumber to write test scenarios in Gherkin syntax, promoting BDD practices.
- Included assertions for validating search results and handling dynamic content.
- Configured logging for debugging purposes and capturing screenshots on test failures.
- Used Maven for project management and dependency injection.

Project Structure:

- src/main/java: Contains page objects and utilities.
- src/test/java: Includes step definitions and test runners for Cucumber scenarios.
- features: Contains feature files written in Gherkin syntax.

Instructions:

1. Clone the repository: git clone https://github.com/ElinaBkr/AmazonProject.git
2. Navigate to the project directory: cd automated-testing-framework
3. Install dependencies: mvn clean install
4. Execute tests: mvn test

Future Improvements:

- Incorporating additional assertions to validate various aspects of the application's behaviuor and UI elements.
- Enhance error handling and reporting mechanisms.
- Implement parallel execution for faster test runs.
- Integrate with a continuous integration tool for automated builds and deployment
