<%@ include file="/common/taglibs.jsp" %>
 
<!DOCTYPE html>
<html>
<head>
<title>Campus Management</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
</head>
<body>
<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="index.jsp">Home</a>
                
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1>Teacher Login</h1>
            </header>       
      <div  class="form">
    		<form id="contactform" action = "teacherlogin.html" method="POST"> 
    			<p class="contact"><label for="username">Username</label></p> 
    			<input name="username" placeholder="username" data-validation="length alphanumeric" data-validation-length="min4" required ="required" tabindex="1" type="text"> 
    			 
    			<p class="contact"><label for="password">Password</label></p> 
    			<input name="password" placeholder="password" data-validation="length alphanumeric" data-validation-length="min4" required ="required" type="text">

                <input class="buttom" name="submit" id="submit" tabindex="5" value="Login" type="submit"> 	 
   </form>
   
     


<c:if test="${null != message}">
    <c:out value="${message}"/>
</c:if>
<br> 
</div> 
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
   <script>
       $.validate({
       lang: 'en'
        });
   </script> 
</body>
</html> 
