package dao;

import entity.Reside;

public interface ResideDao {
	/**
	 * 
	 * 添加reside
	 * @param reside
	 */
	public void insertReside(Reside reside);

	
	/**
	 * 根据dtlid删除reside
	 */
	public void deleteByDtlid(Integer dtlid);
}
