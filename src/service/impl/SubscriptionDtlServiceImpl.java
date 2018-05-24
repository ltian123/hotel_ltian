package service.impl;

import java.util.List;

import dao.CategoryDao;
import dao.SubscriptionDtlDao;

import entity.SubscriptionDtl;
import factory.ObjectFactory;

public class SubscriptionDtlServiceImpl implements service.SubscriptionDtlService {

	public void addSubscriptionDtl(SubscriptionDtl subscriptionDtl) {
		
		SubscriptionDtlDao subscriptionDtlDao=(SubscriptionDtlDao) ObjectFactory.getObject("subscriptionDtlDao");
		
		subscriptionDtlDao.insertSubscriptionDtl(subscriptionDtl);
	}

	public SubscriptionDtl findSubscriptionDtlById(Integer id) {
		SubscriptionDtlDao subscriptionDtlDao=(SubscriptionDtlDao) ObjectFactory.getObject("subscriptionDtlDao");
		SubscriptionDtl dtl = new SubscriptionDtl();
		dtl = subscriptionDtlDao.selectSubscriptionDtlById(id);
		return dtl;
	}

	public List<SubscriptionDtl> findSubscriptionDtlBySid(Integer sid) {
		SubscriptionDtlDao subscriptionDtlDao=(SubscriptionDtlDao) ObjectFactory.getObject("subscriptionDtlDao");
		return subscriptionDtlDao.selectSubscriptionDtlBySid(sid);
		
		
		
	}

	public void removeById(Integer id) {
		SubscriptionDtlDao subscriptionDtlDao=(SubscriptionDtlDao) ObjectFactory.getObject("subscriptionDtlDao");

		subscriptionDtlDao.deleteById(id);
		
	}

	public void removeBySid(Integer sid) {
		SubscriptionDtlDao subscriptionDtlDao=(SubscriptionDtlDao) ObjectFactory.getObject("subscriptionDtlDao");
		subscriptionDtlDao.deleteBySid(sid);
	}

}
