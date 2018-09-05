<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
</head>
<body>

<table>
<tr>
<td>编号</td>
<td>商品名</td>
<td>价格</td>
<td>标语</td>
<td>产地</td>
<td>删除</td>
<td>修改</td>
</tr>

<c:forEach var="product" items="${list}">
<tr>
<td>${product.id}</td>
<td>${product.name}</td>
<td>${product.price}</td>
<td>${product.slogan}</td>
<td>${product.address}</td>
<td><a href="deleteProductServlet?id=${product.id}">删除</a></td>
<td><a href="selectProductServlet?id=${product.id}">修改</a></td>
</tr>
</c:forEach>

</table>


</body>
</html>
