package service;

import entity.Manager;
import exception.ServiceException;

public interface ManagerService {

	/**
	 * 添加管理员用户
	 * @param manager
	 */
	
	public void addManager(Manager manager)throws ServiceException;
	/**
	 * 根据用户名密码，查询管理员(管理员登陆)
	 * 
	 */
	public Manager login(Manager manager)throws ServiceException;
	
}
