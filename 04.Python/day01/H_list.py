#list (중복허용o, 순서보존o)

#(0) 데이터 추출
a = ["a","b","c","d","e","f","a"] #중복을 허용한다
print (a)
print(a[-3:-1]) # a 이상 b 미만

#(1) Element 핸들링
# 1-1 변경(change)

a[1] = "bb" #1번 인덱스의 요소를 "bb"로 변경
print(a)

# 1-2 추가(append)
a.append("g") #배열의 끝에 추가한다
print(a)

# 1-3 삽입(insert)
a.insert(3,"cc") #3번 인덱스 자리에 있던 요소들을 뒤로 밀고 삽입한다
print(a)

# 1-4-1 삭제1 (remove) : 내용
a.remove("cc") #해당 데이터와 일치하는 요소를 삭제
print(a)

# 1-4-2 삭제2 (delete) : 인덱스로 
del a[1] #1번째 인덱스에 있는 요소를 삭제
print(a)

#1-4-3 삭제3 (pop)
a.pop() #맨 끝 요소를 삭제
print(a)

#1-4-4 삭제4 (clear)
a.clear() #모든 요소를 삭제

# (2) 핸들링
# 2-1 핸들링 (loop)
b = ["tiger", "lion", "rabbit"]
for x in b: #?? 요소의 갯수만큼 프린트한건가?
    print(x) 

# 2-2 핸들링 (if)
if "lion" in b: #lion이 있다면
    print("사자가 있다")

# 2-3 핸들링 (len)
print(len(b)) #컬렉션의 사이즈

# 2-4 핸들링(copy)
bb = b.copy() # 복사는 하였지만 서로 다른 객체임
print(bb)
if bb is b: #복사한 bb는 b와 같지 않음
    print("같은 객체") 
else: 
    print("다른 객체") 
print()

# (3) 합치기
# 3-1 방법1
c1 = ["a", "b", "c"]
c2 = [10,20,30]
c= c1 + c2
print("c: ",c)

# 3-2 방법1
for x in c2:
    c1.append(x)
print("c1", c1)


c1 = ["a", "b", "c"]
c1.extend(c2) #extend() : 요소를 추가하여 배열을 확장
print("c1:", c1)
print()