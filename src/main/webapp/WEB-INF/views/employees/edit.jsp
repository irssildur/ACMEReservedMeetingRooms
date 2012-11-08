<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<form:form method="POST" commandName="employee" action="save_edited" >
	<label for="name"><spring:message code="name" />: (${employee.name})</label>
	<i class="icon-user icon-space-right"></i>
	<form:input id="name" path="name"/>
	<form:errors path="name" />
	<br/>
	<label for="email"><spring:message code="email" />: (${employee.email})</label>
	<i class="icon-envelope icon-space-right"></i>
	<form:input id="email" path="email"/>
	<form:errors path="email" />
	<br/>
	<form:hidden path="id" id="id" />
	<input type="submit" name="submit" value="<spring:message code="save.btn" /> "/>
</form:form>
