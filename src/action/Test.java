package action;

import factory.ObjectFactory;
import service.RoomService;

public class Test {
	public static void main(String[] args) {
		RoomService roomService=(RoomService) ObjectFactory.getObject("roomService");
		/**
		 * 
		 * driver=oracle.jdbc.driver.OracleDriver
url=jdbc:oracle:thin:@192.168.17.8:1521:abc
username=tl1
password=tl1
		 * 
		 * driver=com.mysql.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/hotel?useUnicode=true&characterEncoding=utf-8
username=root
password=1234
		 * 
		 * 
		 * 
		 * ajax==》category 但是没有完成
		 *  $(function(){
	  $("#roomType").click(function(){
		 
		    $.getJSON(
		"${pageContext.request.contextPath }/showCategories",
		{}
		function(categories){
			$(categories).each(function(){
				var l = "<option value='"+this.id+"'> "+this.name+"</option>";
					  $("#roomType").append($(l));
			});
			}
	  });
		  
	  
	
		}
	  );
  });
  
		 * 
		 * 
		 * 
		 */
		System.out.println(roomService.findAllCategory());
	}
}
