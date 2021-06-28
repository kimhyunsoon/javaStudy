# 타입캐스팅을 해주는 함수 int(), float(), str()
a = 1
b = 2.5
c = 3j
print(type(a))
print(type(b))
print(type(c))
print()

# casting - int()
a1 = int(a)
a2 = int(b)
a3 = int("3")
print(a1)
print(a2)
print(a3 + 1)
print()

# casting - float()
b1 = float(a)
b2 = float(b)
b3 = float("3")
print(b1)
print(b2)
print(b3)
print()

# casting - str()
c1 = str("가")
c2 = str(a)
c3 = str(b)
print(c1)
print(c2 + " 문자열")
print(c3 + " 문자열")