create table hu_store(
	idx number constraint hu_store_pk_idx primary key,
	sname varchar2(30) constraint hu_store_nn_sname not null,
	scomment varchar2(200) constraint hu_store_nn_scomment not null,
	sdiv varchar2(1) constraint hu_store_nn_sdiv not null,
	ofilename varchar2(100) constraint hu_store_nn_ofilename not null,
	filename varchar2(100) constraint hu_store_nn_filename not null, 
	filesize number constraint hu_store_nn_filesize not null,
	sofilename varchar2(100),
	sfilename varchar2(100), 
	sfilesize number,
	lid varchar2(15) constraint hu_store_nn_lid not null,
	point number constraint hu_store_nn_point not null,
	period number default 7 constraint hu_store_nn_period not null,
	udate date,
	idate date
);

create SEQUENCE hustore_seq start with 1 increment by 1 nocache;