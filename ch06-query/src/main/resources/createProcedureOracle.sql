# 创建表
CREATE TABLE country (
  id INT NOT NULL AUTO_INCREMENT,
  countryname VARCHAR(255) NULL ,
  countrycode VARCHAR(255) NULL ,
  PRIMARY KEY (id)
);

# 初始化表数据
INSERT country(countryname, countrycode) VALUES ('中国','CN'),('美国','US'),('俄罗斯','RU'),('英国','GB'),('法国','FR');

# 在Oracle中使用游标参数的存储过程
create or replace procedure SELECT_COUNTRIES(
  ref_cur1 out sys_refcursor,
  ref_cur2 out sys_refcursor) is
begin
  open ref_cur1 for select * from country where id < 3;
  open ref_cur2 for select * from country where id >= 3;
end SELECT_COUNTRIES;
