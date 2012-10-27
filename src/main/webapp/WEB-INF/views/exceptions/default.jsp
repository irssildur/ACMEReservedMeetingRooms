<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="true" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="error_pages.oops.title"/></title>
</head>
<body>

<div class="row">
	<div class="span7 offset5">
		<div><spring:message code="error_pages.oops.text"/></div>
		<div>${pageContext.exception.localizedMessage}</div>
	</div>
</div>


</body>
</html>