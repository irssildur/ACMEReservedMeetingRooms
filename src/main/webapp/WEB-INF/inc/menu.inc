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
			<a class="brand" href="#">ACME Meetingrooms</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active">
						<a href="${listUrl}">List Employees</a>
					</li>
					<li>
						<a href="${addUrl}">Add Employee</a>
					</li>
					
				</ul>
			</div> <!--/.nav-collapse -->
		</div>
	</div>
</div>