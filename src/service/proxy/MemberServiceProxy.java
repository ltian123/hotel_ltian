package service.proxy;

import entity.Member;
import exception.DataAccessException;
import exception.ServiceException;
import factory.ObjectFactory;
import service.MemberService;
import transaction.TransactionManager;

public class MemberServiceProxy implements MemberService{

	
	private MemberService memberService;
	
	public MemberServiceProxy(){
		memberService=(MemberService) ObjectFactory.getObject("memberServiceTarget");
	}
	public Member login(Member member) {
		Member m = new Member();
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			m=memberService.login(member);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return m;
	}

	public void register(Member member) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			memberService.register(member);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
	}
	public Member findById(int id) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		Member m = new Member();
		try {
			transactionManager.beginTransaction();
			
			m=memberService.findById(id);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return m;
	}
	public void modifyById(Member member) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			memberService.modifyById(member);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
	}
	public void midifyPasswordById(Member member) {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			memberService.midifyPasswordById(member);
			
			transactionManager.commit();
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		
		
		
	}

}
