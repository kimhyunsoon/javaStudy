# 상속( Inheritance )
class Human:
    def __init__(self, name):
        self.name = name
    def move(self):
        print("걷는다")

h = Human("길동")
print("h.name:",  h.name)
h.move()
print()

class Superman(Human):
    def __init__(self, name, power):
        #Human.__init__(self, name)  #방법1
        super().__init__(name) #방법2
        self.power = power

    def move(self):
        print("난다")
    def shotLaserBeam(self):
        print("광선을 쏘다")


s = Superman("클락", 100)
print("s.name:", s.name)
print("s.power:", s.power)
s.move()
s.shotLaserBeam()
print()

h = Human(s) # 형변환
print("h.name:", h.name) # java랑 다른데?  
#print("h.power:", h.power) # 불가
h.move() #걷는다 : java랑 다른데?   
#h.shotLaserBeam() # 불가
