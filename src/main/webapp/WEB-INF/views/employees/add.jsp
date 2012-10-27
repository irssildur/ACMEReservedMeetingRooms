<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

${errors}

<form:form method="GET" commandName="employeeForm" action="save">
	<label for="name"><spring:message code="name" />:</label>
	<form:input id="name" path="name"/>
	<br/>
	<label for="email"><spring:message code="email" />:</label>
	<form:input id="email" path="email"/>
	<br/>
	<input type="submit" name="submit" value="<spring:message code="submit.btn" />" />
</form:form>
