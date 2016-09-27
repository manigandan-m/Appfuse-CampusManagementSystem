<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add User Details</h1>
<form:form id="contactform" action="addUser.html" method="POST" modelAttribute="User">

<label>Username</label>
<form:input path="username" placeholder="UserName" type="text"/>
<label>Password</label>
<form:input path="password" placeholder="Password" type="text"/>
<label>Confirm Password</label>
<form:input path="confirmPassword" placeholder="Confirm Password" type="text"/>
<label>Password Hint</label>
<form:input path="passwordHint" placeholder="Password Hint" type="text"/>
<label>First name</label>
<form:input path="firstName" placeholder="First Name" type="text"/>
<label>Last name</label>
<form:input path="lastName" placeholder="Last Name" type="text"/>
<label>Email</label>
<form:input path="email" placeholder="Email" type="email"/>
<label>Phone Number</label>
<form:input path="phoneNumber" placeholder="Phone Number" type="text"/>
<label>Website</label>
<form:input path="website" placeholder="website" type="text"/>
<label>Date OF Birth</label>
<form:input path="dateOfBirth" id = "datepicker" placeholder="Date Of Birth" required="" tabindex="1" type="text"/>

                        <form:select class="select-style gender" name="nationality" path="nationality">
                        <option value="Nationality">Nationality</option>
                        <option value="Indian">Indian</option>
                        <option value="Other">Other</option>
                        </form:select><br><br>
                        
                        <form:select class="select-style gender" name="religion" path="religion">
                        <option value="select">Religion</option>
                        <option value="Hindu">Hindu</option>
                        <option value="Christian">Christian</option>
                        <option value="Islam">Islam</option>
                        <option value="Jainism">Jainism</option>
                        <option value="Buddhism">Buddhism</option>
                        </form:select><br><br>
        
                        <form:select class="select-style gender" name="gender" path="gender">
                        <option value="select">i am..</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        </form:select><br><br>

                        <form:select class="select-style gender" name="bloodGroup" path="bloodGroup">
                        <option value="select">Blood Group</option>
                        <option value="O+">O+</option>
                        <option value="O-">O-</option>
                        <option value="B+">B+</option>
                        <option value="B-">B-</option>
                        <option value="A+">A+</option>
                        <option value="A-">A-</option>
                        <option value="AB+">AB+</option>
                        <option value="AB-">AB-</option>
                        </form:select><br><br>
                        
                        <form:select class="select-style gender" path="role.id">
	                     <option value="select"> Role </option>
                    	<c:forEach items="${roleList}" var="userRole">
                        <option value="${userRole.id}">${userRole.name}</option>
                        </c:forEach>
                        </form:select><br><br>
                        <form:input type = "hidden" path = "id" value="${User.getId()}"/>
                        <c:out value="${User.getId()}"/>
<input name="submit" id="'submit" value="Submit" type="submit">
</form:form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script>
  $(document).ready(function() {
	  var date = new Date(2012-09-10);
	$("#datepicker").datepicker({
    	minDate: new Date(date),	
        dateFormat:'yy-mm-dd',
        changeYear:true,
        yearRange:'1980:2100'
        
    });
  });
</script>
</body>

</html>