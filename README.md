**FizzBuzz**

**Assumptions**

1. The API has an endpoint - "/compute"
2. The API takes input as arrays. The RequestParameter name is "value" 
3. Incase of invalid query parameter(like "valuex"),the api ignores the invallid parameters and responds for only inputs with the parametr name as "value" 
4. For any input other than integers ,the api responds back with output as "Invaid item"
5. The response schema is in the format of a array inside JSON body.Incase of multiple response for a input, its handled as array.


**Automation Tools**

1. Java 1.8
2. Rest Library - RestAssured
3. Build Tool - Maven
4. Test Runner- JUnit
   


**Case#1**

Request - 
	localhost:8080/compute?value=1&value=3&value=5&value=&value=15&value=A&value=23

Response - 

	{
		"output":[
			{
				"1" : ["Divided 1 by 3", "Divided 1 by 5"]
			},
			{
				"3" : "Fizz"
			},
			{
				"5" : "Buzz"
			},
			{
				"" : "Invalid item"
			},
			{
				"15" : "FizzBuzz"
			},
			{
				"A" : "Invalid item"
			},
			{
				"23" : ["Divided 1 by 3", "Divided 1 by 5"]
			}
		]
	}
	
	
**Case#2**

Request - 
	localhost:8080/compute?value=1

Response - 
	{
		"output":[
			{
				"1" : ["Divided 1 by 3", "Divided 1 by 5"]
			}
		]
	}
	
**Case#3**

Request - 
	localhost:8080/compute?value=1&value=1

Response - 

	{
		"output":[
			{
				"1" : ["Divided 1 by 3", "Divided 1 by 5"]
			}.
			{
				"1" : ["Divided 1 by 3", "Divided 1 by 5"]
			}
		]
	}
	
**Case#4**
Request - 
	localhost:8080/compute?valuex=1&value=3

Note - Invalid request parameter as 'valuex', responds for valid parameter (value=3)
	
Response - 

	{
		"output":[
			{
				"3" : "Fizz"
			}
		]
	}
	
**Case#5**
Request - 
	localhost:8080/compute?valuex=1&valuex=3

Note - Invalid request parameter as 'valuex', responds with empty array
	
Response - 

	{
		"output":[
		]
	}
