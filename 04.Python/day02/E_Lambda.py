#Lambda
def m(n):
    return lambda a:a+n
lam1 = m(2)     # lam1 ->a+2
print(lam1(3))  # lam1 ->3+2 
print()

lam2 = m(3)
print(lam2(4))
    