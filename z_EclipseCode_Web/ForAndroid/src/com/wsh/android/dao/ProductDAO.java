package com.wsh.android.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wsh.android.bean.Product;
import com.wsh.android.db.ConnDB;


public class ProductDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * ����IDɾ����Ʒ
	 */
	public int deleteProductById(int id) {
		int num = 0;
		try {
			conn = ConnDB.openConn();
			String sql = "delete from product where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			num = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnDB.closeConn(rs, ps, conn);
		}
		return num;
	}
	
	/**
	 * �޸���Ʒ
	 */
	public int updateProdct(Product product){
		int num = 0;
		try {
			conn = ConnDB.openConn();
			String sql = "update product set name=?,price=?,slogan=?,address=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getSlogan());
			ps.setString(4, product.getAddress());
			ps.setInt(5, product.getId());
			num = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnDB.closeConn(rs, ps, conn);
		}
		return num;
	}

	/**
	 * ��ѯ������Ʒ
	 */
	public List<Product> selectAllProduct() {
		List<Product> list = new ArrayList<Product>();
		try {
			conn = ConnDB.openConn();
			String sql = "select * from product";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setSlogan(rs.getString(4));
				product.setAddress(rs.getString(5));

				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnDB.closeConn(rs, ps, conn);
		}
		return list;
	}
	
	/**
	 * ����ID��ѯ��Ʒ
	 */
	public Product selectProductById(int id){
		Product product = new Product();
		try {
			conn = ConnDB.openConn();
			String sql = "select * from product where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setSlogan(rs.getString(4));
				product.setAddress(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnDB.closeConn(rs, ps, conn);
		}
		return product;
	}

}
