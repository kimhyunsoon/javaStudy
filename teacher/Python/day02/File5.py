# 디렉토리 삭제 
import os

dir = "a/b/c"
if os.path.exists(dir):
    print("해당 디렉토리 존재함")
    os.removedirs(dir)
    print("해당 디렉토리 삭제됨")
else:
    print("해당 디렉토리 존재하지 않음")
    