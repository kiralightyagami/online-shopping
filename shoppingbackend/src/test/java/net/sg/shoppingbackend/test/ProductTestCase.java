package net.sg.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sg.shoppingbackend.dao.ProductDAO;

import net.sg.shoppingbackend.dto.Product;
public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("net.sg.shoppingbackend");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	/*@Test
	public void testCRUDProduct()
	{
        //cretae the product
		product =new Product();
		
		product.setName("Oppo selfie S53");
		product.setBrand("Oppo");
		product.setDescription("this is a oppo mobile phone");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Something went wrong in adding product in tabel!",true,productDAO.add(product));

		//fetch and update
		product=productDAO.get(2);
		product.setName("Samsung Galaxy S6");
		assertEquals("Something went wrong in adding product in tabel!",true,productDAO.update(product));
		
		//delete a product
		
		assertEquals("Something went wrong in updating product in tabel!",true,productDAO.delete(product));
		
		
		//fetch the list of product
		assertEquals("Something went wrong in deleting product in tabel",6,productDAO.list().size());
		
	}
	*/
	/*@Test
	public void testActiveListProducts()
	{
		assertEquals("Something went wrong in deleting product in tabel",5,productDAO.listActiveProducts().size());
	}*/
	/*@Test
	public void testActiveListProductsByCategoryId()
	{
		assertEquals("Something went wrong in deleting product in tabel",3,productDAO.listActiveProductsByCategoryId(3).size());
	}*/
	
	@Test
	public void testLatestActiveProducts()
	{
		assertEquals("Something went wrong in deleting product in tabel",3,productDAO.getLatestActiveProducts(3).size());
	}
}
