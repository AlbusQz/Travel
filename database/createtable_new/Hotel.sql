create table Hotel (
	ID number(10) constraint nn_hotel_id not null,
	name varchar(20) constraint nn_hotel_name not null,
	city varchar(20) constraint nn_hotel_city not null,
	tel number(20),
	intro clob,
	constraint pk_hotel_name primary key(ID),
	constraint fk_hotel_city foreign key(city) References City (name)
	);
comment on table Hotel is '酒店表';
comment on column Hotel.ID is '酒店ID';
comment on column Hotel.name is '酒店名';
comment on column Hotel.city is '酒店城市';
comment on column Hotel.tel is '酒店联系方式';
comment on column Hotel.intro is '酒店简介';