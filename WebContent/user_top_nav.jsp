<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<div class="topNav">
        <div class="wrapper">
        	<!-- 登录才会显示用户头像和昵称 -->
        	<c:if test="${!empty user }">
        		<div class="welcome"><a href="#" title=""><img style="width:20px;" src="${pageContext.request.contextPath}/static/file/${user.userPhoto}" alt="" /></a><span>${user.userAlice}</span></div>
        	</c:if>
            <div class="userNav">
                <ul>
                    <li><a href="#" title=""><img src="${pageContext.request.contextPath}/static/images/icons/topnav/settings.png" alt="" /><span>设置</span></a></li>
                    <li>
                    	<c:if test="${!empty user }">
                    		<a href="${pageContext.request.contextPath}/user_logout?url=${pageContext.request.requestURI}" title=""><img src="${pageContext.request.contextPath}/static/images/icons/topnav/logout.png" alt="" /><span>登出</span></a>
                    	</c:if>
                    	<c:if test="${empty user }">
                    		<a href="${pageContext.request.contextPath}/login.jsp" title=""><img src="${pageContext.request.contextPath}/static/images/icons/topnav/logout.png" alt="" /><span>请登录</span></a>
                    	</c:if>
                    </li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
