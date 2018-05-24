package service.impl;

import dao.ManagerDao;
import dao.MemberDao;
import entity.Manager;
import entity.Member;
import exception.ServiceException;
import factory.ObjectFactory;
import service.ManagerService;

public class ManagerServiceImpl implements ManagerService{

	public void addManager(Manager manager)throws ServiceException {
		ManagerDao managerDao = (ManagerDao) ObjectFactory.getObject("managerDao");
		//判断用户是否存在
		Manager m = managerDao.selectByUsername(manager);
		//若存在
		if(m!=null){
			//抛出异常
			throw new ServiceException("该用户已经存在");
		}
		//若不存在,执行保存操作
		managerDao.insertManager(manager);
		
		
		
	}

	public Manager login(Manager manager) {
		ManagerDao managerDao = (ManagerDao) ObjectFactory.getObject("managerDao");
		Manager m= managerDao.selectByUsernameAndPwd(manager);
			if(m != null){
				return m;
			}else{
				
				throw new ServiceException("用户名或密码错误,请重新登录");
			}
	}

}
