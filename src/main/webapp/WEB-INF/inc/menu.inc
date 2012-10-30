<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<c:url var="listUrl" value="/employees/list"/>  
<c:url var="addUrl" value="/employees/add"/>  

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a> 
			<a class="brand" href="#"><spring:message code="menu.title" /></a>
			<div class="nav-collapse collapse">
				<ul class="nav">
				
				
					<li class="dropdown">
   						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
      						Employees
      						<b class="caret"></b>
    					</a>
						<ul class="dropdown-menu">
							<li>
								<a href="${listUrl}"><spring:message code="menu.list.employees" /></a>
							</li>
							<li>
								<a href="${addUrl}"><spring:message code="menu.add.employee" /></a>
							</li>
						</ul>
					</li>
				</ul>
			</div> <!--/.nav-collapse -->
		</div>
	</div>
</div>