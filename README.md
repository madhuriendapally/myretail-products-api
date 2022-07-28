# Myreatil-Products-api

This application is built to demonstrate products API for an online retail store

## Tech Stack
* Java 11 
* SpringBoot 2.7.1
* MongoDB
* Spock 

## Local setup
clone the project from https://github.com/madhuriendapally/myretail-products-api.git

### Initialize Docker
The project is setup with a docker-compose.yml file to spin a MongoDB container & Mongo-express container.
* Mongodb container - A local instance of Mongo DB initialized with data /mongo-init/init.js
* Mongo-express UI - For mongo web interface to verify the data.

From your terminal window enter
```docker compose up```
This should spin up a local instance of mongodb and mongoexpress-ui with initial data.

### Verify Docker initialization
on the terminal window enter the below command 
```docker container ls```
This should list the both mongo & mongo-express containers
![docker-container-ls](/images/docker-container-ls.png)

Now access http://localhost:8111 from your web-browser and this should bring up the UI
![mongo-express-ui](/images/mongo-express-ui.png)

### Build the project
Build either form command line or intellij gradle window. (For convenience, I usually use the IDE :))
```./gradlew clean build```
```./gradlew bootrun```

### Verify the application is up & running
You should now be able to bring up the swagger url http://localhost:8080/myretail/swagger-ui/index.html

### Application endpoints
* Access the endpoint /api/v1/products/{productId} either from swagger or directly accessing the url from browser
* http://localhost:8080/myretail/api/v1/products/13860428
```
{"id":13860428,"name":"The Big Lebowski (Blu-ray)","current_price":{"value":138.56,"currency_code":"USD"}}
```
![swagger-products-request](/images/swagger-product-details.png)
* Other sample product id's available in the DB - 123456, 23456, 890674. These product's since not available as part of redsky service will not have the name value.
* If the product is not found then the request returns a 404 - http://localhost:8080/myretail/api/v1/products/1234
response: 
* ```{"id":"970693b9-4154-430b-872e-50e69d7ade59","message":"The product: 1234 is not found"}```