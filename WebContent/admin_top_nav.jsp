<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<!-- 如果没有登录或者一般账户，不能直接访问 -->
	<c:if test="${user.userLevel != 4 }">
		<!-- jsp的动作标签，用于跳转页面，类似于Dispatcher对象的forward方法 -->
		<jsp:forward page="login.jsp" />
	</c:if>
    <!-- Top fixed navigation -->
    <div class="topNav">
        <div class="wrapper">
            <div class="welcome"><a href="#" title=""><img style="width:20px;" src="${pageContext.request.contextPath}/static/file/${user.userPhoto}" alt="" /></a><span>${user.userAlice}</span></div>
            <div class="userNav">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/admin_logout" title=""><img src="${pageContext.request.contextPath}/static/images/icons/topnav/logout.png" alt="" /><span>登出</span></a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="line"></div>
