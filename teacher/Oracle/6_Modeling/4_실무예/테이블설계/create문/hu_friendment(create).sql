create table hu_friendment(
	idx number constraint hu_friendment_pk_idx primary key,
	melid varchar2(15) constraint hu_friendment_nn_melid not null,
	youlid varchar2(15) constraint hu_friendment_nn_youlid not null,
	msg varchar2(100) constraint hu_friendment_nn_msg not null,
	idate date
	,constraint hu_friendment_melid_fk foreign key(melid) references hu_member(lid) on delete cascade 
	,constraint hu_friendment_youlid_fk foreign key(youlid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hufriendment_seq start with 1 increment by 1 nocache;
