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
		  - C:\SOO\Django\ch3>conda activate base
	      - $ conda create -n env_django python=3.8.8
		  
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

# app1: polls
7. 장고 프로젝트/앱 생성 
   (1) 프로젝트 생성 ( p109 )
       (env_django)~\ch3>django-admin startproject mysite

	   1) 상위의 mysite하위의 mysite와 manage.py를 잘라내기 
	   2) 상위의 mysite에 덮어쓰기

   (2) 애플리케이션 생성 ( p110 )
       (env_django)~\ch3>python manage.py startapp polls

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

11. 모델 생성 ( DB Table 도 생성 ) 
   (1) polls/models.py 편집 ( p120 )
   (2) polls/admin.py 편집 ( p121 )
   (3) DB변경사항 반영 ( p122 )
       1) db.sqlite3 파일 사이즈 확인 ( 오른쪽 마우스의 속성 ) : 128KB 

       2) cmd창에서 
          (env_django) ~\ch3>python manage.py makemigrations 
	      (env_django) ~\ch3>python manage.py migrate

	   3) db.sqlite3 파일 사이즈 확인 ( 오른쪽 마우스의 속성 ) : 140KB

   (4) Model 작업 확인 
       1) 서버 재실행 
          (env_django) ~\ch3>python manage.py runserver 0.0.0.0:8000

	   2) 브라우져 확인 
	      <1> http://127.0.0.1:8000/admin/  
          <2> POLLS 서비스 생성 확인 
		  <3> CRUD 테스트 
		      - POLLS/Questions
			  - POLLS/Choices 
     
12. URLconfig ( p126 )
    (1) polls/urls.py 편집 
	   
    (2) mysite/urls.py 편집 

13. 템플릿&뷰 생성 ( p130 )  
    (1) polls/views.py 편집 

    (2) polls/templates/polls/*.html 편집 

	(3) 웹브라우져에서 테스팅 
	    1) 데이터 입력 
			<1> http://127.0.0.1:8000/polls/
				-> No question data
			<2> http://127.0.0.1:8000/admin
				1> Questions +Add클릭  
					- What is your hobby? -> Save and add another버튼
					- Who do you like best ?  -> Save and add another버튼
					- Where do you live ? -> Save버튼

				2> Choices +Add클릭
					- Reading -> Save and add another버튼
					- Soccer -> Save and add another버튼
					- Climbing -> Save버튼
 
		2) polls 서비스 테스트 
		     http://127.0.0.1:8000/polls/

######################### Chapter 04 #########################     
사전준비) ch3 쏘스복사해서 ch4 만들기 

14. Admin 사이트 꾸미기 
    (01) 확인 
	    - polls/models.py 와 실행화면 비교 
    (02) 필드 순서 변경  
	    - polls/admin.py 수정 ( p155 )
    (03) 필드 분리 
        - polls/admin.py 수정 ( p156 )
	(04) 필드 접기 
        - polls/admin.py 수정 ( p157 )
    (05) Choice 필드 순서 변경 
	    - polls/models.py에서.. 
	      question = models.ForeignKey(Question, on_delete=models.CASCADE) #맨위로 
	(06) 한 화면에서 Question과 Choice 같이 입력하게 하기   
	    - polls/admin.py 수정 ( p159 )
    (07) 테이블 모양 변경  
        - polls/admin.py 수정 ( p160 )
    (08) 등록 날짜까지 listing 되게 하기 
        - polls/admin.py 수정 ( p162 상단 )
    (09) 필터 적용하기  
        - polls/admin.py 수정 ( p162 하단 )
    (10) 검색 
        - polls/admin.py 수정 ( p163 ) 

	(11) admin의 Wellcome 페이지 수정 
	    1) mysite/settings.py 수정 ( p165 )
		   - 수정 
		     'DIRS': [os.path.join(BASE_DIR, 'templates')],
		   - 서버 다시 켜야 함( settings.py 가 변경될 때 마다 )

		2) templates/admin/base_site.html 생성 ( p166 )
		   - 탐색기의 C:\Users\kosmo\anaconda3\envs\env_django 에서 
		     'base_site.html'를 검색 -> 내용 복사 -> 붙여넣기   
		   - 수정 
		     <h1 id="site-name"><a href="{% url 'admin:index' %}">KHS Admin INDEX</a></h1>

		3) 테스트 
		   http://127.0.0.1:8000/admin/ 

   
15. 데이터 조작하기
    (01) 쉘열기 ( p167 )
	    (env_django) C:\SOO\Django\ch4>python manage.py shell

	(02) 데이터 생성 ( p168 )
	    >>>from polls.models import Question, Choice
	    >>>from django.utils import timezone
	    >>>q = Question(question_text="What's new?", pub_date=timezone.now())
	    >>>q.save()

	(03) 데이터 조회 ( p169 )
	    1) 모든 
	       >>>Question.objects.all() 

	    2) 필터
           >>>Question.objects.filter(question_text__startswith='당신의')

        3) 범위 
	       >>>Question.objects.all()[:2]
	       >>>Question.objects.all()[2:4]
	       >>>Question.objects.all()[:6:2] # [시작idx: 끝idx :스텝]  

    (04) 데이터 수정 ( p170 중간 )
		 >>>Question.objects.filter(question_text__startswith='어디에').update(question_text='Where do you live ?')
		 >>>Question.objects.filter(question_text__startswith='What').update(question_text='What is your job ?')

    (05) 데이터 삭제 ( p170 하단 )
	    1) 1개 
		    >>>one_entry = Question.objects.get(pk=4) 
            >>>one_entry.delete()
        2) n개 
		    >>>Question.objects.all()
		    >>>Question.objects.filter(pub_date__day=7).delete()
			>>>Question.objects.all()
			
		3) 모든 
		    >>>Question.objects.all()
		    >>>Question.objects.all().delete()
			>>>Question.objects.all()



######################### Chapter 05 ######################### 		   
사전준비) ch4 쏘스복사해서 ch5 만들기 
# app2: books 

16. books앱 추가 
    (1) 앱 생성 ( p224 ) 
	   (env_django)~ch5>python manage.py startapp books

	(2) 앱 등록 ( p255 )
	   - mysite/settings.py를 열고 다음을 추가 

	   INSTALLED_APPS = [
		  기존 것들.. 
		  'books.apps.BooksConfig',
	   ]

17. 모델 생성 ( p226 ) 	   
    (1) books/models.py 편집 ( p226 ) 
	(2) books/admin.py 편집 ( p227 )
	(3) DB변경사항 반영 ( p228 상단 )
        1) db.sqlite3 파일 사이즈 확인 ( 오른쪽 마우스의 속성 ) : 140KB

        2) cmd창에서 
           (env_django) ~\ch5>python manage.py makemigrations 
	       (env_django) ~\ch5>python manage.py migrate

	    3) db.sqlite3 파일 사이즈 확인 ( 오른쪽 마우스의 속성 ) : 176KB 

    (4) Model 작업 확인
        1) 서버 재실행 
          (env_django) ~\ch5>python manage.py runserver 0.0.0.0:8000
        2) 브라우져 확인 
	       <1> http://127.0.0.1:8000/admin/  
           <2> BOOKS 서비스 생성 확인 
		   <3> CRUD 테스트 
		       - BOOKS/Publishers
			   - BOOKS/Authors
			   - BOOKS/Books

18. URLconfig 
    (1) books/urls.py 편집 ( p229 )
	       
    (2) mysite/urls.py 편집( p228 하단 ) 
    
        
/////////////////////////////// 아래 참조 /////////////////////////////  
12.  ( p126 )
    (1) polls/urls.py 편집 
	   
    (2) mysite/urls.py 편집 

13. 템플릿&뷰 생성 ( p130 )  
    (1) polls/views.py 편집 

    (2) polls/templates/polls/*.html 편집 

	(3) 웹브라우져에서 테스팅 
	    1) 데이터 입력 
			<1> http://127.0.0.1:8000/polls/
				-> No question data
			<2> http://127.0.0.1:8000/admin
				1> Questions +Add클릭  
					- What is your hobby? -> Save and add another버튼
					- Who do you like best ?  -> Save and add another버튼
					- Where do you live ? -> Save버튼

				2> Choices +Add클릭
					- Reading -> Save and add another버튼
					- Soccer -> Save and add another버튼
					- Climbing -> Save버튼
 
		2) polls 서비스 테스트 
		     http://127.0.0.1:8000/polls/
	     
       
       

       
   
 


			 
		  

			

		
   