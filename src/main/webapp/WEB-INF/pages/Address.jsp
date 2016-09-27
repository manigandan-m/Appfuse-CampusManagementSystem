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
<form:form id="contactform" action="addAddress.html" method="POST" modelAttribute="Address">
<label>House Number</label>
<form:input path="houseNumber" placeholder="House Number" type="text"/>
<label>Street Name</label>
<form:input path="streetName" placeholder="Street Name" type="text"/>
<select name="country" class="countries" path="country">
<option value="">Select Country</option>
</select>
                        
<select name="state" class="states" path="state">
<option value="">Select State</option>
</select>
                        
<select name="city" class="cities" path="city">
<option value="">Select City</option>
</select>
<label>Pincode</label>
<form:input path="pincode" placeholder="Pincode" type="number"/>
<form:input type = "hidden" path = "user.id" value="${userId}"/>
<input name="submit" id="'submit" value="Submit" type="submit">
</form:form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://iamrohit.in/lab/js/location.js"></script>
</body>
</html>