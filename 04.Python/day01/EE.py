a = "자축인묘진사오미신유술해"
print(a[-1]) #맨 끝에 있는 글자 반환
print(a[0:3]) #0부터 3미만까지
print(a[:-3])
print(a[-3:]) 
print(len(a)) #len() 글자갯수

b = "    자축인묘진사오미신유술해    "
print(len(b.strip())) #strip() 앞뒤 공백이 제거된 문자열 반환

c= "Good Morning"
print(c.lower()) #전체 소문자
print(c.upper()) #전체 대문자

print(c.replace("Goo", "Ba")) #replace() old문자열의 모든 항목을 new로 대체한 문자열 반환
print(c.split()) #split() 구분자 문자열을 사용하여 문자열의 단어목록을 List[str]로 반환

e = "Co" not in c #not in, in <= 존재하는지 여부 검사
print(e)

#format()
f = "나는 이름이 {}이고 {}살이다"
print(f.format("가은","36"))
