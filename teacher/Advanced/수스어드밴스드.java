1. IO ( Input Output )
	(1) 스트림( Stream ): '데이터의 흐름' 
	    Data Source(근원지) ----> Data Destination(목적지)

    (2) 스트림 특징
	     1) FIFO ( First In First Out ) 
		 2) 지연성 
		 3) 단방향성 
		 4) 유연성 

    (3) 표준입력 / 표준출력 
	    키보드(System.in)  ---> 모니터(System.out)

		ex) day01/A.java 
     
	(4) 구분 
	     1) 전송단위
		    <1> 바이트 스트림 ( 1 byte Stream )
			    ex) XXXStream
				
		    <2> 문자 스트림 ( 2 byte Stream )
			    ex) XXXReader, XXXWriter 

		 2) 특성 
		    <1> 근본 스트림 ( Node Stream )

		    <2> 다리 스트림 ( Bridge Stream )
			    ex) InputStreamReader, OutputStreamWriter

		    <3> 목적(응용) 스트림 ( Filter Stream )
			    ex) BufferedReader, PrintWriter, ... 

		 3) 입출력 
		    <1> 입력 스트림  
			    ex) XXXInputStream, XXXReader 

			<2> 출력 스트림 
			    ex) XXX(Output)Stream, XXXWriter 

		 ex) day01/A.java 
  
  	 (5) 주요 스트림 클래스  
	     1) InputStream / OutputStream 
              ex) day01/B.java      
			
		 2) FileInputStream / FileOutputStream 
		      ex) day01/C.java

		 3) BufferedInputStream / BufferedOutputStream 
		      ex) day01/D.java 

	     4) DataInputStream / DataOutputStream 
		      ex) day02/A.java 

		 5) Reader / Writer 
		      ex) day02/B.java 

		 6) FileReader / FileWriter 
		      ex) day02/B.java 

	     7) BufferedReader / PrintWriter
		      ex) day02/C.java 

     (6) 주요 클래스 
		 File : File과 Dir를 모델링 
		      ex) day02/D.java 

2. Network 
     (1) TCP(Transmission Control Protocol): 연결지향프로토콜(신뢰성/실시간)  
           ( ex:전화, 메신져, .. ) 

		   ex) day03/AServer.java, AClient.java 

	 (2) UDP(User Datagram Protocol): 비연결지향프로토콜(비신뢰성)    
           ( ex:편지, 쪽지, 인터넷방송,.. )