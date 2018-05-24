package service;

import entity.Category;


public interface CategoryService {

	
	/**
	 * 根据id，查房间类型
	 * @param id
	 * @return
	 */
	public Category findCategoryById(Integer id);
}
