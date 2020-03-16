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
    <div class="line"></div><br><br>

    <!-- Page statistics area -->
    <div class="statsRow">
        <div class="wrapper">
        	<div class="controlB">
            	<ul>
            		<li><a href="${pageContext.request.contextPath}/plate_manage.jsp" title=""><img src="${pageContext.request.contextPath}/static/images/icons/control/32/database.png" alt="" /><span>板块管理</span></a></li>
                	<li><a href="${pageContext.request.contextPath}/user_manage_access" title=""><img src="${pageContext.request.contextPath}/static/images/icons/control/32/hire-me.png" alt="" /><span>用户管理</span></a></li>
                	<li><a href="#" title=""><img src="${pageContext.request.contextPath}/static/images/icons/control/32/plus.png" alt="" /><span>Add new session</span></a></li>
                    <li><a href="#" title=""><img src="${pageContext.request.contextPath}/static/images/icons/control/32/statistics.png" alt="" /><span>Check statistics</span></a></li>
                    <li><a href="#" title=""><img src="${pageContext.request.contextPath}/static/images/icons/control/32/comment.png" alt="" /><span>Review comments</span></a></li>
                    <li><a href="#" title=""><img src="${pageContext.request.contextPath}/static/images/icons/control/32/order-149.png" alt="" /><span>Check orders</span></a></li>
                </ul>
                <div class="clear"></div>
            </div>
        </div>
    </div>