<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Page</title>
</head>
<body>
	<h2>Hello World!</h2>
	<form action="upload" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td><input type="file" name="name"></td>
				<td><button type="submit">Submit</button></td>
			</tr>
		</table>
	</form>
	<span style="color: green; font-size: 14px;">${msg}</span>
</body>
</html>
