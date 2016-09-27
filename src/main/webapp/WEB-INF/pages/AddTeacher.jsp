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
<form:form id="contactform" action="addTeacher.html" method="POST" modelAttribute="Teacher">
<label>Years of Experience</label>
<form:input path="yearsOfExperience" placeholder="Years Of Experience" type="text"/>
<label>Months Of Experience</label>
<form:input path="monthsOfExperience" placeholder="Months Of Experience" type="text"/>
<label>Qualification</label>
<form:input path="qualification" placeholder="Qualification" type="text"/>
<label>Marital Status</label>
<form:input path="maritalStatus" placeholder="Marital Status" type="text"/>
<label>Date Of Joining</label>
<form:input path="dateOfJoining" placeholder="Date Of Joining" type="text"/>
<label>Designation</label>
<form:input path="designation" placeholder="Designation" type="text"/>

<form:input type = "hidden" path = "user.id" value="${userId}"/>
<input name="submit" id="'submit" value="Submit" type="submit">
</form:form>
<c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                 </c:if>
</body>
</html>