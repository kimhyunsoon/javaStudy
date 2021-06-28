# 변수의 선언
a = 10
b = '스트링'
print(a)
print(b)
print()

a,b,c = "짜장", "짬뽕", "탕수육"
print(a)
print(b)
print(c)

d=e=f="만두국"

print(d)
print(e)
print(f)

g1="파이썬은 "
g2 = "심플하다"

print(g1+g2)
print()

g = "전역"
def m1():
    h="지역"
    print(h)
    global g #전역변수를 뜻함
    print(g)

m1()
# print(h)