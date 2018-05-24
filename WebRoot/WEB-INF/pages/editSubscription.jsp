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
      margin: 15px 0;
    }
    
    fieldset{
      padding: 0 1em 1em 1em;
      margin: auto;      
      width: 400px;
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
    
    div.label{
      margin:auto;
      width: 400px;
      margin-top: 20px;
    }
  	
  </style>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
  <title>修改订单</title>
	<script type="text/javascript">
		$(function(){
			$("#name").blur(function(){
				var id=$("#name").val().replace(/\s/g,"");
				if(id == ""){
					$("#name").next("span").show();
				}else{
					$("#name").next("span").hide();
				}
			});
			$("#phone").blur(function(){
				var tel=/^1\d{10}$/;
				if(!tel.test($("#phone").val())){
					$("#phone").next("span").show();
				}else{
					$("#phone").next("span").hide();
				}
			});
			$("#email").blur(function(){
				var tel=/^\w+[@]\w+(\.com)(\.cn)?$/;
				if(!tel.test($("#email").val())){
					$("#email").next("span").show();
				}else{
					$("#email").next("span").hide();
				}
			});
			
			
		});

	</script>
	</head>
<body>
<div id="container">
   <%@ include file="/WEB-INF/pages/pageshead.jsp" %>
  <div id="content">
     <%@ include file="/WEB-INF/pages/pagesSubmenu.jsp" %>
    <div class="subcontent">
      <form action="${pageContext.request.contextPath }/checked/member/modifyEditSubscription.do">
        <fieldset>
          <legend>联系人信息</legend>
          <div>
            <label for="name">联系人</label>
            <input type="hidden" name="id" value="${subscription.id }" />
            <input type="text" name="linkman" id="name" value="${subscription.linkman }"/>
             <span style="font-size:10px;display:none;color:red">不能为空</span>
          </div>
          <div>
            <label for="phone">联系电话</label>
            <input type="text" name="phone" id="phone" value="${subscription.phone}"/>
            <span style="font-size:10px;display:none;color:red">请输入正确的电话</span>
          </div>
          <div>
            <label for="email">电子邮件</label>
            <input type="text" name="email" id="email" value="${subscription.email  }"/>
            <span style="font-size:10px;display:none;color:red">请输入正确的邮箱</span>
          </div>
        </fieldset>
        <fieldset class="buttons">
          <input type="button" value="取消" onclick="location='${pageContext.request.contextPath }/checked/member/memberCenter.do'"/>
          <input type="submit" value="保存" />
           <span style="color: red;">${requestScope.Msg }</span>
        </fieldset>
      </form>
    </div>
  </div>
  <hr />
   <%@ include file="/WEB-INF/pages/pagesfoot.jsp" %>
</div>
</body>
</html>