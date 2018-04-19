package net.sg.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.sg.shoppingbackend.dao.CategoryDAO;
import net.sg.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	private static List<Category> categories=new ArrayList<>();
	
	static {
		
		Category category=new Category();
		
		category.setId(1);
		category.setImageURL("CAT.png");
		category.setName("Televison");
		category.setDescription("this is a TV");
		categories.add(category);
		

		Category category1=new Category();
		
		category1.setId(2);
		category1.setImageURL("BAT.png");
		category1.setName("Mobile");
		category1.setDescription("this is a mobile");
		categories.add(category1);
		


		Category category2=new Category();
		
		category2.setId(3);
		category2.setImageURL("XAT.png");
		category2.setName("Laptop");
		category2.setDescription("this is a laptop");
		categories.add(category2);
		
	}
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	@Override
	public Category get(int id) {

     for(Category category:categories)
     {
    	 if(category.getId()==id)
    		 return category;
     }
		return null;
	}

}
