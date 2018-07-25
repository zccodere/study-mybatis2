
# 创建用户表
CREATE TABLE sys_user (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  user_name VARCHAR(50) COMMENT '用户名',
  user_password VARCHAR(50) COMMENT '密码',
  user_email VARCHAR(50) COMMENT '邮箱',
  user_info TEXT COMMENT '简介',
  head_img BLOB COMMENT '头像',
  create_time DATETIME COMMENT '创建时间',
  PRIMARY KEY (id)
);
ALTER TABLE sys_user COMMENT '用户表';

# 创建角色表
CREATE TABLE sys_role (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  role_name VARCHAR(50) COMMENT '角色名',
  enabled INT COMMENT '有效标志',
  create_by BIGINT COMMENT '创建人',
  create_time DATETIME COMMENT '创建时间',
  PRIMARY KEY (id)
);
ALTER TABLE sys_role COMMENT '角色表';

# 创建权限表
CREATE TABLE sys_privilege (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  privilege_name VARCHAR(50) COMMENT '权限名称',
  privilege_url VARCHAR(256) COMMENT '权限URL',
  PRIMARY KEY (id)
);
ALTER TABLE sys_privilege COMMENT '权限表';

# 创建用户角色关系表
CREATE TABLE sys_user_role (
  user_id BIGINT COMMENT '用户ID',
  role_id BIGINT COMMENT '角色ID'
);
ALTER TABLE sys_user_role COMMENT '用户角色关系表';

# 创建角色权限关系表
CREATE TABLE sys_role_privilege (
  role_id BIGINT COMMENT '角色ID',
  privilege_id BIGINT COMMENT '权限ID'
);
ALTER TABLE sys_role_privilege COMMENT '角色权限关系表';

# 初始化表数据
INSERT INTO `sys_user`(`id`, `user_name`, `user_password`, `user_email`, `user_info`, `head_img`, `create_time`) VALUES (1, 'admin', '123456', 'admin@zccoder.com', '管理员', NULL, '2018-05-29 13:38:07');
INSERT INTO `sys_user`(`id`, `user_name`, `user_password`, `user_email`, `user_info`, `head_img`, `create_time`) VALUES (1001, 'test', '123456', 'test@zccoder.com', '测试用户', NULL, '2018-05-29 13:38:35');

INSERT INTO `sys_role`(`id`, `role_name`, `enabled`, `create_by`, `create_time`) VALUES (1, '管理员', 1, 1, '2018-05-29 13:39:41');
INSERT INTO `sys_role`(`id`, `role_name`, `enabled`, `create_by`, `create_time`) VALUES (2, '普通用户', 1, 1, '2018-05-29 13:39:53');

INSERT INTO `sys_user_role`(`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `sys_user_role`(`user_id`, `role_id`) VALUES (1, 2);
INSERT INTO `sys_user_role`(`user_id`, `role_id`) VALUES (1001, 2);

INSERT INTO `sys_privilege`(`id`, `privilege_name`, `privilege_url`) VALUES (1, '用户管理', '/users');
INSERT INTO `sys_privilege`(`id`, `privilege_name`, `privilege_url`) VALUES (2, '角色管理', '/roles');
INSERT INTO `sys_privilege`(`id`, `privilege_name`, `privilege_url`) VALUES (3, '系统日志', '/logs');
INSERT INTO `sys_privilege`(`id`, `privilege_name`, `privilege_url`) VALUES (4, '人员维护', '/persons');
INSERT INTO `sys_privilege`(`id`, `privilege_name`, `privilege_url`) VALUES (5, '单位维护', '/companies');

INSERT INTO `sys_role_privilege`(`role_id`, `privilege_id`) VALUES (1, 1);
INSERT INTO `sys_role_privilege`(`role_id`, `privilege_id`) VALUES (1, 2);
INSERT INTO `sys_role_privilege`(`role_id`, `privilege_id`) VALUES (1, 3);
INSERT INTO `sys_role_privilege`(`role_id`, `privilege_id`) VALUES (2, 4);
INSERT INTO `sys_role_privilege`(`role_id`, `privilege_id`) VALUES (2, 5);

