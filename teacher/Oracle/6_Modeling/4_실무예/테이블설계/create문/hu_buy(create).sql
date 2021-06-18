create table hu_buy(
	idx number constraint hu_buy_pk_idx primary key,
	lid varchar2(15) constraint hu_buy_nn_lid not null,
	sidx number constraint hu_buy_nn_sidx not null,
	idate date
	,constraint hu_buy_lid_fk foreign key(lid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hubuy_seq start with 1 increment by 1 nocache;
