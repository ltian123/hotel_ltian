package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import service.ManagerService;
import service.MemberService;
import service.RoomService;
import util.MD5Util;
import vo.SubscriptionCriteria;
import entity.Category;
import entity.Manager;
import entity.Member;
import factory.ObjectFactory;
import form.MemberForm;
import form.SubscriptionCriteriaForm;

public class ManagerAction extends MappingDispatchAction {

	//manager登录
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		if(username.equals("")||pwd.equals("")){
			request.setAttribute("loginMsg", "登录信息不完整");
			return mapping.findForward("fail");
		}
		ManagerService managerService=(ManagerService) ObjectFactory.getObject("managerService");
		Manager manager = new Manager();

		manager.setUsername(username);
		manager.setPwd(MD5Util.md5(pwd));
		Manager m = new Manager();
		m=managerService.login(manager);
		request.getSession().setAttribute("manager", m);
		return mapping.findForward("success");
	}
	
	
	//manager取消登录
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.getSession().invalidate();
		
		return mapping.findForward("success");
	}
	
	//show manager 查询界面，传入categories作下拉用
	public ActionForward showSubcriptionQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RoomService roomService=(RoomService) ObjectFactory.getObject("roomService");
		
		List<Category> categories=roomService.findAllCategory();
		request.setAttribute("categories", categories);
		return mapping.findForward("success");
	}
}
