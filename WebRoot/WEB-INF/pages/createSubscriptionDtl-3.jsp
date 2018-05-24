<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
  	#content p{
  	  text-align: center;
  	  margin-top: 20px;
  	}	  
	  
  </style>
  <title>预定客房</title>
</head>
<body>
<div id="container">
  <%@ include file="/WEB-INF/pages/pageshead.jsp" %>
  
  
  <div id="content">
    <%@ include file="/WEB-INF/pages/pagesSubmenu.jsp" %>
    <div class="subcontent">
      <p>
        恭喜你，房间预订成功，我们会及时与您联系并再次确认预定信息。在系统确认之前，您仍然可以修改所有预定信息。
      </p>
      <p>
        <a href="${pageContext.request.contextPath }/checked/member/showMemberSubscriptionDetail.do">继续预定</a>
      </p>
    </div>
    <div style="height:130px;"></div>
  </div>
  <hr />
   <%@ include file="/WEB-INF/pages/pagesfoot.jsp" %>
</div>
</body>
</html>