#변수의 선언
a = 10
print(a)
b = '스트링'
print(b)
print()

a,b,c = "짜장", "짬뽕", "탕수육"
print(a)
print(b)
print(c)
print()

d=e=f="만두국"
print(d)
print(e)
print(f)
print()

g1 = "내 이름은 "
g2 = "이가은이다!"
print(g1+g2)
print()

g = "전역" #전역으로 선언
def m1():
    h = "지역"
    print(h)
    global g #전역을 지역으로 선언
    # h="지역일까?"
    print(g)
m1() #메소드 호출

    