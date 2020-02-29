Create Database infodb;
use infodb;

Create table _order (
id int primary key NOT NULL AUTO_INCREMENT,
 fullNameOfCustomer varchar(40) not null,
 customerEmail varchar(100) not null,
 dateOfCreateOrder date not null,
 dateOfExpectedConfirmOrder date not null,
 totalNumberOfItems int not null,
 sumOfOrder int not null,
 orderStatus varchar(15) not null);
 
 Create table emailform(
 sendToEmail varchar(100) primary key not null,
 topic varchar(50),
letterTemplait varchar(500),
_text varchar(800));

Create table item(
itemid int primary key AUTO_INCREMENT not null,
itemName varchar(30) not null,
color varchar(15),
note varchar(200),
photolink varchar(200),
totalNumberOfItems int not null,
price int not null,
yearOfIssueFirst date,
yearOfIssueSecond date,
itemInfo varchar(200),
productQuality varchar(7) not null);

Create table photo(
photoId int primary key not null,
nameOfFile varchar(200) not null,
dateOfUpload date not null,
note varchar(200));



