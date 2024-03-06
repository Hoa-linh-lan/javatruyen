
<%@page import="bean.khachhangbean"%>
<%@page import="bean.giohangbean"%>
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
<%	
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8"); 
	String un= (String)request.getAttribute("txtun");	
	String pass= (String)request.getAttribute("txtpass");
	 khachhangbean kh = (khachhangbean)session.getAttribute("dn"); 
	int a=0;
	if(request.getAttribute("a")!=null) a=(int)request.getAttribute("a");
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

	<div class="col-md-8"  >
	<%
	
		ArrayList<giohangbean> ds = (ArrayList)request.getAttribute("ds");	
		int n=0;
		if(ds!=null)  n=ds.size();
		ArrayList<truyenbean> truyen = (ArrayList)request.getAttribute("truyen");	
		int n1=0;
		if(truyen!=null)  n1=truyen.size();	
		long tongtien = 0;
		if(ds!=null) tongtien=(Long)request.getAttribute("tongtien");
		%>
		<%if( a != 0)
		{ %>
	<form method='post' action='xoadachon'>         
      <table class="table table-bordered">
		<%for(int i=0;i<n;i++){ %>		
		<tr>
		 <td>
     <form></form>
			<%for(int j=0;j<n1;j++)
			{
				if(truyen.get(j).getMatruyen().equals(ds.get(i).getMatruyen()))
				{
			%>	
       <table class="table table-bordered">
      <tbody>
        <tr>
         <td><%=truyen.get(j).getTentruyen() %></td>
       </tr>
       <tr>
         <td><img  width="200px" src="<%=truyen.get(j).getAnh()%>"> </td>
       </tr>
      </tbody>
       
     </table>
     <%} }%>
     </td>
     
     <td>
           <table class="table table-bordered">
             <tbody>
                <tr>
                <td>Gia: <%=ds.get(i).getGia() %></td>
                </tr>
                <tr>
                <td>So luong mua: <%=ds.get(i).getSoluong()%></td>
                </tr>
                <tr>
                <td>Thanh Tien: <%=ds.get(i).getThanhtien()%></td>
                </tr>
                <tr>
                <td>
                
                <form method='post' action='suaCTL?th=<%=ds.get(i).getMatruyen()%>'>
				<input style="width: 70px;" type="number" name='txtsua' value="<%=ds.get(i).getSoluong()%>">
				<input type='submit' name='tt' value='Sửa'>
			</form>
                </td>
                </tr>
                <tr>
                 <td>
		             chon de xoa : <input type="checkbox" name="<%=i%>" value="<%=ds.get(i).getMatruyen()%>">
		             
                       <form method='post' action='xoa?th=<%=ds.get(i).getMatruyen()%>'>
			           <input type='submit' name='xoa' value='Xóa'>
			          </form>
		         </td>
                </tr>
             </tbody>
           </table>
       </td>
     	
		<%}%>
		</table>

		
		<div align='right'>Tổng tiền: <%=tongtien %></div>
		<br> <input type='submit' name='b1' value='Xóa Đã Chọn'>
		</form>
		<form method='post' action='xoahet'>
		<br>
			<input type='submit' name='xoa' value='Xóa Hết'>
		</form>
		<form method='post' action='xacnhanCTL'>
		<br>
			<input type='submit' name='xn' value='Xác Nhân Đã Mua'>
		</form>
		<%} %>
			
		
	</div>
	 
	
<%-- <div class="container">
  <h2>Giỏ hàng</h2>
  <%
	
		ArrayList<giohangbean> ds = (ArrayList)request.getAttribute("ds");	
		int n=0;
		if(ds!=null)  n=ds.size();
		ArrayList<truyenbean> truyen = (ArrayList)request.getAttribute("sach");	
		int n1=0;
		if(truyen!=null)  n1=truyen.size();	
		long tongtien = 0;
		if(ds!=null) tongtien=(Long)request.getAttribute("tongtien");
		%>
		<%if( a != 0)
		{ %>
  <form method='post' action='xoadachon'>  
  <%for(int i=0;i<n;i++){ %>
  <form></form>
			<%for(int j=0;j<n1;j++)
			{
				if(truyen.get(j).getMatruyen().equals(ds.get(i).getMatruyen()))
				{
			%>	
  <div class="media">
    <div class="media-left media-top">
      <img src="<%=truyen.get(j).getAnh()%> imgtr/luchao.jpg" class="media-object" style="width:170px">
    </div>
    <div class="media-body">
      <h4 class="media-heading"><%=truyen.get(j).getTentruyen() %></h4>  <%} }%>
      <p>Gia: <%=ds.get(i).getGia() %></p>
      <p>So luong mua: <%=ds.get(i).getSoluong()%></p>
      <p>Thanh Tien: <%=ds.get(i).getThanhtien()%></p>
      <p><form method='post' action='suaCTL?th=<%=ds.get(i).getMatruyen()%>'>
				<input style="width: 70px;" type="number" name='txtsua' value="<%=ds.get(i).getSoluong()%>">
				<input type='submit' name='tt' value='Sửa'>
			</form>
	 </p>
	 <p>
	 chon de xoa : <input type="checkbox" name="<%=i%>" value="<%=ds.get(i).getMatruyen()%>">
		             
                       <form method='post' action='xoa?th=<%=ds.get(i).getMatruyen()%>'>
			           <input type='submit' name='xoa' value='Xóa'>
			          </form>
	 </p>
	<%}%>
	
    </div>
  </div>
  </form>
  <hr>
<div align='right'>Tổng tiền: <%=tongtien %></div>
		<br> <input type='submit' name='b1' value='Xóa Đã Chọn'>
	<form method='post' action='xoahet'>
		<br>
			<input type='submit' name='xoa' value='Xóa Hết'>
		</form>
		<form method='post' action='xacnhanCTL'>
		<br>
			<input type='submit' name='xn' value='Xác Nhân Đã Mua'>
		</form>
		<%} %>
</div>
 --%>

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