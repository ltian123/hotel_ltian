package service.proxy;

import java.util.ArrayList;
import java.util.List;

import dao.SubscriptionDtlDao;

import entity.SubscriptionDtl;
import exception.DataAccessException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.ManagerService;
import service.SubscriptionDtlService;
import transaction.TransactionManager;

public class SubscriptionDtlServiceProxy implements SubscriptionDtlService {

	
	
private SubscriptionDtlService subscriptionDtlService;
	
	public SubscriptionDtlServiceProxy(){
		subscriptionDtlService=(SubscriptionDtlService) ObjectFactory.getObject("subscriptionDtlServiceTarget");
	}
	
	public void addSubscriptionDtl(SubscriptionDtl subscriptionDtl) {
		
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			subscriptionDtlService.addSubscriptionDtl(subscriptionDtl);
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
		

	}

	public SubscriptionDtl findSubscriptionDtlById(Integer id) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		SubscriptionDtl dtl = new SubscriptionDtl();
		try {
			transactionManager.beginTransaction();
			
			dtl = subscriptionDtlService.findSubscriptionDtlById(id);
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return dtl;
	}

	public List<SubscriptionDtl> findSubscriptionDtlBySid(Integer sid) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		List<SubscriptionDtl> dtls =new ArrayList<SubscriptionDtl>();
		try {
			transactionManager.beginTransaction();
			
			dtls = subscriptionDtlService.findSubscriptionDtlBySid(sid);
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return dtls;
	}

	public void removeById(Integer id) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			subscriptionDtlService.removeById(id);
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
	}

	public void removeBySid(Integer sid) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			subscriptionDtlService.removeBySid(sid);
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
	}

}
