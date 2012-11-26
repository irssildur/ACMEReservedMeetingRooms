<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script id="tdTemplate" type="text/x-jsrender">

	
	
		{{for employees}}
			<tr class="highlightableRow" rel="tooltip" title="asdasdas">
				<td>{{>name}} <a href="#" rel="tooltip" title="first tooltip">hover over me</a></td>
				<td>{{>email}}</td>
				<td><a href="edit?id={{>id}}"><i class="icon-edit icon-space-right" title="<spring:message code="edit" />"></i></a></td>
				<td>
					<a href="#" onclick="$(areYouSure{{>id}}).show()"><i class="icon-trash icon-space-right" title="<spring:message code="remove" />"></i></a>
					<div id="areYouSure{{>id}}" class="areYouSure" style="display:none"><spring:message code="are.you.sure" /><br/>
					<a href="remove?id={{>id}}"><spring:message code="yes" /></a>
					/
					<a href="#" onclick="$(areYouSure{{>id}}).hide()"><spring:message code="no" /></a>
					</div>
				</td>
			</tr>
		{{/for}}


</script>

<script id="numberOfPagesTemplate" type="text/x-jsrender">
	<a onclick="listEmployees({{>from}}, 10)">{{>pageNumber}}</a>
</script>






<div>
	<table style="width:600px; text-align:center;">
		<thead>
			<tr>
				<th><i class="icon-user icon-space-right"></i><spring:message code="name" />:</th>
				<th colspan="1"><i class="icon-envelope icon-space-right"></i><spring:message code="email" />:</th>
			</tr>
		</thead>
		<tbody id="employees-list">
		</tbody>
	</table>
</div>
<div id="numberOfPages"></div>
