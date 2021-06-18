create table hu_myhome(
	idx number constraint hu_myhome_pk_idx primary key,
	lid varchar2(15) constraint hu_myhome_nn_lid not null,
	hname varchar2(100) constraint hu_myhome_nn_hname not null,
	hmsg varchar2(2000),
	haddr varchar2(50),
	totcount number default 0 constraint hu_myhome_nn_totcount not null,
	scrapcount number default 0 constraint hu_myhome_nn_scrapcount not null,
	giftcount number default 0 constraint hu_myhome_nn_giftcount not null,
	ofilename varchar2(100),
	filename varchar2(100),
	keyword1 varchar2(30),
	keyword2 varchar2(30),
	keyword3 varchar2(30),
	udate date,
	idate date
	,constraint hu_myhome_lid_fk foreign key(lid) references hu_member(lid) on delete cascade
);

create SEQUENCE humyhome_seq start with 1 increment by 1 nocache;
