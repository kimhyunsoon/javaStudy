import shutil, os

def deleteDir():
    print("삭제하실 디렉토리를 입력해주세요. : ", end='')
    text = input();
    text = text.strip();
    if os.path.isfile(text) or os.path.isdir(text) :
        print("정말 삭제할까요? (y/n) : ", end='');
        yn = input();
        if yn.strip() == 'y' :
            if os.path.isfile(text) :
                os.remove(text);
            else :
                shutil.rmtree(text)
        elif yn.strip() == 'n':
            print("프로그램을 종료합니다.")
        else :
            print("잘못된 입력입니다. 프로그램을 종료합니다.")
    else :
        print("잘못된 경로입니다. 다시 입력하시겠습니까? (y/n): ", end ='')
        yn2 = input();
        if yn2.strip() =='y' :
            deleteDir();
        elif yn2.strip() == 'n':
            print("프로그램을 종료합니다.")
        else :
            print("잘못된 입력입니다. 프로그램을 종료합니다.")
deleteDir();