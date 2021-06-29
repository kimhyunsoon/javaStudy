#while 문
a = -1
while a<5:
    a+=1 # a를 1씩 증가시킴
    #if a==2: continue  #2일때 건너뜀
    if a==2: break      #2이면 종료하고 나옴
    print (a)
    
b=0
while b<5:
    print(b)
    b+=1
else:
    print ("더이상 5보다 작지 않음") #빠져 나오면서 수행