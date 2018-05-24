package service.impl;

import dao.CategoryDao;
import dao.ManagerDao;
import entity.Category;
import factory.ObjectFactory;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	public Category findCategoryById(Integer id) {
		CategoryDao categoryDao = (CategoryDao) ObjectFactory.getObject("categoryDao");
		return categoryDao.selectById(id);
	}

}
