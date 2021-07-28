Spring Board  

1. Model  
   (1) board.sql 인스톨 
   (2) mybatis-config.xml에 추가 
        <typeAlias alias="Board" type="soo.md.domain.Board"/>
		<typeAlias alias="BoardVo" type="soo.md.domain.BoardVo"/>
   (3) BoardMapper.xml 생성 
   (4) soo.md.domain 하위에 생성 
       - Board.java 
       - BoardVo.java 
   (5) soo.md.mapper.BoardMapper.java
   (6) Service 구현 
       - soo.md.service.BoardService.java
	   - soo.md.service.BoardServiceImpl.java
	   - soo.md.domain.BoardListResult.java 
	

2. Controller 
   - BoardController

3. View 
   - board/list.jsp 
   - board/write.jsp 
   - board/content.jsp
   - board/update.jsp