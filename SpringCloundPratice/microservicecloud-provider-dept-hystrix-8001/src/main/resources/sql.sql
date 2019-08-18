DROP DATABASE IF EXISTS cloudDB01;
CREATE DATABASE cloudDB01 CHARACTER SET UTF8;
USE cloudDB01;

CREATE TABLE dept(
    deptNo BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dName VARCHAR (60),
    dbSource VARCHAR (60)
);

INSERT INTO dept(dName, dbSource) VALUES ("开发部", DATABASE());
INSERT INTO dept(dName, dbSource) VALUES ("人事部", DATABASE());
INSERT INTO dept(dName, dbSource) VALUES ("财务部", DATABASE());
INSERT INTO dept(dName, dbSource) VALUES ("运维部", DATABASE());

SELECT * from dept;