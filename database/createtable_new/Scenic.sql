create table Scenic (
	name varchar(20) constraint nn_scenic_name not null,
	city varchar(20) constraint nn_scenic_city not null,
	capacity number,
	price number,
	stars number,
	Intro clob,
	constraint pk_scenic_name primary key(name,city),
	constraint fk_scenic_city foreign key(city) References City (name)
	);
comment on table Scenic is '景点表';
comment on column Scenic.name is '景点名';
comment on column Scenic.city is '景点城市';
comment on column Scenic.capacity is '景点容量';
comment on column Scenic.price is '景点价格';
comment on column Scenic.stars is '景点星级';
comment on column Scenic.Intro is '景点简介';