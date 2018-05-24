package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import service.RoomService;
import entity.Category;
import factory.ObjectFactory;


public class RoomTypeService extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		RoomService roomService=(RoomService) ObjectFactory.getObject("roomService");
		
		List<Category> categories=roomService.findAllCategory();
		
		
		System.out.println("运行");
		
		JSONArray jsonArray = JSONArray.fromObject(categories);
		String categoriesJson = jsonArray.toString();
		out.print(categoriesJson);
		
	}
	
	

}
