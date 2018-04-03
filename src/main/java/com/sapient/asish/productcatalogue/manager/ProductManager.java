/**
 * 
 */
package com.sapient.asish.productcatalogue.manager;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.asish.productcatalogue.constant.ProductConstant;
import com.sapient.asish.productcatalogue.mapper.IProductMapperDAO;
import com.sapient.asish.productcatalogue.model.ProductModel;

/**
 * @author asish
 *
 */
@Component
public class ProductManager {
	
	private static Log log = LogFactory.getLog(ProductManager.class);
	IProductMapperDAO productMapperDAO;
	
	@Autowired
	public ProductManager(IProductMapperDAO productMapperDAO) {
		this.productMapperDAO = productMapperDAO;
	}

	public String createProductTable() {
		log.info(ProductConstant.START+"::"+ProductConstant.PRODUCTMANAGER+"::"+ProductConstant.CREATETABLE);
		productMapperDAO.createProductTable();
		return null;
		
	}

	public List<ProductModel> getData(String productType) {
		log.info(ProductConstant.START+"::"+ProductConstant.PRODUCTMANAGER+"::"+ProductConstant.GETDATA);
		return productMapperDAO.getData(productType);
		
	}

	public Boolean addData(ProductModel product) {
		log.info(ProductConstant.START+"::"+ProductConstant.PRODUCTMANAGER+"::"+ProductConstant.ADDDATA);
		return productMapperDAO.insertData(product);
	}

	public Boolean removeProduct(Long id) {
		log.info(ProductConstant.START+"::"+ProductConstant.PRODUCTMANAGER+"::"+ProductConstant.REMOVEPRODUCT);
		return productMapperDAO.removeProduct(id);
	}

	
	
}
