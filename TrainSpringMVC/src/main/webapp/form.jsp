<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <!DOCTYPE html>
<html>
<body align="center">
<div align="center">
    <table border="1">
    <thead>
    <tr>
    <td>Train Number</td>
    <td>Train Name</td>
    <td>Source</td>
    <td>Destination</td>
    <td>Ticket Price</td>
    </tr>
    </thead>
    <c:forEach var="train" items="${trains}">
    <tr>
    <td>${train.trainNo}</td>
    <td>${train.trainName}</td>
    <td>${train.source}</td>
    <td>${train.destination}</td>
    <td>${train.ticketPrice}</td>
    </tr>
    </c:forEach>
    </table>
    </div>

<a href="index.jsp">return to main menu</a>

</body>

</html>
