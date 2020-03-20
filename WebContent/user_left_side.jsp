<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div id="leftSide">
    <div class="logo"><a href="${pageContext.request.contextPath}/index"><img src="${pageContext.request.contextPath}/static/images/logo.png" alt="" /></a></div>
    
    <div class="sidebarSep mt0"></div>
    
    <!-- Search widget -->
    <form action="" class="sidebarSearch">
        <input type="text" name="search" placeholder="search..." id="ac" />
        <input type="submit" value="" />
    </form>
    
    <div class="sidebarSep"></div>
    
    <!-- Left navigation -->
    <ul id="menu" class="nav">
    	
    </ul>
</div>
<script>
// 使用Ajax实现加载页面获取到所有的版块信息
$(function(){
	// 发送ajax请求，获取到所有版块信息
	$.ajax({
		type: "POST",
		url: "${pageContext.request.contextPath}/list_plates",
		success: function(msg){
			var content = '';
			for(var item in msg){
				content += '<li class="dash">'
					+'<a href="${pageContext.request.contextPath}/index?plateId='+msg[item].plateId+'"'
					+' title="" class="active">'
					+'<span>'+msg[item].plateTitle+'</span></a></li>';
			}
			$("ul[class='nav']").append('<li class="dash"><a href="${pageContext.request.contextPath}/index" title="" class="active"><span>全部</span></a></li>');
			$("ul[class='nav']").append(content);
		},
		error: function(XMLHttpRequest,textStatus,errorThrown) {
		    alert(errorThrown);
		}
	});
});
</script>







