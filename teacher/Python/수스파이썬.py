[ 수스 파이썬 ]

1. 아나콘다 설치 
   URL) https://www.anaconda.com/products/individual
   블로그) https://needjarvis.tistory.com/563
   
2. 개발 환경 설명 
   (1) Anaconda : Python + 기본 Lib 
   (2) Editor 
       - VSCode ( Editplus + Eclipse ) by MS 
	   - Pycham ( Eclipse ) by jetbrains 

3. VSCode 단축키
   (1) VSCode 설치 
       URL) https://code.visualstudio.com/
       블로그) https://mylogcenter.tistory.com/7
        
   (2) VSCode 필수 설치 plugin
	    - Python
	    - Python for VSCode 
	    - Python Extension Pack 
	    - Korean Language Pack 
	    - Code Runner

   (3) 단축키 
        - Ctrl + Shift + P : Select Interpreter 
        -  Ctrl + , : Settings ( font size , zoom , .. )

        블로그) https://developer-theo.tistory.com/entry/VSCode-%EA%B8%B0%EB%B3%B8-%EC%82%AC%EC%9A%A9%EB%B2%95


4. 가상 환경 셋팅 
   (1) conda 가상환경(env) 생성( create )
       
	   1) 버젼 확인 
	      VScode의 Python창에서 
		  $ python --version

       2) 생성  
	      VSCode에서 Command Prompt 열기 
	      $ conda create -n env_python python=3.8.8
		  
		  예) (base) C:\SOO\Python\day01>conda create -n env_python python=3.8.8

	   3) 생성되는 위치 확인  
	      C:\Users\kosmo\anaconda3\envs\env_python


   (2) conda 가상환경 조회 
       $ conda env list 
  
   (3) conda 가상환경 내 package 목록/버젼 확인 
       $ conda list -n env_python
	    
	   예) (base) C:\SOO\Python\day01>conda list -n env_python

   (4) VSCode에서 가상환경 선택 
       Ctrl + Shift + P: Select Interpreter 에서 오른쪽 상단의 Refresh아이콘 
       -> env_python 확인 -> 선택 
	      
   (5) conda 가상환경 핸들링  
       1) 활성화 
	      $ conda activate env_python

	   2) 비활성화
	      $ conda deactivate

	   3) 제거 
	      $ conda remove --name env_python --all

		  디렉토리 삭제) 탐색기에서 C:\Users\kosmo\anaconda3\envs\env_python 삭제! 

5. 파이썬 실행 
   (1) VSCode에서 실행 
	   1) day01/hello.py 작성 
	   2) 실행버튼(오른쪽 상단) -> Run Python File in Terminal

   (2) 명령프롬프트(cmd)에서 작성/실행 
       1) 가상환경 활성화 
	      day01>conda activate env_python

       2) 파이썬 작성 
	      day01>python 
	      >>> print('방가 파이썬')
		  >>> exit()

	   cf) 파이썬파일 실행 
	      day01>python hello.py

6. Built-in Data Types 
   (1) Text: str 
   (2) Numeric: int, float, complex 
   (3) Sequence: list, tuple, range 
   (4) Mapping: dict 
   (5) Set: set, frozenset
   (6) Boolean: bool 
   (7) Binary: bytes, bytearray, memoryview 
   
       
		
       
 