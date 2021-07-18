<%@ page contentType="text/html; charset=utf-8" %>

<meta charset='utf-8'>
<style>
	table, th, td {
	   border: 1px solid black;
	   border-collapse: collapse;
	}
	th, td {
	   padding: 5px;
	}
	a { text-decoration:none }
</style>

	<script language="javascript">
	   function check()
	   {
            for(var i=0; i<document.input.elements.length; i++)
		    {
		        if(document.input.elements[i].value == "")
			    {
			        alert("모든 값을 입력 하셔야 합니다. ");
				    return false;
			    }
		    }
		    document.input.submit();
       }
	</script>
	
<body onload="input.writer.focus()">
<font color="gray" size='4'>
<center>
<hr width="600" size="2" color="gray" noshade>
<h3>Simple Board with MVC(kaeun)</h3>

<font color="gray" size="3">
<a href='board.do?m=list'>list</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='../'>index</a>
</font>
<hr width="600" size='2' color="gray" noshade>
</center>


<form name="input" method="post" action="board.do?m=insert">
	   <table border="0" width="500" align="center" cellpadding="3" cellspacing="1" bordercolor="gray">
	      <tr>
		     <td width="30%" align="center">WRITER</td>
			 <td><input type="text" name="writer" size="67"></td>
		  </tr>
		  <tr>
		     <td align="center">EMAIL</td>
			 <td><input type="text" name="email" size="67"></td>
		  </tr>
          <tr>
		     <td align="center">SUBJECT</td>
			 <td><input type="text" name="subject" size="67"></td>
		  </tr>
		  <tr>
		     <td align="center">CONTENT</td>
			 <td><textarea  name="content" rows="15" cols="60"></textarea></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			    <input type="button" value="전송" onclick="check()">
				<input type="reset" value="다시입력" onclick="input.writer.focus()">
			 </td>
		  </tr>
	   </table>
	   <hr width="600" size="2" color="gray" noshade>
	</form>
</body>