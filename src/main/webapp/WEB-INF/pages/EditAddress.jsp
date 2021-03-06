<%@ include file="/common/taglibs.jsp" %>
 
<html>
    <head>
        <title>Campus Management</title>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
	    <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
        <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
    </head>
<body>
<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="home.html">Home</a>&nbsp;&nbsp;
                <span class="right">
                    <a href="logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1>Edit Address</h1>
            </header>       
      <div  class="form">
            <c:if test="${Address != null}">
    		<form:form id="contactform" action="editAddress.html" method="POST" modelAttribute="Address"> 
    			<p class="contact"><label for="houseNumber" path = "label1">House Number</label></p> 
    			<form:input path="houseNumber" placeholder="House Number" data-validation="length alphanumeric" data-validation-length="min1" required ="required" tabindex="1" type="text"/>

                        <p class="contact"><label for="streetName" path = "label1">Street Name</label><p> 
    			<form:input path="streetName" placeholder="Street Name" data-validation="custom" data-validation-regexp="^([A-Za-z\s]+)$" data-validation-error-msg = "Enter alphabets only" required = "required" tabindex="1" type="text"/>

                     <br>
                        <br>
                        <select name="country" class="countries" path="country">
                        <option value="">Select Country</option>
                        </select>
                        <br>
                        <br>
                        <select name="state" class="states" path="state">
                        <option value="">Select State</option>
                        </select>
                        <br>
                        <br>
                        <select name="city" class="cities" path="city">
                        <option value="">Select City</option>
                        </select>
                        <br> 
                        <br>  
                     
                     <p class="contact"><label for="pincode" path = "label1">PinCode</label></p> 
    			<form:input path="pincode" placeholder="PinCode" data-validation="number" data-validation-error-msg = "Enter numbers only" required="required" tabindex="1" type="text"/> 
                 <form:input type = "hidden" path = "user.id" value="${userId}"/>
                 <form:input type = "hidden" path = "addressId" value="${addressId}"/>     
                       <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit"> 	 
                </form:form>
                </c:if>
   <c:if test="${null != Message}">
                    <c:out value="${Message}"/>
                 </c:if> 
</div>      
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
   <script>
       $.validate({
       lang: 'en'
        });
   </script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://iamrohit.in/lab/js/location.js"></script>
</body>
</html>
