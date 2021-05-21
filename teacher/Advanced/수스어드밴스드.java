1. IO ( Input Output )
	(1) ��Ʈ��( Stream ): '�������� �帧' 
	    Data Source(�ٿ���) ----> Data Destination(������)

    (2) ��Ʈ�� Ư¡
	     1) FIFO ( First In First Out ) 
		 2) ������ 
		 3) �ܹ��⼺ 
		 4) ������ 

    (3) ǥ���Է� / ǥ����� 
	    Ű����(System.in)  ---> �����(System.out)

		ex) day01/A.java 
     
	(4) ���� 
	     1) ���۴���
		    <1> ����Ʈ ��Ʈ�� ( 1 byte Stream )
			    ex) XXXStream
				
		    <2> ���� ��Ʈ�� ( 2 byte Stream )
			    ex) XXXReader, XXXWriter 

		 2) Ư�� 
		    <1> �ٺ� ��Ʈ�� ( Node Stream )

		    <2> �ٸ� ��Ʈ�� ( Bridge Stream )
			    ex) InputStreamReader, OutputStreamWriter

		    <3> ����(����) ��Ʈ�� ( Filter Stream )
			    ex) BufferedReader, PrintWriter, ... 

		 3) ����� 
		    <1> �Է� ��Ʈ��  
			    ex) XXXInputStream, XXXReader 

			<2> ��� ��Ʈ�� 
			    ex) XXX(Output)Stream, XXXWriter 

		 ex) day01/A.java 
  
  	 (5) �ֿ� ��Ʈ�� Ŭ����  
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

     (6) �ֿ� Ŭ���� 
		 File : File�� Dir�� �𵨸� 
		      ex) day02/D.java 

2. Network 
     (1) TCP(Transmission Control Protocol): ����������������(�ŷڼ�/�ǽð�)  
           ( ex:��ȭ, �޽���, .. ) 

		   ex) day03/AServer.java, AClient.java 

	 (2) UDP(User Datagram Protocol): �񿬰�������������(��ŷڼ�)    
           ( ex:����, ����, ���ͳݹ��,.. )