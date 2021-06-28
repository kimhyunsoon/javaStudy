#bool로 형변환하는 메소드 bool(), isinstance()

print(bool("")) #False : only empty String
print(bool("문자열"))

print(bool(0)) #False : 0일때 
print(bool(1))

print(bool([])) #False : 빈 배열일 때
print(bool(["가","나"]))

#bool이 False를 반환하는 예
print(bool(False))
print(bool(None))
print(bool(0))
print(bool(""))
print(bool({}))
print(bool([]))
print(bool(()))

def m1():
    return True;

if m1():
    print("T")
else:
    print("F")

print()
a=10
print(isinstance(a,int)) #객체가 클래스의 인스턴스인지 하위 클래스인지를 반환합니다. 