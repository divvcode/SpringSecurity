<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:white;">
	<div class="d-flex justify-content-center">
		<div class="w-75 p-3">
		 <div class="center">
			<h1 class="display-4">Search for a User By ID</h1>
			
			<div class="jumbotron">
			
				<h2 class="hello-title">Login Success</h2>
				
				<p class="lead">View user table <a href="/users">here</a></p>
				<br><br>
				<form method="post" action="update">
					<p class="lead">Enter an id from the table: <p><input type="text" id="id" name="id" placeholder="Type here" required><input type="submit" value="Enter" class="btn btn-primary mb-2"/>
				</form>
			</div>
		 </div>
		</div>
	</div>
</body>
</html>