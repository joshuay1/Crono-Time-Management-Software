--
--
--
DROP TABLE APP.pay;
DROP TABLE APP.times;
DROP TABLE APP.employees;
DROP TABLE APP.keys;
--
CREATE TABLE APP.employees(
   userID INT,
   firstName VARCHAR(50),
   lastNAme VARCHAR(50),
   email VARCHAR(100),
   username VARCHAR(50) UNIQUE,
   password VARCHAR(50),
   PRIMARY KEY(userID));
 
INSERT INTO APP.employees VALUES (006, 'Callum', 'Vidler','email@example.com','admin', 'password1');
INSERT INTO APP.employees VALUES (000, 'Joshua', 'Yang','email2@example.com','admin2', 'password2');
INSERT INTO APP.employees VALUES (001, 'Jack', 'Ho','email3@example.com','user1', 'password3');
INSERT INTO APP.employees VALUES (002, 'Dana', 'Bill','email4@example.com','user2', 'password4');
INSERT INTO APP.employees VALUES (003, 'Alex', 'Blob','email5@example.com','user3', 'password5');
INSERT INTO APP.employees VALUES (004, 'Adam', 'Go','email6@example.com','user4', 'password6');
INSERT INTO APP.employees VALUES (005, 'David', 'Run','email7@example.com','user5', 'password7');
--
--
--
--
CREATE TABLE APP.times(
   userID INT,
   timeID INT,
   startTime VARCHAR(50),
   finishTime VARCHAR(50),
   date VARCHAR(50),
   FOREIGN KEY(userID) REFERENCES APP.employees(userID),
   PRIMARY KEY(timeID));
 
INSERT INTO APP.times VALUES (001,01, '09:23', '17:30','11/11/2011');
INSERT INTO APP.times VALUES (002,02, '09:24', '17:31','12/11/2011');
INSERT INTO APP.times VALUES (003,03, '09:25', '17:32','13/11/2011');
INSERT INTO APP.times VALUES (004,4, '09:26', '17:33','14/11/2011');
INSERT INTO APP.times VALUES (005,5, '09:27', '17:34','15/11/2011');
--
--
--
--
CREATE TABLE APP.keys(
   location INT,
   usersID INT,
   timeID INT);
-- 
INSERT INTO APP.keys VALUES (2,7,68 );
--

CREATE TABLE APP.pay(
	userID INT,
	payAmount FLOAT,
	FOREIGN KEY(userID) REFERENCES APP.employees(userID));
	
INSERT INTO APP.pay VALUES(1, 25.5);
INSERT INTO APP.pay VALUES(2, 25.5);
INSERT INTO APP.pay VALUES(3, 25.5);
INSERT INTO APP.pay VALUES(4, 25.5);
INSERT INTO APP.pay VALUES(5, 25.5);
INSERT INTO APP.pay VALUES(6, 25.5);
