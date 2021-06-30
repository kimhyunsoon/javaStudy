# class 와 object 
class Human1:
    name = "길동"
h1 = Human1()
print(h1.name)

class Human2:
    def __init__(self, name, age): #self는 항상 앞에 옴
        self.name = name #자바에서 this 같은거
        self.age = age
    def m1(self):
        print("m1()")
    def m2(self, addr):
        self.addr = addr
        print("m2() name: ", self.name, "addr", addr)

h2 = Human2("이가은", 36)
h2.m1()
h2.m2("서울")
        
        
