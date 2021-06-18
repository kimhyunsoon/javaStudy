create table hu_paper(
	idx number constraint hu_paper_pk_idx primary key,
	sendid varchar2(15) constraint hu_paper_nn_sendid not null,
	receiveid varchar2(15) constraint hu_paper_nn_receiveid not null,
	sendmsg varchar2(4000) constraint hu_paper_nn_sendmsg not null,
	isreceive number default 0,
	plive number default 0,
	senddate date,
	receivedate date
	,constraint hu_paper_sendid_fk foreign key(sendid) references hu_member(lid) on delete cascade
	,constraint hu_paper_receiveid_fk foreign key(receiveid) references hu_member(lid) on delete cascade
);

create SEQUENCE hupaper_seq start with 1 increment by 1 nocache;
