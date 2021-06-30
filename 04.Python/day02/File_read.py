#파일 쓰기
#f1 = open("a.txt", "xt")
f = open("a.txt", "a", encoding="utf-8") #추가
f.write("추가되는 문자열")
f.close()

f = open("b.txt", "w", encoding="utf-8")
f.write("덮어쓴 문자열")
f.close()

#(1) 파일 읽기 (상대경로)
f = open("original.txt", "r")
print(f.read(100)) #전체 다 읽음
print(f.readline()) #한 줄만 읽음
print(f.readlines()) #list 형태로 출력
f.close()

# (2) 파일 읽기 (절대경로)
f = open("C:\KAEUN\gitStudy\original.txt")

