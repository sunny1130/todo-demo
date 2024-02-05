<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

	<head>
		<title>ToDo's Page</title>
		<%@ include file="common/header.jspf" %>
	</head>
	
	<body>
		<%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1> Your To Do's are </h1>
			<hr>
			<table class="table">
				<thead>
					<tr>
						
						<th>Description</th>
						<th>Target Date</th>
						<th>Done?</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="eachtodo">
						<tr>
							
							<td>${eachtodo.description}</td>
							<td>${eachtodo.targetDate}</td>
							<td>${eachtodo.done}</td>
							<td><a href="update-todo?id=${eachtodo.id}" class="btn btn-success">Update</a>
							<td><a href="delete-todo?id=${eachtodo.id}" class="btn btn-warning">Delete</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-success">Add TODO</a>
		</div>
	</body>


</html>