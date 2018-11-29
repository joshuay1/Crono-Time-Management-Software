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

Architechtural Layers Description

Presentation Layer:
The layer delivers user’s request to the domain logic layer and receives the services provided by the domain logic layer. It is made up of a model view controller (MVC). The controller is made up of servlets that implement a page controller pattern. This mean that they hand request for a particular views and data modelling aspect. The Views are made up of JSP files that implement template view pattern and use a mix of dynamic data from the model and static html and makes get/post request to the controllers. Model layer is the domain layer logic that is access from both the views and controllers. 
Domain Logic Layer:
Domain model pattern is used in this layel to incorporates both behaviour and data . Each object created corresponds to an object in the business. 

Data Mapper Layer:
This layer of data mapper moves data between objects and database and keep domain logic layer and data source layer independent from each other.

Data Source Layer:
The data source layer communicates with the SQL database.


