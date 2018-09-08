DROP TABLE APP.books;
CREATE TABLE APP.books(
   id INT,
   title VARCHAR(50),
   author VARCHAR(50),
   price FLOAT,
   qty INT,
   PRIMARY KEY(id));
 
INSERT INTO APP.books VALUES (1001, 'Java for dummies', 'Tan Ah Teck', 11.11, 11);
INSERT INTO APP.books VALUES (1002, 'More Java for dummies', 'Tan Ah Teck', 22.22, 22);
INSERT INTO APP.books VALUES (1003, 'More Java for more dummies', 'Mohammad Ali', 33.33, 33);
INSERT INTO APP.books VALUES (1004, 'A Cup of Java', 'Kumar', 44.44, 44);
INSERT INTO APP.books VALUES (1005, 'A Teaspoon of Java', 'Kevin Jones', 55.55, 55);

DROP TABLE APP.customer;
CREATE TABLE APP.customer(
   id INT,
   name VARCHAR(50),
   email VARCHAR(100),
   address VARCHAR(200),
   PRIMARY KEY(id));
 
INSERT INTO APP.customer VALUES (001, 'Jones', 'jones@gmail.com','Office 9, IAS, Princeton, USA');
INSERT INTO APP.customer VALUES (002, 'Dana', 'dana@gmail.com','Office 6, IAS, Princeton, USA');
INSERT INTO APP.customer VALUES (003, 'Alex', 'alex@gmail.com', 'Office 9, IAS, Princeton, USA');
INSERT INTO APP.customer VALUES (004, 'Adam', 'adam@gmail.com', 'SOME WHERE');
INSERT INTO APP.customer VALUES (005, 'David', 'david@gmail.com', 'SOME WHERE');



DROP TABLE APP.times;
CREATE TABLE APP.times(
   id INT,
   startTime VARCHAR(50),
   finishTime VARCHAR(50),
   date VARCHAR(50),
   PRIMARY KEY(id));
 
INSERT INTO APP.times VALUES (001, '09:23', '17:30','11/11/2011');
INSERT INTO APP.times VALUES (002, '09:24', '17:31','12/11/2011');
INSERT INTO APP.times VALUES (003, '09:25', '17:32','13/11/2011');
INSERT INTO APP.times VALUES (004, '09:26', '17:33','14/11/2011');
INSERT INTO APP.times VALUES (005, '09:27', '17:34','15/11/2011');
