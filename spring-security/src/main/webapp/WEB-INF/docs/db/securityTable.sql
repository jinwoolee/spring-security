create table roles (
	role varchar2(50) not null primary key,
	role_name varchar2(50)
);

comment on table roles is '권한';
comment on column roles.role is '권한';
comment on column roles.role_name is '권한명'; 

insert into roles (role, role_name) values ('ROLE_ADMIN', 'ADMIN');
insert into roles (role, role_name) values ('ROLE_USER', 'USER');

create table roles_hierarchy (
	parent_role varchar2(50) not null,
	child_role varchar2(50) not null,
	primary key(parent_role, child_role),
	foreign key(parent_role) references roles(role),
	foreign key(child_role) references roles(role)
);

comment on table roles_hierarchy is '권한 계층구조';
comment on column roles_hierarchy.parent_role is '상위권한';
comment on column roles_hierarchy.child_role is '하위권한';

insert into roles_hierarchy (parent_role, child_role) values ('ROLE_USER', 'ROLE_ADMIN');

CREATE TABLE users (
  username VARCHAR2(50) NOT NULL ,
  password VARCHAR2(50) NOT NULL,
  constraint pk_users primary key (userid)
);

comment on table users is '사용자';
comment on column users.username is '아이디';
comment on column users.password is '비밀번호';

insert into users (userid, password) values('brown', '1234');
insert into users (userid, password) values('cony', '1234');
insert into users (userid, password) values('sally', '1234');
insert into users (userid, password) values('james', '1234');
insert into users (userid, password) values('moon', '1234');

CREATE TABLE USER_ROLES(
	USERNAME VARCHAR2(50) NOT NULL, 
	ROLE VARCHAR2(50) NOT NULL, 
	CONSTRAINT PK_USER_ROLES PRIMARY KEY (USERNAME, ROLE),
	CONSTRAINT FK_USER_ROLES_TO_USER FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME) ENABLE
);

comment on table user_roles is '사용자 권한';
comment on column user_roles.USERNAME is '상용자 아이디';
comment on column user_roles.ROLE is '보유 권한';
  
insert into user_roles (userid, role) values ('brown', 'ROLE_USER');
insert into user_roles (userid, role) values ('brown', 'ROLE_ADMIN');
insert into user_roles (userid, role) values ('cony', 'ROLE_USER');
insert into user_roles (userid, role) values ('sally', 'ROLE_USER');
insert into user_roles (userid, role) values ('james', 'ROLE_USER');
insert into user_roles (userid, role) values ('moon', 'ROLE_USER');  
 

create table secured_resources (
	resource_id varchar2(10) not null,
	resource_name varchar2(50),
	resource_pattern varchar2(100) not null,
	resource_type varchar2(10),
	sort_order number,
	constraint pk_secured_resources primary key (resource_id)
);

comment on table secured_resources is '보안대상리소스';
comment on column secured_resources.resource_id is '리소스 아이디';
comment on column secured_resources.resource_name is '리소스 명';
comment on column secured_resources.resource_pattern is '리소스 패턴';
comment on column secured_resources.resource_type is '리소스 타입';
comment on column secured_resources.sort_order is '리소스 적용 우선순위';


insert into secured_resources (resource_id, resource_name, resource_pattern, resource_type, sort_order) values('R0001', 'admin', '/admin**', 'url', 1);
insert into secured_resources (resource_id, resource_name, resource_pattern, resource_type, sort_order) values('R0002', 'welcome', '/welcome**', 'url', 2);

		
create table secured_resources_role (
	resource_id varchar2(10) not null,
	role varchar2(50) not null,
	primary key(resource_id, role)
);

comment on table secured_resources_role is '보안대상리소스 권한 매핑';
comment on column secured_resources.resource_id is '리소스 아이디';
comment on column secured_resources.role is '권한';



insert into secured_resources_role (resource_id, role) values ('R0001', 'ROLE_ADMIN');
insert into secured_resources_role (resource_id, role) values ('R0002', 'ROLE_USER');
insert into secured_resources_role (resource_id, role) values ('R0002', 'ROLE_ADMIN');