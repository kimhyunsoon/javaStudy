import os
dir = "1st/2nd/3rd"
try:
    if not os.path.exists(dir):
        print("디렉토리 존재하지 않음")
        os.makedirs(dir)
        print(0)
except OSError as ose:
    print("디렉토리 생성 실패 ose: ",ose)