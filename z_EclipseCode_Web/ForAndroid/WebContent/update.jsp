<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update</title>
</head>
<body>
<form action="updateProductServlet" method="post">
<input type="hidden" name="id" value="${product.id}"/>
<input type="text" name="name" value="${product.name}"/>
<input type="text" name="price" value="${product.price}"/>
<input type="text" name="slogan" value="${product.slogan}"/>
<input type="text" name="address" value="${product.address}"/>
<input type="submit" value="修改"/>
</form>
</body>
</html>