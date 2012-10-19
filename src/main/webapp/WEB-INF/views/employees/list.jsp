<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table style="width:60%; text-align:center;">
	<tr>
		<th>Name:</th>
		<th colspan="3">Email:</th>
		
	</tr>
	<c:forEach var="next" items="${employees}">
		<c:url var="editUrl" value="/employees/edit/${next.id}"/>
		<c:url var="removeUrl" value="/employees/remove/${next.id}"/>   	
		<tr>
			<td>${next.id}</td>
			<td>${next.name}</td>
			<td>${next.email}</td>
			<td><a href="${editUrl}">edit</a></td>
			<td><a href="${removeUrl}">remove</a></td>
		</tr>
	</c:forEach>
</table>
