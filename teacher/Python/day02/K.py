# Exception 
# (1) 예외처리 
try:
    f = open('myfile.txt')
    s = f.readline()
    i = int(s.strip())
except OSError as ose:
    print("OSError 발생 ose:", ose)
except ValueError:
    print("숫자형태의 데이터가 아니네요")
except:
    print("위의 OSError 이외의 예외 발생")
finally:
    print("항상 수행되는 절")


#(2) 예외발생 
flag = True
def m1():
    if flag:
        raise Exception("Soo's Exception")

try:
    m1()
    print("예외 발생 안함")
except:
    print("예외 발생 함")