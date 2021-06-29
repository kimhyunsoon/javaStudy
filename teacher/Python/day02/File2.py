# 파일 쓰기 
f = open("a.txt", "a", encoding="utf8") # 추가 
f.write("추가되는 문자열") 
f.close()


f = open("b.txt", "w", encoding="utf8") # (덮어)쓰기 
f.write("덮어쓴 문자열")
f.close()

# (1) 파일 읽기( 상태경로 ) 
#f = open("a.txt", "rt", encoding="utf8")  # "rt"는 디폴트값 
f = open("a.txt", "r", encoding="utf8")   
print(f.read())
f.close()
print()


# (2) 파일 읽기( 절대경로 )
f = open("C:\\SOO\\Java\\수스자바.java", "r") 
print(f.read())
f.close()
print()

# (3) 파일 읽기( 일부분만까지만 읽기 )
f = open("C:\\SOO\\Java\\수스자바.java", "r") 
print(f.read(100)) # 캐릭터(문자) 갯수 만큼 
f.close()
print()