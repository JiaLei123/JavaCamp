DROP TABLE IF EXISTS 'user'

CREATE TABLE 'user'(
    'id' int(11) NOT NULL auto_increment,
    'username' varchar(32) NOT NULL  COMMENT '用户名称',
    'birthday' datetime default NULL COMMENT '生日',
    'sex' char(1) default NULL COMMENT '性别',
    'address' varchar(256) default NULL COMMENT '地址',
    PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARACTER=utf8

insert into 'user'('id', 'username', 'birthday', 'sex', 'address')
values (41, '老王', '2018-02-27 17:47:09', '男', '北京'), (41, '老王', '2018-02-27 17:47:09', '男', '北京'),41, '老王', '2018-02-27 17:47:09', '男', '北京'