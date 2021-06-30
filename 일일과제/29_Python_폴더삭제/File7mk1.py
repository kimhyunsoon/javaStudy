import os

def deleteRe(dir):
    if os.path.isfile(dir) :
        os.remove(dir);
    elif(os.path.isdir(dir)):
        list = os.listdir(dir);
        for i in list :
            deleteRe(dir+'/'+i);
        os.rmdir(dir)

            
def deleteDir():
    text = input("삭제하실 디렉토리를 입력해주세요. : ")
    text = text.strip();
    if os.path.isfile(text) or os.path.isdir(text) :
        yn = input("정말 삭제할까요? (y/n) : ");
        if yn.strip() == 'y' :
            deleteRe(text)
        elif yn.strip() == 'n':
            print("프로그램을 종료합니다.")
        else :
            print("잘못된 입력입니다. 프로그램을 종료합니다.")
    else :
        yn2 = input("잘못된 경로입니다. 다시 입력하시겠습니까? (y/n): ");
        if yn2.strip() =='y' :
            deleteDir();
        elif yn2.strip() == 'n':
            print("프로그램을 종료합니다.")
        else :
            print("잘못된 입력입니다. 프로그램을 종료합니다.")
deleteDir();
 



