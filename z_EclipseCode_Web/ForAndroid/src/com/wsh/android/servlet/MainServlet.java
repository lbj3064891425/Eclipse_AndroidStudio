package com.wsh.android.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsh.android.bean.Product;
import com.wsh.android.service.ProductService;


public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductService productService = new ProductService();
		List<Product> list = productService.selectAllProduct();

		// ���ݼ���
		request.setAttribute("list", list);

		// ת�����Դ�ֵ
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
