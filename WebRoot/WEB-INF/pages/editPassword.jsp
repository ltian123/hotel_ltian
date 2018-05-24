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
   	 font-size:12;
    }
    .error{
    color:red;
     font-size:12;
    }
  </style>
  <script type="text/javascript">

	function checkpassword(){
		var password = document.getElementById("password");
		var passwordspan = document.getElementById("passwordspan1");
		var reg = /^.{6,16}$/;
		if(reg.test(password.value)){
			passwordspan.innerHTML="密码格式正确";
			passwordspan.className="ok";
			return true;
		}else{
			passwordspan.innerHTML="密码格式错误";
			passwordspan.className="error";
			return false;
		}
	}
  function   checkNewpassword() {
		var password = document.getElementById("newPassword");
		var passwordspan = document.getElementById("passwordspan2");
		var reg = /^.{6,16}$/;
		if(reg.test(password.value)){
			passwordspan.innerHTML="密码格式正确";
			passwordspan.className="ok";
			return true;
		}else{
			passwordspan.innerHTML="密码格式错误";
			passwordspan.className="error";
			return false;
		}
	}
	function checkNewpassword2() {
		var password = document.getElementById("newPassword");
		var password2 = document.getElementById("reNewPassword");
		var passwordspan2 = document.getElementById("passwordspan3");
		var word1 = password.value;
		if(word1 ==""){
			passwordspan2.innerHTML="输入上一步密码";
			passwordspan2.className="error";
			return false;
		}
		if(word1==password2.value){
			passwordspan2.innerHTML="密码与上一步相同";
			passwordspan2.className="ok";
			return true;
		}else{
		passwordspan2.innerHTML="再次输入密码错误";
			passwordspan2.className="error";
			return false;
		}
	}
	
  function checkform(){
		if(checkNewpassword()==true&&checkpassword()==true&&checkNewpassword2()==true){
			return true;
		}else{
			var submitspan = document.getElementById("submitspan");
			submitspan.innerHTML= "请将信息填写完整！";
			submitspan.className="error";
			return false;
		}
	}
  </script>
  <title>修改密码</title>
</head>
<body>
<div id="container">
   <%@ include file="/WEB-INF/pages/pageshead.jsp" %>
  <div id="content" style="width:98%;position:relative">
     <%@ include file="/WEB-INF/pages/pagesSubmenu.jsp" %>
    <div class="subcontent">
      <form action="${pageContext.request.contextPath }/checked/member/modifyPassword.do" method="post" onsubmit="return checkform()">        
        <fieldset>
          <legend>密码信息</legend>
          <div>
            <label for="password">原密码</label>
            <input type="password" name="pwd" onblur="checkpassword()" id="password" />
            <span id="passwordspan1" style="font-size: 10px"></span>
          </div>
          <div>
            <label for="newPassword">新密码</label>
            <input type="password" name="newPwd" onblur="checkNewpassword()"id="newPassword"/>
            <span id="passwordspan2" style="font-size: 10px"></span>
          </div>
          <div>
            <label for="reNewPassword">重复新密码</label>
            <input type="password" name="reNewPwd" onblur="checkNewpassword2()"id="reNewPassword" />
            <span id="passwordspan3" style="font-size: 10px"></span>
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