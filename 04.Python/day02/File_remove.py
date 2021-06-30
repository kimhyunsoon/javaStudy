#파일삭제

import os

if os.path.exists("b.dump"):
    print("해당 파일 존재")
    os.remove("b.dump")
    print("파일 삭제 완료")
else:
    print("해당파일 존재하지 않음")