--
--
--
DROP TABLE IF EXISTS APP.pay;
DROP TABLE IF EXISTS APP.times;
DROP TABLE IF EXISTS APP.employees;
DROP TABLE IF EXISTS APP.users;
DROP TABLE IF EXISTS APP.keys;
DROP TABLE IF EXISTS APP.roles_permission;
DROP SCHEMA APP;
CREATE SCHEMA APP;
--
CREATE TABLE APP.users(
   userID INT,
   firstName VARCHAR(50),
   lastName VARCHAR(50),
   email VARCHAR(100),
   username VARCHAR(50) UNIQUE,
   password VARCHAR(50),
   role VARCHAR(50),
   version INT,
   PRIMARY KEY (userID));
 
INSERT INTO APP.users VALUES (000, 'Callum', 'Vidler','email@example.com','admin', 'password1','Admin',0);
INSERT INTO APP.users VALUES (001, 'Joshua', 'Yang','email2@example.com','admin2', 'password2','Admin',0);
INSERT INTO APP.users VALUES (002, 'Jack', 'Ho','email3@example.com','user1', 'password3','Employee',1);
INSERT INTO APP.users VALUES (003, 'Dana', 'Bill','email4@example.com','user2', 'password4','Employee',1);
INSERT INTO APP.users VALUES (004, 'Alex', 'Blob','email5@example.com','user3', 'password5','Employee',1);
INSERT INTO APP.users VALUES (005, 'Adam', 'Go','email6@example.com','user4', 'password6','Employee',1);
INSERT INTO APP.users VALUES (006, 'David', 'Run','email7@example.com','user5', 'password7','Employee',1);

CREATE TABLE APP.roles_permission(
	PermID INT,
	role VARCHAR(50),
	permission VARCHAR(50),
	PRIMARY KEY (PermID));
	
INSERT INTO APP.roles_permission VALUES (1, 'Admin', 'admin:edit_time');
INSERT INTO APP.roles_permission VALUES (2, 'Admin', 'admin:login');
INSERT INTO APP.roles_permission VALUES (3, 'Admin', 'admin:create_user');
INSERT INTO APP.roles_permission VALUES (4, 'Admin', 'admin:edit_user');
INSERT INTO APP.roles_permission VALUES (5, 'Admin', 'admin:view_time');
INSERT INTO APP.roles_permission VALUES (6, 'Admin', 'admin:pay');
INSERT INTO APP.roles_permission VALUES (7, 'Employee', 'employee:add_time');
INSERT INTO APP.roles_permission VALUES (8, 'Employee', 'employee:view_time');
INSERT INTO APP.roles_permission VALUES (9, 'Employee', 'employee:edit_profile');

CREATE TABLE APP.times(
   userID INT,
   timeID INT,
   startTime VARCHAR(50),
   finishTime VARCHAR(50),
   date VARCHAR(50),
   paid INT,
   version INT,
   FOREIGN KEY (userID) REFERENCES APP.users(userID) ON DELETE CASCADE,
   PRIMARY KEY (timeID));
 
INSERT INTO APP.times VALUES (001,1, '09:23', '17:30','11/11/2011',0,0);
INSERT INTO APP.times VALUES (002,2, '09:24', '17:31','12/11/2011',0,0);
INSERT INTO APP.times VALUES (003,3, '09:25', '17:32','13/11/2011',0,0);
INSERT INTO APP.times VALUES (004,4, '09:26', '17:33','14/11/2011',0,0);
INSERT INTO APP.times VALUES (005,5, '09:27', '17:34','15/11/2011',0,0);
--
--
--
--
CREATE TABLE APP.keys(
   location INT,
   userID INT,
   timeID INT);
-- 
INSERT INTO APP.keys VALUES (2,7,68 );
--

CREATE TABLE APP.pay(
	userID INT,
	payAmount FLOAT,
	version INT,
	FOREIGN KEY (userID) REFERENCES APP.users(userID) ON DELETE CASCADE);
	
INSERT INTO APP.pay VALUES(1, 25.5,0);
INSERT INTO APP.pay VALUES(2, 25.5,0);
INSERT INTO APP.pay VALUES(3, 25.5,0);
INSERT INTO APP.pay VALUES(4, 25.5,0);
INSERT INTO APP.pay VALUES(5, 25.5,0);
INSERT INTO APP.pay VALUES(6, 25.5,0);

