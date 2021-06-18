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



create table hu_login
(lid varchar2(15) 
,pwd varchar2(15)
,constraint hu_login_lid_pk primary key(lid)
,constraint hu_login_lid_fk foreign key(lid) references hu_member(lid) on delete cascade 			   		  		 
);


create table hu_login_user
(lid varchar2(15) 
, logdate date
, logoutdate date
, islogin number
,constraint hu_login_user_lid_pk primary key(lid)
,constraint hu_login_user_lid_fk foreign key(lid) references hu_member(lid) on delete cascade 			   		  		 
);



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



create table hu_buy(
	idx number constraint hu_buy_pk_idx primary key,
	lid varchar2(15) constraint hu_buy_nn_lid not null,
	sidx number constraint hu_buy_nn_sidx not null,
	idate date
	,constraint hu_buy_lid_fk foreign key(lid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hubuy_seq start with 1 increment by 1 nocache;




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




create table hu_group(
	idx number constraint hu_group_pk_idx primary key,
	lid varchar2(15) constraint hu_group_nn_lid not null,
	gdiv varchar2(30) constraint hu_group_nn_gdiv not null,
	underline varchar2(1),
	gname varchar2(50) constraint hu_group_nn_gname not null,
	glevel number default 9,
	df varchar2(1) default 'n' constraint hu_group_nn_df not null,
	udate date,
	idate date
	,constraint hu_group_lid_fk foreign key(lid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hugroup_seq start with 1 increment by 1 nocache;




create table hu_friend(
	idx number constraint hu_friend_pk_idx primary key,
	melid varchar2(15) constraint hu_friend_nn_melid not null,
	mename varchar2(50) constraint hu_friend_nn_mename not null,
	youlid varchar2(15) constraint hu_friend_nn_youlid not null,
	youname varchar2(50) constraint hu_friend_nn_youname not null,
	gidx number constraint hu_friend_nn_gidx not null,
	fmsg varchar2(1000),
	fdiv number default 0 constraint hu_friend_nn_fdiv not null,
	udate date,
	idate date
	,constraint hu_friend_melid_fk foreign key(melid) references hu_member(lid) on delete cascade 
	,constraint hu_friend_youlid_fk foreign key(youlid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hufriend_seq start with 1 increment by 1 nocache;




create table hu_myhome(
	idx number constraint hu_myhome_pk_idx primary key,
	lid varchar2(15) constraint hu_myhome_nn_lid not null,
	hname varchar2(100) constraint hu_myhome_nn_hname not null,
	hmsg varchar2(2000),
	haddr varchar2(50),
	totcount number default 0 constraint hu_myhome_nn_totcount not null,
	scrapcount number default 0 constraint hu_myhome_nn_scrapcount not null,
	giftcount number default 0 constraint hu_myhome_nn_giftcount not null,
	ofilename varchar2(100),
	filename varchar2(100),
	keyword1 varchar2(30),
	keyword2 varchar2(30),
	keyword3 varchar2(30),
	udate date,
	idate date
	,constraint hu_myhome_lid_fk foreign key(lid) references hu_member(lid) on delete cascade
);

create SEQUENCE humyhome_seq start with 1 increment by 1 nocache;



create table hu_menu(
	idx number constraint hu_menu_pk_idx primary key,
	lid varchar2(15) constraint hu_menu_nn_lid not null,
	name varchar2(30) constraint hu_menu_nn_name not null,
	div varchar2(30),
	huse number default 0 constraint hu_menu_nn_use not null,
	lev number default 9 constraint hu_menu_nn_lev not null,
	udate date,
	idate date
	,constraint hu_menu_lid_fk FOREIGN KEY(lid) REFERENCES hu_member(lid) ON DELETE CASCADE
);

create SEQUENCE humenu_seq start with 1 increment by 1 nocache;



create table hu_friendment(
	idx number constraint hu_friendment_pk_idx primary key,
	melid varchar2(15) constraint hu_friendment_nn_melid not null,
	youlid varchar2(15) constraint hu_friendment_nn_youlid not null,
	msg varchar2(100) constraint hu_friendment_nn_msg not null,
	idate date
	,constraint hu_friendment_melid_fk foreign key(melid) references hu_member(lid) on delete cascade 
	,constraint hu_friendment_youlid_fk foreign key(youlid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hufriendment_seq start with 1 increment by 1 nocache;



create table hu_myitem(
	idx number constraint hu_myitem_pk_idx primary key,
	lid varchar2(15) constraint hu_myitem_nn_lid not null,
	sidx number constraint hu_myitem_nn_sidx not null,
	zindex number,
	aleft number,
	atop number,
	msg varchar2(100),
	huse number default 9 constraint hu_myitem_nn_huse not null,
	usedate date,
	remaindate number,
	udate date,
	idate date
	,constraint hu_myitem_lid_fk foreign key(lid) references hu_member(lid) on delete cascade
);

create SEQUENCE humyitem_seq start with 1 increment by 1 nocache;



create table hu_guestbook(
	idx number constraint hu_guestbook_pk_idx primary key,
	melid varchar2(15) constraint hu_guestbook_nn_lid not null,
	youlid varchar2(15),
	num number constraint hu_guestbook_nn_num not null,
	name varchar2(30),
	pwd varchar2(30),
	content varchar2(4000) constraint hu_guestbook_nn_content not null,
	host varchar2(15),
	secret varchar2(1) default 'n' constraint hu_guestbook_nn_secret not null,
	udate date,
	idate date
	,constraint hu_guestbook_melid_fk foreign key(melid) references hu_member(lid) on delete cascade 
	,constraint hu_guestbook_youlid_fk foreign key(youlid) references hu_member(lid) on delete cascade 
);

create SEQUENCE huguestbook_seq start with 1 increment by 1 nocache;



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



create table hu_find(
	idx number constraint hu_find_pk_idx primary key,
	name varchar2(500) constraint hu_find_nn_name not null,
	bytename varchar2(1000) constraint hu_find_nn_bytename not null,
	hcount number default 0 constraint hu_find_nn_hcount not null,
	idate date
);

create SEQUENCE hufind_seq start with 1 increment by 1 nocache;


create table hu_today(
	idx number constraint hu_today_pk_idx primary key,
	lid varchar2(15) constraint hu_today_nn_lid not null,
	daycount number default 0 constraint hu_today_nn_daycount not null,
	idate date
	,constraint hu_today_lid_fk foreign key(lid) references hu_member(lid) on delete cascade 
);

create SEQUENCE hutoday_seq start with 1 increment by 1 nocache;