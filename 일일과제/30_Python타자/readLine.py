import random
import time

fname = "original.txt"
f = open(fname, "r")
# print(f.read())

s = set()
# print(s)

while True:
    line = f.readline()
    if not line: break
    line = line.strip()
    s.add(line)
f.close()

# print(s)
slist = list(s)
# print(slist)

n = 1                                   
print("[타자 게임] 준비되면 Enter!")
input()                                
start = time.time()                    
 
q = random.choice(slist)                  
while n <= 5:                         
    print("문제)", n,"",q)
    x = input()                        
    if q == x:                        
        n = n + 1                     
        q = random.choice(slist)            
    else:
        print("오타! 다시 도전!")
 
end = time.time()                      
tt = end - start                       
tt = format(tt, ".2f")                
print("걸린시간:", tt, "초")

