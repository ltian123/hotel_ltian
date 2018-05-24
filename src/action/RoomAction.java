package action;

import java.text.SimpleDateFormat;
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

import entity.Category;
import entity.Room;
import factory.ObjectFactory;

import service.RoomService;
import vo.RoomCriteria;

public class RoomAction extends MappingDispatchAction{
	//查找所有的categories操作
	public ActionForward findAllCategory(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		RoomService roomService=(RoomService) ObjectFactory.getObject("roomService");
		
		List<Category> categories=roomService.findAllCategory();
		
		request.setAttribute("categories", categories);
		
		return mapping.findForward("success");
	}
	
	//查找所有的可用房间操作
	public ActionForward findAvailableRoom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String roomType = request.getParameter("roomType");
		String bookType = request.getParameter("bookType");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String sid = request.getParameter("sid");
		
		
		RoomCriteria roomCriteria = new RoomCriteria();
		if(roomType!=null){
			
			roomCriteria.setCategoryId(Integer.parseInt(roomType));
		}
		if(bookType!=null){
			roomCriteria.setResidetype(Integer.parseInt(bookType));
			
		}
		if(startDate!=null){
			if(!startDate.equals("")){
				
				roomCriteria.setSdate(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
			}
			if(startDate.equals("")){
				request.setAttribute("Msg", "请填写日期");
				
				return mapping.findForward("fail");
			}
			
		}
		if(endDate!=null){
			if(!endDate.equals("")){
				roomCriteria.setEdate(new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
			}
			if(endDate.equals("")){
				request.setAttribute("Msg", "请填写日期");
				
				return mapping.findForward("fail");
			}
		}
		if(roomType==null&&bookType==null&&startDate==null&&endDate==null){
			 roomCriteria = (RoomCriteria) request.getSession().getAttribute("roomCriteria");
			 sid =  (String) request.getSession().getAttribute("sid");
		}
		
		Calendar cSdate = Calendar.getInstance();
		cSdate.setTime(roomCriteria.getSdate());
		Calendar cEdate = Calendar.getInstance();
		cEdate.setTime(roomCriteria.getEdate());
		
		while(cEdate.before(cSdate)){
			request.setAttribute("Msg", "请填写正确的日期");
			return mapping.findForward("fail");
		}
		
		RoomService roomService=(RoomService) ObjectFactory.getObject("roomService");
		List<Room> rooms = new ArrayList<Room>();
		if((roomCriteria.getResidetype()+"").equals(Constant.RESERVE_WAY_SINGLE)){
			 rooms = roomService.findAvailableSingleRoom(roomCriteria);
		}else{
			 rooms = roomService.findAvailableWholeRoom(roomCriteria);
		}
		request.setAttribute("rooms", rooms);
		request.getSession().setAttribute("sid", sid);
		request.getSession().setAttribute("roomCriteria", roomCriteria);
		return mapping.findForward("success");
	}
}
