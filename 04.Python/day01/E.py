a = "안녕 반가워 파이썬"
print(a[-1]) #마지막 글자 출력
print()

print(a[0:2]) # 0 이상 2 미만
print()

print(a[-3:]) # -3 이상
print()

print(len(a)) #문자열의 길이
print()

b = "     안녕 방가워 파이썬   "
print(len(b.strip())) #strip() : 공백을 벗겨냄
print()

c = "Good Morning"
print(c.lower()) #lower() 전체 소문자로
print(c.upper()) #upper() 전체 대문자로
print()

d = "Black and Blue"
print(d.replace("Bl", "W")); #replace(a,b) a문자열을 b 문자열로 변경
print()

print(d.split(" ")) #split(str)  str기준으로 분리해서 출력 
print()