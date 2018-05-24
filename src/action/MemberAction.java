package action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import service.MemberService;
import service.RoomService;
import util.MD5Util;
import entity.Member;
import exception.ServiceException;
import factory.ObjectFactory;
import form.MemberForm;

public class MemberAction extends MappingDispatchAction{

	//通过订单号进入明细界面后，返回跳转传出path选择返回界面
	public ActionForward memberReback(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String path =  request.getParameter("path");
		return mapping.findForward(path);
		
	}
	//member登出界面
	public ActionForward logOut(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.getSession().invalidate();
		
		return mapping.findForward("success");
		
	}
	
	
	
	//member登录
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		if(username.equals("")||pwd.equals("")){
			request.setAttribute("loginMsg", "登录信息不完整");
			return mapping.findForward("fail");
		}
		MemberService memberService=(MemberService) ObjectFactory.getObject("memberService");
		Member member = new Member();
		member.setUsername(username);
		member.setPwd(MD5Util.md5(pwd));
		Member m = new Member();
		
			m=memberService.login(member);
			request.getSession().setAttribute("member", m);
			return mapping.findForward("success");
	}
	
	//用户member注册
	public ActionForward regist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberService memberService=(MemberService) ObjectFactory.getObject("memberService");
		MemberForm memberForm = (MemberForm) form;
		Member member = memberForm.getMember();
		member.setPwd(MD5Util.md5(member.getPwd()));
		member.setRegtime(new Date());
		try {
			memberService.register(member);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("registMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	//show会员修改信息
	public ActionForward showMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			Member m = (Member) request.getSession().getAttribute("member");
			MemberService memberService=(MemberService) ObjectFactory.getObject("memberService");
			Member member= memberService.findById(m.getId());
			request.setAttribute("member", member);
			return mapping.findForward("success");
		} catch (Exception e) {
			request.setAttribute("memberMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	//修改会员信息
	public ActionForward modifyMember(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		Member m= (Member) request.getSession().getAttribute("member");
		Member member =new Member();
		member.setId(m.getId());
		if(!name.equals("")){
			member.setName(name);
		}
		if(!phone.equals("")){
			member.setPhone(phone);
		}else{
			request.setAttribute("memberMsg", "请填写手机号码");
			return mapping.findForward("fail");
		}
		if(!email.equals("")){
			member.setEmail(email);
		}
		
		try {
			MemberService memberService=(MemberService) ObjectFactory.getObject("memberService");
			memberService.modifyById(member);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("memberMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	//修改密码操作
	public ActionForward modifyPassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String pwd = request.getParameter("pwd");
		String newPwd = request.getParameter("newPwd");
		Member m= (Member) request.getSession().getAttribute("member");
		try {
			MemberService memberService=(MemberService) ObjectFactory.getObject("memberService");
			Member member = memberService.findById(m.getId());
			
			if(member.getPwd().equals(MD5Util.md5(pwd))){
				member.setPwd(MD5Util.md5(newPwd));
				memberService.midifyPasswordById(member);
				return mapping.findForward("success");
			}else{
				request.setAttribute("memberMsg", "原密码错误");
				return mapping.findForward("fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("memberMsg", e.getMessage());
			return mapping.findForward("fail");
		}
		
		
	}
	
}
