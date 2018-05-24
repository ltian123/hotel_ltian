package service.impl;

import dao.MemberDao;
import entity.Member;
import exception.ServiceException;
import factory.ObjectFactory;
import service.MemberService;

public class MemberServiceImpl implements MemberService{

	
	
	public Member login(Member member) throws ServiceException {
		 MemberDao memberDao = (MemberDao) ObjectFactory.getObject("memberDao");
		Member m = memberDao.selectMemberByUsernameAndPassword(member);
		if(m != null){
			return m;
		}
		throw new ServiceException("用户名或密码错误,请重新登录");
	}

	public void register(Member member) throws ServiceException{
		 MemberDao memberDao = (MemberDao) ObjectFactory.getObject("memberDao");
		//判断用户是否存在
		Member m = memberDao.selectMemberByUsername(member.getUsername());
		//若存在
		if(m!=null){
			//抛出异常
			throw new ServiceException("该用户已经存在");
		}
		//若不存在,执行保存操作
		memberDao.insertMember(member);
		
	}

	public Member findById(int id) {
		 MemberDao memberDao = (MemberDao) ObjectFactory.getObject("memberDao");
		 Member member=memberDao.selectById(id);
		 if(member==null){
			 throw new ServiceException("该用户不存在");
		 }else{
			 
			 return member;
		 }
	}

	public void modifyById(Member member) {
		 MemberDao memberDao = (MemberDao) ObjectFactory.getObject("memberDao");
		 
		 Member m= memberDao.selectByPhone(member.getPhone());
		 Member m1=memberDao.selectById(member.getId());
		 if(m==null||m1.getPhone().equals(member.getPhone())){
			 memberDao.updateById(member);
		 }else{
			 throw new ServiceException("该手机号已存在");
		 }
		
	}

	public void midifyPasswordById(Member member) {
		MemberDao memberDao = (MemberDao) ObjectFactory.getObject("memberDao");
		
		 Member m=memberDao.selectById(member.getId());
		 if(m.getPwd().equals(member.getPwd())){
			 throw new ServiceException("错误：与原密码相同");
		 }else{
			 
			 memberDao.updatePasswordById(member);
		 }
		 
	}
	
	
	
	

}
