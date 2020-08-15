<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="demo3" method="post">
		<input type="text" name="name"/>
		<input type="text" name="age"/>
		
<!-- 		<input type="checkbox" name="hover" value="学习1" >
		<input type="checkbox" name="hover" value="学习2" >
		<input type="checkbox" name="hover" value="学习3" >
		<input type="checkbox" name="hover" value="学习4" > -->
		
<!-- 		<input type="text" name="peo.name"/>
		<input type="text" name="peo.age"/> -->
		
<!-- 		<input type="text" name="peo[0].name"/>
		<input type="text" name="peo[0].age"/>
		<input type="text" name="peo[1].name"/>
		<input type="text" name="peo[1].age"/> -->
		<input type="submit" name="提交"/>
	</form>
	
	<a href="demo9?age=123&name=abc">跳转</a>
	<a href="demo10/123/abc">跳转</a>
</body>
</html>