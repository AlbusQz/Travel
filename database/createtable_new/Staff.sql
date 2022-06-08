create table Staff (
	ID        number(10) constraint nn_staff_id not null,
	password        varchar(20) constraint nn_staff_password not null, 
	tel       number(11) constraint nn_staff_tel not null,
	person_ID        number(18) constraint nn_staff_personID not null,    
	constraint pk_staff_id primary key(ID),
	constraint fk_staff_personID foreign key(person_ID) References Person (ID)
	);
comment on table Staff is '员工表';
comment on column Staff.ID is '员工ID';
comment on column Staff.password is '员工密码';
comment on column Staff.tel is '员工手机号';
comment on column Staff.person_ID is '员工身份证号';