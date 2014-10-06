<%-- 
    Document   : admin-default
    Created on : 5 Oct, 2014, 10:20:23 PM
    Author     : Prem Baboo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <meta name="description" content="">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><tiles:getAsString name="title" /></title>
	<style type="text/css" media="screen,print">
	    @import url("<c:url value="/resources/static/css/style.css"/>");
	</style>
	<script type="text/javascript" src="<c:url value="/resources/static/js/jquery.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/static/js/script.js"/>"></script>
    </head>
    <body>
        <div class="main-container">
            <h1>Welcome to Prizy Price | Administrator</h1>
            <tiles:insertAttribute name="header" />
            
            <div class="container">
                <tiles:insertAttribute name="content" />
            </div>

            <div class="footer">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </body>
</html>
