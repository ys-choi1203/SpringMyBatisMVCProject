<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
</head>
<body>
<table width=50% border="0" cellpadding="0" cellspacing="0">
<c:if test="${count > 0 }">
	<tr align="center" valign="middle">
		<td colspan="4">MVC 게시판</td>
		<td align=right>
			<font size=2>글 개수 : ${count }</font>
		</td>
	</tr>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
			<div align="center">번호</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="50%">
			<div align="center">제목</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">작성자</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="17%">
			<div align="center">날짜</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="11%">
			<div align="center">조회수</div>
		</td>
	</tr>
	<c:forEach items="${lists }" var="board" varStatus="status">
	<tr align="center" valign="middle" bordercolor="#333333"
		onmouseover="this.style.backgroundColor='F8F8F8'"
		onmouseout="this.style.backgroundColor=''">
		<td height="23" style="font-family:Tahoma;font-size:10pt;">
			${status.count }
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="left"> 
			<a href="boardDetail?num=${board.boardNum }" >
				${board.boardSubject }
			</a>
			</div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center">${board.boardName }</div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center">
			<fmt:formatDate value="${board.boardDate }" type="Date" 
			pattern="yyyy년 MM월 dd일"/> </div>
		</td>	
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center">${board.readCount }</div>
		</td>
	</tr>
	</c:forEach>

	<tr align=center height=20>
		<table>
			<tr align=center height=20>
				<td colspan=5 style=font-family:Tahoma;font-size:10pt;>
					<%@ include file="../include/includePage.jsp" %>
				</td>
			</tr>
		</table>
	</tr>
</c:if>
<c:if test="${ empty lists }">
	<tr align="center" valign="middle">
		<td colspan="4">MVC 게시판</td>
		<td align=right>
			<font size=2>등록된 글이 없습니다.</font>
		</td>
	</tr>

	<tr align="right">
		<td colspan="5">
	   		<a href="boardWrite">[글쓰기]</a>
		</td>
	</tr>
</c:if>
</table>
</body>
</html>