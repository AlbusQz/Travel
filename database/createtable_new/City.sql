create table City (
	name      varchar(20) constraint nn_city_name not null constraint pk_city_name primary key
	);
comment on table City is '城市表';
comment on column City.name is '城市名';