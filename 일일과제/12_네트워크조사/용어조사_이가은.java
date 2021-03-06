1. 서버(Server)
서버는 클라이언트에게 네트워크를 통해 정보나 서비스를 제공하는 컴퓨터 시스템으로 
컴퓨터 프로그램(server program) 또는 장치(device)를 의미한다. 

서비스를 제공하는 server program(SW) + Computer(HW)



2. 요청(request) : 서비스를 요구하는 행위
: 클라이언트(브라우저)를 통해 서버에 어떤 정보를 요청하는 정보를 담고있는 객체
	- 사용자의 요청에 관련된 정보를 얻기 위해 사용하는 객체
	- 클라이언트에서 서버로 보내는 요청을 담고있는 객체
	- 요청범위를 가지며 javax.servlet.http.HttpServletRequest 클래스의 한 인스턴스
	- 요청 파라미터와 관련된 메소드들
	- 서블릿의 service 메소드의 argument인 HttpServletRequest와 동일하게 사용됨

3. 응답(responce) : 서비스를 제공하는 행위
	- 클라이언트에게 전송하기 위한 정보들을 객체에 담는다
	- 서버가 클라이언트의 요청에 응답하는 정보를 담고있는 객체

4. 클라이언트(Client)
네트워크를 통하여 서버라는 다른 컴퓨터 시스템 상의 원격 서비스에 접속할 수 있는 응용 프로그램이나 서비스를 말한다

서비스를 제공받는 컴퓨터나 소프트웨어 혹은 사람


5. Network 
두대 이상의 컴퓨터들을 연결하는 일을 위한 통신망

6. IP (Internet Protocol) : 아파트의 동
송신 호스트와 수신 호스트가 패킷 교환 네트워크(패킷 스위칭 네트워크, Packet Switching Network)에서 
정보를 주고받는 데 사용하는 정보 위주의 규약(프로토콜, Protocol)이며, OSI 네트워크 계층에서
호스트의 주소지정과 패킷 분할 및 조립 기능을 담당한다. 

7. Port : 서비스의 통로, 아파트의 호수(65536개, 2^16)
논리적인 접속 장소

8. DNS server :  IP와 도메인 매칭

8. firewall

미리 정의된 보안 규칙에 기반한, 들어오고 나가는 네트워크 트래픽을 모니터링하고 제어하는 네트워크 보안 시스템

9. URL (Uniform Resource Locator 또는 web address) : 네트워크 자원의 위지
네트워크 상에서 자원이 어디 있는지를 알려주기 위한 규약이다

10. URI (Uniform Resource Identifier) : 네트워크 자원의 식별자
통합자원식별자, 인터넷에 있는 자원을 나타내는 유일한 주소

11. URN (Uniform Resource Name) : 네트워크 자원의 이름

11. 게이트웨이 : 서로 다른 네트워크로 출입하기 위한 문

컴퓨터 네트워크에서 서로 다른 통신망, 프로토콜을 사용하는 네트워크 간의 통신을 가능하게 하는
컴퓨터나 소프트웨어를 두루 일컫는 용어, 즉 다른 네트워크로 들어가는 입구 역할을 하는 네트워크 포인트이다.

12. 라우터/라우터스위치
라우터 : 둘 혹은 그 이상의 네트워크와 네트워크 간 데이터 전송을 위해 최적 경로를 설정해주며 
데이터를 해당 경로를 따라 한 통신망에서 다른 통신망으로 통신할 수 있도록 도와주는 인터넷 접속 장비
라우터스위치 : '같은 네트워크 내부'에서 데이터 전송을 수행하는 기기

13. 프록시(대리, proxy server) : 검열, 임시저장

프록시 서버는 클라이언트가 자신을 통해서 다른 네트워크 서비스에 간접적으로 접속할 수 있게 해 주는 
컴퓨터 시스템이나 응용 프로그램을 가리킨다. 

14. LAN / WAN 
	LAN: 근거리통신망
	WAN: 원거리통신망

15. www(World Wide Web)
Internet을 통해 접근 가능한 공용 웹페이지의 상호연결 시스템

16. 인터넷(Internet) 
컴퓨터로 연결하여 TCP/IP(Transmission Control Protocol/Internet Protocol)라는 
통신 프로토콜을 이용해 정보를 주고받는 컴퓨터 네트워크

17. 패킷 (packet) : 네트워크로 전송하는 데이터의 전송 단위
정보 기술에서 패킷 방식의 컴퓨터 네트워크가 전달하는 데이터의 형식화된 블록

18.socket : 데이터의 SW적인 이동 통로
컴퓨터 네트워크를 경유하는 프로세스 간 통신의 종착점

19. 프로토콜 : 통신규약
컴퓨터나 네트워크 장비가 서로 통신하기 위해서 미리 정해놓은 약속

20. TCP : 연결지향 프로토콜, 신뢰성 ex)전화

21. UDP : 비연결지향 프로토콜, 비신뢰성 ex)편지, 인터넷방송

22. VPN : Virtual Private Network . 네트워크 사이에 암호화된 개인터널을 생성할 수 있는 네트워크

23. MAC Address 물리적주소, 하드웨어의 무선랜 혹은 유선랜 카드의 물리적인 주소
