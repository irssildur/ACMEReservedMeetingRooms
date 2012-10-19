<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   

<jsp:useBean id="employee" class="com.acme.meetingrooms.dao.entity.EmployeeEntity" scope="page" />
<jsp:setProperty property="name" name="employee" value="Kiss Pista"/>
<jsp:getProperty property="name" name="employee"/>
