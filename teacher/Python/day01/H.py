# list ( 중복허용O, 순서보존O )

# (0) 데이터추출 
a = ["a", "b", "c", "d", "e", "f", "a"]
print(a)
print(a[-2])
print(a[1:3]) #이상 미만 
print(a[3:]) #이상 
print(a[:3]) # 미만 
print(a[-3:-1]) #이상 미만 
print()

# (1) Element 핸들링 
# 1-1 변경( change )
a[1] = "bb"
print(a)
print()

# 1-2 추가( append )
a.append("g")
print(a)
print()

# 1-3 삽입( insert )
a.insert(3, "cc")
print(a)
print()

# 1-4-1 삭제1 ( remove ): 내용 
a.remove("cc")
print(a)
print()

# 1-4-2 삭제2( del ): 인덱스 
del a[1]
print(a)
print()

# 1-4-2 삭제3( pop ): 맨끝에 있는 놈 
a.pop()
print(a)
print()

# 1-4-3 삭제4( clear ): 모든 요소 삭제 
a.clear()
print(a)
print()

# (2) 핸들링 
# 2-1 핸들링 ( loop )
b = ["tiger", "lion", "rabbit"]
for x in b:
    print(x)

# 2-2 핸들링 ( if )
if "lion" in b:
    print("사자가 있음")

# 2-3 핸들링 ( len )
print(len(b))
print()

# 2-4 핸들링 ( copy )
bb = b.copy()
print(bb)
if bb is b:
    print("같은 객체")
else:
    print("다른 객체")
print()

# (3) 합치기 
# 3-1 방법1
c1 = ["a", "b", "c"]
c2 = [10, 20, 30]
c = c1 + c2
print("c:", c)
print()

# 3-2 방법2
for x in c2:
    c1.append(x);
print("c1", c1)
print()

# 3-3 방법3
c1 = ["a", "b", "c"]
c1.extend(c2)
print("c1:", c1)
print()
