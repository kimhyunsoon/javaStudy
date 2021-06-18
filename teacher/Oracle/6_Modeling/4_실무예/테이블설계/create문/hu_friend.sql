create table hu_friend(
	idx number constraint hu_friend_pk_idx primary key,
	melid varchar2(15) constraint hu_friend_nn_melid not null,
	mename varchar2(50) constraint hu_friend_nn_mename not null,
	youlid varchar2(15) constraint hu_friend_nn_youlid not null,
	youname varchar2(50) constraint hu_friend_nn_youname not null,
	gidx number constraint hu_friend_nn_gidx not null,
	fmsg varchar2(1000),
	fdiv number default 0 constraint hu_friend_nn_fdiv not null,
	udate date,
	idate date
	,constraint hu_friend_melid_fk foreign key(melid) references hu_member(lid) on delete cascade 
	,constraint hu_friend_youlid_fk foreign key(youlid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hufriend_seq start with 1 increment by 1 nocache;
