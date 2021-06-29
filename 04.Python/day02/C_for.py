# for문
animals = ["tiger", "lion", "rabbit", "mouse"]

for x in animals:
    if x=="rabbit": 
        #continue #건너뜀
        break #래빗 만나면 멈추고 나옴
    print(x)

for c in "tiger": #char 다 뽑을 수 있음
    print (c)

for x in range(5): #0 이상 5 미만
    print (x)
for x in range(1,5): #1 이상 5 미만
    print(x)

for x in range(0,5,2): #2씩 증가
    print(x)
else:
    print ("end")

a = ["a", "b", "c"]
b = ["A", "B", "C"]

for x in a:
    for y in b:
        print (x,y) #이중 for문

for x in ["AA", "BB", "CC"]:
    print(x)

m = {"k1":"AAA", "k2":"BBB", "k3":"CCC"}
#방법1

for x in m:
    print(x, m[x])

#방법2

for x,y in m.items():
    print (x,y)