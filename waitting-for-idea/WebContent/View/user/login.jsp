<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
<style>
    .col-centered{
    float: none;
    margin: 0 auto;
}</style>
</head>
<body>
<body style="background-color: #4b5257">
  <div class="container">
  <div class="col-xs-12 col-sm-8 col-md-4 col-lg-4 col-centered">
  <div class="jumbotron">
        <h3>Please login</h3>
        <form action="${pageContext.request.contextPath}/loginUser/login" method="post">
          <div class="form-group">
            <input type="text" name="email" class="form-control" placeholder="Enter Username">
          </div>
          <div class="form-group">
            <input type="password" name="password" class="form-control" placeholder="Enter password">
          </div>
          <div class="custom-checkbox">
            <label><input type="checkbox"> Remember me</label>
          </div>
          <input type="submit" value="Login"/>
          <a href="/waitting-for-idea/loginAdmin">to admin login</a>
        </form>
      </div>
  </div>
  </div>
</body>
</html>