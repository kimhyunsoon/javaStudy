# tuple(중복허용O, 순서보존 O but 바꿀 수 없다)

# (0) 데이터추출
a = ("a", "b", "c", "d", "e", "f", "a")
print(a)
print(a[-3:-1])

#(1) Element 핸들링
# 1-1 변경(change)

b = list(a)     #step1 : list로 형변환
b[1] = "bb"     #step2 : 1번째 인덱스의 요소를 변경
a = tuple(b)    #step3 : tuple형으로 다시 형변환
print(a)


# 1-2 추가 불가, 삽입 불가

# (2) 핸들링
# 2-1 핸들링(loop)
b = ("tiger", "lion", "rabbit")
for x in b:
    print(x)

# 2-2 핸들링(if) 
if "lion" in b:
    print("사자가있음")

# 2-3 핸들링(len)
print(len(b))

# (3) 합치기
c1 = ("a", "b", "c")
c2 = (10, 20, 30)
c=c1+c2
print("c", c)

# (4) 요소가 1개인 튜플
d = ("apple",)
print(type(d))