# if 문 
a = 2
b = 1
if a>b:
    s = "{}가 {}보다 크다"
    print(s.format(a, b))
print()

print("A") if a>b else print("B")
print()

c = 4
if c>3: print(str(c) + "는 3보다 크다"); print("이것도 바디?")
elif c<3: print(str(c) + "는 3보다 작다")
else: print(str(c) + "는 3이다")
print()

d1 = 3
d2 = 4
d3 = 5
if d1<d2 or d2>d3:
    print("수행")
print()

e1 = 6
e2 = 7
if e1>5:
    print("1")
    if e2>6: print("2"); print("22")
    else: print("3")
print()

if 9>8:
    pass

print("end")