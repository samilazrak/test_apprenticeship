# TEST

The application offers two REST Services that allows you to register a user and to display one or all users

To be registered, the user must have a name, a country where he lives in and an age (Mandatory Fields).
The job field is optional.

Using the second WS, you can display a specific user given his ID, and display them.

# Run the app

To run the application, you must have a MongoDB Server running at your localhost:27017 at the same time.
After checking that, you can run the following commands :
- mvn clean package
- java -jar target/test-0.0.1-SNAPSHOT.jar

# Models

The User model is the only one implemented in this application :
It contains four fields : 
- name
- age
- country
- job (optional)

# Exceptions 

There are two types of Exceptions : 
- UserNotValidException : this exception is launched if you try to register 
a user that doesn't meet the conditions to register (To be at least 18 years old and to live in France)
- MissingMandatoryInformation : this exception is launched if you try to register
a user without all the informations required (missing name, age...)

Theses two exceptions returns to the client HTTP Status NOT_ACCEPTABLE (406).

# AOP

To check if the input received by the application doesn't contain errors, a aspect 
RegistrationChecker has been created : it checks if one of the two Exceptions must be launched and logs
the input.

The DisplayAspect class contain two @Before advices that log the input to display one or all users.

# Add a user

To add a user, the RegisterController must receive an HTTP Post request on 
http://localhost:8080/register/user with a JSON body containing the user's informations.

Example : {
          	"name": "Sami",
          	"age":22,
          	"country":"France"
          }

This user satisfies all the conditions to be registered, so the HTTP response is :
"You have been registered successfully"

# Display all users

To display all users, you must send an HTTP GET request on http://localhost:8080/display/user.
This request will be useful to find a user's ID.

# Display a specific user

To display a specific user, you must send an HTTP GET request on http://localhost:8080/display/user/{ID}, 
where ID is the id of the user. If the ID doesn't match a user's ID, an HTTP response is sent back :
"This ID doesn't refer any user" with HTTP Status BAD_REQUEST (400).


