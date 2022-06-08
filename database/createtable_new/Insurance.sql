create table Insurance (
	ID varchar(10) constraint nn_insurance_id not null,
	name varchar(20) constraint nn_insurance_name not null,
	price number ,
	agency varchar2(20),
	period number,
	intro clob,
	constraint pk_insurance  primary key(ID)
	);
comment on table Insurance is '保险表';
comment on column Insurance.ID is '保险ID';
comment on column Insurance.period is '保险保期（单位未定）';
comment on column Insurance.name is '保险名称';
comment on column Insurance.agency is '保险公司';
comment on column Insurance.price is '保险价格';
comment on column Insurance.intro is '保险简介';