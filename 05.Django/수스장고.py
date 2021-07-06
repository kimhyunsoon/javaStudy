[ 수스 장고 ]

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
        - Ctrl + , : Settings ( font size , zoom , .. )

        블로그) https://developer-theo.tistory.com/entry/VSCode-%EA%B8%B0%EB%B3%B8-%EC%82%AC%EC%9A%A9%EB%B2%95


4. 가상 환경 셋팅 
   (1) conda 가상환경(env) 생성( create )
       
	   1) 버젼 확인 
	      VScode의 Python창에서 
		  $ python --version

       2) 생성  
	      VSCode에서 Command Prompt 열기 
		  C:\SOO\Django\ch3>conda activate base

	      $ conda create -n env_django python=3.8.8
		  
		  예) (base) C:\SOO\Python\day01>conda create -n env_django python=3.8.8

	   3) 생성되는 위치 확인  
	      C:\Users\kosmo\anaconda3\envs\env_django


   (2) conda 가상환경 조회 
       $ conda env list 
  
   (3) conda 가상환경 내 package 목록/버젼 확인 
       $ conda list -n env_django
	    
	   예) (base) C:\SOO\Python\day01>conda list -n env_django

   (4) VSCode에서 가상환경 선택 
       Ctrl + Shift + P: Select Interpreter 에서 오른쪽 상단의 Refresh아이콘 
       -> env_django 확인 -> 선택 
	      
   (5) conda 가상환경 핸들링  
       1) 활성화 
	      $ conda activate env_django

	   2) 비활성화
	      $ conda deactivate

	   3) 제거 
	      $ conda remove --name env_django --all

		  디렉토리 삭제) 탐색기에서 C:\Users\kosmo\anaconda3\envs\env_django 삭제! 

5. 장고 설치/삭제 
   (1) 설치 
       1) django 버젼 확인
	      (env_django)$ python -m django --version 
	   2) django 인스톨
	      (env_django)$ python -m pip install Django
	   3) django 설치 디렉토리 확인
	      (env_django)$ python -c "import django; print(django.__path__)"

		 ex1:글로벌) C:\Users\kosmo\Anaconda3\Lib\site-packages\django
		 ex1:로컬) C:\Users\kosmo\anaconda3\envs\env_django\Lib\site-packages\django
	      
   (2) 삭제 
       1) django 삭제
	      <1> 글로벌 
	          (base)$pip uninstall Django
	      <2> 로컬 
		      (env_django)$pip uninstall Django -y
			
	   2) 모든 패키지 삭제
	      <1> 가상환경 내 package 목록/버젼 확인 ( 15개 확인 ) 
              (env_django)~$conda list -n env_django 
	      <2> requirement.txt 제작
		      (env_django)~$pip freeze > requirement.txt
		  <3> package 삭제 ( -r: 파일목록지정, -y: yes/no묻지말고 ) 
		      (env_django)~$pip uninstall -r requirement.txt -y
		  <4>가상환경 내 package 목록/버젼 확인 ( 10개 확인 )
              (env_django)~$conda list -n env_django

	   3) 모든 패키지 설치 
	      <1> requirement.txt 목록의 package 설치 
		      (env_django)~$pip install -r requirement.txt
		  <2> 가상환경 내 package 목록/버젼 확인 ( 15개 확인 ) 
              (env_django)~$conda list -n env_django

   (3) 장고 버젼 업그레이드 
       1) 업그레이드 
          (env_django)$python -m pip install Django --upgrade
       2) 버젼 확인 
	      (env_django)$python -m django --version

		
	   참고) pip 버젼 업그레이드 
		  (env_django)~$python -m pip install --upgrade pip


######################### Chapter 03 #########################
6. MVT 모델 작성 순서 ( p104 )
   (1) 프로젝트 뼈대 생성: 디렉토리와 파일들 
   (2) 설정: settings.py
   (3) DB table생성: db.sqlite3
   (4) 관리자생성: khs/1234
   (5) 모델: models.py, admin.py
   (6) URLconfig: urls.py
   (7) 템플릿: templates/*.html
   (8) 뷰: views.py 

# 2. polls
7. 장고 프로젝트/앱 생성 
   (1) 프로젝트 생성 ( p109 )
       (env_django)ch3$django-admin startproject mysite

	   1) 상위의 mysite하위의 mysite와 manage.py를 잘라내기 
	   2) 상위의 mysite에 덮어쓰기

   (2) 애플리케이션 생성 ( p110 )
       (env_django)ch3$python manage.py startapp polls

   (3) p107의 그림과 비교! 

8. mysite/settings.py 설정 ( p112 ) 
   (1) ALLOWED_HOSTS 추가 ( 서버의 IP 나 domain ) 
       ALLOWED_HOSTS = ['192.168.0.143', 'localhost', '127.0.0.1']
   (2) INSTALLED_APPS 추가
       INSTALLED_APPS = [ 기존것들.. , 'polls.apps.PollsConfig',]
   (3) DATABASES 변경( os.path.join ) 
        import os #추가 

        DATABASES = { # 수정 
			'default': {
				'ENGINE': 'django.db.backends.sqlite3',
				'NAME': os.path.join(BASE_DIR / 'db.sqlite3'),
			}
		}
   (4) TIME_ZONE 수정 
       TIME_ZONE = 'Asia/Seoul'

9. DB table 생성/확인
   (1) 생성 
       (env_django)~\ch3>python manage.py migrate
   (2) 확인 
       ~ch3/db.sqlite3 

10. 서버 실행
   (1) (env_django) ~\ch3>python manage.py runserver 0.0.0.0:8000
   (2) web browser 서비스 확인 ( 작동에러면.. port를 변경해서 시도 )
       http://127.0.0.1:8000/
   (3) 중지: Ctrl + C
   (4) 계정 생성
       1) 로그인 페이지 
	      http://127.0.0.1:8000/admin
	   2) 위의 로그인 페이지에 로긴할 관리자 계정 생성 
	      (env_django) ~\ch3>python manage.py createsuperuser
          - Username (leave blank to use 'kosmo'): khs
		  - Email: khsoo1128@nate.com
		  - Password: 1234
		  - Password (again): 1234
		  - [y/N]: y
	   3) 위의 관리자 계정으로 로긴 
	      http://127.0.0.1:8000/admin

11. 모델 생성 ( DB Table 도 생성됨 ) 
   (1) polls/models.py 편집 

       
   
 


			 
		  

			

		
   