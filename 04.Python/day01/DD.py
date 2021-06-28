#타입캐스팅을 해주는 함수 int(), float(), str()

a = 1
b = 2.5
c = 3j
print(type(a))
print(type(b))
print(type(c)) #complex
print()

#casting int()
a1 = int(a)
a2 = int(b)
a3 = int("3") #스트링 "3"을 int형으로
print(a1)
print(a2)
print(a3)
print()

#casting float()
b1 = float(a)
b2 = float(b)
b3 = float("3")
print(b1)
print(b2)
print(b3)

#casting str()
c1 = str(a)
c2 = str(b)
c3 = str("가")
print(c1+"더할 수 있다!")
print(c2+"스트링으로 변환했으니까")
print(c3)