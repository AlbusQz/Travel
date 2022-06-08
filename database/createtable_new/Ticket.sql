create table Ticket (
	ID varchar(10) constraint nn_ticket_id not null,
  t_city varchar(20) constraint nn_ticket_ta not null,
	t_time date constraint nn_ticket_ttime not null,
	r_city varchar(20),
	r_time date,
	type varchar(20) constraint nn_ticket_type not null,
	price number ,
	agency varchar(20),
	constraint pk_ticket primary key(ID),
	constraint fk_ticket_tcity foreign key(t_city) References city (name),
	constraint fk_ticket_rcity foreign key(r_city) References city (name)
	);
comment on table Ticket is '车票表';
comment on column Ticket.ID is '车票ID';
comment on column Ticket.t_time is '车票出发时间';
comment on column Ticket.t_city is '车票出发城市';
comment on column Ticket.r_time is '车票到达时间';
comment on column Ticket.r_city is '车票到达城市';
comment on column Ticket.type is '车票种类';
comment on column Ticket.agency is '车票公司';
comment on column Ticket.price is '车票价格';
