<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    
    #content div{
  	  margin: 10px 0px;
  	}
  	
  	table{
  	  margin:auto;
  	  margin-top:20px;
  	  width:700px;
  	  border-collapse:collapse;
  	}
  	
  	th,td{
  	  border:solid 1px #000000;
  	  padding:6px 1px;
  	}
  	
  	.index{
  	  width: 50px;
  	  text-align:center;
  	}
  	
  	.no{
  	  text-align:center;
  	}
  	
  	.shortname{
  	  text-align:center;
  	}
  	
  	.phone{
  	}
  	
  	.email{
  	}
  	
  	.status{
  	}
  	
  	.opt{
  	  text-align:center;
  	}
  	
  	#content div{
  	  text-align:center;
  	  margin:0;
  	  padding:0;
  	}
  	
  	#content div.button{
  	  text-align:center;
  	  padding-top:15px;
  	}
  	
  </style>
  <title>订单列表</title>
</head>
<body>
<div id="container">
  <div id="header">
    <ul>
      <li><a href="${pageContext.request.contextPath }/checked/manager/logout.do">退出</a></li>
    </ul>
  </div>
  <%@ include file="/WEB-INF/pages/manager/manageMenu.jsp" %>
  <div id="content">
    <table>
      <colgroup>
        <col class="index" />
        <col class="no" />
        <col class="shortname" />
        <col class="phone" />
        <col class="email" />
        <col class="status" />
        <col class="opt" />
      </colgroup>
      <tr>
        <th>序号</th>
        <th>订单号</th>
        <th>联系人</th>
        <th>联系电话</th>
        <th>电子邮件</th>
        <th>状态</th>
        <th>操作</th>
      </tr>
      
       <c:forEach items="${subscriptions }" var="subscription" varStatus="i">
      <tr>
        <td><div>${i.index+1}</div></td>
        <td><div><a href="${pageContext.request.contextPath }/checked/manager/showSubscriptionDetail.do?id=${subscription.id}">${subscription.no}</a></div></td>
        <td><div>${subscription.linkman}</div></td>
        <td>${subscription.phone}</td>
        <td>${subscription.email}</td>
        <td>
            
            <c:if test="${subscription.status==0}">
            <div>
           	待确认
            </div>
            <td>
          <div>
            <a href="${pageContext.request.contextPath }/checked/manager/removeSubscription.do?id=${subscription.id}" onclick="return confirm('真的要删除该订单及其明细信息吗？')">删除</a>
          </div>
        </td>
            </c:if>
            <c:if test="${subscription.status==1}">
            <div>
           <span style="color: green" >已确认</span>
            </div>
             <td></td>
            </c:if>
            <c:if test="${subscription.status==2}">
            <div>
            <span style="color: red" > 已取消</span>
            </div>
            <td>
          <div>
            <a href="${pageContext.request.contextPath }/checked/manager/removeSubscription.do?id=${subscription.id}" onclick="return confirm('真的要删除该订单及其明细信息吗？')">删除</a>
          </div>
        </td>
            </c:if>
          </td>
        
      </tr>
       </c:forEach>
     
    </table>
    <div class="button">
      <input type="button" value="重新查询" onclick="location='${pageContext.request.contextPath }/checked/manager/showSubscriptionQuery.do'"/>
    </div>
  </div>
  <hr />
 <%@ include file="/WEB-INF/pages/pagesfoot.jsp" %>
</div>
</body>
</html>