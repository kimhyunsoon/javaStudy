#Operators
#(1) 산술
a = 1/2 #type = float
print("a: ", a) #str형이랑 int랑 같이 쓰고 싶으면 쉼표(,)로 연결
print("int(a)", int(a)) 

b = 100//25 #몫을 구할 때
print("b: ",b)

c = 2**3; #제곱계산
print("c: ", c)

#(2) 논리
d= True and True #a와 b를 모두 만족해야 True
print(d)
e = True and False 
print(e)
f = not True
print(f)

#(3) Identity (is, is not)
g = "댕댕이"
h = 10
i = g is not h #the same object?
print(i)

#(4) Membership (in, not in)
listA = ["a","b","c"]
j = "d" not in listA
j = "d" in listA
print(j)
