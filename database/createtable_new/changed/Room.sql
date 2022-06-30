drop table Room;
create table Room (
	id number(10) constraint nn_room_id not null,
	type varchar(20) constraint nn_room_type not null,
	H_id number(10) constraint nn_room_hid not null,
	capacity number,
	price number,
	constraint pk_room_name primary key(id),
	constraint fk_room_hid foreign key(H_id) References Hotel(ID)
	);
comment on table Room is '房间表';
comment on column Room.ID is '房间ID';
comment on column Room.type is '房间类型';
comment on column Room.H_id is '房间所属酒店ID';
comment on column Room.capacity is '房间容量';
comment on column Room.price is '房间价格';