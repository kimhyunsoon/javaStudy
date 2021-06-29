# if 문
a = 2
b = 1
if a>b: # 일반적인 유형
    s = "{}가 {}보다 크다"
    print(s.format(a,b))


#좀 특이한 유형
print("A") if a>b else print ("B")
# 해석 : a가 b보다 크면 "A"를 출력해라

c=3

if c>3: print (c, "는 3보다 크다"); print ("같은 줄에 붙여쓸땐 세미콜론으로 ")
elif c<3: print (c, "는 3보다 작다"); print ("elif는 else if임ㅋㅋㅋ")
else: print (c,"는 3이다")

d1=3
d2=4
d3=5

if d1<d2 or d2>d3:
    print ("수행")

if d1<d2 and d2>d3:
    print ("안나오겠지")

e1 = 6
e2 = 7
if e1>5:
    print("수행2")
    if e2>6: print ("수행3"); print ("수행4")
    else: print ("수행5")

if 9>8:
    pass #if문 수행하지 않고 넘긴다

