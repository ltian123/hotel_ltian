package dao;

import java.util.List;

import entity.SubscriptionDtl;

public interface SubscriptionDtlDao {

	/**
	 * 添加SubscriptionDtl
	 * @param subscriptionDtl
	 */
	
	public void insertSubscriptionDtl(SubscriptionDtl subscriptionDtl);
	
	/**
	 * 根据id查找订单明细
	 * @param id
	 * @return
	 */
	public SubscriptionDtl selectSubscriptionDtlById(Integer id);
	
	/**
	 * 根据订单id查询订单明细
	 * @param sid
	 * @return
	 */
	
	public List<SubscriptionDtl> selectSubscriptionDtlBySid(Integer sid);
	
	/**
	 * 根据id删除订单明细
	 * @param id
	 */
	public void deleteById(Integer id);
	/**
	 * 根据sid删除订单明细
	 * @param id
	 */
	public void deleteBySid(Integer sid);
	
}
