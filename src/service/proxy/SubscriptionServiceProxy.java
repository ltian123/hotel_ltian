package service.proxy;

import java.util.ArrayList;
import java.util.List;

import entity.Subscription;
import exception.DataAccessException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.SubscriptionService;
import transaction.TransactionManager;
import vo.SubscriptionCriteria;

public class SubscriptionServiceProxy implements SubscriptionService{

	
	
private SubscriptionService subscriptionService;
	
	public SubscriptionServiceProxy() {
		subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionServiceTarget");
	}
	public void addSubscription(Subscription subscription) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			subscriptionService.addSubscription(subscription);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
	}

	public List<Subscription> findAll(Integer mid) {
			List<Subscription> subscriptions=new ArrayList<Subscription>();
			TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
			try {
				transactionManager.beginTransaction();
				
				subscriptions=subscriptionService.findAll(mid);
				
				transactionManager.commit();
			} catch (DataAccessException e) {
				transactionManager.rollback();
				throw new ServiceException(e);
			}
			return subscriptions;
		}
	

	public Subscription findById(int id) {
		Subscription subscription=new Subscription();
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			subscription=subscriptionService.findById(id);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return subscription;
	}
		
	

	public void modifyById(Subscription subscription) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			subscriptionService.modifyById(subscription);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
	}
	public List<Subscription> findHistory(Integer mid) {
		List<Subscription> subscriptions=new ArrayList<Subscription>();
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			subscriptions=subscriptionService.findHistory(mid);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return subscriptions;
	}
	public void cancelStatusById(Subscription subscription) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");

		try {
			transactionManager.beginTransaction();
			
			subscriptionService.cancelStatusById(subscription);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
	}
	public void removeById(Integer id) {
		
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");

		try {
			transactionManager.beginTransaction();
			
			subscriptionService.removeById(id);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
		
	}
	public List<Subscription> findByCriteria(
			SubscriptionCriteria subscriptionCriteria) {
		List<Subscription> subscriptions=new ArrayList<Subscription>();
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");

		try {
			transactionManager.beginTransaction();
			
			subscriptions=subscriptionService.findByCriteria(subscriptionCriteria);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return subscriptions;
	}
	public void modifyRemarkAndStatus(Subscription subscription) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");

		try {
			transactionManager.beginTransaction();
			
			subscriptionService.modifyRemarkAndStatus(subscription);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
	}
	
}
