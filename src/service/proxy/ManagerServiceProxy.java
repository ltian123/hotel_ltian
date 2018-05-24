package service.proxy;

import entity.Manager;
import entity.Member;
import exception.DataAccessException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.ManagerService;
import service.MemberService;
import transaction.TransactionManager;

public class ManagerServiceProxy implements ManagerService{

	
private ManagerService managerService;
	
	public ManagerServiceProxy(){
		managerService=(ManagerService) ObjectFactory.getObject("managerServiceTarget");
	}
	
	
	
	
	public void addManager(Manager manager) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			managerService.addManager(manager);
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
		
		
		
	}

	public Manager login(Manager manager) {
		Manager m = new Manager();
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			m=managerService.login(manager);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return m;
	}

	
}
