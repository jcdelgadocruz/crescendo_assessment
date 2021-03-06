# Crescendo


## Yelp Reviews Skills Assessment

- Choose your favorite local restaurant on Yelp that has a considerable amount of reviews. Here is an example.
- Build an API endpoint in your preferred language and framework (e.g., Spring Boot) that can take a parameter that you’ll use to retrieve the Yelp data.
- In the API endpoint, process the Yelp data, pull out the reviews, convert the review data into a list and output the information as JSON. Processing could be by Yelp API. Your JSON should include the reviewer’s relevant info and review content.
- Extra credit: For each review, take the reviewer avatar image and run it through the Google Vision API. What we are looking for is the emotions data such as joyLikelihood or sorrowLikelihood. Include this data along with the JSON data. If you are familiar with a similar technology feel free to use that instead of the Google Vision API.


## Overview

- Yelp has is current API allowing other system to connect to it and fetch the same information they are able to provide via their own UI
- The Instruction on how to use it can be found here : https://www.yelp.com/developers/documentation/v3/get_started
- For this project we are creating a facade for the "Reviews" section using the ID as the identifier

### How to get the ID

- The ID of a business can be found on the search section : GET https://api.yelp.com/v3/businesses/search
- We can use Postman or a simple HttpClient with basic information

### How to Connect to YELP

- Yelp Fusion Api uses private API Keys to authenticate requests
- I authenticated my app and got a API_KEY/CLIENT_ID assigned

### How to Run the example

- The program is a Spring-boot application ready to be executed.
- Run it via IDE (Eclipse , Intellij) or generate the JAR file (requires Pom chane)   
- Find a Business id  (ie. : MGd6HFEq1ALD58XWNviSXw)
- Make a call to : http://localhost:8989/crescendo/assessment/MGd6HFEq1ALD58XWNviSXw/reviews
- The port can be modified in the application.properties 