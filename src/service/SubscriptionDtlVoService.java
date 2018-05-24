package service;

import java.util.List;

import vo.SubscriptionDtlVo;

public interface SubscriptionDtlVoService {

	
	/**
	 * 根据id查询订单明细
	 * @param id
	 * @return
	 */
	public List<SubscriptionDtlVo> findSubscriptionDtlVoDaoBySid(Integer sid);
}
