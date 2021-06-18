create table hu_guestbook(
	idx number constraint hu_guestbook_pk_idx primary key,
	melid varchar2(15) constraint hu_guestbook_nn_lid not null,
	youlid varchar2(15),
	num number constraint hu_guestbook_nn_num not null,
	name varchar2(30),
	pwd varchar2(30),
	content varchar2(4000) constraint hu_guestbook_nn_content not null,
	host varchar2(15),
	secret varchar2(1) default 'n' constraint hu_guestbook_nn_secret not null,
	udate date,
	idate date
	,constraint hu_guestbook_melid_fk foreign key(melid) references hu_member(lid) on delete cascade 
	,constraint hu_guestbook_youlid_fk foreign key(youlid) references hu_member(lid) on delete cascade 
);

create SEQUENCE huguestbook_seq start with 1 increment by 1 nocache;
