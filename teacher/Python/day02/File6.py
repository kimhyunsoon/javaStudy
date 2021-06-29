# 디렉토리 리스팅 
import os

'''
dir = "C:\\SOO\\Python\\day02"
childs = os.listdir(dir)
#print("childs: ", childs)
for child in childs:
    if os.path.isfile(dir+"\\"+child):
        print("[F] ", child)
    else:
        print("[D] ", child)
'''

def listDir(dir):
    childs = os.listdir(dir)
    for child in childs:
        if os.path.isfile(dir+"\\"+child):
            print("[F] ", child)
        else:
            print("[D] ", child)


target = input("리스팅할 디렉토리:")

if os.path.exists(target):
    if os.path.isdir(target):
        listDir(target)
    else:
        print(target+"은 디렉토리가 아님")
else: 
    print(target+"이란 디렉토리 존재 하지 않음")