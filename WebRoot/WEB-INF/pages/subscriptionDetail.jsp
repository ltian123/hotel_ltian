<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    h1{
      text-align: center;
      font-size: 1em;
      padding: 0.3em 0;
      margin-top: 20px;
    }    
   
  	div.submit{
  	  text-align:center;
  	  margin-top: 15px;
  	  border: solid 1px #ffffff;
  	}
  	
  	table{
  	  margin:auto;
  	  margin-top:5px;
  	  width:720px;
  	  border-collapse:collapse;
  	}
  	
  	th,td{
  	  border:solid 1px #000000;
  	  padding:6px 1px;
  	}
  	
  	.category{
  	  text-align:center;
  	}
  	
  	.date{
  	  text-align:center;
  	}
  	
  	.opt{
  	  text-align:center;
  	}
  	
  	td div{
  	  text-align: center;
  	  margin: 0;
  	  padding: 0;
  	}
  	
  	.text{
  	  width:390px;
  	}
  	
  </style>
  <title>订单明细信息</title>
</head>
<body>
<div id="container">
  <%@ include file="/WEB-INF/pages/pageshead.jsp" %>
  
  
  <div id="content">
     <%@ include file="/WEB-INF/pages/pagesSubmenu.jsp" %>
    <div class="subcontent">
      <h1>订单明细信息管理</h1>
      <table>
        <colgroup>
          <col class="category" />
          <col class="no" />
          <col />
          <col />
          <col span="2" class="date" />
          <col class="opt" />
        </colgroup>
        <tr>
          <th>房间类型</th>
          <th>房间号</th>
          <th>预定方式</th>
          <th>单价(元)</th>
          <th>入住日期</th>
          <th>退房日期</th>
          <th>操作</th>
        </tr>
        
        
        <c:forEach items="${subscriptionDtlVos}" var="subscriptionDtlVo" varStatus="i">
      <tr>
        <td><div>${subscriptionDtlVo.categoryName}</div></td>
        <td><div>${subscriptionDtlVo.roomNo}</div></td>
        <td><div>${subscriptionDtlVo.residetype eq "1"?"单个床位":"整个房间"}</div></td>
        <td><div>${subscriptionDtlVo.price}</div></td>
        <td><fmt:formatDate value="${subscriptionDtlVo.sdate}" pattern="yyyy-MM-dd HH:mm:ss "/></td>
        <td><fmt:formatDate value="${subscriptionDtlVo.edate}" pattern="yyyy-MM-dd HH:mm:ss "/></td>
        <td>
          <div>
	            <a href="${pageContext.request.contextPath }/checked/member/removeSubscriptionDtl.do?sdid=${subscriptionDtlVo.id}&sid=${subscriptionDtlVo.sid}" onclick="return confirm('真的要删除该预定细信息吗？')">删除</a>
          </div>
        </td>
      </tr>
      </c:forEach>
        
        
      </table>
      <div class="submit">
        <input type="button" value="返回" onclick="location='${pageContext.request.contextPath }/checked/member/memberCenter.do'"/>
        <input type="button" value="新增预定" onclick="location='${pageContext.request.contextPath }/checked/member/showCreateSubscriptionDtl-1.do?sid=${sid} '"/>
      </div>
    </div>
  </div>
  <hr />
   <%@ include file="/WEB-INF/pages/pagesfoot.jsp" %>
</div>
</body>
</html>