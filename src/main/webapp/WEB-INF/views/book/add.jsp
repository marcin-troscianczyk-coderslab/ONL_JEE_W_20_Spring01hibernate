<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>Add book</h3>

<form:form method="post" modelAttribute="book">

    <div>Title: <form:input path="title"/></div>
    <div>Description: <form:input path="description"/></div>
    <div>Rating: <form:input path="rating" type="number" min="1" max="10"/></div>
    <div>Publisher: <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/></div>
    <input type="submit" value="Add book">
</form:form>

</body>
</html>
