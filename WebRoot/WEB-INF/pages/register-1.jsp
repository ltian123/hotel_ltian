<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    form{
      margin: 5px 0;
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
    
    #content div input{
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

  function checkname(){
		var name = document.getElementById("username");
		var namespan = document.getElementById("namespan");
		var reg = /^.{4,16}$/;
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
	function checkpassword(){
		var password = document.getElementById("password");
		var passwordspan = document.getElementById("passwordspan");
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
	function checkpassword2(){
		var password = document.getElementById("password");
		var password2 = document.getElementById("repassword");
		var passwordspan2 = document.getElementById("passwordspan2");
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
		if(checkname()==true&&checkpassword()==true&&checkpassword2()==true){
			return true;
		}else{
			var submitspan = document.getElementById("submitspan");
			submitspan.innerHTML= "请将必填信息填写完整！";
			submitspan.className="error";
			return false;
		}
	}
</script>
  <title>用户注册</title>
</head>
<body>
<div id="container">
  <%@ include file="/WEB-INF/pages/pageshead.jsp" %>
  <div id="content">
    <form action="${pageContext.request.contextPath }/regist.do" method="post" onsubmit="return checkform()">
      <fieldset>
        <legend>登录信息[必选]</legend>
        <div>
          <label for="username">用户名</label>
          <input type="text" name="member.username" onblur="checkname()" id="username" />
          <span id="namespan" style="font-size: 10px"></span>
        </div>
        <div>
          <label for="password">密码</label>
          <input type="password" name="member.pwd"  onblur="checkpassword()" id="password" />
          <span id="passwordspan" style="font-size: 10px"></span>
        </div>
        <div>
          <label for="repassword">重复密码</label>
          <input type="password" name="repassword" onblur="checkpassword2()" id="repassword" />
          <span id="passwordspan2" style="font-size: 10px"></span>
        </div>
      </fieldset>
      <fieldset>
        <legend>联系信息[可选]</legend>
        <div>
          <label for="name">联系人</label>
          <input type="text" name="member.name" id="name"/>
        </div>
        <div>
          <label for="phone">联系电话</label>
          <input type="text" name="member.phone" id="phone"/>
        </div>
        <div>
          <label for="email">电子邮件</label>
          <input type="text" name="member.email" id="email"/>
        </div>
      </fieldset>
      <fieldset class="buttons">
        <input type="submit" value="注册" />
         <span id="submitspan"></span>
        <span style="color: red;">${requestScope.registMsg }</span>
      </fieldset>
    </form>
  </div>
  <hr />
   <%@ include file="/WEB-INF/pages/pagesfoot.jsp" %>
</div>
</body>
</html>