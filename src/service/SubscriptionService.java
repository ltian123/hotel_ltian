package service;

import java.util.List;

import vo.SubscriptionCriteria;

import entity.Subscription;

public interface SubscriptionService {

	/**
	 * 查询所有的订单
	 * @return
	 */
	public List<Subscription> findAll(Integer mid);
	
	/**
	 * 添加订单
	 * @return
	 */
	public void addSubscription(Subscription subscription);
	
	/**
	 * 根据id查询订单
	 * @return
	 */
	public Subscription findById(int id);
	
	/**
	 * 根据id修改订单
	 * @return
	 */
	public void modifyById(Subscription subscription);
	/**
	 * 查询所有的订单
	 * @return
	 */
	public List<Subscription> findHistory(Integer mid);
	/**
	 * 根据id修改订单状态
	 * @return
	 */
	public void cancelStatusById(Subscription subscription);
	/**
	 * 根据id删除订单
	 * @return
	 */
	public void removeById(Integer id);
	
	/**
	 * 根据条件查询订单
	 * @return
	 */
	public List<Subscription> findByCriteria(SubscriptionCriteria subscriptionCriteria);
	
	
	/**
	 * 根据id修改订单备注和订单状态
	 * @param subscription
	 */
	public void modifyRemarkAndStatus(Subscription subscription);
}
