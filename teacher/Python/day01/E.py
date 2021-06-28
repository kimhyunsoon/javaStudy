# 문자열 핸들링 

a = "안녕 방가워 파이썬"
print(a[-1])
print()

print(a[0:2]) # 이상/미만
print()

print(a[-3:])
print()

print(len(a))
print()

b = "     안녕 방가워 파이썬   "
print(len(b.strip()))
print()

c = "Good Morning"
print(c.lower())
print(c.upper())
print()

d = "Black and Blue"
print(d.replace("Bl", "W"));
print()

print(d.split(" "))
print()

e = "Bl" not in d  # in 과 not in
print(e)
print()

# String Format 출력
f = "나는 이름이 {}이고, 나이는 {}살이다"
age = 20;
print(f.format("길동", age))
print()

g = "나는 이름이 {2}이고, 나이는 {1}살이고, {0}에 산다"
print(g.format("서울", 18, "순신"))
print()

h = "나는 급여를 {:.2f}만원 받고 싶어"
print(h.format(456.789))
print()

i = "나는 {com}의 {car}라는 자동차를 갖고 싶어"
print(i.format(car="제네시스", com="현대"))
print()

j = "그가 \"뉘시요?\" 라고 \n물었다"
print(j);

#Escape Characters => \", \' , \\, \n, \r , \t , \b 