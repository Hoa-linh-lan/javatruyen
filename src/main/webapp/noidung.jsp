
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
<title>Chi tiết</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
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
      <li><a href="adminxacnhancontroller">admin </a></li>
        <li><a href="gioCTL">Giỏ Hàng </a></li>
        <li><a href="thanhtoan.jsp">Thanh Toán</a></li>
       <li><a href="lichsuMHCTL">Lịch Sử Mua Hàng</a></li>
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Thể loại<span class="caret"></span></a>
        <ul class="dropdown-menu">
       <%
				ArrayList<loaibean> dsloai= (ArrayList)request.getAttribute("dsloai");	
				for(loaibean loai: dsloai)
				{			
			%>
          <li><a  href="truyencontroller?ml=<%=loai.getMaloai()%>"><%=loai.getTenloai()%></a></li>
           <%}%>        
        </ul>
      </li>
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
  <h2>Chi tiết</h2>
  
  <%				// loaibo lbo = new loaibo();
// lấy danh sách loại từ sachcontrollẻ gui ve
                 ArrayList<truyenbean> dstruyen= (ArrayList<truyenbean>)
                     request.getAttribute("dstruyen");
                       for (truyenbean tr : dstruyen) {
				%>
  <div class="media">
    <div class="media-left media-top">
      <img src="<%=tr.getAnh() %>" class="media-object" style="width:300px">
    </div>
    <div class="media-body">
      <h4 class="media-heading"><%=tr.getTentruyen() %></h4>
      <p>Tác giả :<%=tr.getTacgia() %></p>
      <p>Thể loại :<%=tr.getMaloai() %></p>
      <p>Số chương :<%=tr.getSochuong() %></p>
      <h5>VĂN ÁN:</h5>
      <p><%=tr.getVanan() %></p>
       <p> 
          <a href="gioCTL?mt=<%=tr.getMatruyen()%>&tt=<%=tr.getTentruyen()%>&gia=<%=tr.getGia()%>"><button type="button" class="btn btn-default">Mua</button></a> 
          <a href="truyencontroller"><button type="button" class="btn btn-info">Trở lại </button></a>
      </p>
    </div>
  </div>
  <hr>
  <%} %>
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