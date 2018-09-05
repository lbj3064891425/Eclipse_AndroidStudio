package com.wsh.android.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsh.android.bean.Product;
import com.wsh.android.service.ProductService;




public class UpdateProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		String slogan = request.getParameter("slogan");
		String address = request.getParameter("address");
		
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setSlogan(slogan);
		product.setAddress(address);
		
		ProductService productService = new ProductService();
		int num = productService.updateProduct(product);
		
		response.sendRedirect("mainServlet");
	}

}
