# Iterator
a = ["tiger", "lion", "rabbit", "deer"]

# 방법1
it = iter(a) # list -> iter 
print(next(it))
print(next(it))
print(next(it))
print(next(it))
print()

# 방법2
for x in it:
    print(x)
