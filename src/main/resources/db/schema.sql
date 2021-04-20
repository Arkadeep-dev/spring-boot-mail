create table if not exists employee  (
empId varchar(5) primary key not null ,
empName varchar(10) ,
empSalary decimal (8,2),
empProject varchar(10),
empDOJ TIMESTAMP,
empDOR TIMESTAMP
);
