# 파일 생성 & 파일 권한
'''
open(file,mode)
    file : 열 파일의 이름을 제공하는 텍스트
    mode : 파일이 열리는 모드를 지정하는 선택적 문자열

    "r": open for reading (default) 
    "w": open for writing, truncating the file first
    'x'	create a new file and open it for writing
    'a'	open for writing, appending to the end of the file if it exists 
        (파일의 마지막에 새로운 내용을 추가 시킬 때 사용)
    
    'b'	binary mode (원시 바이트 읽기 및 쓰기)
    't'	text mode (default)
    '+'	open a disk file for updating (reading and writing)
    "b": Binary 

'''


f1 = open("a.txt", "xt") #open(file,mode) 
f2 = open("b.dump", "xb")
print("파일 생성 완료")