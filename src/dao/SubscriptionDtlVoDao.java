package dao;

import java.util.List;

import vo.SubscriptionDtlVo;

public interface SubscriptionDtlVoDao {

	/**
	 * 根据id查询订单明细
	 * @param id
	 * @return
	 */
	public List<SubscriptionDtlVo> selectSubscriptionDtlVoDaoBySid(Integer sid);
}
