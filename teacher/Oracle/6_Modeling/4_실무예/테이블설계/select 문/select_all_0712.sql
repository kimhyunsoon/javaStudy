/* ȸ������ */
select IDX, LID, PWD, NAME, NICKNAME, BIRTH, 
ADDR1, ADDR2, ADDR3, EMAIL, HOMEPAGE, PWD_SEARCH,
PWD_SEARCHOK, AUTHORITY, MLIVE, VISIT_COUNT, 
POINT, LOGDATE, UDATE, IDATE 
from hu_member
where lid='admin';

/* ���� */
select g.idx "�������̺�idx", g.sendid "�������", g.receiveid "�޴»��", g.sidx "��ǰidx", s.sname "��ǰ��"
from hu_gift g, hu_member m1, hu_member m2, hu_store s
where m1.lid = g.sendid and m2.lid = g.receiveid and s.idx = g.sidx;

/* ������ */
select b.idx "������idx", m.lid "�����ھ��̵�", s.idx "��ǰidx"
from hu_buy b, hu_member m, hu_store s 
where b.lid = m.lid and b.sidx = s.idx;

/* ���� */
select p.idx "������idx", m1.lid "�����»��", m2.lid "�޴»��", p.sendmsg "�����޽���", p.isreceive "���ſ���", p.plive "�������" 
from hu_paper p, hu_member m1, hu_member m2
where m1.lid = p.sendid and m2.lid = p.receiveid;

/* �׷�� */
select g.idx "�׷�idx", m.lid "�α��ξ��̵�", g.gdiv "�׷챸��", g.gname "�׷��", g.glevel "�׷췹��", g.df "�⺻����" 
from hu_group g, hu_member m 
where m.lid = g.lid and m.lid = 'guest';

/* ���̰��� */
select f.idx "���̰���idx", m1.lid "Ȩ���ξ��̵�", f.mename "Ȩ�������̸�", 
m2.lid "���̾��̵�", f.youname "�մ����̸�", g.idx "���̱׷�", g.gname "�׷��",
f.fmsg "���̽�û��Ʈ", f.fdiv "����" 
from hu_friend f, hu_member m1, hu_member m2, hu_group g 
where f.melid = m1.lid and f.youlid = m2.lid and f.gidx = g.idx;

/* �̴�Ȩ�� */
select h.idx "�̴�Ȩ��idx", m.lid "���̵�", h.hname "Ȩ���̸�", h.hmsg "���θ޽���", h.haddr "Ȩ�ּ�", h.totcount "���̽�û��Ʈ", 
h.scrapcount "��ũ����", h.giftcount "�����Լ�", h.ofilename "�������ϸ�", h.filename "���ϸ�", 
h.keyword1 "Ű����1", h.keyword2 "Ű����2", h.keyword3 "Ű����3" 
from hu_myhome h, hu_member m
where m.lid = h.lid and m.lid='guest';

/* �޴�����Ʈ */
select n.idx "�޴�����Ʈidx", m.lid "�������̵�", n.name "�޴���", n.div "�޴�����", n.huse "��뿩��", n.lev "������" 
from hu_menu n, hu_member m 
where n.lid = m.lid and m.lid='guest';

/* ������ */
select fm.idx "������idx", m1.lid "Ȩ���ξ��̵�", m2.lid "���̾��̵�", fm.msg "������" 
from hu_friendment fm, hu_member m1, hu_member m2 
where fm.melid = m1.lid and fm.youlid = m2.lid;

/* �̴Ϸ� �����ۻ��� */
select i.idx "�̴Ϸ�����ۻ���idx", m.lid "���̵�", s.idx "��ǰidx", s.sname "��ǰ��", 
i.zindex "zindex��", i.aleft "������ġ-����", i.atop "������ġ-����", 
i.msg "�޽���", i.huse "��뿩��", i.usedate "��볯¥", i.remaindate "������¥����" 
from hu_myitem i, hu_member m, hu_store s 
where i.lid = m.lid and i.sidx = s.idx;

/* ���� �Խ��� (ȸ��) */
select gb.idx "���ϰԽ���idx", m1.lid "Ȩ���ξ��̵�", m2.lid "�۾��̾��̵�", gb.num "�۹�ȣ", 
gb.name "�̸�", gb.pwd "��й�ȣ", gb.content "�۳���", gb.host "������", gb.secret "��бۿ���" 
from hu_guestbook gb, hu_member m1, hu_member m2 
where m1.lid = gb.melid and m2.lid = gb.youlid;

/* ���� �Խ��� (��ȸ��) */
select gb.idx "���ϰԽ���idx", m.lid "Ȩ���ξ��̵�", gb.num "�۹�ȣ", 
gb.name "�̸�", gb.pwd "��й�ȣ", gb.content "�۳���", gb.host "������", gb.secret "��бۿ���" 
from hu_guestbook gb, hu_member m
where m.lid = gb.melid;

/* ���� �亯 */
select gbr.idx "���ϴ亯idx", gbr.gidx "�亯���Խ���idx", m.lid "�α��ξ��̵�", gbr.content "����" 
from hu_guestbookRe gbr, hu_guestbook gb, hu_member m 
where gbr.gidx = gb.idx and gbr.lid = m.lid;

/* ���߰Խ��� (ȸ��) */
select bs.idx "���߰Խ���idx", m1.lid "Ȩ���ξ��̵�", m2.lid "�۾��̾��̵�", 
g.idx "�׷�idx", g.gdiv "�׷챸��", g.gname "�׷��", bs.glevel "���ٷ���", bs.num "��ȣ", 
bs.name "�̸�", bs.pwd "��й�ȣ", bs.subject "����", bs.content "����", bs.host "������", 
bs.ofilename "�������ϸ�", bs.filename "���ϸ�", bs.filesize "���ϻ�����", 
bs.refer "����", bs.lev "����", bs.sunbun "����", 
bs.read_num "����ī��Ʈ", bs.scrapcount "��ũ��ī��Ʈ", bs.oriidx "�����۹�ȣ" 
from hu_bbs bs, hu_member m1, hu_member m2, hu_group g 
where m1.lid = bs.melid and m2.lid = bs.youlid and g.idx = bs.gidx;

/* ���߰Խ��� (��ȸ��) */
select bs.idx "���߰Խ���idx", m.lid "Ȩ���ξ��̵�", 
g.idx "�׷�idx", g.gdiv "�׷챸��", g.gname "�׷��", bs.glevel "���ٷ���", bs.num "��ȣ", 
bs.name "�̸�", bs.pwd "��й�ȣ", bs.subject "����", bs.content "����", bs.host "������", 
bs.ofilename "�������ϸ�", bs.filename "���ϸ�", bs.filesize "���ϻ�����", 
bs.refer "����", bs.lev "����", bs.sunbun "����", 
bs.read_num "����ī��Ʈ", bs.scrapcount "��ũ��ī��Ʈ", bs.oriidx "�����۹�ȣ" 
from hu_bbs bs, hu_member m, hu_group g 
where m.lid = bs.melid and g.idx = bs.gidx;

/* �亯���� */
select bsr.idx "�亯����idx", bs.idx "�亯���Խ���idx", m.lid "�α��ξ��̵�", bsr.content "����" 
from hu_bbsRe bsr, hu_bbs bs, hu_member m 
where bsr.bidx = bs.idx and m.lid = bsr.lid;