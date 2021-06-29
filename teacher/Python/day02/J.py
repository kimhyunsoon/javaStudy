# 모듈 사용 

# (1) 내가 만든 모듈 사용 
import aa.jmodule as jm

jm.hi("철수") # function 호출
print()

print("jm.i:", jm.i)
print()

for x in jm.animals:
    print(x)
print()

# 방법1
for k in jm.man:
    print(k, jm.man[k])
print()

# 방법2
for k, v in jm.man.items():
    print(k, v)
print()

# (2) 남이 만든 모듈
import platform
x = platform.system();
print(x)