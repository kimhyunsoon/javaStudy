
insert into hu_member values(humember_seq.nextval, 'admin', 'admin', '������', '������', '19821009',
	'133160', '����� ������ �ɵ�', '546-45', 'abc@abc.com', 'http://www.daum.net', '1', '����', 1, 0,
	0,10000,sysdate,sysdate,sysdate);

insert into hu_member values(humember_seq.nextval, 'master', 'master', '��ǰ������', '��ǰ������', '19821010',
	'133160', '����� ������ �ɵ�', '546-45', 'abc@abc.com', 'http://www.daum.net', '1', '����', 3, 0,
	0,10000,sysdate,sysdate,sysdate);


insert into hu_member values(humember_seq.nextval, 'test', 'test', '�׽�Ʈ', '�׽�Ʈ', '19821011',
	'133160', '����� ������ �ɵ�', '546-45', 'abc@abc.com', 'http://www.daum.net', '1', '����', 9, 0,
	0,100,sysdate,sysdate,sysdate);

insert into hu_member values(humember_seq.nextval, 'guest', 'guest', '�Խ�Ʈ', '�Խ�Ʈ', '19821012',
	'133160', '����� ������ �ɵ�', '546-45', 'abc@abc.com', 'http://www.daum.net', '1', '����', 9, 0,
	0,100,sysdate,sysdate,sysdate);



insert into hu_store values(hustore_seq.nextval,'��Ų�׽�Ʈ', '�׽�Ʈ��Ų�Դϴ�', 's','sample_1_l.gif','sample_1_l.gif',
 100,'sample_1_s.gif', 'sample_1_s.gif' , 100 , 'master', 10, 7,sysdate,sysdate);

insert into hu_store values(hustore_seq.nextval,'�̴Ϸ��׽�Ʈ', '�׽�Ʈ�̴Ϸ��Դϴ�', 'r','room1.gif','room1.gif',
 100,'','' , 0 ,'master', 12, 7,sysdate,sysdate);

insert into hu_store values(hustore_seq.nextval,'�̴Ϲ��׽�Ʈ', '�׽�Ʈ�̴Ϲ��Դϴ�', 'i','item1.gif','item1.gif',
 100,'','' , 0 ,'master', 5, 7,sysdate,sysdate);

insert into hu_store values(hustore_seq.nextval,'�����׽�Ʈ', '�׽�Ʈ�����Դϴ�', 'm','music1.mp3','music1.mp3',
 100,'','' , 223 ,'master', 5, 7,sysdate,sysdate);



insert into hu_gift values(hugift_seq.nextval, 'test', 'guest', 2, '�׽�Ʈ�̴Ϸ뺸���ϴ�', '', sysdate, sysdate,0);
insert into hu_gift values(hugift_seq.nextval, 'test', 'guest', 1, '�׽�Ʈ��Ų�����ϴ�', '�߹޾ҽ��ϴ�', sysdate, sysdate,9);



insert into hu_buy values(hubuy_seq.nextval, 'test', 3,sysdate);
insert into hu_buy values(hubuy_seq.nextval, 'test', 4,sysdate);


insert into hu_paper values(hupaper_seq.nextval, 'guest', 'test', '�ȳ��ϼ���', 0, 0, sysdate, sysdate);
insert into hu_paper values(hupaper_seq.nextval, 'guest', 'test', '�ݰ�����~', 9, 0, sysdate, sysdate);


insert into hu_friend values(hufriend_seq.nextval, 'guest', '�Խ�Ʈ', 'test', '�׽�Ʈ', 16, '���̽�û�̿�', 9, sysdate, sysdate);
insert into hu_friend values(hufriend_seq.nextval, 'test', '�׽�Ʈ', 'guest', '�Խ�Ʈ', 11, '���̽�û�̿�', 9, sysdate, sysdate);

insert into hu_friendment values(hufriendment_seq.nextval, 'guest', 'test', '�� �����׿�^^',sysdate);

insert into hu_myitem values(humyitem_seq.nextval, 'test', 3, 1, 200, 200, '', 9, null,0,sysdate,sysdate);
insert into hu_myitem values(humyitem_seq.nextval, 'test', 4, 0, 0, 0, '', 9, null,0,sysdate,sysdate);
insert into hu_myitem values(humyitem_seq.nextval, 'guest', 1, 0, 0, 0, '', 0, sysdate,7,sysdate,sysdate);

insert into hu_guestbook values(huguestbook_seq.nextval, 'guest', 'test', 1, '','','�׽�Ʈ�Դϴ�','211.254.138.193', 'y', sysdate, sysdate);
insert into hu_guestbook values(huguestbook_seq.nextval, 'guest', '', 2, 'test','test','����� ȸ��','211.254.138.193', 'n', sysdate, sysdate);

insert into hu_guestbookre values(huguestbookre_seq.nextval, 2, 'guest', '�ߺþ��', sysdate);

insert into hu_bbs values(hubbs_seq.nextval, 'guest', 'test', 19, 9, 1,'','', '�׽����Դϴ�', '�Խ����׽�Ʈ', 
'211.254.138.193', '', '', 0,1,0,0,0,0,0,sysdate,sysdate);
insert into hu_bbs values(hubbs_seq.nextval, 'guest', '', 19, 9, 2,'�׽�Ʈ','test', '��ȸ��', '��ȸ���׽�Ʈ', 
'211.254.138.193', '', '', 0,2,0,0,0,0,0,sysdate,sysdate);
insert into hu_bbs values(hubbs_seq.nextval, 'test', 'test', 14, 9, 1,'','', '(��ũ��)�׽����Դϴ�', '�Խ����׽�Ʈ', 
'211.254.138.193', '', '', 0,1,0,0,0,0,1,sysdate,sysdate);

insert into hu_bbsre values(hubbsre_seq.nextval, 2, 'guest', '�ߺþ��', sysdate);

insert into hu_find values(hufind_seq.nextval, '�˻���', '�˻���', 1, sysdate);

insert into hu_today values(hutoday_seq.nextval, 'guest' ,1 , sysdate);

insert into hu_Store values(0,'�޼���','�޼���','c','aa','aa',0,'','',0,'master',0,0,sysdate,sysdate);