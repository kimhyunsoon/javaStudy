--회원 탈회 요청 시 DOG 테이블의 데이터도 같이 삭제
delete from MOM where M_NUMBER='m0002';
commit;