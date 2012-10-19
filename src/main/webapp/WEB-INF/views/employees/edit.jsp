<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

${errors}

<form:form method="POST" commandName="employee">
	<label for="name">Név: ($employee.name)</label>
	<form:input id="name" path="name"/>
	<br/>
	<label for="email">E-Mail: ($employee.email)</label>
	<form:input id="email" path="email"/>
	<br/>
	<input type="submit" value="submit" name="submit"/>
</form:form>
