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

## NOTES

The trend score is calculated based on these three categories:
    1. **Normalized number of views of the recipe**
    2. **Normalized number of Engagements (sum of all likes, comments, and shares)**
    3. **Recency factor**
        - For the recency factor we use the Exponential Decay formula = e^(−λ⋅Δt)
            - Whereas e is the natural logarithm 
            - λ = lambda is the rate of decay.
            - delta time is the time passed between current date and date of last engagement 

All these three are taken into consideration based on their "weights" 

The weights will determine how each categories will impact the trend score.

formula for trend score

TrendScore = (NormalizedViews*w1) + (NormalizedEngagements*w2) + (RecencyFactor*w3)

Whereas the w1 + w2 + w3 must be equal to = 1.0 (100%) percentage represented as decimal

Example:
    w1 = 0.3 (30%) 
    w2 = 0.5 (50%) -- having the highest weight making w2 important than w1 and w3
    w3 = 0.2 (20%)

    


  
