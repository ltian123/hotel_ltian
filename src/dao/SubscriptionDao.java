package dao;

import java.util.List;

import vo.SubscriptionCriteria;

import entity.Subscription;

public interface SubscriptionDao {

	/**
	 * 查询所有的订单
	 * @return
	 */
	public List<Subscription> selectAll(Integer mid);
	
	/**
	 * 添加订单
	 * @return
	 */
	public void insertSubscription(Subscription subscription);
	
	/**
	 * 根据id查询订单
	 * @return
	 */
	public Subscription selectById(int id);
	
	/**
	 * 根据id修改订单
	 * @return
	 */
	public void updateById(Subscription subscription);
	/**
	 * 查询所有的订单
	 * @return
	 */
	public List<Subscription> selectHistory(Integer mid);
	/**
	 * 根据id修改订单状态
	 * @return
	 */
	public void updateStatusById(Subscription subscription);
	
	/**
	 * 根据id删除订单
	 * @return
	 */
	public void delectById(Integer id);
	/**
	 * 根据条件查询订单
	 * @return
	 */
	public List<Subscription> selectByCriteria(SubscriptionCriteria subscriptionCriteria);
	
	
	
	/**
	 * 根据id修改订单备注和订单状态
	 * @param subscription
	 */
	public void updateRemarkAndStatus(Subscription subscription);
	
}
