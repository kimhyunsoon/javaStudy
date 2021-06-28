# 변수의 타입을 알아내는 함수


a = 1 #int
print(type(a))
print()

b = 0.12 #float
print(type(b))
print()

c = "문자열" #str
print(type(c))
print()

d = ["가", "나", "다"] #list
print(type(d))
print()

e = ("a", "b", "c") #tuple
print(type(e))
print()

f1 = {"A", "B", "C"} #set
print(type(f1))
print()

f2 = frozenset({"A", "B", "C"}) #frozenset
print(type(f2))
print()

g = {"name" : "Json", "age": 22} #dict
print(type(g))
print()

h = range(4) #range
print(type(h))
print()
for i in h: #0부터 3까지
    print(i)


i = False #bool
print(type(i))
print()