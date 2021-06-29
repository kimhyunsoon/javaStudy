# Scope : global ( 멤버로 영역이 승격 )
def m1(): # Outter Function 
    global a
    a = 1
    def m2(): # Inner Function 
        global b
        b = 2 
        print("a:", a, "b:",b)
    m2()
m1()

print("a:", a)
print("b:", b)