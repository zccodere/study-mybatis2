# 创建数据库
CREATE DATABASE mybatis2 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

# 创建表
CREATE TABLE country (
  id INT NOT NULL AUTO_INCREMENT,
  countryname VARCHAR(255) NULL ,
  countrycode VARCHAR(255) NULL ,
  PRIMARY KEY (id)
);

# 初始化表数据
INSERT country(countryname, countrycode) VALUES ('中国','CN'),('美国','US'),('俄罗斯','RU'),('英国','GB'),('法国','FR');
