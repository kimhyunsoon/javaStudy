/* 회원관리 */
select IDX, LID, PWD, NAME, NICKNAME, BIRTH, 
ADDR1, ADDR2, ADDR3, EMAIL, HOMEPAGE, PWD_SEARCH,
PWD_SEARCHOK, AUTHORITY, MLIVE, VISIT_COUNT, 
POINT, LOGDATE, UDATE, IDATE 
from hu_member
where lid='admin';

/* 선물 */
select g.idx "선물테이블idx", g.sendid "보낸사람", g.receiveid "받는사람", g.sidx "상품idx", s.sname "상품명"
from hu_gift g, hu_member m1, hu_member m2, hu_store s
where m1.lid = g.sendid and m2.lid = g.receiveid and s.idx = g.sidx;

/* 구매함 */
select b.idx "구매함idx", m.lid "구매자아이디", s.idx "상품idx"
from hu_buy b, hu_member m, hu_store s 
where b.lid = m.lid and b.sidx = s.idx;

/* 쪽지 */
select p.idx "쪽지함idx", m1.lid "보내는사람", m2.lid "받는사람", p.sendmsg "보낼메시지", p.isreceive "수신여부", p.plive "삭제대기" 
from hu_paper p, hu_member m1, hu_member m2
where m1.lid = p.sendid and m2.lid = p.receiveid;

/* 그룹명 */
select g.idx "그룹idx", m.lid "로그인아이디", g.gdiv "그룹구분", g.gname "그룹명", g.glevel "그룹레벨", g.df "기본설정" 
from hu_group g, hu_member m 
where m.lid = g.lid and m.lid = 'guest';

/* 일촌관리 */
select f.idx "일촌관리idx", m1.lid "홈주인아이디", f.mename "홈주인일촌명", 
m2.lid "일촌아이디", f.youname "손님일촌명", g.idx "일촌그룹", g.gname "그룹명",
f.fmsg "일촌신청멘트", f.fdiv "구분" 
from hu_friend f, hu_member m1, hu_member m2, hu_group g 
where f.melid = m1.lid and f.youlid = m2.lid and f.gidx = g.idx;

/* 미니홈피 */
select h.idx "미니홈피idx", m.lid "아이디", h.hname "홈피이름", h.hmsg "메인메시지", h.haddr "홈주소", h.totcount "일촌신청멘트", 
h.scrapcount "스크랩수", h.giftcount "선물함수", h.ofilename "실제파일명", h.filename "파일명", 
h.keyword1 "키워드1", h.keyword2 "키워드2", h.keyword3 "키워드3" 
from hu_myhome h, hu_member m
where m.lid = h.lid and m.lid='guest';

/* 메뉴리스트 */
select n.idx "메뉴리스트idx", m.lid "유저아이디", n.name "메뉴명", n.div "메뉴구분", n.huse "사용여부", n.lev "사용권한" 
from hu_menu n, hu_member m 
where n.lid = m.lid and m.lid='guest';

/* 일촌평 */
select fm.idx "일촌평idx", m1.lid "홈주인아이디", m2.lid "일촌아이디", fm.msg "일촌평" 
from hu_friendment fm, hu_member m1, hu_member m2 
where fm.melid = m1.lid and fm.youlid = m2.lid;

/* 미니룸 아이템상자 */
select i.idx "미니룸아이템상자idx", m.lid "아이디", s.idx "상품idx", s.sname "상품명", 
i.zindex "zindex값", i.aleft "절대위치-왼쪽", i.atop "절대위치-위쪽", 
i.msg "메시지", i.huse "사용여부", i.usedate "사용날짜", i.remaindate "남은날짜여부" 
from hu_myitem i, hu_member m, hu_store s 
where i.lid = m.lid and i.sidx = s.idx;

/* 방명록 게시판 (회원) */
select gb.idx "방명록게시판idx", m1.lid "홈주인아이디", m2.lid "글쓴이아이디", gb.num "글번호", 
gb.name "이름", gb.pwd "비밀번호", gb.content "글내용", gb.host "아이피", gb.secret "비밀글여부" 
from hu_guestbook gb, hu_member m1, hu_member m2 
where m1.lid = gb.melid and m2.lid = gb.youlid;

/* 방명록 게시판 (비회원) */
select gb.idx "방명록게시판idx", m.lid "홈주인아이디", gb.num "글번호", 
gb.name "이름", gb.pwd "비밀번호", gb.content "글내용", gb.host "아이피", gb.secret "비밀글여부" 
from hu_guestbook gb, hu_member m
where m.lid = gb.melid;

/* 방명록 답변 */
select gbr.idx "방명록답변idx", gbr.gidx "답변형게시판idx", m.lid "로그인아이디", gbr.content "내용" 
from hu_guestbookRe gbr, hu_guestbook gb, hu_member m 
where gbr.gidx = gb.idx and gbr.lid = m.lid;

/* 다중게시판 (회원) */
select bs.idx "다중게시판idx", m1.lid "홈주인아이디", m2.lid "글쓴이아이디", 
g.idx "그룹idx", g.gdiv "그룹구분", g.gname "그룹명", bs.glevel "접근레벨", bs.num "번호", 
bs.name "이름", bs.pwd "비밀번호", bs.subject "제목", bs.content "내용", bs.host "아이피", 
bs.ofilename "실제파일명", bs.filename "파일명", bs.filesize "파일사이즈", 
bs.refer "레퍼", bs.lev "레벨", bs.sunbun "순번", 
bs.read_num "읽은카운트", bs.scrapcount "스크랩카운트", bs.oriidx "원본글번호" 
from hu_bbs bs, hu_member m1, hu_member m2, hu_group g 
where m1.lid = bs.melid and m2.lid = bs.youlid and g.idx = bs.gidx;

/* 다중게시판 (비회원) */
select bs.idx "다중게시판idx", m.lid "홈주인아이디", 
g.idx "그룹idx", g.gdiv "그룹구분", g.gname "그룹명", bs.glevel "접근레벨", bs.num "번호", 
bs.name "이름", bs.pwd "비밀번호", bs.subject "제목", bs.content "내용", bs.host "아이피", 
bs.ofilename "실제파일명", bs.filename "파일명", bs.filesize "파일사이즈", 
bs.refer "레퍼", bs.lev "레벨", bs.sunbun "순번", 
bs.read_num "읽은카운트", bs.scrapcount "스크랩카운트", bs.oriidx "원본글번호" 
from hu_bbs bs, hu_member m, hu_group g 
where m.lid = bs.melid and g.idx = bs.gidx;

/* 답변내용 */
select bsr.idx "답변내용idx", bs.idx "답변형게시판idx", m.lid "로그인아이디", bsr.content "내용" 
from hu_bbsRe bsr, hu_bbs bs, hu_member m 
where bsr.bidx = bs.idx and m.lid = bsr.lid;