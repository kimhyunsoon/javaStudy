create table hu_gift(
	idx number constraint hu_gift_pk primary key,
	sendid varchar2(15) constraint hu_gift_nn_sendid not null,
	receiveid varchar2(15) constraint hu_gift_nn_receiveid not null,
	sidx number constraint hu_gift_nn_sidx  not null,
	sendmsg varchar2(200),
	receivemsg varchar2(200),
	senddate date,
	receivedate date,
	isreceive number default 0
	,constraint hu_gift_sendid_fk foreign key(sendid) references hu_member(lid) on delete cascade 
	,constraint hu_gift_receiveid_fk foreign key(receiveid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hugift_seq start with 1 increment by 1 nocache;