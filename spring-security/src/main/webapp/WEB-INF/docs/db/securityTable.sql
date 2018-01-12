--drop table users;
CREATE TABLE users (
  userid VARCHAR2(50) NOT NULL ,
  password VARCHAR2(50) NOT NULL,
  constraint pk_users primary key (userid) );
  
CREATE TABLE user_roles (
  userid varchar(50) NOT NULL,
  role varchar(50) NOT NULL,
  constraint pk_user_roles PRIMARY KEY (userid, role),
  constraint fk_user_roles_to_user FOREIGN KEY (userid) REFERENCES users (userid) );
  
  
 insert into users (userid, password) values('brown', '1234');
 insert into users (userid, password) values('cony', '1234');
 insert into users (userid, password) values('sally', '1234');
 insert into users (userid, password) values('james', '1234');
 insert into users (userid, password) values('moon', '1234');  
 
insert into user_roles (userid, role) values ('brown', 'ROLE_USER');
insert into user_roles (userid, role) values ('brown', 'ROLE_ADMIN');
insert into user_roles (userid, role) values ('cony', 'ROLE_USER');
insert into user_roles (userid, role) values ('sally', 'ROLE_USER');
insert into user_roles (userid, role) values ('james', 'ROLE_USER');
insert into user_roles (userid, role) values ('moon', 'ROLE_USER');