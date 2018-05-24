package service.impl;

import java.util.List;
import constant.Constant;
import dao.SubscriptionDao;

import entity.Subscription;
import factory.ObjectFactory;
import service.SubscriptionService;
import vo.SubscriptionCriteria;

public class SubscriptionServiceImpl implements SubscriptionService{


	public void addSubscription(Subscription subscription) {
		
		SubscriptionDao subscriptionDao=(SubscriptionDao) ObjectFactory.getObject("subscriptionDao");
		
		subscriptionDao.insertSubscription(subscription);
		
		
	}

	public List<Subscription> findAll(Integer mid) {
		SubscriptionDao subscriptionDao=(SubscriptionDao) ObjectFactory.getObject("subscriptionDao");
		List<Subscription> subscriptions= subscriptionDao.selectAll(mid);
		return subscriptions;
	}

	public Subscription findById(int id) {
		SubscriptionDao subscriptionDao=(SubscriptionDao) ObjectFactory.getObject("subscriptionDao");
		
		return subscriptionDao.selectById(id);
	}

	public void modifyById(Subscription subscription) {
		SubscriptionDao subscriptionDao=(SubscriptionDao) ObjectFactory.getObject("subscriptionDao");
		subscriptionDao.updateById(subscription);
	}

	public List<Subscription> findHistory(Integer mid) {
		SubscriptionDao subscriptionDao=(SubscriptionDao) ObjectFactory.getObject("subscriptionDao");
		List<Subscription> subscriptions= subscriptionDao.selectHistory(mid);
		return subscriptions;
	}

	public void cancelStatusById(Subscription subscription) {
		SubscriptionDao subscriptionDao=(SubscriptionDao) ObjectFactory.getObject("subscriptionDao");
		subscription.setStatus(Constant.SUBSCRIPTION_STATUS_CANCEL);
		
		subscriptionDao.updateStatusById(subscription);
		
	}

	public void removeById(Integer id) {
		SubscriptionDao subscriptionDao=(SubscriptionDao) ObjectFactory.getObject("subscriptionDao");
		
		subscriptionDao.delectById(id);
		
	}

	public List<Subscription> findByCriteria(
			SubscriptionCriteria subscriptionCriteria) {
		SubscriptionDao subscriptionDao=(SubscriptionDao) ObjectFactory.getObject("subscriptionDao");
		List<Subscription> subscriptions=subscriptionDao.selectByCriteria(subscriptionCriteria);
		
		
		return subscriptions;
	}

	public void modifyRemarkAndStatus(Subscription subscription) {
		SubscriptionDao subscriptionDao=(SubscriptionDao) ObjectFactory.getObject("subscriptionDao");
		
		subscriptionDao.updateRemarkAndStatus(subscription);
		
		
		
	}

}
