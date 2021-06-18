create table hu_today(
	idx number constraint hu_today_pk_idx primary key,
	lid varchar2(15) constraint hu_today_nn_lid not null,
	daycount number default 0 constraint hu_today_nn_daycount not null,
	idate date
	,constraint hu_today_lid_fk foreign key(lid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hutoday_seq start with 1 increment by 1 nocache;