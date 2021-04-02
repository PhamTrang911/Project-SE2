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
                    <h2>Cart</h2>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-main table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Images</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${carts}" var="c">
                                	<tr>
                                    <td class="thumbnail-img"><img class="img-fluid" src="${c.p_image}" alt="" /></td>
                                    <td class="name-pr">${c.p_name}</td>
                                    <td class="price-pr">${c.p_price}</td>
                                    <td class="quantity-box">${c.amount}</td>
                                    <td class="total">${c.p_price*c.amount}</td>
                                    <td class="remove-pr">
                                        <a href="${pageContext.request.contextPath}/cart/delete?id=${c.cart_id}">
									<i class="fas fa-times"></i>
								</a>
                                    </td>
                                </tr>
                                </c:forEach>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="row my-5">
                <div class="col-lg-6 col-sm-6">
                    <div class="coupon-box">
                        <div class="input-group input-group-sm">
                            <select id="discount" class="form-control">
                            		<option selected>None</option>
                            	<c:forEach items="${discount}" var="dis">
                            		<option value="${dis.percentage}" onclick="saveId(${dis.discount_id})">${dis.name}&nbsp;-&nbsp;${dis.percentage}%</option>
                            	</c:forEach>
                            </select>
                            <div class="input-group-append">
                                <button id="btn_coupon" class="btn btn-theme" type="button">Apply Coupon</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                <form action="${pageContext.request.contextPath}/user/checkout">
            <div class="row my-5">
                <div class="col-lg-6 col-sm-12">
                <div class="col-md-12 col-lg-12">
                            <div class="shipping-method-box">
                                <div class="title-left">
                                    <h3>Shipping Method</h3>
                                </div>
                                <div class="mb-4">
                                    <div class="custom-control custom-radio">
                                        <input id="shippingOption1" value="0" name="shipping-option" class="custom-control-input" checked="checked" type="radio">
                                        <label class="custom-control-label" for="shippingOption1">Standard Delivery</label> <span class="float-right font-weight-bold">FREE</span> </div>
                                    <div class="ml-4 mb-2 small">(3-7 business days)</div>
                                    <div class="custom-control custom-radio">
                                        <input id="shippingOption2" value="2" name="shipping-option" class="custom-control-input" type="radio">
                                        <label class="custom-control-label" for="shippingOption2">Express Delivery</label> <span class="float-right font-weight-bold">$2</span> </div>
                                    <div class="ml-4 mb-2 small">(2-4 business days)</div>
                                    <div class="custom-control custom-radio">
                                        <input id="shippingOption3" value="5" name="shipping-option" class="custom-control-input" type="radio">
                                        <label class="custom-control-label" for="shippingOption3">Next Business day</label> <span class="float-right font-weight-bold">$5</span> </div>
                                </div>
                            </div>
                        </div>
                </div>
                <div class="col-lg-2 col-sm-12"></div>
                <div class="col-lg-4 col-sm-12">
                    <div class="order-box">
                        <h3>Order summary</h3>
                        <div class="d-flex">
                            <h4>Total Product</h4>
                            <input id="sum" readonly value="0" name="sum" class="ml-auto font-weight-bold r"/>$
                        </div>
                        <div class="d-flex">
                            <h4>Discount</h4>
                            <input id="disc" readonly value="0" name="disc" class="ml-auto font-weight-bold r"/>%
                        </div>
                        <hr class="my-1">
                        <div class="d-flex">
                            <h4>Sub Total</h4>
                            <input id="sub" readonly value="0" name="sub" class="ml-auto font-weight-bold r"/>$
                        </div>
                        <div class="d-flex">
                            <h4>Tax</h4>
                            <input id="tax" readonly name="tax" value="2" class="ml-auto font-weight-bold r"/>$
                        </div>
                        <div class="d-flex">
                            <h4>Shipping Cost</h4>
                            <input id="ship" value="0" readonly name="ship" class="ml-auto font-weight-bold r"/>$
                        </div>
                        <hr>
                        <div class="d-flex gr-total">
                            <h5>Grand Total</h5>
                            <input id="total" readonly name="total" class="ml-auto h5 r"/>$
                        </div>
                        <hr> </div><input name="cart_ids" hidden value="${cart_ids}"/>
                </div>
                <div class="col-12 d-flex shopping-box" style="padding-left: 68%;"><button class="form-control hvr-hover">Checkout</button> </div>
            </div></form>

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
    	let sum = document.getElementById("sum");
    	let disc = document.getElementById("disc");
    	let sub = document.getElementById("sub");
    	let tax = document.getElementById("tax");
    	let ship = document.getElementById("ship");
    	let total = document.getElementById("total");
    	sum.value = sums();
    	sub.value = sum.value;
    	total.value = parseFloat(sum.value)+parseFloat(tax.value)+parseFloat(ship.value);

    	function sums(){
    		let sumN = 0.0;
    		let prices = document.getElementsByClassName("total");
    		
    		for(let i = 0; i < prices.length;i++){
    			sumN += parseFloat(prices[i].innerHTML);
    		}
    		return sumN;
    	}
    	
    	let btn = document.getElementById("btn_coupon");
    	btn.addEventListener("click",function(e){
    		disc.value = document.getElementById("discount").value;
    		sub.value = parseFloat(sum.value) - parseFloat(sum.value)*parseFloat(disc.value)/100;
    		total.value = parseFloat(sub.value)+parseFloat(tax.value)+parseFloat(ship.value);
    	});
    	
    	let radio = document.getElementsByClassName("custom-radio")
    	for(let j = 0; j<radio.length;j++){
    		radio[j].addEventListener("click",function(e){
    			ship.value = radio[j].getElementsByTagName("input")[0].value;
    			total.value = parseFloat(sub.value)+parseFloat(tax.value)+parseFloat(ship.value);
    		})
    	}
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