<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>帖子管理</title>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />

<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/spinner/ui.spinner.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/spinner/jquery.mousewheel.js"></script>

<script src="${pageContext.request.contextPath}/static/js/jquery-ui.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/charts/excanvas.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/charts/jquery.sparkline.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/forms/uniform.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.cleditor.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.validationEngine-en.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.validationEngine.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.tagsinput.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/autogrowtextarea.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.maskedinput.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.dualListBox.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.inputlimiter.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/forms/chosen.jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/wizard/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/wizard/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/wizard/jquery.form.wizard.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/uploader/plupload.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/uploader/plupload.html5.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/uploader/plupload.html4.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/uploader/jquery.plupload.queue.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/tables/datatable.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/tables/tablesort.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/tables/resizable.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.tipsy.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.collapsible.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.prettyPhoto.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.progress.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.timeentry.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.colorpicker.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.jgrowl.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.breadcrumbs.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.sourcerer.js"></script>

<script src="${pageContext.request.contextPath}/static/js/plugins/calendar.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/plugins/elfinder.min.js"></script>

<script src="${pageContext.request.contextPath}/static/js/custom.js"></script>

<!-- Shared on MafiaShare.net  --><!-- Shared on MafiaShare.net  --></head>

<body>

<!-- Left side content -->
<%@ include file="admin_left_side.jsp" %>

<!-- Right side -->
<div id="rightSide">

	<%@ include file="admin_top_nav.jsp" %>
    
	<!-- Dynamic table -->
	<div class="widget">
 		<div class="title"><img src="images/icons/dark/full2.png" alt="" class="titleIcon" /><h6>帖子管理</h6></div>                          
		<table cellpadding="0" cellspacing="0" border="0" class="display dTable">
            <thead>
            <tr>
            <th>账户</th>
            <th>标题</th>
            <th>审核</th>
            <th>屏蔽</th>
            <th>精华</th>
            <th>修改时间</th>
            </tr>
            </thead>
            <tbody>
            	<c:forEach items="${invitations }" var="inv">
            		<tr class="gradeA">
            		<td class="center">${inv.userId }</td>
            		<td class="center"><a href="${pageContext.request.contextPath}/invitation_power?invitationId=${inv.invitationId }">${inv.invitationTitle }</a></td>
            		<c:choose>
            			<c:when test="${inv.isPass == 0 }">
            				<td class="center">待审核</td>
            			</c:when>
            			<c:when test="${inv.isPass == 1 }">
            				<td class="center" style="color:green;">已通过</td>
            			</c:when>
            			<c:otherwise>
            				<td class="center" style="color:red;">未通过</td>
            			</c:otherwise>
            		</c:choose>
					<c:choose>
						<c:when test="${inv.isEnable == 1 }">
							<td class="center" style="color:red;">已屏蔽</td>
						</c:when>
						<c:otherwise>
							<td class="center">&nbsp;</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${inv.isCream == 1 }">
							<td class="center" style="color:red;">精华</td>
						</c:when>
						<c:otherwise>
							<td class="center">&nbsp;</td>
						</c:otherwise>
					</c:choose>
            		<td class="center"><fmt:formatDate value="${inv.invitationModify }" pattern="yyyy-MM-dd HH-mm-ss"/></td>
            		</tr>
            	</c:forEach>
            </tbody>
   		</table>  
	</div>
    
    <!-- Footer line -->
    <div id="footer">
        <div class="wrapper">&nbsp;</div>
    </div>

</div>

<div class="clear"></div>
</body>
</html>

    