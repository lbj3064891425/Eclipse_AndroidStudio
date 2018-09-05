package com.wsh.android.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wsh.android.bean.Person;
import com.wsh.android.db.ConnDB;



/**
 * ʵ�ֲ�
 */
public class PersonDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// ������д���ܴ���

	/**
	 * ע��
	 */
	public int registerPerson(Person person) {
		int num = 0;
		try {
			conn = ConnDB.openConn();
			String sql = "insert into person(name,password) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.setString(2, person.getPassword());
			num = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnDB.closeConn(rs, ps, conn);
		}
		return num;
	}

	/**
	 * ��¼
	 */
	public int loginPerson(Person person) {

		int num = 0;

		// ͨ��JDBC������ɾ�Ĳ鹦�ܴ���ı�д
		try {
			conn = ConnDB.openConn();
			String sql = "select * from person where name=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.setString(2, person.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				num = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnDB.closeConn(rs, ps, conn);
		}
		return num;
	}

}
