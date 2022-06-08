create table Person(
	ID      number(18) constraint pk_person_id primary key constraint nn_person_id not null,
	name      varchar(20) constraint nn_person_name not null,
	sex      char(2) constraint nn_person_sex not null,
	bday      date ,
	address   varchar(20),
	nationality  varchar(20)
	);
comment on table Person is '人表';
comment on column Person.ID is '身份证号';
comment on column Person.name is '姓名';
comment on column Person.sex is '性别';
comment on column Person.bday is '出生日期';
comment on column Person.address is '住址';
comment on column Person.nationality is '民族';