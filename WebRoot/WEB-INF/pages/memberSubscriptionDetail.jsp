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
    div.heading{
      border-bottom:solid 1px #000000;
      border-top:solid 1px #ffffff;
      margin-bottom:10px;
    }
    
    div.heading p{
      padding:0;
      margin-bottom:10px;
      text-align:center;
    }
    
  	div.submit{
  	  text-align:center;
  	  margin-top: 15px;
  	  border: solid 1px #ffffff;
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
  	  margin-bottom:10px;
  	}
  	
  	div.column1{
  	  width:25%;
  	  position:relative;
  	  float: left;
  	  margin: 0;
  	}
  	
  	div.column2{
  	  width:25%;
  	  margin: 0;
  	  float:left;
  	}

    div.column3{
      width:25%;
  	  margin: 0;
  	  float:left;
  	}
  	
  	div.column4{
  	  margin-left:675px;
  	  width:180px;
  	}
  	  	
  	.column_1{
  	  float:left;
  	}

   	.column_2{
   	  margin-left:50px;
   	  width:150;
  	}
  	
  	.column_2 span{
  	  border-bottom: dashed 1px #000000;
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
  <title>查询明细信息</title>
</head>
<body>
<div id="container">
<%@ include file="/WEB-INF/pages/pageshead.jsp" %>
  <div id="content" style="border:solid 1px #ffffff;width:90%;margin:auto;padding-top:10px">
    <form action="${pageContext.request.contextPath }/checked/manager/saveRemarkAndStatus.do" method="post">
        <div class="heading">
          <p>订单基本信息</p>
        </div>      
        <div class="row">
          <div class="column1">
            <div class="column_1">
              <span>订单号:</span>
            </div>
            <div class="column_2">
              <span>${subscription.no}</span>
            </div>
          </div>
          
          <div class="column2">
            <div class="column_1">
              <span>创建时间:</span>
            </div>
            <div class="column_2">
              <span><fmt:formatDate value="${subscription.cretime}" pattern="yyyy-MM-dd HH:mm:ss "/></span>
            </div>
          </div>
          
          <div class="column3">
            <div class="column_1">
              <span>会员名:</span>
            </div>
            <div class="column_2">
              <span>${member.username}</span>
            </div>            
          </div>
          
          <div class="column4">
            <div class="column_1">
              <span>状态:</span>
            </div>
            <div class="column_2">
               
            <c:if test="${subscription.status==0}">
            未生效
            </c:if>
            <c:if test="${subscription.status==1}">
            已确认
            </c:if>
            <c:if test="${subscription.status==2}">
            已取消
            </c:if>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="column1">
            <div class="column_1">
              <span>联系人:</span>
            </div>
            <div class="column_2">
              <span>${subscription.linkman}</span>
            </div>
          </div>
          
          <div class="column2">
            <div class="column_1">
              <span>联系电话:</span>
            </div>
            <div class="column_2">
              <span>${subscription.phone}</span>
            </div>
          </div>
          
          <div class="column3">
            <div class="column_1">
              <span>电子邮件:</span>
            </div>
            <div class="column_2">
              <span>${subscription.email}</span>
            </div>            
          </div>
          <div class="column4">
            <span>&nbsp;</span>
          </div>
        </div>
        
        <div class="row">
          <label for="remark">备注</label>
          <input type="text" class="text" name="remark" id="remark" value="${subscription.remark}"readonly="readonly"/> 
          <input  type="hidden" name="id" value="${subscription.id}"/>
          <br />
           <span style="color: green;">${requestScope.Msg }</span>
        </div>
      </form>
      <div class="heading">
        <p>订单明细信息</p>
      </div>
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
      </tr>
      
      <c:forEach items="${subscriptionDtlVos}" var="subscriptionDtlVo" varStatus="i">
      <tr>
        <td><div>${subscriptionDtlVo.categoryName}</div></td>
        <td><div>${subscriptionDtlVo.roomNo}</div></td>
        <td><div>${subscriptionDtlVo.residetype eq "1"?"单个床位":"整个房间"}</div></td>
        <td><div>${subscriptionDtlVo.price}</div></td>
        <td><fmt:formatDate value="${subscriptionDtlVo.sdate}" pattern="yyyy-MM-dd HH:mm:ss "/></td>
        <td><fmt:formatDate value="${subscriptionDtlVo.edate}" pattern="yyyy-MM-dd HH:mm:ss "/></td>
      </tr>
      </c:forEach>
      
     
      
      
    </table>
    <div class="submit">
      <input type="button" value="返回" onclick="location='${pageContext.request.contextPath }/checked/member/reback.do?path=${path} '"/>
    </div>
  </div>
  <hr />
  <%@ include file="/WEB-INF/pages/pagesfoot.jsp" %>
</div>
</body>
</html>