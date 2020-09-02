# RetailStoreDiscouns

### PUT - Retail Store Discounts

URI: /payments/v1/retail/{id}/discounts

### Description

On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.

### Input Parameters

| NAME | FROM | DESCRIPTION | TYPE | MANDATORY
| :---: | :---: | :---: | :---: | :---: |
| id | PathVariable | id is the unique user id of the customer | String | YES

### Data Model

#### Input Request

            ```{
                "items": [
                  {
                    "itemName": "Potato",
                    "quantity": 5,
                    "type": "GROCERY",
                    "price": 200
                  }
                  ]
              }```
              
#### Output Response

              ```{
                  "userName": "Arul",
                  "userType": "OTHERS",
                  "totalDiscountedPrice": 6845.17,
                  "itemsPurchased": [
                      {
                          "itemName": "Potato",
                          "quantity": 5,
                          "type": "GROCERY",
                          "price": 1000.0,
                          "discountedPrice": 1000.0
                      }
                  ]
              }```
              
 ### Curl Collection
 
 #### Non Regular Users
 
         ```curl --location --request PUT 'http://localhost:8080/products/v1/retail/5f4e1b76ead6f06f6a348489/discounts' \
        --header 'Content-Type: application/json' \
        --data-raw '{
          "items": [
            {
              "itemName": "Potato",
              "quantity": 5,
              "type": "GROCERY",
              "price": 200
            }
          ]
        }'```
        
 #### Employed Users
 
           ```
           curl --location --request PUT 'http://localhost:8080/products/v1/retail/5f4e1b76ead6f06f6a348487/discounts' \
          --header 'Content-Type: application/json' \
          --data-raw '{
            "items": [
              {
                "itemName": "Potato",
                "quantity": 5,
                "type": "GROCERY",
                "price": 200
              },
              {
                "itemName": "Ipad Pro",
                "quantity": 1,
                "type": "HOME",
                "price": 3500
              },
              {
                "itemName": "Tomatoes",
                "quantity": 4,
                "type": "GROCERY",
                "price": 150
              },
              {
                "itemName": "Bose Headphones",
                "quantity": 2,
                "type": "HOME",
                "price": 1200.23
              }
            ]
          }'```
          
 #### Affiliated Users
 
        ```
        curl --location --request PUT 'http://localhost:8080/products/v1/retail/5f4e1b76ead6f06f6a348459/discounts' \
        --header 'Content-Type: application/json' \
        --data-raw '{
          "items": [
            {
              "itemName": "Potato",
              "quantity": 5,
              "type": "GROCERY",
              "price": 200
            },
            {
              "itemName": "Ipad Pro",
              "quantity": 1,
              "type": "HOME",
              "price": 3500
            },
            {
              "itemName": "Tomatoes",
              "quantity": 4,
              "type": "GROCERY",
              "price": 150
            },
            {
              "itemName": "Bose Headphones",
              "quantity": 2,
              "type": "HOME",
              "price": 1200.23
            }
          ]
        }'```
        
 ### Clone your repository to your local machine
 1) Clone RetailStoreDiscouns repository from GitHub to your local computer. From this repository page on GitHub, click the green button labeled Clone or download, and in the “Clone with HTTPs” section, copy the URL for your repository.
 
 2) create a directory in your local machine
            ```
            cd Documents
            ```
 3) git clone https://github.com/sunilnjc/RetailStoreDiscouns.git  
 
 4) cd RetailStoreDiscouns
 
 5) mvn clean install (Maven should be installed in the system and should be configured in the path variable)
 
 ### Code Coverage
 
 1) After successfull build go to cd RetailStoreDiscouns/target/site/jacoco
 
 2) Open index.html file to view the code coverage

 
 
 
 
 
