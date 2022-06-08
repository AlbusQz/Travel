create table Tips (
	ID number(10) constraint nn_tips_id not null,
	c_ID number(10) constraint nn_tips_cid not null,
	ctime date,
	text clob,
	pic blob,
	constraint pk_tips_ID primary key(ID),
	constraint fk_tips_cid foreign key(c_ID) References CUSTOMER(ID)
	);
comment on table Tips is '攻略表';
comment on column Tips.ID is '攻略ID';
comment on column Tips.c_ID is '攻略发布用户ID';
comment on column Tips.ctime is '攻略发布时间';
comment on column Tips.text is '攻略文本';
comment on column Tips.pic is '攻略图片';