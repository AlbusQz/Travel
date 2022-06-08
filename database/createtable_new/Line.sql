create table Line (
	ID varchar(10) constraint nn_line_id not null,
  t_city varchar(20) constraint nn_line_ta not null,
	t_time date constraint nn_line_ttime not null,
	r_city varchar(20),
	r_time date,
	name varchar(20) constraint nn_line_name not null,
	price number ,
	agency varchar(20),
	intro clob,
	constraint pk_line primary key(ID),
	constraint fk_line_tcity foreign key(t_city) References city (name),
	constraint fk_line_rcity foreign key(r_city) References city (name)
	);
comment on table line is '路线表';
comment on column Line.ID is '路线ID';
comment on column Line.t_time is '路线出发时间';
comment on column Line.t_city is '路线出发城市';
comment on column Line.r_time is '路线到达时间';
comment on column Line.r_city is '路线到达城市';
comment on column Line.name is '路线名称';
comment on column Line.agency is '路线旅游社';
comment on column Line.price is '路线价格';
comment on column Line.intro is '路线简介';