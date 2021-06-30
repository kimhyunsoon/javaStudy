#1. 파일(original.txt)을 열어서 읽는다
fname = "original.txt"
f = open(fname, "r")
#print(f.readline()) # 한줄만 
#print(f.readlines()) # 줄바꿈기호를 포함한 list 
#print(f.read()) # 줄바꿈해서 

#2. 중복문제거를 위해서 컬렉션(set)에 담는다
#s = {} # 기본값이 dict으로 인식 
s = set()
while True:
    line = f.readline()
    if not line: break
    line = line.strip()
    #print(line)
    s.add(line)
f.close()

#3. set에서 list로 이동시킨다
li = []
for x in s:
    li.append(x)
#print(li)


#4. 게임시작을 알리는 Enter을 입력받으면, 랜덤한 문제를 출력한다 
import random
q = random.choice(li)
#print(q)

print("[타자 게임!! 준비되면 엔터!!]")
input()

import time
start = time.time()
print("시작시간:", start)

#5. 사용의 입력받고 -> 문제의 내용과 비교 -> 통과 or 재도전 
total = 3 # 맞추야 할 총 문제수
n = 1 # 문제번호 
while n<=total:
    print("#문제", n)
    print(q)
    x = input()
    if q == x:
        print("통과!")
        n+=1
        q = random.choice(li)
    else:
        print("오타! 다시 도전")

#6. 게임 시간을 체킹하여 걸린시간을 출력한다
end = time.time()
tt = end - start
tt = format(tt, ".2f")
print("걸린시간:", tt, "초")