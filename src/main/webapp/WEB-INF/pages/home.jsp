<%@ include file="/common/taglibs.jsp"%>
<%@page import="com.i2i.Constants" %>

    <% if (!(request.isUserInRole(Constants.ADMIN_ROLE))) {%>
        <c:redirect url="/RetrieveSubjects"/>
    <%} %>
    
    <% if ((request.isUserInRole(Constants.ADMIN_ROLE))) {%>
        <c:redirect url="/RetrieveStudents"/>
    <%} %> 
    
      <% if ((request.isUserInRole(Constants.USER_TEACHER))) {%>
        <c:redirect url="/RetrieveTeachers"/>
    <%} %> 
    
    