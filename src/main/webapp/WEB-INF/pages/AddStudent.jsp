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
<form:form id="contactform" action="addStudent.html" method="GET" modelAttribute="Student">
<label>Father First Name</label>
<form:input path="fatherFirstName" placeholder="Father First Name" type="text"/>
<label>Father Last Name</label>
<form:input path="fatherLastName" placeholder="Father Last Name" type="text"/>
<label></label>
<form:input path="motherFirstName" placeholder="Mother First Name" type="text"/>
<label></label>
<form:input path="motherLastName" placeholder="Mother Last Name" type="text"/>
<label>Family Income</label>
<form:input path="familyIncome" placeholder="Annual Income" type="text"/>
<label>Date Of Admission</label>
<form:input path="dateOfAdmission" placeholder="Date Of Admission" type="text"/>
<form:select name="admissionCategory" path="admissionCategory">
          <option value="select">Admission Category</option>
          <option value="General">General</option>
          <option value="OBC">OBC</option>
          <option value="SC">SC</option>
          <option value="ST">ST</option>
</form:select><br><br>
<form:input type = "hidden" path = "user.id" value="${userId}"/>
<input name="submit" id="'submit" value="Submit" type="submit">
</form:form>
<c:if test="${null != addMessage}">
                    <c:out value="${addMessage}"/>
                 </c:if>
</body>
</html>