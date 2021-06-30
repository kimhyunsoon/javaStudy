import os
def listDir(dir):
    childs = os.listdir(dir)
    for child in childs:
        if os.path.isfile(dir+"\\"+child):
            print("[F]", child)
        else:
            print("[D]", child)

target = input("리스팅할 디렉토리")
            
        
    