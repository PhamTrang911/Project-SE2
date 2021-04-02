<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<c:url value="/View/user" var="url" />
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="css/style.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/custom.css">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.${url}/js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
.r{
	border:none;
	text-align:right;
}
</style>
</head>

<body>
       <jsp:include page="nav-bar.jsp"></jsp:include>

    <!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Checkout</h2>
	            </div>
	        </div>
	    </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
           <form action="${pageContext.request.contextPath}/authorize_payment" class="needs-validation">
            <div class="row">
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="checkout-address">
                        <div class="title-left">
                            <h3>Billing address</h3>
                        </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="firstName">First name *</label>
                                    <input type="text" class="form-control" id="firstName" placeholder="" value="${firstName}" required="required">
                                    <div class="invalid-feedback"> Valid first name is required. </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="lastName">Last name *</label>
                                    <input type="text" class="form-control" id="lastName" placeholder="" value="${lastName}" required="required">
                                    <div class="invalid-feedback"> Valid last name is required. </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="email">Email Address *</label>
                                <input type="email" class="form-control" id="email" value="${email}" placeholder="">
                                <div class="invalid-feedback"> Please enter a valid email address for shipping updates. </div>
                            </div>
                            <div class="mb-3">
                                <label for="address">Address *</label>
                                <input type="text" class="form-control" id="address" placeholder="" required="required">
                                <div class="invalid-feedback"> Please enter your shipping address. </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5 mb-3">
                                    <label for="country">Country *</label>
                                    <input type="text" class="form-control" id="country" placeholder="" required="required">
                                    <div class="invalid-feedback"> Please enter a valid country. </div>
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label for="state">State *</label>
                                    <input type="text" class="form-control" id="city" placeholder="" required="required">
                                    <div class="invalid-feedback"> Please enter a valid state. </div>
                                </div>
                                <div class="col-md-3 mb-3">
                                    <label for="zip">Zip *</label>
                                    <input type="text" class="form-control" id="zip" placeholder="" maxlength="7" required="required">
                                    <div class="invalid-feedback"> Zip code required. </div>
                                </div>
                            </div>
                            <input name="info" id="info" hidden/>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="row">
                        <div class="col-md-12 col-lg-12">
                            <div class="order-box">
                                <div class="title-left">
                                    <h3>Your order</h3>
                                </div>
                                <div class="d-flex">
                            <h4>Sub Total</h4>
                            <input id="sum" readonly value="${sub}" name="sum" class="ml-auto font-weight-bold r"/>$
                        </div>
                        <hr class="my-1">
                        <div class="d-flex">
                            <h4>Tax</h4>
                            <input id="tax" readonly name="tax" value="${tax}" class="ml-auto font-weight-bold r"/>$
                        </div>
                        <div class="d-flex">
                            <h4>Shipping Cost</h4>
                            <input id="ship" value="${ship}" readonly name="ship" class="ml-auto font-weight-bold r"/>$
                        </div>
                        <hr>
                        <div class="d-flex gr-total">
                            <h5>Grand Total</h5>
                            <input id="total" value="${total}" readonly name="total" class="ml-auto h5 r"/>$
                        </div>
                                <hr> </div>
                        </div>
                        <div class="col-12 d-flex shopping-box"><input id="fake-button" value="Place Order" class="form-control ml-auto btn hvr-hover" > <button id="real" type="submit" hidden class="ml-auto btn hvr-hover">Place Order</button> </div>
                    </div>
                </div>
            </div>
			</form>
        </div>
    </div>
    <!-- End Cart -->

    <!-- Start Instagram Feed  -->
    <div class="instagram-box">
        <div class="main-instagram owl-carousel owl-theme">
            <div class="item">
                <div class="ins-inner-box">
                    <img src="${url}/images/laleaf_ins.jpg" alt="" style ="width:248px;height:254px;"/>
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="${url}/images/laleaf_ins1.jpg" alt="" style ="width:248px;height:254px;"/>
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="${url}/images/laleaf_ins2.jpg" alt="" style ="width:248px;height:254px;"/>
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="${url}/images/laleaf_ins3.jpg" alt=""  style ="width:248px;height:254px;"/>
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="${url}/images/laleaf_ins4.jpg" alt="" style ="width:248px;height:254px;"/>
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="${url}/images/laleaf_ins5.jpg" alt="" style ="width:248px;height:254px;"/>
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="${url}/images/laleaf_ins6.jpg" alt="" style ="width:248px;height:254px;"/>
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="${url}/images/laleaf_ins7.jpg" alt="" style ="width:248px;height:254px;"/>
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="${url}/images/laleaf_ins8.jpg" alt="" style ="width:248px;height:254px;"/>
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="ins-inner-box">
                    <img src="${url}/images/laleaf_ins4.jpg" alt="" style ="width:248px;height:254px;"/>
                    <div class="hov-in">
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Instagram Feed  -->


    <!-- Start Footer  -->
    <footer>
        <div class="footer-main">
            <div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Business Time</h3>
							<ul class="list-time">
								<li>Monday - Friday: 08.00am to 05.00pm</li> <li>Saturday: 10.00am to 08.00pm</li> <li>Sunday: <span>Closed</span></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Newsletter</h3>
							<form class="newsletter-box">
								<div class="form-group">
									<input class="" type="email" name="Email" placeholder="Email Address*" />
									<i class="fa fa-envelope"></i>
								</div>
								<button class="btn hvr-hover" type="submit">Submit</button>
							</form>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Social Media</h3>
							<p>Follow me</p>
							<ul>
                                <li><a href="#"><i class="fab fa-facebook" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fab fa-twitter" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fab fa-linkedin" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fab fa-google-plus" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fa fa-rss" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fab fa-pinterest-p" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fab fa-whatsapp" aria-hidden="true"></i></a></li>
                            </ul>
						</div>
					</div>
				</div>
				<hr>
                <div class="row">
                    <div class="col-lg-4 col-md-12 col-sm-12">
                        <div class="footer-widget">
                            <h4>Covid Precautions</h4>
                            <p> All customers and employees are required to wear a mask at all times. To encourage social distancing, only 3 customers will be allowed in the store at a time. Hand sanitizer for customers on site. No repotting services or returns allowed, but we are happy to set you with potting materials for home. All sales final during this time. </p> 							
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12 col-sm-12">
                        
                    </div>
                    <div class="col-lg-4 col-md-12 col-sm-12">
                        <div class="footer-link-contact">
                            <h4>Contact Us</h4>
                            <ul>
                                <li>
                                    <p><i class="fas fa-map-marker-alt"></i>Address: Km9 Nguyen Trai Street <br>Thanh Xuan<br>Ha Noi </p>
                                </li>
                                <li>
                                    <p><i class="fas fa-phone-square"></i>Phone: <a href="tel:+1-888705770">+1-888 705 770</a></p>
                                </li>
                                <li>
                                    <p><i class="fas fa-envelope"></i>Email: <a href="mailto:contactinfo@gmail.com">contactinfo@gmail.com</a></p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- End Footer  -->

  
    <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>
<!-- ALL JS FILES -->
<script type="text/javascript">
	let firstName = document.getElementById("firstName");
	let lastName = document.getElementById("lastName");
	let email = document.getElementById("email");
	
	document.getElementById("fake-button").addEventListener("click",function(e){
		document.getElementById("info").value = firstName.value+","+lastName.value+","+email.value;
		document.getElementById("real").click();
	})
		
</script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${url}/js/popper.min.js"></script>
    <script src="${url}/js/bootstrap.min.js"></script>
    <!-- ALL PLUGINS -->
    <script src="${url}/js/jquery.superslides.min.js"></script>
    <script src="${url}/js/bootstrap-select.js"></script>
    <script src="${url}/js/inewsticker.js"></script>
    <script src="${url}/js/bootsnav.js."></script>
    <script src="${url}/js/images-loded.min.js"></script>
    <script src="${url}/js/isotope.min.js"></script>
    <script src="${url}/js/owl.carousel.min.js"></script>
    <script src="${url}/js/baguetteBox.min.js"></script>
    <script src="${url}/js/form-validator.min.js"></script>
    <script src="${url}/js/contact-form-script.js"></script>
    <script src="${url}/js/custom.js"></script>
</body>

</html>