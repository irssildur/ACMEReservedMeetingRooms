<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<c:url var="resourceUrl" value="/resources/" />
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><spring:message code="title" /></title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
 
<!-- Le styles -->
<link href="${resourceUrl}css/bootstrap.css" rel="stylesheet">
<link href="${resourceUrl}css/docs.css" rel="stylesheet">
<style>
body {
       
}
</style>
<link href="${resourceUrl}css/bootstrap-responsive.css" rel="stylesheet">
 
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
 
<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
</head>
 
<body>
	<%@ include file="menu.inc" %>
	
	<div class="container" style="margin-top:80px;">