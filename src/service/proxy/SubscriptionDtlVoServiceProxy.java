package service.proxy;

import java.util.ArrayList;
import java.util.List;

import exception.DataAccessException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.SubscriptionDtlService;
import service.SubscriptionDtlVoService;
import transaction.TransactionManager;
import vo.SubscriptionDtlVo;

public class SubscriptionDtlVoServiceProxy implements SubscriptionDtlVoService {

private SubscriptionDtlVoService subscriptionDtlVoService;
	
	public SubscriptionDtlVoServiceProxy(){
		subscriptionDtlVoService=(SubscriptionDtlVoService) ObjectFactory.getObject("subscriptionDtlVoServiceTarget");
	}
	
	
	public List<SubscriptionDtlVo> findSubscriptionDtlVoDaoBySid(Integer sid) {
		
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		
		
		List<SubscriptionDtlVo> dtlVos = new ArrayList<SubscriptionDtlVo>();
		try {
			transactionManager.beginTransaction();
			
			dtlVos = subscriptionDtlVoService.findSubscriptionDtlVoDaoBySid(sid);
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
		
		
		return dtlVos;
	}

}
