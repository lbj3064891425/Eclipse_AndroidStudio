package com.wsh.android.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wsh.android.bean.Person;
import com.wsh.android.service.PersonService;


/**
 * ���Ʋ�
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		//�ѵ���������װ��Modelģ�Ͳ�Personʵ������
		Person person =new Person();
		person.setName(name);
		person.setPassword(password);
		
		// Conntroller�����Service��
		PersonService personService = new PersonService();
		int num = personService.loginPerson(person);
		
		response.getWriter().write(num + "");
	}

}
