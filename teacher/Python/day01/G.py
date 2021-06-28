# Operators
# (1) 산술  
a = 1/2 #몴: float  
print("a:", a)
print("int(a):", int(a))
print()

b = 1//2 #몴: int
print("b:", b)
print()

c = 2**3; #승 
print("c:", c)
print()

#(2) 논리 
d = True and True 
print("d:", d)
e = True or False
print("e:", e)
f = not True
print("f:", f)
print()

#(3) Identity ( is , is not )  
g = "김치"
h = 10
#i = g == h;
i = g is not h; # the same object ? 
print("i:", i);
print()

#(4) Membership ( in, not in )
li = ["a", "b", "c"]
j = "d" not in li;
print("j:", j)
print()