<%@page import="com.simpli.admin.ModelAdmin"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>ADMIN DATA DISPLAY</h2>

<TABLE BORDER="1">
<TR>
<TH>ADMIN ID</TH>
<TH>ADMIN NAME</TH>
<TH>ADMIN PASSWORD</TH>
<TH>ADMIN EMAIL</TH>
<TH>ADMIN ROLE</TH>
</TR>

<%
List<ModelAdmin> mArrayList=(List<ModelAdmin>)session.getAttribute("list");
for(ModelAdmin mlist: mArrayList){

%>

<tr><td><%=mlist.getAdmin_id() %></td><td><%=mlist.getAdmin_uname() %></td><td><%=mlist.getAdmin_pwd() %></td><td><%=mlist.getAdmin_email() %></td><td><%=mlist.getAdmin_role()%></td>

<%
} 
%>


<a href="AdminSuccess.html"> <h1>Home</h1></a>
</body>
</html>