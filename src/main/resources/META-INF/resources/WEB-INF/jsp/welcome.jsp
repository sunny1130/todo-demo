<html>

	<head>
		<title>Welcome Page</title>
		<%@ include file="common/header.jspf" %>
	</head>
	
	<body>
		<%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1>Welcome ${user}</h1>
			<hr>
			<a href="list-todos">Manage Your Todo's</a>
		</div>
	</body>


</html>