drop table T1;
drop table T2;


-- sqlForOuterJoin.sql
create table T1(
   NO number(2), 
   NAME varchar2(10)
);

insert into T1 values(10, '홍길동');
insert into T1 values(20, '이순신');

create table T2(
   NO number(2), 
   NAME varchar2(10)
);

insert into T2 values(10, 'AAA');
insert into T2 values(30, 'BBB');

commit;

select * from T1;
select * from T2;
