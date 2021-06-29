# Lambda 식 
def m(n):
    return lambda a: a+n

lam1 = m(2)
print(lam1(3))
print()

lam2 = m(3)
print(lam2(4))