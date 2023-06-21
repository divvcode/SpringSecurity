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
			<h1 class="display-4">Spring Security</h1>
				<div class="jumbotron">
					<p class="lead">Login below to access the user's table</p>
					
					<form method="post" action="index">
						<input type="text" id="namelogin" name="namelogin" placeholder="Name" required>
						<input type="text" id="passwordlogin" name="passwordlogin" placeholder="Password" required>	
						<input type="submit" value="Enter" class="btn btn-primary mb-2" />
					</form>
				</div>
		 </div>
		</div>
	</div>
</body>
</html>