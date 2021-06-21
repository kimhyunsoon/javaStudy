--1. 자신의 전화번호로 회원 번호를 알고싶다. (회원이름, 회원번호)

select m_name, m_number from mom where m_phone='';

--2. 강아지엄마가 강아지의 병이름을 알고 싶어한다. (강아지번호, 강아지이름, 병이름)

select d.D_NUMBER, D_NAME, DS_NAME
from MOM m
join DOGCARD d
on m.M_NUMBER = d.M_NUMBER
join MEDICAL md
on d.D_NUMBER = md.D_NUMBER
join DISEASE da
on da.DS_CODE = md.DS_CODE
where m.M_NUMBER = 'AAAA1';

--3. d0004 환자에게 주사를 놔야하는데 몸무게와 나이를 알고 싶다.

select d_weight, d_age
from dogcard
where d_number = 'd0004';

--4. 관절염의 병명코드를 알고 싶다

select ds_code
from disease
where ds_name = '관절염';

--5. d0010 환자가 어떤 병 때문에 병원에 왔고 병원비 얼마 냈는지 알고싶다(이거 좀 어렵네) → ez

select ds_name, (b_vcost+nvl(b_tcost,0)) as 병원비
from dogcard d
join medical md
on d.d_number = md.d_number
join disease di
on di.ds_code = md.ds_code
join bill b
on b.md_date = md.md_date
where d.d_number = 'd0010';

--6. 오이쁨 직원이 일하는 파트의 부서장이 누구인지

select e_name, h_mgr
from hospital h
join emp e
on h.h_code = e.h_code
where e_name = '오이쁨';

--7. 21/06/21에 '치료'를 받은 댕댕이들의 목록을 보고싶다

select d.d_number, d_name, d_kinds, d_age, d_weight, d_sex
from dogcard d
join medical md
on d.d_number = md.d_number
join bill bi
on bi.md_date = md.md_date
where b_tcost is not null and bi.md_date like '210621%';

--8. 우리 애 이름이 똥이인데 첫 방문일을 YYYY-MM-DD로 출력해주세요 (회원 번호와 강이지 이름으로)

select d_name, to_char(d_fdate,'yyyy-mm-dd')
from mom m
join dogcard d
on m.m_number = d.m_number
where m.m_number = ' ' and d_name = ' ';

--9. 보험처리가 가능한 치료방법을 다 보고싶습니다

select t_how from treat where t_ins = '급여';

--10. 맑음소녀 간호사 우리 병원에서 치료비가 제일 비싼 치료방법이 뭐지??

select t_how, t_cost from treat
where t_cost = (select max(t_cost) from treat);

--11. 강아지가 2마리 이상인 회원 리스트좀 뽑아줘

select m.m_number, m_phone,m_name, m_addr, count(d_number) as "num"
from mom m
join dogcard d
on m.m_number = d.m_number
group by m.m_number,m_phone,m_name, m_addr
having count(d_number)>=2;

--12.  치료를 받지않고 진단을 받은 회원 리스트좀 뽑아줘

select m.m_number, m_phone,m_name, m_addr
from mom m
join dogcard d
on m.m_number = d.m_number
join medical md
on md.d_number = d.d_number
join bill bi
on bi.md_date = md.md_date
where b_tcost is null;

--13. 강아지 나이가 13이상인 회원 리시트좀 뽑아줘

select m.m_number, m_phone, m_name, m_addr
from mom m
join dogcard d
on m.m_number = d.m_number
where d_age >=13;

--14. 골든 리트리버의 견주의 주소는 무엇이며 강아지는 진료만 받았는지 치료까지 했는지 알려줘!

select m_addr, t_how
from mom m
join dogcard d
on m.m_number = d.m_number
join medical md
on md.d_number = d.d_number
join treat t
on t.t_code = md.t_code
where d_kinds = '골든 리트리버';

--15.치료를 받은 암컷 강아지들 견주의 이름을 알려줘!

select m_name
from mom m
join dogcard d
on m.m_number = d.m_number
join medical md
on md.d_number = d.d_number
join bill bi
on bi.md_date = md.md_date
where b_tcost is not null and d_sex = '암컷';

--16. 치료를 받은 3살이상 10살 이하의 수컷 강아지들중 20kg 이하의 강아지들 주인의 회원코드를 알려줘!!

select m.m_number
from mom m
join dogcard d
on m.m_number = d.m_number
join medical md
on md.d_number = d.d_number
join bill bi
on bi.md_date = md.md_date
where b_tcost is not null and d_age between 3 and 10
and d_sex = '수컷' and d_weight <=20;

--17. 이보영 회원의 강아지가 수컷인지 암컷인지, 그리고 최초방문일자가 언제인지 알려줘!

select d_sex, d_fdate
from mom m
join dogcard d
on m.m_number = d.m_number
where m_name ='이보영';

--18. 3만원 이상 50만원 미만 치료방법중 보험처리가 안되는것들만 알려줘!

select t_how, t_cost, t_ins
from treat
where t_cost between 30000 and 500000
and t_ins = '비급여';

--19. 회원 휴대전화번호가 중간에 8이 있고 1로끝나는 회원들중 치료를 받은 강아지의 몸무게를 알려줘! ←변태네 (이건 좀??  ㅋㅋㅋㅋㅋㅋ) ← 진짜 변태인가,.,,?

select d_age
from mom m
join dogcard d
on m.m_number = d.m_number
join medical md
on md.d_number = d.d_number
join bill b
on b.md_date = md.md_date
where m_phone like '%8%1' and b.b_tcost is not null;

--20. 맑음간호사 2021년 병원을 찾은 환자 중 어떤 병 걸린 환자가 제일 많았나?(가능?)
--→ 그런건 원장님이 좀... 일일이 기억하세요....

select d_number, md.ds_code , ds_name, count(ds_name)
from medical md
join disease di
on md.ds_code = di.ds_code
where substr(md_date,1,2)='21'
group by d_number,md.ds_code,ds_name
having count(ds_name)=(select max(count(ds_name))
from disease
group by ds_code);

--21.근데 이걸로 오늘 매출 뽑을 수 있나?

select sum(b_vcost)+sum(b_tcost)
from bill
where substr(md_date,1,6) = to_char(sysdate,'YYMMDD');

--22.  소녀야~? 올해 입사한 직원 리스트좀 뽑아와

select * from emp
where substr(e_hiredate,1,2)=to_char(sysdate,'yy');

--23. 10살이 넘은 강아지들 중에 심장사상충에 걸린 강아지 수 알려줘

select count(ds_name) as "심장사상충 걸린 강아지수"
from dogcard d
join medical md
on d.d_number = md.d_number
join disease di
on di.ds_code = md.ds_code
where ds_name = '심장사상충' and d_age>10
group by ds_name;

--24.  피부병에 걸리고 연고로만 치료한 강아지 이름 알려줘

select d.d_number, d_name
from dogcard d
join medical md
on d.d_number = md.d_number
join treat t
on t.t_code = md.t_code
join disease di
on di.ds_code = md.ds_code
where ds_name ='피부병' and t_how = '연고';

--25. 원장 나오라 그래 원장! 책임자가 누구야! (의사부 부서장 이름) ㅋㅋㅋㅋㅋㅋㅋㅋ←아 이거 쓸라고 들어왔는데. 의사부 부서장을 원장으로 ㄱㄱ

select h_mgr||'입니다' from hospital where h_job='의사부';

--26. 두 가지 치료를 받은 강아지 이름을 알려줘

select d_name
from dogcard d
join medical md
on d.d_number = md.d_number
join treat t
on t.t_code = md.t_code
group by d.d_name
having count(d.d_name)>=2;

--27.  직원들 중에 매니저보다 나이 많은 사람 이름 알려줘

select e_name, e_age
from emp e
join hospital h
on e.h_code = h.h_code
where e_age >all(select e_age from emp where e_name in ('맑음소녀','수스맨'));

--28.  우리 강아지가 몇 번째 방문이죠? 회원번호: m0001 (혹시 되나?)

select count(m.d_number) as 방문횟수
from medical m
join dogcard d
on d.d_number = m.d_number
join mom m
on m.m_number = d.m_number
where m.m_number ='m0001'
group by d.d_name;

--29.  오윤희 고객님 전화번호랑  주소좀 알려줘(이유는 묻지말고)←ㅋㅋㅋㅋㅋㅋ

select m_name, m_phone, m_addr
from mom
where m_name ='오윤희';

--30.  치와와 중에 내과수술 받은 강아지 이름 알려줘

select d.d_number, d_name
from dogcard d
join medical md
on d.d_number = md.d_number
join treat t
on t.t_code = md.t_code
where t_how ='내과수술';