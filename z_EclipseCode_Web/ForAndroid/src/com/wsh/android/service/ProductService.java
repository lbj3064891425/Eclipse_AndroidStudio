package com.wsh.android.service;

import java.util.List;

import com.wsh.android.bean.Product;
import com.wsh.android.dao.ProductDAO;



public class ProductService {
	
	ProductDAO productDAO = new ProductDAO();
	
	
	/**
	 * ����IDɾ����Ʒ
	 */
	public int deleteProductById(int id){
		return productDAO.deleteProductById(id);
	}
	
	/**
	 * �޸���Ʒ
	 */
	public int updateProduct(Product product){
		return productDAO.updateProdct(product);
	}

	
	/**
	 * ��ѯ������Ʒ
	 */
	public List<Product> selectAllProduct(){
		return productDAO.selectAllProduct();	
	}
	
	/**
	 * ����ID��ѯ��Ʒ
	 */
	public Product selectProductById(int id){
		return productDAO.selectProductById(id);
	}
}
