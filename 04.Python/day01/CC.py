#변수의 타입을 알아내는 함수 : type()
a = 1
print(type(a))
print()

b = 0.12
print(type(b))
print()

c = "문자열"
print(type(c))
print()

d = ["가", "나", "다"]
print(type(d))
print()

e = ("가","나","다")
print(type(e))
print()

f1 = {"가","나","다"} #set은 순서보존이 되지 않는다
print(type(f1))
print(f1)

f2 = frozenset({"가","나","다"}) 
print(type(f2))
print(f2)

g = {"name" :"길동", "age" : 22}
print(type(g))
print()

h = range(4)
print(type(h))
print(h)

i=False #bool 앞에 대문자로
print(type(i))
print(i)