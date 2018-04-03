/**
 * 
 */
package com.sapient.asish.productcatalogue.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.asish.productcatalogue.constant.ProductConstant;
import com.sapient.asish.productcatalogue.manager.ProductManager;
import com.sapient.asish.productcatalogue.model.ProductModel;
/**
 * @author asish
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	private static Log log = LogFactory.getLog(ProductController.class);

	ProductManager productmanager;

	@Autowired
	public ProductController(ProductManager productmanager) {
		this.productmanager = productmanager;
	}

	@RequestMapping(method = RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE ,value = "/removeProduct/{id}")
	public Boolean removeProduct(@PathVariable Long id) {
		log.info(ProductConstant.START+"::"+ProductConstant.PRODUCTCONTROLLER+"::"+ProductConstant.REMOVEPRODUCT);
		Boolean  message=productmanager.removeProduct(id);
		log.info(ProductConstant.END+"::"+ProductConstant.PRODUCTCONTROLLER+"::"+ProductConstant.REMOVEPRODUCT);
		return message;
	}
	
	@RequestMapping(method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE ,value = "/getProductData/{productType}")
	public List<ProductModel> getData(@PathVariable String productType) {
		log.info(ProductConstant.START+"::"+ProductConstant.PRODUCTCONTROLLER+"::"+ProductConstant.REMOVEPRODUCT);
		log.info(ProductConstant.START+"::"+ProductConstant.PRODUCTCONTROLLER+"::"+ProductConstant.CREATETABLE);
		productmanager.createProductTable();
		log.info(ProductConstant.END+"::"+ProductConstant.PRODUCTCONTROLLER+"::"+ProductConstant.CREATETABLE);
		log.info(ProductConstant.END+"::"+ProductConstant.PRODUCTCONTROLLER+"::"+ProductConstant.REMOVEPRODUCT);
		return productmanager.getData(productType);
	}
	
	@RequestMapping(method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE, value = "/addProduct")
	public Boolean addData( @RequestBody ProductModel product) {
		log.info(ProductConstant.START+"::"+ProductConstant.PRODUCTCONTROLLER+"::"+ProductConstant.REMOVEPRODUCT);
		Boolean result;
		log.info(ProductConstant.START+"::"+ProductConstant.PRODUCTCONTROLLER+"::"+ProductConstant.CREATETABLE);
		productmanager.createProductTable();
		log.info(ProductConstant.END+"::"+ProductConstant.PRODUCTCONTROLLER+"::"+ProductConstant.CREATETABLE);
		result=productmanager.addData(product);
		log.info(ProductConstant.END+"::"+ProductConstant.PRODUCTCONTROLLER+"::"+ProductConstant.REMOVEPRODUCT);
		log.info("end");
		return result;
	}

}
