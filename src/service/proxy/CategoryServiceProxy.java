package service.proxy;

import entity.Category;
import exception.DataAccessException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.CategoryService;
import service.ManagerService;
import transaction.TransactionManager;

public class CategoryServiceProxy implements CategoryService {

	
private CategoryService categoryService;
	
	public CategoryServiceProxy(){
		categoryService=(CategoryService) ObjectFactory.getObject("categoryServiceTarget");
	}
	
	
	
	public Category findCategoryById(Integer id) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		Category category = new Category();
		try {
			transactionManager.beginTransaction();
			
			category = categoryService.findCategoryById(id);
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return category;
	}

}
