<%@page import="com.onlineexamapp.model.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MCQs</title>
</head>
<body>
<% Question question= (Question)request.getAttribute("question"); %>
<div>
	<div>MCQ. 1 <br>
	<%=question.getQuestionText() %></div>
	<div>
		<label>1)</label>
		<%=question.getOption1() %>
	</div>
	<div>
		<label>2)</label>
		<%=question.getOption2() %>
	</div>
	<div>
		<label>3)</label>
		<%=question.getOption3() %>
	</div>
	<div>
		<label>4)</label>
		<%=question.getOption4() %>
	</div>
</div>
</body>
</html>