# Recime

**Recime** is a recipe searching demonstration. This project uses a trending algorithm using user engagement metrics, and a recency factor to provide the best recent recipe recommendations.

## Table of Contents

- [Features](#features)
- [Run the application](#Run-the-Application)
- [POSTMAN testing](#Postman)
- [Additional Notes](#Notes)

## Features and Path

- **Recipe Search**: Search all recipes. (`localhost:8080/api/recipes/trending/search/all`)
- **Recipe Search by Difficulty**: Search all recipes filtering by Difficulty (EASY, MEDIUM, HARD) (`localhost:8080/api/recipes/trending/search?difficulty=EASY`).


## Run the Application:
    To run Recime locally, follow these steps:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/neildiamzon/recime.git
    cd recime
    ```

2. **Install dependencies**:
    Make sure you have Java and Maven installed on your system. Then, install the necessary dependencies:

    ```bash
    mvn clean install
    ```
    
3. **Run the Application**:
    Use the following command to start the application:

    ```bash
    mvn spring-boot:run
    ```

4. **Access the Application**:
    Once the application is running, you can access it in your web browser at `http://localhost:8080`.


## POSTMAN

- **POSTMAN COLLECTIONS is included in the root folder (`postman_collection-test_cases`)**
  
