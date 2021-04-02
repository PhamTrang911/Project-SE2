<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<c:url value="/View/user" var="url" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>La Leaf-Begin your life in the garden</title>

    <meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>La Leaf - Begin your life in the garden</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="${url}/images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="${url}/images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${url}/css/bootstrap.min.css" type="text/css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="${url}/css/style.css" type="text/css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="${url}/css/responsive.css" type="text/css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${url}/css/custom.css" type="text/css">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    	#basic{
    		
    font-size: 16px;
    text-transform: uppercase;
    font-weight: bold;
    	}
    </style>
    
</head>
<body>
 <!-- Start Main Top -->
    <header class="main-header">
        <!-- Start Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
            <div class="container">
                <!-- Start Header Navigation -->
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/user"><img src="${url}/images/laleaf_logo.jpg" class="logo" alt="" style ="width:108px;height:108px;border-radius: 50%;"></a>
                </div>
                <!-- End Header Navigation -->

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar-menu">
                    <ul class="nav navbar-nav ml-auto" id="menu" data-in="fadeInDown" data-out="fadeOutUp">
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a></li>
                        
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/product" class="nav-link">SHOP</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/gallery">Gallery</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about">About Us</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact-us">Contact Us</a></li>
                        <li class="dropdown">
                            <a href="${pageContext.request.contextPath}/user/profile" class="nav-link dropdown-toggle" data-toggle="dropdown">Account</a>
                            <ul class="dropdown-menu" id="drop">
                                <li style="display:flex; flex-flow:row; justify-content: space-between; padding-right: 25px; align-items:center;"><a href="${pageContext.request.contextPath}/user/cart">Cart</a><p id="number" style="text-align:center; width:20px; color:white;">${cart}</p></li>
                                <li><a href="${pageContext.request.contextPath}/user/history">Ordered</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->

                <!-- Start Atribute Navigation -->
                <div class="login-box">
                <% if(session.getAttribute("user_email")==null){ %>
						<a href="${pageContext.request.contextPath}/login" id="basic">Login</a>
						<%}%>
						
				</div>
                <!-- End Atribute Navigation -->
            </div>
        </nav>
        <!-- End Navigation -->
    </header>
    <!-- End Main Top -->

    <!-- Start Top Search -->
    <div class="top-search">
        <div class="container">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-search"></i></span>
                <input type="text" class="form-control" placeholder="Search">
                <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
            </div>
        </div>
    </div>
    <!-- End Top Search -->
<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>
    <!-- ALL JS FILES -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${url}/js/popper.min.js"></script>
    <script src="${url}/js/bootstrap.min.js"></script>
    <!-- ALL PLUGINS -->
    <script src="${url}/js/jquery.superslides.min.js"></script>
    <script src="${url}/js/bootstrap-select.js"></script>
    <script src="${url}/js/inewsticker.js"></script>
    <script src="${url}/js/bootsnav.js"></script>
    <script src="${url}/js/images-loded.min.js"></script>
    <script src="${url}/js/isotope.min.js"></script>
    <script src="${url}/js/owl.carousel.min.js"></script>
    <script src="${url}/js/baguetteBox.min.js"></script>
    <script src="${url}/js/form-validator.min.js"></script>
    <script src="${url}/js/contact-form-script.js"></script>
    <script src="${url}/js/custom.js"></script>
    <script type="text/javascript">
    	if(document.getElementById("basic")==null){
    		var b = document.createElement("a");
    		b.href = "${pageContext.request.contextPath}/user/logout";
    		b.innerHTML = "Log Out";
    		var li = document.createElement("li");
    		li.appendChild(b);
    		document.getElementById("drop").appendChild(li);
    	}
    	let a = document.getElementById("number");
    	if(a.innerHTML != "0"){
    		a.style.backgroundColor = "red";
    	}else{
    		a.innerHTML = "";
    	}
    </script>
</body>
</html>