<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
  	div.submit{
  	  text-align:center;
  	  margin-top: 15px;
  	  border: solid 1px #ffffff;
  	}
  	
  	form{
  	  margin-top: 20px;
  	}
  	
  	label{
  	  width:70px;
  	  display:block;
  	  float:left;
  	  text-align: center;
  	  padding: 3px 0;
  	}
  	
  	fieldset{
  	  position:relative;
      width:450px;
      margin:auto;
      margin-top:20px;
  	}
  	
  	fieldset select{
  	  width:120px;
  	}
  	
  	fieldset input{
  	  width:120px;
  	}
  	
  	div.row{
  	  position: relative;
  	  padding:8px 0;
  	  border: solid 1px #ffffff;
  	}
  	
  	div.column1{
  	  float: left;
  	}
  	
  	div.column2{
  	  margin-left:210px;
  	}
  </style>
  
 
  
  <title>订单查询</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js">
</script></head>
<body>
<div id="container">
  <div id="header">
    <ul>
      <li><a href="${pageContext.request.contextPath }/checked/manager/logout.do">退出</a></li>
    </ul>
  </div>
  <%@ include file="/WEB-INF/pages/manager/manageMenu.jsp" %>
  <div id="content">
    <form action="${pageContext.request.contextPath }/checked/manager/querySubscriptionList.do" method="post">
      <fieldset>
        <legend>查询条件</legend>
        <div class="row">
          <div class="column1">
            <label for="rootType">客房类型</label>
            <select name="subscriptionCriteria.categoryId" id="rootType">
             <option value="0">不限</option>
             
             <c:forEach items="${categories }" var="category" varStatus="i" >
             
              <option value="${category.id}">${category.name }</option>
                </c:forEach>
                
            </select>
          </div>
          <div class="column2">
            <label for="status">状态</label>
            <select name="subscriptionCriteria.subscriptionStatus" id="status">
              <option value="-1">不限</option>
              <option value="0">待确认</option>
              <option value="1">已确认</option>
              <option value="2">已取消</option>
            </select>
          </div>
        </div>
       
        <div class="row">
          <div class="column1">
            <label for="startDate">开始日期</label>
            <input type="text" name="subscriptionCriteria.startDate" id="startDate" readonly="readonly"
                onclick="new Calendar().show(this)"/>
          </div>
          <div class="column2">
            <label for="endDate">结束日期</label>
            <input type="text" name="subscriptionCriteria.endDate" id="endDate" readonly="readonly"
                onclick="new Calendar().show(this)"/>
          </div>
        </div>
        <div class="row">
          <div class="column1">
            <label for="no">订单号</label>
            <input type="text" name="subscriptionCriteria.subscriptionNo" id="no" />
          </div>
          <div class="column2">
            <label for="username">会员名</label>
            <input type="text" name="subscriptionCriteria.username" id="username" />
          </div>
        </div>
      </fieldset>
      <div class="submit">
        <input type="submit" value="查询" />
      </div>
    </form>
  </div>
  <hr />
 <%@ include file="/WEB-INF/pages/pagesfoot.jsp" %>
</div>
</body>
</html>