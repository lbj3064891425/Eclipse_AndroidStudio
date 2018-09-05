package com.wsh.android.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsh.android.bean.Person;
import com.wsh.android.service.PersonService;



public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		Person person  = new Person();
		person.setName(name);
		person.setPassword(password);
		
		PersonService personService = new PersonService();
		int num = personService.registerPerson(person);
		
		response.getWriter().write(num + "");
		
	}

}
