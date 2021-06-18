
insert into hu_member values(humember_seq.nextval, 'admin', 'admin', '관리자', '관리자', '19821009',
	'133160', '서울시 광진구 능동', '546-45', 'abc@abc.com', 'http://www.daum.net', '1', '지구', 1, 0,
	0,10000,sysdate,sysdate,sysdate);

insert into hu_member values(humember_seq.nextval, 'master', 'master', '상품관리자', '상품관리자', '19821010',
	'133160', '서울시 광진구 능동', '546-45', 'abc@abc.com', 'http://www.daum.net', '1', '지구', 3, 0,
	0,10000,sysdate,sysdate,sysdate);


insert into hu_member values(humember_seq.nextval, 'test', 'test', '테스트', '테스트', '19821011',
	'133160', '서울시 광진구 능동', '546-45', 'abc@abc.com', 'http://www.daum.net', '1', '지구', 9, 0,
	0,100,sysdate,sysdate,sysdate);

insert into hu_member values(humember_seq.nextval, 'guest', 'guest', '게스트', '게스트', '19821012',
	'133160', '서울시 광진구 능동', '546-45', 'abc@abc.com', 'http://www.daum.net', '1', '지구', 9, 0,
	0,100,sysdate,sysdate,sysdate);



insert into hu_store values(hustore_seq.nextval,'스킨테스트', '테스트스킨입니다', 's','sample_1_l.gif','sample_1_l.gif',
 100,'sample_1_s.gif', 'sample_1_s.gif' , 100 , 'master', 10, 7,sysdate,sysdate);

insert into hu_store values(hustore_seq.nextval,'미니륨테스트', '테스트미니룸입니다', 'r','room1.gif','room1.gif',
 100,'','' , 0 ,'master', 12, 7,sysdate,sysdate);

insert into hu_store values(hustore_seq.nextval,'미니미테스트', '테스트미니미입니다', 'i','item1.gif','item1.gif',
 100,'','' , 0 ,'master', 5, 7,sysdate,sysdate);

insert into hu_store values(hustore_seq.nextval,'음악테스트', '테스트음악입니다', 'm','music1.mp3','music1.mp3',
 100,'','' , 223 ,'master', 5, 7,sysdate,sysdate);



insert into hu_gift values(hugift_seq.nextval, 'test', 'guest', 2, '테스트미니룸보냅니다', '', sysdate, sysdate,0);
insert into hu_gift values(hugift_seq.nextval, 'test', 'guest', 1, '테스트스킨보냅니다', '잘받았습니다', sysdate, sysdate,9);



insert into hu_buy values(hubuy_seq.nextval, 'test', 3,sysdate);
insert into hu_buy values(hubuy_seq.nextval, 'test', 4,sysdate);


insert into hu_paper values(hupaper_seq.nextval, 'guest', 'test', '안녕하세요', 0, 0, sysdate, sysdate);
insert into hu_paper values(hupaper_seq.nextval, 'guest', 'test', '반가워요~', 9, 0, sysdate, sysdate);


insert into hu_friend values(hufriend_seq.nextval, 'guest', '게스트', 'test', '테스트', 16, '일촌신청이요', 9, sysdate, sysdate);
insert into hu_friend values(hufriend_seq.nextval, 'test', '테스트', 'guest', '게스트', 11, '일촌신청이요', 9, sysdate, sysdate);

insert into hu_friendment values(hufriendment_seq.nextval, 'guest', 'test', '참 멋지네요^^',sysdate);

insert into hu_myitem values(humyitem_seq.nextval, 'test', 3, 1, 200, 200, '', 9, null,0,sysdate,sysdate);
insert into hu_myitem values(humyitem_seq.nextval, 'test', 4, 0, 0, 0, '', 9, null,0,sysdate,sysdate);
insert into hu_myitem values(humyitem_seq.nextval, 'guest', 1, 0, 0, 0, '', 0, sysdate,7,sysdate,sysdate);

insert into hu_guestbook values(huguestbook_seq.nextval, 'guest', 'test', 1, '','','테스트입니다','211.254.138.193', 'y', sysdate, sysdate);
insert into hu_guestbook values(huguestbook_seq.nextval, 'guest', '', 2, 'test','test','비공개 회원','211.254.138.193', 'n', sysdate, sysdate);

insert into hu_guestbookre values(huguestbookre_seq.nextval, 2, 'guest', '잘봤어요', sysdate);

insert into hu_bbs values(hubbs_seq.nextval, 'guest', 'test', 19, 9, 1,'','', '테스터입니다', '게시판테스트', 
'211.254.138.193', '', '', 0,1,0,0,0,0,0,sysdate,sysdate);
insert into hu_bbs values(hubbs_seq.nextval, 'guest', '', 19, 9, 2,'테스트','test', '비회원', '비회원테스트', 
'211.254.138.193', '', '', 0,2,0,0,0,0,0,sysdate,sysdate);
insert into hu_bbs values(hubbs_seq.nextval, 'test', 'test', 14, 9, 1,'','', '(스크랩)테스터입니다', '게시판테스트', 
'211.254.138.193', '', '', 0,1,0,0,0,0,1,sysdate,sysdate);

insert into hu_bbsre values(hubbsre_seq.nextval, 2, 'guest', '잘봤어요', sysdate);

insert into hu_find values(hufind_seq.nextval, '검색어', '검색어', 1, sysdate);

insert into hu_today values(hutoday_seq.nextval, 'guest' ,1 , sysdate);

insert into hu_Store values(0,'메세지','메세지','c','aa','aa',0,'','',0,'master',0,0,sysdate,sysdate);