create table hu_find(
	idx number constraint hu_find_pk_idx primary key,
	name varchar2(500) constraint hu_find_nn_name not null,
	bytename varchar2(1000) constraint hu_find_nn_bytename not null,
	hcount number default 0 constraint hu_find_nn_hcount not null,
	idate date
);

create SEQUENCE hufind_seq start with 1 increment by 1 nocache;