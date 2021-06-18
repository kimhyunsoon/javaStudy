create table hu_bbs(
	idx number constraint hu_bbs_pk_idx primary key,
	melid varchar2(15) constraint hu_bbs_nn_lid not null,
	youlid varchar2(15),
	gidx number constraint hu_bbs_nn_gidx not null,
	glevel number default 9 constraint hu_bbs_nn_glevel not null,
	num number constraint hu_bbs_nn_num not null,
	name varchar2(30),
	pwd varchar2(30),
	subject varchar2(200) constraint hu_bbs_nn_subject not null,
	content varchar2(4000) constraint hu_bbs_nn_content not null,
	host varchar2(15),
	ofilename varchar2(100),
	filename varchar2(100),
	filesize number,
	refer number default 0 constraint hu_bbs_nn_refer not null,
	lev number default 0 constraint hu_bbs_nn_lev not null,
	sunbun number default 0 constraint hu_bbs_nn_sunbun not null,
	read_num number default 0,
	scrapcount number default 0,
	oriidx number,
	udate date,
	idate date
	,constraint hu_bbs_melid_fk foreign key(melid) references hu_member(lid) on delete cascade 
	,constraint hu_bbs_youlid_fk foreign key(youlid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hubbs_seq start with 1 increment by 1 nocache;
