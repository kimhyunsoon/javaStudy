--1. �ڽ��� ��ȭ��ȣ�� ȸ�� ��ȣ�� �˰�ʹ�. (ȸ���̸�, ȸ����ȣ)

select m_name, m_number from mom where m_phone='';

--2. ������������ �������� ���̸��� �˰� �;��Ѵ�. (��������ȣ, �������̸�, ���̸�)

select d.D_NUMBER, D_NAME, DS_NAME
from MOM m
join DOGCARD d
on m.M_NUMBER = d.M_NUMBER
join MEDICAL md
on d.D_NUMBER = md.D_NUMBER
join DISEASE da
on da.DS_CODE = md.DS_CODE
where m.M_NUMBER = 'AAAA1';

--3. d0004 ȯ�ڿ��� �ֻ縦 �����ϴµ� �����Կ� ���̸� �˰� �ʹ�.

select d_weight, d_age
from dogcard
where d_number = 'd0004';

--4. �������� �����ڵ带 �˰� �ʹ�

select ds_code
from disease
where ds_name = '������';

--5. d0010 ȯ�ڰ� � �� ������ ������ �԰� ������ �� �´��� �˰�ʹ�(�̰� �� ��Ƴ�) �� ez

select ds_name, (b_vcost+nvl(b_tcost,0)) as ������
from dogcard d
join medical md
on d.d_number = md.d_number
join disease di
on di.ds_code = md.ds_code
join bill b
on b.md_date = md.md_date
where d.d_number = 'd0010';

--6. ���̻� ������ ���ϴ� ��Ʈ�� �μ����� ��������

select e_name, h_mgr
from hospital h
join emp e
on h.h_code = e.h_code
where e_name = '���̻�';

--7. 21/06/21�� 'ġ��'�� ���� ����̵��� ����� ����ʹ�

select d.d_number, d_name, d_kinds, d_age, d_weight, d_sex
from dogcard d
join medical md
on d.d_number = md.d_number
join bill bi
on bi.md_date = md.md_date
where b_tcost is not null and bi.md_date like '210621%';

--8. �츮 �� �̸��� �����ε� ù �湮���� YYYY-MM-DD�� ������ּ��� (ȸ�� ��ȣ�� ������ �̸�����)

select d_name, to_char(d_fdate,'yyyy-mm-dd')
from mom m
join dogcard d
on m.m_number = d.m_number
where m.m_number = ' ' and d_name = ' ';

--9. ����ó���� ������ ġ������ �� ����ͽ��ϴ�

select t_how from treat where t_ins = '�޿�';

--10. �����ҳ� ��ȣ�� �츮 �������� ġ��� ���� ��� ġ������ ����??

select t_how, t_cost from treat
where t_cost = (select max(t_cost) from treat);

--11. �������� 2���� �̻��� ȸ�� ����Ʈ�� �̾���

select m.m_number, m_phone,m_name, m_addr, count(d_number) as "num"
from mom m
join dogcard d
on m.m_number = d.m_number
group by m.m_number,m_phone,m_name, m_addr
having count(d_number)>=2;

--12.  ġ�Ḧ �����ʰ� ������ ���� ȸ�� ����Ʈ�� �̾���

select m.m_number, m_phone,m_name, m_addr
from mom m
join dogcard d
on m.m_number = d.m_number
join medical md
on md.d_number = d.d_number
join bill bi
on bi.md_date = md.md_date
where b_tcost is null;

--13. ������ ���̰� 13�̻��� ȸ�� ����Ʈ�� �̾���

select m.m_number, m_phone, m_name, m_addr
from mom m
join dogcard d
on m.m_number = d.m_number
where d_age >=13;

--14. ��� ��Ʈ������ ������ �ּҴ� �����̸� �������� ���Ḹ �޾Ҵ��� ġ����� �ߴ��� �˷���!

select m_addr, t_how
from mom m
join dogcard d
on m.m_number = d.m_number
join medical md
on md.d_number = d.d_number
join treat t
on t.t_code = md.t_code
where d_kinds = '��� ��Ʈ����';

--15.ġ�Ḧ ���� ���� �������� ������ �̸��� �˷���!

select m_name
from mom m
join dogcard d
on m.m_number = d.m_number
join medical md
on md.d_number = d.d_number
join bill bi
on bi.md_date = md.md_date
where b_tcost is not null and d_sex = '����';

--16. ġ�Ḧ ���� 3���̻� 10�� ������ ���� ���������� 20kg ������ �������� ������ ȸ���ڵ带 �˷���!!

select m.m_number
from mom m
join dogcard d
on m.m_number = d.m_number
join medical md
on md.d_number = d.d_number
join bill bi
on bi.md_date = md.md_date
where b_tcost is not null and d_age between 3 and 10
and d_sex = '����' and d_weight <=20;

--17. �̺��� ȸ���� �������� �������� ��������, �׸��� ���ʹ湮���ڰ� �������� �˷���!

select d_sex, d_fdate
from mom m
join dogcard d
on m.m_number = d.m_number
where m_name ='�̺���';

--18. 3���� �̻� 50���� �̸� ġ������ ����ó���� �ȵǴ°͵鸸 �˷���!

select t_how, t_cost, t_ins
from treat
where t_cost between 30000 and 500000
and t_ins = '��޿�';

--19. ȸ�� �޴���ȭ��ȣ�� �߰��� 8�� �ְ� 1�γ����� ȸ������ ġ�Ḧ ���� �������� �����Ը� �˷���! �纯�³� (�̰� ��??  ������������) �� ��¥ �����ΰ�,.,,?

select d_age
from mom m
join dogcard d
on m.m_number = d.m_number
join medical md
on md.d_number = d.d_number
join bill b
on b.md_date = md.md_date
where m_phone like '%8%1' and b.b_tcost is not null;

--20. ������ȣ�� 2021�� ������ ã�� ȯ�� �� � �� �ɸ� ȯ�ڰ� ���� ���ҳ�?(����?)
--�� �׷��� ������� ��... ������ ����ϼ���....

select d_number, md.ds_code , ds_name, count(ds_name)
from medical md
join disease di
on md.ds_code = di.ds_code
where substr(md_date,1,2)='21'
group by d_number,md.ds_code,ds_name
having count(ds_name)=(select max(count(ds_name))
from disease
group by ds_code);

--21.�ٵ� �̰ɷ� ���� ���� ���� �� �ֳ�?

select sum(b_vcost)+sum(b_tcost)
from bill
where substr(md_date,1,6) = to_char(sysdate,'YYMMDD');

--22.  �ҳ��~? ���� �Ի��� ���� ����Ʈ�� �̾ƿ�

select * from emp
where substr(e_hiredate,1,2)=to_char(sysdate,'yy');

--23. 10���� ���� �������� �߿� �������濡 �ɸ� ������ �� �˷���

select count(ds_name) as "�������� �ɸ� ��������"
from dogcard d
join medical md
on d.d_number = md.d_number
join disease di
on di.ds_code = md.ds_code
where ds_name = '��������' and d_age>10
group by ds_name;

--24.  �Ǻκ��� �ɸ��� ����θ� ġ���� ������ �̸� �˷���

select d.d_number, d_name
from dogcard d
join medical md
on d.d_number = md.d_number
join treat t
on t.t_code = md.t_code
join disease di
on di.ds_code = md.ds_code
where ds_name ='�Ǻκ�' and t_how = '����';

--25. ���� ������ �׷� ����! å���ڰ� ������! (�ǻ�� �μ��� �̸�) ������������������� �̰� ����� ���Դµ�. �ǻ�� �μ����� �������� ����

select h_mgr||'�Դϴ�' from hospital where h_job='�ǻ��';

--26. �� ���� ġ�Ḧ ���� ������ �̸��� �˷���

select d_name
from dogcard d
join medical md
on d.d_number = md.d_number
join treat t
on t.t_code = md.t_code
group by d.d_name
having count(d.d_name)>=2;

--27.  ������ �߿� �Ŵ������� ���� ���� ��� �̸� �˷���

select e_name, e_age
from emp e
join hospital h
on e.h_code = h.h_code
where e_age >all(select e_age from emp where e_name in ('�����ҳ�','������'));

--28.  �츮 �������� �� ��° �湮����? ȸ����ȣ: m0001 (Ȥ�� �ǳ�?)

select count(m.d_number) as �湮Ƚ��
from medical m
join dogcard d
on d.d_number = m.d_number
join mom m
on m.m_number = d.m_number
where m.m_number ='m0001'
group by d.d_name;

--29.  ������ ���� ��ȭ��ȣ��  �ּ��� �˷���(������ ��������)�礻����������

select m_name, m_phone, m_addr
from mom
where m_name ='������';

--30.  ġ�Ϳ� �߿� �������� ���� ������ �̸� �˷���

select d.d_number, d_name
from dogcard d
join medical md
on d.d_number = md.d_number
join treat t
on t.t_code = md.t_code
where t_how ='��������';