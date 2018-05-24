package dao;

import entity.Manager;

public interface ManagerDao {

	/**
	 * 添加管理员用户
	 * @param manager
	 */
	
	public void insertManager(Manager manager);
	/**
	 * 根据用户名密码，查询管理员
	 * 
	 */
	public Manager selectByUsernameAndPwd(Manager manager);
	/**
	 * 根据用户名，查询管理员
	 * 
	 */
	public Manager selectByUsername(Manager manager);
}
