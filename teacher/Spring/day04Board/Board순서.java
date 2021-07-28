Spring Board  

1. Model  
   (1) board.sql �ν��� 
   (2) mybatis-config.xml�� �߰� 
        <typeAlias alias="Board" type="soo.md.domain.Board"/>
		<typeAlias alias="BoardVo" type="soo.md.domain.BoardVo"/>
   (3) BoardMapper.xml ���� 
   (4) soo.md.domain ������ ���� 
       - Board.java 
       - BoardVo.java 
   (5) soo.md.mapper.BoardMapper.java
   (6) Service ���� 
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