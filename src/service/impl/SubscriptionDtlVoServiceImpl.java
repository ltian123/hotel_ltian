package service.impl;

import java.util.List;

import dao.SubscriptionDtlDao;
import dao.SubscriptionDtlVoDao;
import factory.ObjectFactory;
import service.SubscriptionDtlVoService;
import vo.SubscriptionDtlVo;

public class SubscriptionDtlVoServiceImpl implements SubscriptionDtlVoService {

	public List<SubscriptionDtlVo> findSubscriptionDtlVoDaoBySid(Integer sid) {

		SubscriptionDtlVoDao subscriptionDtlVoDao=(SubscriptionDtlVoDao) ObjectFactory.getObject("subscriptionDtlVoDao");
		
		
		return subscriptionDtlVoDao.selectSubscriptionDtlVoDaoBySid(sid);
	}

}
