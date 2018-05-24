package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import constant.Constant;

import service.ResideService;
import service.RoomService;
import service.SubscriptionDtlService;
import service.SubscriptionService;
import vo.SubscriptionCriteria;
import entity.Category;
import entity.Member;
import entity.Subscription;
import entity.SubscriptionDtl;
import factory.ObjectFactory;
import form.SubscriptionCriteriaForm;

public class SubscriptionAction extends MappingDispatchAction {

	//查找所有的订单，member通过session获取
	public ActionForward findAllSubscription(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");
		
		Member m = (Member) request.getSession().getAttribute("member");
		
		
		try {
			List<Subscription> subscriptions=subscriptionService.findAll(m.getId());
			
			request.setAttribute("subscriptions", subscriptions);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	//查询所有的历史订单，其中订单状态为取消或者已确定的
	public ActionForward historySubscription(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");
		
		Member m = (Member) request.getSession().getAttribute("member");
		
		try {
			List<Subscription> subscriptions=subscriptionService.findHistory(m.getId());
			
			request.setAttribute("subscriptions", subscriptions);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	//设置订单状态为取消状态，未用到
	public ActionForward cancelSubscription(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");

		String id = request.getParameter("id");
		
		Subscription subscription = new Subscription();
		subscription.setId(Integer.parseInt(id));
		
		try {
			subscriptionService.cancelStatusById(subscription);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	//删除订单
	public ActionForward removeSubscription(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");
		SubscriptionDtlService subscriptionDtlService=(SubscriptionDtlService) ObjectFactory.getObject("subscriptionDtlService");
		ResideService resideService=(ResideService) ObjectFactory.getObject("resideService");

		String id = request.getParameter("id");
		try {
			List<SubscriptionDtl> subscriptionDtls=subscriptionDtlService.findSubscriptionDtlBySid(Integer.parseInt(id));
			for(int i=0;i<subscriptionDtls.size();i++){
				resideService.removeByDtlid(subscriptionDtls.get(i).getId());
			}
			subscriptionDtlService.removeBySid(Integer.parseInt(id));
			
			
			subscriptionService.removeById(Integer.parseInt(id));
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	//展示 订单内 的 联系人信息
	public ActionForward showEditSubscription(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");

		String id = request.getParameter("id");
		
		Subscription subscription = new Subscription();
		
		
		try {
			subscription = subscriptionService.findById(Integer.parseInt(id));
			
			request.setAttribute("subscription", subscription);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	//修改联系人信息
	public ActionForward modifyEditSubscription(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String linkman = request.getParameter("linkman");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");
		Subscription subscription = new Subscription();
		subscription.setId(Integer.parseInt(id));
		subscription.setLinkman(linkman);
		subscription.setPhone(phone);
		subscription.setEmail(email);
		
		
		try {
			subscriptionService.modifyById(subscription);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
		
	}
	//创建新的订单
	public ActionForward createNewSubscription(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String linkman = request.getParameter("linkman");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");
		Subscription subscription = new Subscription();
		subscription.setLinkman(linkman);
		subscription.setPhone(phone);
		subscription.setEmail(email);
		subscription.setCretime(new Date());
		Member m = (Member) request.getSession().getAttribute("member");
		subscription.setMember(m);
		subscription.setStatus(Constant.SUBSCRIPTION_STATUS_INEFFECTIVE);
		subscription.setNo(getNo());
		try {
			subscriptionService.addSubscription(subscription);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
		
	}
	
	
	//管理员，查询所有的符合条件的订单
	public ActionForward querySubscriptionList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");
		
		SubscriptionCriteriaForm sForm = (SubscriptionCriteriaForm) form;
		SubscriptionCriteria sCriteria = sForm.getSubscriptionCriteria();
		//房间类型为0;不限类型，
		if(sCriteria.getCategoryId()==null){
			sCriteria.setCategoryId(0);
		}
		if(sCriteria.getSubscirptionStatus()==null){
			sCriteria.setSubscirptionStatus("-1");
		}
		
		List<Subscription> subscriptions=new ArrayList<Subscription>();
		subscriptions=subscriptionService.findByCriteria(sCriteria);
		request.setAttribute("subscriptions", subscriptions);
		return mapping.findForward("success");
	}
	
	
	//修改订单备注
	public ActionForward modifyRemarkAndStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");
		String id = request.getParameter("id");
		String remark = request.getParameter("remark");
		String status = request.getParameter("status");
		Subscription subscription = new Subscription();
		subscription.setId(Integer.parseInt(id));
		subscription.setRemark(remark);
		subscription.setStatus(status);
		try {
			subscriptionService.modifyRemarkAndStatus(subscription);
			request.setAttribute("Msg", "订单状态和备注保存成功");
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
		
		
	}
	
	
	//订单编号获取方法
	public static String getNo(){
		Random random = new Random();
		String str = "qwertyuioplkjhgfdsazxcvbnm";
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++){
			sb.append(str.charAt(random.nextInt(str.length())));
		}
		return sb.toString()+new Date().getTime();
	}
}
