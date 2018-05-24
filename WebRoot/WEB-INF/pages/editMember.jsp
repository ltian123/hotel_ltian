<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    
  	form{
      margin: 10px 0;
    }
    
    fieldset{
      padding: 0 1em 1em 1em;
      margin: auto;      
      width: 400px;
      display: block;
    }
    
    fieldset div{
      margin: 5px 0;
    }
    
    legend {
  		padding: 1em;
  	}
	
    label{
      float: left;
      width: 100px;
    }
    
    fieldset div input{
      width: 200px;
    }
    
    fieldset.buttons{
      border: solid 1px #ffffff;
      text-align: center;
      display:block;
      margin-top: 20px;
    }
     .ok{
    color:green;
   	 font-size:10;
    }
    .error{
    color:red;
     font-size:10;
    }
  </style>
   <script type="text/javascript">
  	function checkemail(){
    		var email = document.getElementById("email");
    		var emailspan = document.getElementById("emailspan");
    		var reg = /^\w+[@]\w+(\.com)(\.cn)?$/;
    		if(reg.test(email.value)){
    			emailspan.innerHTML="邮箱格式正确";
    			emailspan.className="ok";
    			return true;
    		}else{
    			emailspan.innerHTML="邮箱格式错误";
    			emailspan.className="error";
    			return false;
    		}
    	}
  	
  	
  	function checkname(){
    		var name = document.getElementById("name");
    		var namespan = document.getElementById("namespan");
    		var reg =  /^[\u4e00-\u9fa5]+$/;
    		if(reg.test(name.value)){
    			namespan.innerHTML="格式正确";
    			namespan.className="ok";
    			return true;
    		}else{
    			namespan.innerHTML="格式错误";
    			namespan.className="error";
    			return false;
    		}
    	}
  	
  		function checkphone(){
    		var phone = document.getElementById("phone");
    		var phonespan = document.getElementById("phonespan");
    		var reg =  /^[1][3578]\d{9}$/;
    		if(reg.test(phone.value)){
    			phonespan.innerHTML="格式正确";
    			phonespan.className="ok";
    			return true;
    		}else{
    			phonespan.innerHTML="格式错误";
    			phonespan.className="error";
    			return false;
    		}
    	}
  	
  	 function checkform(){
		if(checkname()==true&&checkemail()==true&&checkphone()==true){
			return true;
		}else{
			var submitspan = document.getElementById("submitspan");
			submitspan.innerHTML= "请将信息填写完整！";
			submitspan.className="error";
			return false;
		}
	}
   </script>
  <title>会员中心</title>
</head>
<body>
<div id="container">
   <%@ include file="/WEB-INF/pages/pageshead.jsp" %>
  <div id="content" style="width:98%;position:relative">
    <%@ include file="/WEB-INF/pages/pagesSubmenu.jsp" %>
    <div class="subcontent">
      <form action="${pageContext.request.contextPath }/checked/member/modifyMember.do" method="post" onsubmit="return checkform()">        
        <fieldset>
          <legend>联系信息</legend>
          <div>
            <label for="name">联系人</label>
            <input type="text" name="name" onblur="checkname()"id="name" value="${member.name }"/>
            <span id="namespan"></span>
          </div>
          <div>
            <label for="phone">联系电话</label>
            <input type="text" name="phone"onblur="checkphone()" id="phone" value="${member.phone }"/>
            <span id="phonespan"></span>
          </div>
          <div>
            <label for="email">电子邮件</label>
            <input type="text" name="email" onblur="checkemail()" id="email" value="${member.email }"/>
            <span id="emailspan"></span>
          </div>
        </fieldset>
        <fieldset class="buttons">
          <input type="submit" value="保存" />
          <span id="submitspan"></span>
          <span style="color: red;">${requestScope.memberMsg }</span>
        </fieldset>
      </form>
    </div>
  </div>
  <hr />
  <%@ include file="/WEB-INF/pages/pagesfoot.jsp" %>
</div>
</body>
</html>