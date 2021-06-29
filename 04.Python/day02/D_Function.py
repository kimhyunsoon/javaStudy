# function
def m1():
    print("function")
m1() #펑션 호출

def m2(name, age): #파라미터
    print ("name: ", name , "age: ", age)
m2("가은", 36)
m2("순이", 29)    

def m3(*args): #list
    print(args[2]) #index 2 의 인자
    for x in args: #모든 인자 출력
        print(x) 
m3("짜장", "짬뽕", 3000)

def m4(**args): #dict
    print(args["name"], args["age"], args["addr"])
m4(name = "이가은", age = 36, addr = "서울")
    

def m5(args1, args2, args3):
    print(args1, args2, args3)
m5(args3 = "가은", args1 = "순이", args2 = "똥이") #순이, 똥이, 가은

def m6(arg = "댕댕이"):
    print(arg)
m6()
m6("냥아치") 

def m7(animals): #arguments에 컬렉션을 넣을 수 있음
    for x in animals:
        print(x)
animals = ["tiger", "lion", "rabbit", "mouse"]
m7(animals)
    
def m8(a,b):
    return a+b
print (m8(10,20))

def m9():
    pass
print("끝!")
        