#for문 
animals = ["tiger", "lion", "rabbit", "mouse"]

for x in animals:
    if x=="rabbit": continue #break
    print(x)
print()

for c in "tiger":
    print(c)
print()

for x in range(5):
    print(x)
print()

for x in range(1,5):
    print(x)
print()

for x in range(0, 5, 2):
    print(x)
else: 
    print("end")
print()


a = ["a", "b", "c"]
b = ["A", "B", "C"]
for x in a:
    for y in b:
        print(x, y)
print()

for x in ["AA", "BB", "CC"]:
    print(x)
print()

m = {"k1":"AAA", "k2":"BBB", "k3":"CCC"}
#방법1
for x in m:
    print(x, m[x])
print()
#방법2
for x, y in m.items():
    print(x, y)