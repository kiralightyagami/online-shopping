package net.sg.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sg.shoppingbackend.dao.CategoryDAO;
import net.sg.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("net.sg.shoppingbackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory()
	{
		
		category =new Category();
		category.setImageURL("XAT.png");
		category.setName("Mobile");
		category.setDescription("this is a mobile");
		assertEquals("Successfully added a category inside table!",true,categoryDAO.add(category));
	}*/
	/*@Test
	public void testGetCategory()
	{
		category=categoryDAO.get(1);
		assertEquals("Successfully fetched  a single category inside table!","Televison",category.getName());
		
	}*/
	
	/*@Test
	public void testUpdateCategory()
	{
		category=categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Successfully updated  a single category inside table!",true,categoryDAO.update(category));
		
	}*/
	/*@Test
	public void testDeleteCategory()
	{
		category=categoryDAO.get(1);
		
		assertEquals("Successfully deleted  a single category inside table!",true,categoryDAO.delete(category));
		
	}*/
	
	/*@Test
	public void testGetListCategory()
	{
		
		
		assertEquals("Successfully fetched  a single category inside table!",2,categoryDAO.list().size());
		
	}*/
	
	@Test
	public void testCRUDCategory()
	{
        //cretae the category
		category =new Category();
		category.setImageURL("CAT1.png");
		category.setName("Mobile");
		category.setDescription("this is a mobile");
		assertEquals("Successfully added a category inside table!",true,categoryDAO.add(category));

		category =new Category();
		category.setImageURL("CAT2.png");
		category.setName("Laptop");
		category.setDescription("this is a laptop");
		assertEquals("Successfully added a category inside table!",true,categoryDAO.add(category));
		
		category =new Category();
		category.setImageURL("CAT3.png");
		category.setName("Television");
		category.setDescription("this is a TV");
		assertEquals("Successfully added a category inside table!",true,categoryDAO.add(category));
		
		//fetch and update
		category=categoryDAO.get(2);
		category.setName("Iphone");
		assertEquals("Successfully updated  a single category inside table!",true,categoryDAO.update(category));
		
		//delete a category
		category=categoryDAO.get(2);
		assertEquals("Successfully deleted  a single category inside table!",true,categoryDAO.delete(category));
		
		
		//fetch the list of category
		assertEquals("Successfully fetched  a single category inside table!",2,categoryDAO.list().size());
		
	}
}
