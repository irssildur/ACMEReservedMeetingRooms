<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<table style="width:80%; text-align:center;">
	<tr>
		<th><spring:message code="name" />:</th>
		<th colspan="1"><spring:message code="email" />:</th>
		
	</tr>
	<c:forEach var="next" items="${employees}">
		<c:url var="editUrl" value="/employees/edit?id=${next.id}"/>
		<c:url var="removeUrl" value="/employees/remove?id=${next.id}"/>
		
		<tr>
			<td>${next.name}</td>
			<td>${next.email}</td>
			<td><a href="${editUrl}"><spring:message code="edit" /></a></td>
			<td>
				<a href="#" onclick="$(areYouSure${next.id}).show()"><spring:message code="remove" /></a>
				<div id="areYouSure${next.id}" class="areYouSure" style="display:none"><spring:message code="are.you.sure" /><br/>
				<a href="${removeUrl}"><spring:message code="yes" /></a>
				/
				<a href="#" onclick="$(areYouSure${next.id}).hide()"><spring:message code="no" /></a>
				</div>
			</td>
		</tr>
	</c:forEach>
</table>
