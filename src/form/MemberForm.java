package form;

import org.apache.struts.action.ActionForm;

import entity.Member;

public class MemberForm extends ActionForm{

	
	private Member member = new Member();

	public Member getMember() {
		return member;
	}

	public void setUser(Member member) {
		this.member = member;
	}
}
