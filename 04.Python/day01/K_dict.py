# dict (key는 중복허용x, value는 중복허용o / 순서보존x)

a = {"name":"이가은", "age":36}     #방법 1
b = dict(name = "김현순", age=29)   #방법 2
print(a)
print(b)

# (0) 데이터추출 value 값 추출
print (a["name"]) 
print (a.get("name"))

# (1) Element 핸들링
# 1-1 변경(change)
a["name"] = "이깐따"
a["age"] = 35
print (a)

# 1-2 추가(append / insert)
a["addr"] = "서울시"
print(a)

# 1-3-1 삭제 1 pop()
a.pop("age")
print(a)

# 1-3-2 삭제2 del
del a["name"]
print (a)

# 1-3-3 삭제3 : popitem() 마지막으로 추가된 아이템, (키, 값) 쌍을 제거하고 2- 튜플로 반환합니다.
a = {"name" : "홍길동", "age":25}
a.popitem()
print (a)

# 1-3-4 삭제4 clear() : remove all item
a = {"name" : "홍길동", "age":25}
a.clear()
print(a)


# (2) 핸들링
# 2-1 핸들링(loop)
b = {"key1" : "tiger", "key2" : "lion", "key3" : "rabbit"}
for x in b:
    print (x , b[x]) #b[x] => b컬렉션의 x 키값에 해당되는 value값

for x in b.values(): #values() : 컬렉션의 value값을 볼 수 있는 메소드, 인자가 한개
    print(x)

for x,y in b.items(): #items() : 컬렉션의 항목을 볼 수 있는 메소드, 인자가 두개
    print (x,y)


# 2-2 핸들링(if)
if "key1" in b: # key값으로 접근
    print ("1번째 동물이 있음")

if "lion" in b.values(): # value값으로 접근
    print ("사자가 있음")

# 2-3 핸들링(len)
print (len(b))

# 2-4 핸들링(copy)
bb = b.copy()
print(bb)
if bb is b:
    print("같은 객체")
else:
    print("다른 객체")
print()

# (3) Nested Dict : 중첩 dict
student1 = {"name":"이가은", "age":36} 

student = {
    "st1": student1,
    "st2": {"name":"김현순", "age":29}
}
print(student)
