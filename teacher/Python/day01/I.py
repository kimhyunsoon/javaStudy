# tuple ( 중복허용O, 순서보존O but unchangeable )

# (0) 데이터추출 
a = ("a", "b", "c", "d", "e", "f", "a")
print(a)
print(a[-2])
print(a[1:3]) #이상 미만 
print(a[3:]) #이상 
print(a[:3]) # 미만 
print(a[-3:-1]) #이상 미만 
print()

# (1) Element 핸들링 
# 1-1 변경( change ) 
#a[1] = "bb" # 불가 why? 그게 튜플이야!
b = list(a) # Step1
b[1] = "bb" # Step2
a = tuple(b) # Step3
print(a)
print()

# 1-2 추가( append / insert / remove / del / pop / clear )
#a.append("g") # 불가 why? 그게 튜플이야!
#a.insert(3, "cc") # 불가 why? 그게 튜플이야!
#a.remove("c") # 불가 why? 그게 튜플이야!
#del a[1] # 불가 why? 그게 튜플이야!
#a.pop() # 불가 why? 그게 튜플이야!
#a.clear() # 불가 why? 그게 튜플이야!

# (2) 핸들링 
# 2-1 핸들링 ( loop )
b = ("tiger", "lion", "rabbit")
for x in b:
    print(x)

# 2-2 핸들링 ( if )
if "lion" in b:
    print("사자가 있음")

# 2-3 핸들링 ( len )
print(len(b))
print()

# 2-4 핸들링 ( copy )
#bb = b.copy() # 불가 why? 그게 튜플이야!
#print(bb)

# (3) 합치기 
# 3-1 방법1
c1 = ("a", "b", "c")
c2 = (10, 20, 30)
c = c1 + c2
print("c:", c)
print()

# 3-2 방법2 # 불가 why? 그게 튜플이야!
# 3-2 방법3 # 불가 why? 그게 튜플이야!

# (4) 요소가 1개인 튜플 
d = ("apple",)
print(type(d)) 