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

DROP table account;
CREATE TABLE account(
    ID int(11) NOT NULL auto_increment,
    UID int(11) NOT NULL  COMMENT '用户编号',
    MONEY double default NULL COMMENT '金额',
    PRIMARY KEY (ID),
    foreign key(UID) references user(id)
) ;

insert into account(ID, UID, MONEY)
values
(1, 41, 1000),
(2, 42, 1000),
(3, 41, 2000);

CREATE TABLE role(
    id int(11) NOT NULL auto_increment,
    role_name varchar(32) NOT NULL  COMMENT '角色名称',
    role_desc varchar(64) NOT NULL  COMMENT '角色描述',
    PRIMARY KEY (id)
);

insert into role(id, role_name, role_desc)
values
(1, "院长", "管理学院"),
(2, "总裁", "管理公司"),
(3, "校长", "管理学校");

CREATE TABLE user_role(
    uid int(11) NOT NULL,
    rid int(11) NOT NULL,
    foreign key(uid) references user(id),
    foreign key(rid) references role(id)
);

insert into user_role(uid, rid)
values
(41, 1),
(42, 1),
(41, 2);

