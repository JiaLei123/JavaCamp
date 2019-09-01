-- DROP DATABASE IF EXISTS cloudDB01;
-- CREATE DATABASE cloudDB01 CHARACTER SET UTF8;
USE cloudDB01;


CREATE TABLE user(
    id int(11) NOT NULL auto_increment,
    username varchar(32) NOT NULL  COMMENT '用户名称',
    birthday datetime default NULL COMMENT '生日',
    sex char(1) default NULL COMMENT '性别',
    address varchar(256) default NULL COMMENT '地址',
    PRIMARY KEY (id)
) ;

insert into user(id, username, birthday, sex, address)
values
(41, '老王', '2018-02-27 17:47:09', '男', '北京'),
(42, '老王1', '2018-02-27 17:47:09', '男', '北京1'),
(43, '老王2', '2018-02-27 17:47:09', '男', '北京2'),
(44, '老王3', '2018-02-27 17:47:09', '男', '北京3');

select * from user