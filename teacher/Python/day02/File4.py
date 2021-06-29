# 디렉토리 생성 
import os

dir = "a/b/c"
try:
    if not os.path.exists(dir):
        print("디렉토리 존재하지 않음")
        os.makedirs(dir)
        print("디렉토리 생성 완료")
except OSError as ose:
    print("디렉토리 생성 실패 ose:", ose)



