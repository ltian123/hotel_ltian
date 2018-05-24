package service;

import java.util.List;

import entity.SubscriptionDtl;

public interface SubscriptionDtlService {

	
	/**
	 * 添加SubscriptionDtl
	 * @param subscriptionDtl
	 */
	
	public void addSubscriptionDtl(SubscriptionDtl subscriptionDtl);
	
	/**
	 * 根据id查找订单明细
	 * @param id
	 * @return
	 */
	public SubscriptionDtl findSubscriptionDtlById(Integer id);
	
	/**
	 * 根据订单id查询订单明细
	 * @param sid
	 * @return
	 */
	
	public List<SubscriptionDtl> findSubscriptionDtlBySid(Integer sid);
	
	
	/**
	 * 根据id删除订单明细
	 * @param id
	 */
	public void removeById(Integer id);
	/**
	 * 根据sid删除订单明细
	 * @param id
	 */
	public void removeBySid(Integer sid);
}
