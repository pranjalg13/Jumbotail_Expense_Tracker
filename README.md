# JumboTail_Assignment
## An Expense Tracker REST Api using Spring boot
Assignment Submission for Jumbotail

### Name: Pranjal Goyal
### Email: pranjalgoyal13@gmail.com


## Technology Used

- Spring Boot 
  - Spring Boot allows easy setup of standalone Spring-based applications with high scalability.
  
- Swagger-UI
  - It is a framework used to demonstrate the API in better format similar to Postman

- Database Used
    - Mysql

### Features
- I have tried to decouple as much as I can in the assignment.
- User can add register themselves using thier email Id
- User can add expense and due amount
- User can remove the debt amount by following algorithms:
  - Method 1: Removing the due which was added first 
  - Method 2: Removing the due based of repayment date
- Dividing the code into separate modules as applicable. (Modularity)

### How to Run

```
1. First of all clone the Repo:
git clone <Repo_URL>
2. Open with Fav, IDE
3. The Application is running on port 8080
-> Swagger-Url: localhost:8080/swagger-ui.html
```

### Endpoints for the application:
1. Creates a User (Only Email id is taken)
* Path : `/create_user`
* Input :
   ```
   {
	  "email":"pranjalgoyal13@example.com"
   }
   ```
* Sample Output :
   ```
    {
	    "success": true,
    }
	```

2.  Add a user Expense
* Path : `/add_user_expense`
* RequestParam: userEmail  
* Input :
  ```
  {
    "modeOfPayment": "string",
    "place": "string",
    "reasonForExpense": "string"
  }   
  ```
* Output :
  ```
  {
      "success": true,
  }
  ```

3.  Add the details of due_amount
* Path : `/add_due_amount_data`
* RequestParam: userEmail
* Input :
  ```
  {
    "amount": 0,
    "payDuePerson": "string",
    "repaymentDate": "string"
  }
  ```
* Output :
  ```
  {
      "success": true,
  }
  ```

4. Settle Due Amount  
* Path : `/pay_due_amount/{userEmail}/{method}`
* Param: Method--> Integer (Pass 0 to follow First in First out and 1 to Last Repayment Method)
* Input :
  ```
  {
    "amount": 0,
    "payDuePerson": "string",
    "repaymentDate": "string"
  }
  ```
* Output :
  ```
  {
      "success": true,
  }
  ```


5.  Returns list of all expenses by user
* Path : `/get_all_expense/{userEmail}`
* Input :
  ```
    UserEmail (Path Variable)
  ```
* Output :
  ```
  [
    {
      "expenseDate": "string",
      "id": 0,
      "modeOfPayment": "string",
      "place": "string",
      "reasonForExpense": "string",
      "userId": "string"
    }
  ]
  ```

5. Get all Due amount pending by user 
* Path : `/get_all_due_amount_of_user/{userEmail}`
* Input :
  ```
  { 
    userEmail (PathVariable)
  }
  ```
* Output :
  ```
  [
    {
      "amount": 0,
      "id": 0,
      "payDuePerson": "string",
      "repaymentDate": "string",
      "userId": "string"
    }
  ]
  ```

### Error and Exception
Due to time constraint only status code with Base Exception are added to the code along with log statements.