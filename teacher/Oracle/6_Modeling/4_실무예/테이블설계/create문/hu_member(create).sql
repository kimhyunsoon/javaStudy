
create table hu_member(
	idx number constraint hu_member_nn_idx not null,
	lid varchar2(15) constraint hu_member_pk_lid primary key,
	pwd varchar2(15) constraint hu_member_nn_pwd not null,
  name varchar2(15) constraint hu_member_nn_name not null,
	nickname varchar2(20) constraint hu_member_nn_nickname not null,
	birth varchar2(8) constraint hu_member_nn_birth not null,
	addr1 varchar2(6) constraint hu_member_nn_addr1 not null,
	addr2 varchar2(50) constraint hu_member_nn_addr2 not null,
	addr3 varchar2(50) constraint hu_member_nn_addr3 not null,
	email varchar2(50),
	homepage varchar2(50),
  pwd_search varchar2(1) constraint hu_member_nn_pwd_search not null, 
	pwd_searchok varchar2(40) constraint hu_member_nn_pwd_searchok not null,
	authority number default 9 constraint hu_member_nn_authority not null, 
	mlive number default 0 constraint hu_member_nn_mlive not null, 
	visit_count number default 0 constraint hu_member_nn_visit_count not null,
	point number default 100,
	logdate date,
	udate date,
	idate date,
	constraint hu_member_uk_nickname unique(nickname)
);

create SEQUENCE humember_seq start with 1 increment by 1 nocache;
