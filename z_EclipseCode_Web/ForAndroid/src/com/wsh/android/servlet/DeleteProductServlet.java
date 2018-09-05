package com.wsh.android.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsh.android.service.ProductService;

public class DeleteProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =  Integer.parseInt(request.getParameter("id"));
		
		ProductService productService = new ProductService();
		int num = productService.deleteProductById(id);
		
		response.sendRedirect("mainServlet");
	}

}
