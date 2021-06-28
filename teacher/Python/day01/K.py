# dict ( 중복허용(key X, value O), 순서보존X )

a = {"name":"홍길동", "age":25} # 방법1
#a = dict(name="홍길동", age=25) # 방법2
print(a)
print()

# (0) 데이터추출
print(a["name"])
print(a["age"])
print(a.get("name"))
print(a.get("age"))
print()

# (1) Element 핸들링 
# 1-1 변경( change )
a["name"] = "이순신"
a["age"] = 30
print(a)
print()

# 1-2 추가( append / insert )
a["addr"] = "서울시"
print(a)
print()

# 1-3-1 삭제1 ( key 값으로 )
a.pop("age")
print(a)
print()

# 1-3-2 삭제2( key 값으로 )
del a["name"]
print(a)
print()

# 1-3-2 삭제3 : 마지막으로 추가된 아이템
a = {"name":"홍길동", "age":25}
a.popitem()
print(a)
print()

# 1-3-3 삭제4( clear ): 모든 요소 삭제 
a = {"name":"홍길동", "age":25}
a.clear()
print(a)
print()

# (2) 핸들링 
# 2-1 핸들링 ( loop )
b = {"an1":"tiger", "an2":"lion", "an3":"rabbit"}
for x in b:
    print("key:", x, " value:", b[x])
print()

for x in b.values():
    print(x)
print()

for x, y in b.items():
    print(x, y)
print()

# 2-2 핸들링 ( if )
if "an2" in b:
    print("2번째 동물이 있음")
print()

if "lion" in b.values():
    print("사자가 있음")
print()

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

# (3) 합치기 : 불가!!

# (4) Nested Dict 
student1 = {"name":"유관순", "age":25} 
students = {
    "st1": student1,
    "st2": {"name":"강감찬", "age":30}
}
print(students)




