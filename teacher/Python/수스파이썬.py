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


3. 가상 환경 셋팅 
   (1) conda 가상환경(env) 생성( create )
       
	   1) 버젼 확인 
	      VScode의 Python창에서 
		  $> python --version

       2) VSCode에서 Command Prompt 열기 
	      $ conda create -n env_python python=3.8.8

	   3) 생성되는 위치 확인  
	       C:\Users\kosmo\anaconda3\envs
 