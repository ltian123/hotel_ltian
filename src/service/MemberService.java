package service;

import entity.Member;
import exception.ServiceException;

public interface MemberService {

	/**
	 * 用户注册
	 * @param user
	 * @throws UserExistException 
	 */
	public void register(Member member) throws ServiceException;
	
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws ServiceException 
	 */
	public Member login(Member member) throws ServiceException ;
	
	
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return member
	 */
	public Member findById(int id);
	/**
	 * 根据id修改用户信息
	 * @param member
	 * @return
	 */
	public void modifyById(Member member);
	
	/**
	 * 根据id修改用户密码
	 * @param member
	 * @return
	 */
	public void midifyPasswordById(Member member);
	
}
