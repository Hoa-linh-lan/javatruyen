<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
	<%
	 	int a=0,b=0;
		float c=0;
		if(request.getAttribute("a")!=null && request.getAttribute("b")!=null && request.getAttribute("c")!=null)
		{
			a=(int)request.getAttribute("a");
			b=(int)request.getAttribute("b");
			c= (float)request.getAttribute("c");
		}
	%>
	<form method="post" action="kqController">
		A= <input type="number" name="a" value=<%=a%>> <br><br>
		B= <input type="number" name="b" value=<%=b%>> <br><br>
		Kq= <input type="number" name="kq" value=<%=c%>> <br><br>
		<input type="submit" name="cong" value="	+	" class="btn-primary">
		<input type="submit" name="tru" value="	-	" class="btn-primary">
		<input type="submit" name="nhan" value="	x	" class="btn-primary">
		<input type="submit" name="chia" value="	/	" class="btn-primary">
	</form>
</body>
</html>