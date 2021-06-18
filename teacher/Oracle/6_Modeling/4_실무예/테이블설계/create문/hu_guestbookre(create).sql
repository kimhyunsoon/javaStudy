create table hu_guestbookre(
	idx number constraint hu_guestbookre_pk_idx primary key,
	gidx number constraint hu_guestbookre_nn_gidx not null,
	lid varchar2(15) constraint hu_guestbookre_nn_lid not null,
	content varchar2(1000) constraint hu_guestbookre_nn_content not null,
	idate date
	,constraint hu_guestbookre_lid_fk foreign key(lid) references hu_member(lid) on delete cascade
	,constraint hu_guestbookre_gidx_fk foreign key(gidx) references hu_guestbook(idx) on delete cascade
);

create SEQUENCE huguestbookre_seq start with 1 increment by 1 nocache;
