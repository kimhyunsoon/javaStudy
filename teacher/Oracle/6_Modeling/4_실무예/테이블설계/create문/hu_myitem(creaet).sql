create table hu_myitem(
	idx number constraint hu_myitem_pk_idx primary key,
	lid varchar2(15) constraint hu_myitem_nn_lid not null,
	sidx number constraint hu_myitem_nn_sidx not null,
	zindex number,
	aleft number,
	atop number,
	msg varchar2(100),
	huse number default 9 constraint hu_myitem_nn_huse not null,
	usedate date,
	remaindate ,
	udate date,
	idate date
	,constraint hu_myitem_lid_fk foreign key(lid) references hu_member(lid) on delete cascade
);

create SEQUENCE humyitem_seq start with 1 increment by 1 nocache;
