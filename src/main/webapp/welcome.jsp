<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

response.setHeader("cache-Control", "no-cache,no-store,must-revalidate"); // http 1.1

response.setHeader("Pragma","no-cache");//http 1.0

response.setHeader("Expires","0");//proxy
if(session.getAttribute("username")==null){
	response.sendRedirect("login.jsp");
}





%>



<a href = "videos.jsp" > Videos</a>
<form action="logout">

<input type="submit" value = "logout">

</form>
</body>
</html>