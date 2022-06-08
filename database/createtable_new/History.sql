drop table History;
create table History(
	ID number(10)constraint nn_history_id not null,
	c_ID number(10) constraint nn_history_cid not null,
	type varchar2(20),
	p_id number(10),
	ctime date,
	price number,
	state varchar2(20),
	intro clob,
	constraint pk_history_id primary key(ID),
	constraint fk_history_cid foreign key(c_ID) References Customer (ID)
	);
comment on table History is '订单表';
comment on column History.c_ID is '订单顾客ID';
comment on column History.type is '订单物品种类';
comment on column History.p_ID is '订单物品ID';
comment on column History.ctime is '订单创建时间';
comment on column History.price is '订单价格';
comment on column History.state is '订单状态';
comment on column History.intro is '订单详情';