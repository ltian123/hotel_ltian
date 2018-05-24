<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    div.submit{
  	  text-align:center;
  	  margin-top: 15px;
  	  border: solid 1px #ffffff;
  	}
  	
  	table{
  	  margin:auto;
  	  margin-top:3px;
  	  width:600px;
  	  border-collapse:collapse;
  	}
  	
  	td{
  	  border:solid 1px #ffffff;
  	  padding:6px 1px;
  	  text-align:center;
  	}
  	
  	fieldset{
  	  border: 0;
  	}
  	
  	#content p{
  	  text-align: center;
  	  margin-top: 20px;
  	}	  
	  
  </style>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
  <title>预定客房</title>

</head>
<body>
<div id="container">
   <%@ include file="/WEB-INF/pages/pageshead.jsp" %>
   
   
  <div id="content">
     <%@ include file="/WEB-INF/pages/pagesSubmenu.jsp" %>
    <div class="subcontent">
      <p>下面是满足您预订条件的房间，请选择一个或多个然后点击完成按钮，点击上一步可以更改预定条件。</p>
      <form action="${pageContext.request.contextPath }/checked/member/createSubscriptionDtl-3.do" method="post">
        <fieldset>
          <table>
            
           <tr>
            <c:forEach items="${rooms }" var="room">
            
             <td>
                <label for="${room.no }">${room.no }</label>
                <input type="checkbox" name="rooms" value="${room.id }" id="${room.no }" />
              </td>
            
            </c:forEach>
            
            </tr>
          </table>
        </fieldset>
        
        <div class="submit">
          <input type="button" value="上一步" onclick="location='${pageContext.request.contextPath }/checked/member/showCreateSubscriptionDtl-1.do '"/>
          <input type="submit" value="完成" />
           <br />
          <span style="color:red">${Msg }</span>
        </div>
      </form>
    </div>
  </div>
  <hr />
  <%@ include file="/WEB-INF/pages/pagesfoot.jsp" %>
</div>
</body>
</html>