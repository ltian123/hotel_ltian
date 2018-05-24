package service;

import entity.Reside;

public interface ResideService {

	/**
	 * 
	 * 添加reside
	 * @param reside
	 */
	public void addReside(Reside reside);
	/**
	 * 根据dtlid删除reside
	 */
	public void removeByDtlid(Integer dtlid);
}
