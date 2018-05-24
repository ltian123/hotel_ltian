<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/calendar.js"></script>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css"></link>
  <style type="text/css">
    div.submit{
  	  text-align:center;
  	  margin-top: 15px;
  	  border: solid 1px #ffffff;
  	}
  	
  	label{
  	  float: left;
  	  width: 80px;
  	  text-align: left;
  	}
  	
  	fieldset{
  	  position:relative;
      width:300px;
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
  	
  	div.column{
  	}
  	
	  #content p{
	    text-align: center;
	    margin-top: 20px;
	  }
	  
  </style>
  <script type="text/javascript">
  
 function show(){
	  var d = document.getElementById("roomType");
	  
	  var xmlhttprequest = new XMLHttpRequest();
	  
	  xmlhttprequest.open("get","${pageContext.request.contextPath }/showCategories",true);
	  
	  xmlhttprequest.onreadystatechange=function(){
		  if(xmlhttprequest.status == 200 && xmlhttprequest.readyState == 4){
		  var result = xmlhttprequest.responseText;
		  var categories = eval("("+result+")");
			for(var i=0;i<categories.length;i++){
				d.innerHTML = d.innerHTML+"<option value='"+categories[i].id+"'>"+categories[i].name+"</option>"
				
			}
		  }
	  }
	  xmlhttprequest.send(null);
	  
  }
  
  
  
  </script>
  <title>预定客房</title>


</head>
<body onload="show()">
<div id="container">

 <%@ include file="/WEB-INF/pages/pageshead.jsp" %>
 
 
  <div id="content">
     <%@ include file="/WEB-INF/pages/pagesSubmenu.jsp" %>
    <div class="subcontent">
      <p>请输入您要预定的房间类型以及预订的起始日期，系统会显示可用的房间并供您选择。</p>
      <form action="${pageContext.request.contextPath }/checked/member/showCreateSubscriptionDtl-2.do" method="post">
        <fieldset>
          <div class="row">
            <div class="column">
              <label for="roomType">客房类型</label>
              <select name="roomType" id="roomType" >
                 <c:forEach items="${categories }" var="category" varStatus="i" >
             
                </c:forEach>
              </select>
            </div>
          </div>
          
          <div class="row">
            <div class="column">
              <label for="bookType">预定方式</label>
              <select name="bookType" id="bookType" >
                <option value="1" ${roomCriteria.residetype eq "1" ? "selected":""}>单个床位</option>
                <option value="2" ${roomCriteria.residetype eq "2" ? "selected":""}>整个房间</option>
              </select>
            </div>
          </div>
         
          <div class="row">
            <div class="column">
              <label for="startDate">开始日期</label>
              <input type="text" name="startDate" id="startDate" readonly="readonly"
                  onclick="new Calendar().show(this)" value="<fmt:formatDate value="${roomCriteria.sdate}" pattern="yyyy-MM-dd"/>"/>
            </div>
          </div>
          <div class="row">
            <div class="column">
              <label for="endDate">结束日期</label>
              <input type="text" name="endDate" id="endDate" readonly="readonly"
                  onclick="new Calendar().show(this)" value="<fmt:formatDate value="${roomCriteria.edate}" pattern="yyyy-MM-dd"/>"/>
            </div>
          </div>
        </fieldset>
        <div class="submit">
          <input type="button" value="返回" onclick="location='${pageContext.request.contextPath }/checked/member/showMemberSubscriptionDetail.do?id=${sid }'"/>
          <input type="hidden" name="sid" value="${sid}"/>
          <input type="submit" value="下一步" />
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