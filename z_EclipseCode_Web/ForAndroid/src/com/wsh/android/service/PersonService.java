package com.wsh.android.service;

import com.wsh.android.bean.Person;
import com.wsh.android.dao.PersonDAO;

/**
 * ҵ���
 */
public class PersonService {
	
	//Service����DAO��
	PersonDAO personDAO = new PersonDAO();
	
	
	/**
	 * ע��
	 */
	public int registerPerson(Person person){
		return personDAO.registerPerson(person);
	}
	
	/**
	 * ��¼
	 */
	public int loginPerson(Person person){
		return personDAO.loginPerson(person);
	}
	
	


}
