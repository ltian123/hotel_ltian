package service.proxy;

import entity.Reside;
import exception.DataAccessException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.MemberService;
import service.ResideService;
import transaction.TransactionManager;

public class ResideServiceProxy implements ResideService {

	
private ResideService resideService;
	
	public ResideServiceProxy(){
		resideService=(ResideService) ObjectFactory.getObject("resideServiceTarget");
	}
	
	
	public void addReside(Reside reside) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			
			resideService.addReside(reside);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}

	}


	public void removeByDtlid(Integer dtlid) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			
			resideService.removeByDtlid(dtlid);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
	}

}
