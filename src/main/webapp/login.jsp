<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="login.title"/></title>
    <meta name="menu" content="Login"/>
    <title>Campus Management</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
</head>
<body>
<div class="container">
			
            <header>
			
				<h1>Login</h1>
				</header>

      <div  class="form">

<form method="post" id="contactform" action="<c:url value='/j_security_check'/>"
    onsubmit="saveUsername(this);return validateForm(this)"  autocomplete="off">
   
<c:if test="${param.error != null}">
    <div class="alert alert-danger alert-dismissable">
        <fmt:message key="errors.password.mismatch"/>
    </div>
</c:if>
    <p class="contact"><label for="username">Username</label></p> 
    <input name="j_username" placeholder="username" data-validation="length alphanumeric" data-validation-length="min4" required ="required" tabindex="1" type="text"> 
    
    <br></br>       
    <p class="contact"><label for="password">Password</label></p> 
    <input name="j_password" placeholder="password" data-validation="length alphanumeric" data-validation-length="min4" required ="required" type="text">
    <br></br>  
    <input class="buttom" name="login" id="submit" tabindex="5" value="Login" type="submit"> 	
    
</form>

</div>      
</div>

<c:set var="scripts" scope="request">
<%@ include file="/scripts/login.js"%>
</c:set>



</body>