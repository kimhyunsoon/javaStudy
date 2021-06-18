create table hu_group(
	idx number constraint hu_group_pk_idx primary key,
	lid varchar2(15) constraint hu_group_nn_lid not null,
	gdiv varchar2(30) constraint hu_group_nn_gdiv not null,
	underline varchar2(1),
	gname varchar2(50) constraint hu_group_nn_gname not null,
	glevel number default 9,
	df varchar2(1) default 'n' constraint hu_group_nn_df not null,
	udate date,
	idate date
	,constraint hu_group_lid_fk foreign key(lid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hugroup_seq start with 1 increment by 1 nocache;
