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

e = "Bl" not in d #d에 Bl이 포함되어 있는가? java에서 contains 같은거
print(e)
e1 = "Bl" in d
print(e1)

f = "나는 이름이 {}이고, 나이는 {}살이다"
name = "가은"
age = 36
print(f.format(name,age)) #format() 맵핑하는 함수, 중괄호로 식별

g = "나는 이름이 {2}이고, 나이는 {1}살이며, {0}에 산다"
print(g.format("서울",36,"가은")) #중괄호 안에 있는 숫자는 인덱스이다

h = "나는 급여를 {:.2f}만원 받고 싶어"
print(h.format(456.789)) #float, 소숫점 밑 2자리까지

i = "나는 {com}의 {car}라는 차를 갖고 싶어"
print(i.format(com="테슬라", car="모델3"))

j = "\"이것은\" 참 귀하군요"
print(j)

#Escape Characters => \" , \' , \\ , \n , \t , \r , \b 