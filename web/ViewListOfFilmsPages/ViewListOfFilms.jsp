<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>View List of Films</title>
    <style>
        @import url("../Main.css");
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body>
<sql:setDataSource var="filmList" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/filmstore"
                   user = "root" password="qwerty123"/>
<sql:query var="result" dataSource="${filmList}">
    SELECT * FROM films;
</sql:query>
<h1 align="center">View list of all films</h1>
<hr>
<aside>
    <div>
        <h2>Menu</h2>
        <ui>
            <li><a href="../AddFilmPages/AddFilm.html">Add film</a></li>
            <li><a href="../DeleteFilmPages/DeleteFilm.html">Delete film</a></li>
            <li><a href="../ViewListOfFilmsPages/ViewListOfFilms.jsp">View list of films</a></li>
        </ui>
    </div>
</aside>
<div>
    <table border="0" align="center" cellpadding="10" cellspacing="5">
        <div>
        <tr>
            <th>Title</th>
            <th>Cost</th>
            <th>Film Type</th>
        </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td><c:out value="${row.title}"/></td>
                <td><c:out value="${row.cost}"/></td>
                <td><c:out value="${row.type}"/></td>
            </tr>
        </c:forEach>
        </div>
    </table>
</div>
</body>
</html>