CRONÓ

Cronó is a time tracking enterprise system that can be used within an organization to help the administration to manage their human capitals. It aims to simplify and reduce the cost of managing the payment process and overseeing time management of staffs in an organisation. It also allows companies to manage freelancers and employees who work remotely at ease. This system should be able to effortlessly integrated into the established enterprise systems (ex. task management system) of an organization, due to its direct relation to its domain and its simplicity.

Cronó was designed for two featured user types, administration (admin) and employees that have different functionalities. The goal of admin users is to be able to manage employees. In order to accomplish this, they are able to add, remove and edit the profile, hours worked and payments of employees. Most importantly, admins should be able to pay outstanding wages of employees. The employee functionality should allow them to reliably and accurately convey their time to the their admin and able to track/view their work and payment history.

The system allows for this functionality by using a dynamic web service created using Java 2 Platforms, Enterprise Edition (J2PEE). It connects a PostGre database to store accounts details and work history. It is a project heavily focused on the backend and therefore has a very simple and minimal user interface.  

Heroku App Link:
https://cronoheroku.herokuapp.com/

--------------------------------------------

Testing as an admin:

username:admin2
password:password2

to log in as an Admin.

--------------------------------------------

Testing as an Employee

username:user1
password:password3

to log in as an Employee.

--------------------------------------------

Brief Architechtural Layers Description:

Presentation Layer:
The layer delivers user’s request to the domain logic layer and receives the services provided by the domain logic layer. It is made up of a model view controller (MVC). The controller is made up of servlets that implement a page controller pattern. This mean that they hand request for a particular views and data modelling aspect. The Views are made up of JSP files that implement template view pattern and use a mix of dynamic data from the model and static html and makes get/post request to the controllers. Model layer is the domain layer logic that is access from both the views and controllers. 

Domain Logic Layer:
Domain model pattern is used in this layel to incorporates both behaviour and data . Each object created corresponds to an object in the business. 

Data Mapper Layer:
This layer of data mapper moves data between objects and database and keep domain logic layer and data source layer independent from each other.

Data Source Layer:
The data source layer communicates with the SQL database.


Detailed Architecture:

Sessions Pattern:

The session pattern our project implements is a server side session. This means that the session state of all users is kept on the server/s of the system as objects, or in serialized form if there are memory issues. The sessions are maps session objects, to SessionID’s that the user gives to access their session.
 Our team initially used client side sessions, using the browser's built in session. The user input their username and gives their browse session, that then could be used to initiate a session if they a user. This however this lacked security and when implementing the security patterns our team decided to changed to a server side session with Apache Shiro.  A server side session is more secure, as we assume the user can access and tampter with everything on the client side. Using Shiro to session not only allows added security, but also when being initiated the user has to be authenticated with user login in and when access views, has to go through an session authorisation in the controller’s. The use can end their session by logging out.
We discounted using database due to the performance issue involved with calls to the database. Using a free PostgresQL database on heroku means these calls are expensive.

Input controller/View:

Page Controller and Template View Pattern:
We used Page Controller and and Template view patterns for our project. JSP where used as the Template view, creating static html and obtain dynamic data from the domain/data model. Servlets where used as page controllers, and acts as a the way to populate the data structures. The Model in our structure (MVC) was our domain layer. 
Template view allows us to render dynamic data in our static view by embedding markers in our html (Looping: <% ... %>, or displaying: <%=... %>). This was used in our project to loop through data structures like arrays storing Employee data, and Time data of users. Then display them in the by placing them in the static html.
Page Controller was implemented in the servlets to handle requests for a specific page, ensuring that the user/session has the correct authorisation to access the page. The user is redirected depending on the result of the users authorization access in the domain layer. We used in the particularly on login. User depending authorisation of access they have been allocated.
Implementing Page Controller pattern led to a lot of duplication of code. In each controller the user is authenticated and checked if they have permission to access to the specific page. The biggest concern occured when the controller had to handle multiple post requests from the view leading to a complex action of events, meaning the developer had to have an understanding of both the JSP and the servlet to be able to send these requests.

Front Controller Pattern:
Front Controller pattern suggest using a single controller pattern for the entire website. With the complexity of dividing our controllers up based on page already being quite complex, using a single controller would have been inefficient and very complex. This complexity would make it difficult for a developer to edit both the views or the controller. This negative outweighs the positives of implementing Front Controller pattern so our team discounded it as an option.

Two Set Views and Transform Views Patterns:
Two Set View and Transform View patterns where both discounted due to their implementation and design complexity. Page Controller and Template view achieve our goals, without being overly complex.


Concurrency Patterns:

Optimistic Offline Lock:
Our team used an Optimistic Offline Lock Pattern to manage concurrent access of the database. Opermermistic lock detects when there has been a conflicting access of the database and rolls back the transaction. 
We implemented this my adding versions to our domain objects correlating the the versions they are retrieved as from the database. If the Admin attempts to update a object, we first check the database to ensure that the version in the database is the same our current object. If the version are the same then the object is used to update the database. If the version are not the same then the user receives that another Admin has updated and they should refresh their view.
The reason our team chose to use Optimistic Lock pattern was due to its simplicity, the short period of time it takes to acquire the lock and that our domain logic do to most things being done has relatively low cost. 
We chose Optimistic lock over pessimistic lock, due to the low chance of conflict occurring between users, the cost of conflict being low and low business logic cost.
We also implemented implicit lock pattern. Implicit lock pattern allows the domain layer to access offline locks simply. Using both optimistic lock and Implicit lock pattern did not add to the design of our locks, and mergly appear to act as a bottleneck for every time a user wants to access a lock they have to go through LockingMapper. Implicit Lock pattern works better for Pessimistic lock as it moves the logic for acquiring and releasing lock out of the domain layer into the datasource layer, and achieves better distinction between the layers.


Distributed Patterns:

Data Transfer Object (DTO):
DTO is a fine grain object that allows distribute systems to reduce the number of remote method calls between the distributed system, which is very expensive. It compiles information from potentially multiple objects to reduce the number of calls required. The DTO is transferred between the systems, because of this it should return only basic data types to improve consistency between these system, and only contain the basic methods, such as getters and setters.
Our project contains two DTO for Time and Users. Our users DTO contains all the information of Admin/Employees and also a List of TimeDTO. Our program also contain assembers for both of TimeDTO and UserDTO that allow easy transfer of a serialised DTO and filling of the DTO.  

Remote Facade Pattern:
Remote Facade pattern extends the DTO pattern providing a coarse grained (complex) object over the top of a DTO fine grained object. The facade object exists only to translate coarse-grained method calls into the fine grained method call of the DTO. The Facade is to allow easy access to the DTO by distributed systems, allowing them call the Facade and be transfered a serialized DTO. 
Our project implements does not implement the remote facade or DTO. The Remote Facade access the assemblers to make the compiling as serializing of the DTO easier and reduces the complexity of it coarse grained method calls. 
The DTO and Remote Facade pattern biggest benefit is to reduce the method call between distributed systems. 


Security Patterns:

Authentication:
 Our project implements both authorisation and authentication patterns. Authentication pattern is a checking method to ensure that a user is the identity they present themselves as. We use one unique public key (username) and on private key (password) to ensure this. Shiro access and store usernames and passwords from/into the database. We use a an external library, Apache Shiro to ensure our user has proper protection of the personal data. This also takes over for our session pattern, as when we can authenticate who a user is, we can give them the previous session from the service layer. 

Authorisation:
Authorisation is checking that a user has access to the data they are trying to access or allowed to perform the action they are trying to perform. We  also use Apache Shiro to implement this pattern. Storing the permission and roles in our database, Shiro accesses these and allows us to check the users permissions at run time. We do this generally in the Controller's however some time we check in View.

Intercepting Validator Pattern:
The Intercepting Validator pattern was not implemented in our project, but should be to prevent SQL injection. The validator pattern cleanses and validates user input data prior to the domain and datasource layer have access to the data. This would protect our vulnerable system from SQL injection hacks but preventing things like SQL embedded commands. 

Secure Pipe Pattern:
Secure Pipe pattern is a way of ensuring the integrity and privacy of data sent over a network. We did not implement this pattern in our project. It uses cryptography to ensure that data encrypted over the network so it cannot be understood if intercepted or tampered with.







