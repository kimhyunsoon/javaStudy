# class 와 object 
class Human1:
    name = "길동"

h1 = Human1()
print(h1.name)
print()


class Human2:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def m1(self):
        print("m1()")
    
    def m2(self, addr):
        self.addr = addr
        print("m2() name:", self.name, "addr:", addr)

h2 = Human2("이순신", 24)
h2.m1()
h2.m2("서울")
print("속성값(1)=> ",h2.name, h2.age, h2.addr)
h2.addr = "부산"
print("속성값(2)=> ",h2.name, h2.age, h2.addr)
del h2.addr #멤버 삭제 
print("속성값(3)=> ",h2.name, h2.age) #h2.addr는 사용불가!
del h2 #객체 삭제   


class Human3:
    pass