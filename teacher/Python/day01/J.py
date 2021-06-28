# set ( 중복허용X, 순서보존X )

a = {"a", "b", "c", "a"}
print(a)
#print(a[1:3]) #불가 why? index가 없으니까
print()

# (1) Element 핸들링 
# 1-1 변경( change )
#a[1] = "bb"  #불가 why? index가 없으니까

# 1-2 추가1( add )
a.add("tiger")
print(a)
print()

# 1-3 추가2( update )
a.update({"lion", "rabbit"}) # 다른 Set을 추가 
print(a)
print()

# 1-4 삽입( insert ) #불가 why? index가 없으니까

# 1-5-1 삭제1 ( remove ): 내용 
a = {"a", "b", "a"}
#a.remove("c")
a.discard("c") # 해당 요소가 없어도 error를 내지 않음 
print(a)
print()

# 1-5-2 삭제2( del ): 인덱스 
# del a[1] #불가 why? index가 없으니까

# 1-5-3 삭제3( pop ): 랜덤한 요소가 삭제 
a.pop() 
print(a)
print()

# 1-5-4 삭제4( clear ): 모든 요소 삭제 
a.clear()
print(len(a))
print()

# (2) 핸들링 
# 2-1 핸들링 ( loop )
b = {"tiger", "lion", "rabbit"}
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
c1 = {"a", "b", "c"}
c2 = {10, 20, 30}
#c = c1 + c2 # 불가!
c = c1.union(c2)
print("c:", c)
print()

# 3-2 방법2 
for x in c2:
    c1.add(x);
print("c1:", c1)
print()

# 3-3 방법3
# c1.extend(c2) # 불가!

