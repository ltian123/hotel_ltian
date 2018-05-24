package action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import constant.Constant;

import service.CategoryService;
import service.MemberService;
import service.ResideService;
import service.RoomService;
import service.SubscriptionDtlService;
import service.SubscriptionDtlVoService;
import service.SubscriptionService;
import vo.RoomCriteria;
import vo.SubscriptionDtlVo;
import entity.Category;
import entity.Member;
import entity.Reside;
import entity.Room;
import entity.Subscription;
import entity.SubscriptionDtl;
import factory.ObjectFactory;

public class SubscriptionDtlAction extends MappingDispatchAction  {
	
	//member  界面显示订单明细
	public ActionForward showDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sid = request.getParameter("id");
		
		SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");
		
		try {
			Subscription subscription = new Subscription();
			
			subscription=subscriptionService.findById(Integer.parseInt(sid));
			request.setAttribute("subscription", subscription);
			
			Integer mid = subscription.getMember().getId();
			MemberService memberService=(MemberService) ObjectFactory.getObject("memberService");
			
			Member member = memberService.findById(mid);
			request.setAttribute("member", member);
			
			SubscriptionDtlService subscriptionDtlService=(SubscriptionDtlService) ObjectFactory.getObject("subscriptionDtlService");
			List<SubscriptionDtl> subscriptionDtls = subscriptionDtlService.findSubscriptionDtlBySid(Integer.parseInt(sid));
			request.setAttribute("subscriptionDtls", subscriptionDtls);
			
			SubscriptionDtlVoService subscriptionDtlVoService=(SubscriptionDtlVoService) ObjectFactory.getObject("subscriptionDtlVoService");
			List<SubscriptionDtlVo> dtlVos = new ArrayList<SubscriptionDtlVo>();
			dtlVos = subscriptionDtlVoService.findSubscriptionDtlVoDaoBySid(Integer.parseInt(sid));
			request.setAttribute("subscriptionDtlVos", dtlVos);
			
			String path = request.getServletPath();
			if(path.equals("/checked/member/showCenterDetail.do")){
				request.setAttribute("path", "path1");
			}
			if(path.equals("/checked/member/showHistoryDetail.do")){
				request.setAttribute("path", "path2");
			}
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
		
	}
	//管理员 获取订单明细
	public ActionForward showSubscriptionDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sid = request.getParameter("id");
		if(sid==null){
			sid=(Integer) request.getAttribute("id")+"";
		}
		SubscriptionService subscriptionService=(SubscriptionService) ObjectFactory.getObject("subscriptionService");
		
		try {
			Subscription subscription = new Subscription();
			
			subscription=subscriptionService.findById(Integer.parseInt(sid));
			request.setAttribute("subscription", subscription);
			
			Integer mid = subscription.getMember().getId();
			MemberService memberService=(MemberService) ObjectFactory.getObject("memberService");
			
			Member member = memberService.findById(mid);;
			request.setAttribute("member", member);
			
			SubscriptionDtlService subscriptionDtlService=(SubscriptionDtlService) ObjectFactory.getObject("subscriptionDtlService");
			List<SubscriptionDtl> subscriptionDtls = subscriptionDtlService.findSubscriptionDtlBySid(Integer.parseInt(sid));
			request.setAttribute("subscriptionDtls", subscriptionDtls);
			
			SubscriptionDtlVoService subscriptionDtlVoService=(SubscriptionDtlVoService) ObjectFactory.getObject("subscriptionDtlVoService");
			List<SubscriptionDtlVo> dtlVos = new ArrayList<SubscriptionDtlVo>();
			dtlVos = subscriptionDtlVoService.findSubscriptionDtlVoDaoBySid(Integer.parseInt(sid));
			request.setAttribute("subscriptionDtlVos", dtlVos);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
		
	}
	//删除订单明细 连带删除reside表中的信息
	public ActionForward removeSubscriptionDtl(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SubscriptionDtlService subscriptionDtlService=(SubscriptionDtlService) ObjectFactory.getObject("subscriptionDtlService");
		ResideService resideService=(ResideService) ObjectFactory.getObject("resideService");

		Integer sdid = Integer.parseInt(request.getParameter("sdid"));
		Integer sid = Integer.parseInt(request.getParameter("sid"));
	try{	
		
		request.setAttribute("id", sid);
		resideService.removeByDtlid(sdid);
		subscriptionDtlService.removeById(sdid);
		return mapping.findForward("success");
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("Msg", e.getMessage());
		return mapping.findForward("fail");
	}
		
	}
	//member界面 删除 订单明细
	public ActionForward removeMemberSubscriptionDtl(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SubscriptionDtlService subscriptionDtlService=(SubscriptionDtlService) ObjectFactory.getObject("subscriptionDtlService");
		ResideService resideService=(ResideService) ObjectFactory.getObject("resideService");

		Integer sdid = Integer.parseInt(request.getParameter("sdid"));
		Integer sid = Integer.parseInt(request.getParameter("sid"));
	try{	
		
		request.setAttribute("id", sid);
		resideService.removeByDtlid(sdid);
		subscriptionDtlService.removeById(sdid);
		return mapping.findForward("success");
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("Msg", e.getMessage());
		return mapping.findForward("fail");
	}
	
		
		
	}
	
	//member 界面 点击 客房信息 后的 展示界面
	public ActionForward showMemberSubscriptionDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sid = request.getParameter("sid");
		if(sid==null){
			sid = (String) request.getSession().getAttribute("sid");
		}
		SubscriptionDtlVoService subscriptionDtlVoService=(SubscriptionDtlVoService) ObjectFactory.getObject("subscriptionDtlVoService");
		List<SubscriptionDtlVo> dtlVos = new ArrayList<SubscriptionDtlVo>();
		request.getSession().setAttribute("sid", sid);
		try{	
			dtlVos = subscriptionDtlVoService.findSubscriptionDtlVoDaoBySid(Integer.parseInt(sid));
			request.getSession().setAttribute("roomCriteria", null);
			request.setAttribute("subscriptionDtlVos", dtlVos);
			request.setAttribute("sid", sid);
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("Msg", e.getMessage());
			return mapping.findForward("fail");
		}
		
	}
	
	//展示新建预订的界面1 传入categories
	public ActionForward showCreateSubscriptionDtl1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RoomService roomService=(RoomService) ObjectFactory.getObject("roomService");
		String sid = request.getParameter("sid");
		if(sid==null){
			sid = (String)request.getSession().getAttribute("sid");
		}
		List<Category> categories=roomService.findAllCategory();
		
		request.setAttribute("categories", categories);
		request.setAttribute("sid", Integer.parseInt(sid));
		return mapping.findForward("success");
		
	}
	
	//创建新预订
	public ActionForward createSubscriptionDtl3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SubscriptionDtlService subscriptionDtlService=(SubscriptionDtlService) ObjectFactory.getObject("subscriptionDtlService");
		RoomCriteria roomCriteria = (RoomCriteria) request.getSession().getAttribute("roomCriteria");
		
		CategoryService categoryService=(CategoryService) ObjectFactory.getObject("categoryService");
		RoomService roomService=(RoomService) ObjectFactory.getObject("roomService");
		ResideService resideService=(ResideService) ObjectFactory.getObject("resideService");
		try{

		String[] rooms = request.getParameterValues("rooms");
		String sid = (String) request.getSession().getAttribute("sid");
		if(rooms==null){
			request.setAttribute("Msg", "请选择房间");
			return mapping.findForward("fail");
		}
		SubscriptionDtl subscriptionDtl = new SubscriptionDtl();
		
		subscriptionDtl.setEdate(roomCriteria.getEdate());
		subscriptionDtl.setSdate(roomCriteria.getSdate());
		subscriptionDtl.setResidetype(roomCriteria.getResidetype());

		Room room = new Room();
		Subscription subscription = new Subscription();
		subscription.setId(Integer.parseInt(sid));
		
		subscriptionDtl.setSubscription(subscription);
		
		
		for(int i=0;i<rooms.length;i++){
			
			Room r = roomService.findById(Integer.parseInt(rooms[i]));
			Category category= categoryService.findCategoryById(r.getCategory().getId());
			//订购一张床
			if((roomCriteria.getResidetype()+"").equals(Constant.RESERVE_WAY_SINGLE)){
				subscriptionDtl.setPrice(category.getBedprice());
			}else{
				//订购一个房间
				subscriptionDtl.setPrice(category.getRoomprice());
			}
			room.setId(Integer.parseInt(rooms[i]));
			
			subscriptionDtl.setRoom(room);
			subscriptionDtlService.addSubscriptionDtl(subscriptionDtl);
			//添加reside表的数据库
			Reside reside = new Reside();
			reside.setSubscriptionDtl(subscriptionDtl);
			Calendar cSdate = Calendar.getInstance();
			cSdate.setTime(roomCriteria.getSdate());
			Calendar cEdate = Calendar.getInstance();
			cEdate.setTime(roomCriteria.getEdate());
			while(cSdate.before(cEdate)){
				cSdate.add(Calendar.DAY_OF_MONTH,1);
				reside.setResidedate(cSdate.getTime());
				resideService.addReside(reside);
				
			}
		}
		//置空session中的对象
		request.getSession().setAttribute("roomCriteria", null);
		return mapping.findForward("success");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("Msg", e.getMessage());
				return mapping.findForward("fail");
			}
	}
}
