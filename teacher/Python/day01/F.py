# bool로 형변환하는 메소드 bool() , isinstance()

print(bool("")) # False : only empty string 
print(bool("문자열"))
print()

print(bool(0)) #False : only 0
print(bool(2))
print()

print(bool([])) #False : only empty ones 
print(bool(["가", "나"]))
print()

#False를 리턴하는 예 
print(bool(False))
print(bool(None))
print(bool(0))
print(bool(""))
print(bool([])) 
print(bool(())) 
print(bool({}))
print()


def m1():
    return True;

if m1():
    print("T")
else:
    print("F")
    
print()

a = 10
print(isinstance(a, int)) 
