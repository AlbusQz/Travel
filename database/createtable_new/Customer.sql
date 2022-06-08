create table Customer (
	ID        number(10) constraint nn_customer_id not null,
	name      varchar(20) constraint nn_customer_name not null,
	password  varchar(20) constraint nn_customer_password not null, 
	ctime     date,
	tel       number(11),
	email     varchar(32),
	person_ID number(18) constraint nn_customer_personID not null,    
	constraint pk_customer_id primary key(ID),
	constraint fk_customer_personID foreign key(person_ID) References Person (ID)
	);
comment on table Customer is '用户表';
comment on column Customer.ID is '用户ID';
comment on column Customer.name is '用户昵称';
comment on column Customer.password is '用户密码';
comment on column Customer.ctime is '用户创建时间';
comment on column Customer.tel is '用户手机号';
comment on column Customer.email is '用户邮箱';
comment on column Customer.person_ID is '用户身份证号';
