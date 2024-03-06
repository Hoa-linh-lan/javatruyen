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
<title>admin</title>
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
        <li><a href="adminsachcontrollerL">QUẢN LÍ SÁCH </a></li>
        
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
	ArrayList<truyenbean> ds= (ArrayList)request.getAttribute("ds");
	ArrayList<loaibean> dsloai= (ArrayList)request.getAttribute("dsloai");
	String mt="",tt="",tg="",a="",gi="",sl="",sc="",va="";
	if(request.getAttribute("mt")!=null) mt=(String)request.getAttribute("mt");
	if(request.getAttribute("tt")!=null) tt=(String)request.getAttribute("tt");
	if(request.getAttribute("a")!=null) a=(String)request.getAttribute("a");
	if(request.getAttribute("tg")!=null) tg=(String)request.getAttribute("tg");
	if(request.getAttribute("gi")!=null) gi=(String)request.getAttribute("gi");
	if(request.getAttribute("sl")!=null) sl=(String)request.getAttribute("sl");
	if(request.getAttribute("sc")!=null) sc=(String)request.getAttribute("sc");
	if(request.getAttribute("va")!=null) va=(String)request.getAttribute("va");
	
	%>
	<form method="post" action="admintruyencontroller" enctype= "multipart/form-data" >
    <input name="matruyen" value="<%=mt %>" class="form-control" placeholder="Mã truyện"> <br>
    <input name="tentruyen" value="<%=tt %>" class="form-control" placeholder="Tên truyện"><br>
    <input name="tacgia" value="<%=tg %>" class="form-control" placeholder="Tác giả"><br>
    <input name="gia" value="<%=gi %>" class="form-control" placeholder="Giá"><br>
    <input name="soluong" value="<%=sl %>" class="form-control" placeholder="Số Lượng"><br>
    <input name="sochuong" value="<%=sc %>" class="form-control" placeholder="Số chương"><br>
    <input name="vanan" value="<%=va %>" class="form-control" placeholder="văn án"><br>
    <img width="70px" src="<%=a %>"><br>
    Sửa ảnh:<input type="file" name="anh"  ><br>
    <br>
    
    <br>
<%--     <input name="sotap" value="${sotap}" class="form-control" placeholder="Số tập"><br> --%>
   <input name="them" type="submit" value="Thêm" class="btn btn-danger">
    <input name="sua" type="submit" value="Sửa" class="btn btn-danger">
    <%if(request.getParameter("ktthem")!=null) {%>
        <b class="text-danger">Mã loại đã tồn tại</b>
    <%} %>
</form>
	<table class="table table-bordered">
    <thead>
      <tr>
      <th>Ảnh Bìa</th>
      <th>Mã Truyện</th>
      <th>Tên Truyện</th>
      <th>Tác Giả</th>
      <th>Giá</th>
      <th>Số Lượng</th>
      <th>Số Chương</th>
      <th>Mã Loại</th>
      <th>Văn Án</th> 
      </tr>
    </thead>
    <tbody>
    <%for(truyenbean t  :ds) {%>
    <tr>
    	<td width="300px"><img width="100%" src="<%=t.getAnh()%>"></td>
    	<td><%=t.getMatruyen() %> </td>
     	<td><%=t.getTentruyen() %></td>
     	<td><%=t.getTacgia() %></td>
     	<td><%=t.getGia() %> </td>
     	<td><%=t.getSoluong()%></td>
     	<td><%=t.getSochuong() %> </td>
     	<td>
     	<%for (loaibean loai :dsloai){
     	if(loai.getMaloai().equals(t.getMaloai())){ %>
     	<%=loai.getTenloai() %>
     	<%}} %>
     	</td>
     	<td><%=t.getVanan() %></td>    
     	<td><a href="admintruyencontroller?mt=<%=t.getMatruyen() %>&bt=chon">chọn</a></td> 
      	<td><a href="admintruyencontroller?mt=<%=t.getMatruyen() %>&bt=xoa">Xóa</a></td>
    </tr>
   <%} %>
    </tbody>
  </table>


</div>

</body>
</html>