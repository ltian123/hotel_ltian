package dao;

import entity.Member;

public interface MemberDao {
/**
 * 添加用户
 * @param member
 */
	public void insertMember(Member member);

	
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @param password
	 */
	public Member selectMemberByUsername(String username);
	
	/**
	 * 根据用户名和密码查询用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	public Member selectMemberByUsernameAndPassword(Member member);
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return member
	 */
	public Member selectById(int id);
	/**
	 * 根据phone查询用户信息
	 * @param phone
	 * @return member
	 */
	public Member selectByPhone(String phone);
	/**
	 * 根据id修改用户信息
	 * @param member
	 * @return
	 */
	public void updateById(Member member);
	/**
	 * 根据id修改用户密码
	 * @param member
	 * @return
	 */
	public void updatePasswordById(Member member);
}
