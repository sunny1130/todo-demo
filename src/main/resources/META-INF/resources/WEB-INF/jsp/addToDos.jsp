<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

	<head>
		<title>Add ToDo's Page</title>
		<%@ include file="common/header.jspf" %>
	</head>
	
	<body>
		<%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1> Enter your To Do's here </h1>
			<hr>
			<form:form action="" method="post" modelAttribute="todovar">
				<fieldset class="mb-3">
					<form:label  path="description">Description : </form:label>
					<form:input  path="description" type="text"  required="required"/>
					<form:errors path="description" cssClass="text-warning"></form:errors>
				</fieldset>
				<fieldset class="mb-3">
					<form:label  path="targetDate">Target Date : </form:label>
					<form:input  path="targetDate" cssClass="datepicker" required="required"/>
					<form:errors path="targetDate" cssClass="text-warning"></form:errors>
				</fieldset>
				<form:input  path="id" type="hidden"  />
				<form:input  path="done" type="hidden"  />
				
				<input type="submit" class="btn btn-success"/>
			</form:form>
		</div>
		<script type="text/javascript">
		$('.datepicker').datepicker({
		    format:'yyyy-mm-dd'
		});
		</script>
	</body>


</html>