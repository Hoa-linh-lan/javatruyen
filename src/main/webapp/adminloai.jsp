<%@page import="bean.adminxacnhanbean"%>
<%@page import="bean.khachhangbean"%>
<%@page import="bean.truyenbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>

<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<style>
form {
    width: 500px;
    margin: 0 auto;
}

.needs-validation {
    display: block;
}

.form-control {
    width: 100%;
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

.btn {
    width: 100px;
    margin-top: 10px;
}

.text-danger {
    color: red;
}
</style>
 <%	
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8"); 
	String un= (String)request.getAttribute("txtun");	
	String pass= (String)request.getAttribute("txtpass");
	khachhangbean kh = (khachhangbean)session.getAttribute("dn");
%> 
<nav class="navbar navbar-default" >
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="truyencontroller">Trang Chủ</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="adminloaicontroller">QUẢN LÍ LOẠI </a></li>
        <li><a href="admintruyencontrollerL">QUẢN LÍ TRUYỆN </a></li>
        <!-- <li><a href="danhsachkhcontroller">DANH SÁCH </a></li> -->
       <li><a href="adminxacnhancontroller">XÁC NHẬN</a></li>
      </ul>
  
	<form class="navbar-form navbar-left" method = "post" action = "truyencontroller">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="txttim">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
      
       <ul class="nav navbar-nav navbar-right">
         <%if(session.getAttribute("dn")==null) %> <li><a href="dangky.jsp"><span class="glyphicon glyphicon-user"></span> Đăng Ký</a></li>
     <%
		if(session.getAttribute("dn")==null){
	%>
		<li><a data-toggle="modal" data-target="#exampleModalCenter"><span class="glyphicon glyphicon-log-in"></span> Đăng Nhập</a></li>
	<%
	}
	else {
	%>
	<li><a href="truyencontroller"><span class="glyphicon "></span> Xin Chào <%=kh.getHoten()%></a></li>
	<%}%>
      <%if(session.getAttribute("dn")!=null) %> <li><a href="dangxuatCTL"><span class="glyphicon glyphicon-log-out"></span> Đăng Xuất</a></li>
      </ul> 
    </div>
  </div>
</nav>

<div class="container">
<%
	ArrayList<loaibean> ds= (ArrayList)request.getAttribute("dsloai");
	String ml="",tl="";
	if(request.getAttribute("ml")!=null) ml=(String)request.getAttribute("ml");
	if(request.getAttribute("tl")!=null) tl=(String)request.getAttribute("tl");
%>
	<form action="adminloaicontroller" class="needs-validation" novalidate>
    <input name="ml" value="<%=ml %>" class="form-control" placeholder="Mã loại">
    <input name="tl" value="<%=tl %>" class="form-control" placeholder="Tên loại">
    <input name="them" type="submit" value="Thêm" class="btn btn-danger">
    <input name="sua" type="submit" value="Sửa" class="btn btn-danger">
  	<%if(request.getParameter("ktthem")!=null) {%>
        <b class="text-danger">Mã loại đã tồn tại</b>
    <%} %>
</form>
	<table class="table table-bordered">
    <thead>
      <tr>
      <th>Mã Loại</th>
      <th>Tên Loại</th>
      </tr>
    </thead>
    <tbody>
    <%for(loaibean loai  :ds) {%>
    <tr>
    	<td><%=loai.getMaloai() %> </td>
     	<td><%=loai.getTenloai() %></td>    
     	<td><a href="adminloaicontroller?ml=<%=loai.getMaloai() %>&tl=<%=loai.getTenloai() %>&bt=chon">chọn</a></td> 
      	<td><a href="adminloaicontroller?ml=<%=loai.getMaloai() %>&bt=xoa">Xóa</a></td>
    </tr>
   <%} %>
    </tbody>
  </table>
</div>

<!-- Modal -->
 <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Đăng Nhập</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
       <form method="post" action="dangnhapcontroller">
      <div class="modal-body">
       
		Tài Khoản:<input type="text" name="txtun" > <br><br>
		Mật Khẩu: <input type="password" name="txtpass" > <br><br>	
			<%
		if(request.getParameter("kt")!=null)
		{%>
		<b> Đăng nhập sai</b>	
		<%}%>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
       <input type="submit"  class="btn btn-secondary" name="b1" value="Login">
	</form>
	   </div>
      </div>
    </div> 
    
</body>
</html>