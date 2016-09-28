<%@ include file="/common/taglibs.jsp" %>
        
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
 a:link, a:visited {
    color: black;
    padding: 14px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}

a:hover, a:active {
    background-color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Campus Management</title>
<link rel="stylesheet" type="text/css" href="css/style2.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
<%-- <link rel="stylesheet" type="text/css" href="css/style3.css" media="all" />--%>
<link rel="stylesheet" type="text/css" href="css/reset.css" media="all" />
</head>
<body>
<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="home.html">Home</a>&nbsp;&nbsp;
                <a href="displayStudents.html">Students</a>
                <span class="right">
                    <a href="logout.html">
                        <strong>Logout</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1>Edit Teacher Details</h1>
            </header>
<c:if test="${null != student}">
<center>
<a  href="editUserById.html?userId=${student.getUser().getId()}">Edit User Details</a>
<a  href="editAddressById.html?addressId=${student.getUser().getAddress().getAddressId()}">Edit Address Details</a>
<a  href="editStudentById.html?rollNumber=${student.getRollNumber()}">Edit Student Details</a>
</center>
</c:if>
</div>

<c:if test="${null != Message}">
                <c:out value="${Message}"/>
            </c:if>
</body>
</html>
