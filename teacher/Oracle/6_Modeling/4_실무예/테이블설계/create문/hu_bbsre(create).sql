create table hu_bbsre(
	idx number constraint hu_bbsre_pk_idx primary key,
	bidx number constraint hu_bbsre_nn_bidx not null,
	lid varchar2(15) constraint hu_bbsre_nn_lid not null,
	content varchar2(1000) constraint hu_bbsre_nn_content not null,
	idate date
	,constraint hu_bbsre_lid_fk foreign key(lid) references hu_member(lid) on delete cascade
	,constraint hu_bbsre_bidx_fk foreign key(bidx) references hu_bbs(idx) on delete cascade
);

create SEQUENCE hubbsre_seq start with 1 increment by 1 nocache;
