package dao;

import java.util.List;

import entity.Category;

public interface CategoryDao {
	public List<Category> selectAll();
	/**
	 * 根据id，查房间类型
	 * @param id
	 * @return
	 */
	public Category selectById(Integer id); 
	
}
