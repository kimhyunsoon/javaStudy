# set ( 중복허용X, 순서보존X )

a = {"a", "b", "c", "a"}
print(a)
# 인덱스로 추출하는 방법은 안됨. index가 없음

# (1) Element 핸들링 
# 1-1 변경( change ) <-안됨

# 1-2 추가1(add)
a.add("tiger")
print(a) # 세트에 요소 추가

# 1-3 추가2(update)
a.update({"lion", "rabbit"}) # set update
print(a)

# 1-4-1 삭제 1 (remove) : 내용
a = {"a", "b", "c"}
a.discard("c") #구성원인 경우 집합에서 요소를 제거. 해당 요소가 없는 경우 아무 작업도 수행X
print(a)

# 1-4-2 삭제2 (pop)
a.pop() #임의의 집합 요소를 제거하고 반환
print(a)

# 1-5 전체 요소 삭제 
a.clear()
print(len(a))

# (2) 핸들링 
# 2-1 핸들링 ( loop )

b = {"tiger", "lion", "rabbit"}
for x in b:
    print(x)

# 2-2 핸들링 ( if )
if "lion" in b:
    print("사자가 있음")

# len()과 copy() 리스트와 동일

# (3) 합치기
# 3-1 방법1 : union() 집합의 합집합을 새 집합으로 반환
c1 = {"a","b","c"}
c2 = {10,20,30}

c = c1.union(c2)
print(c)

# 3-2 방법2
for x in c2:
    c1.add(x)
print (c1)