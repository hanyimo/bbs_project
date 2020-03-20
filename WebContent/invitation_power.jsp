<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>管理员页面</title>
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
	
	<!-- Validation form -->
    <form id="validate" class="form" method="post" action="${pageContext.request.contextPath}/invitation_power_action">
    	<input type="hidden" name="invitationId" value="${invitation.invitationId }" />
		<fieldset>
			<div class="widget">
				<div class="title"><img src="images/icons/dark/alert.png" alt="" class="titleIcon" /><h6>帖子权限</h6></div>
				<div class="formRow">
					<label>帖子标题:<span class="req">*</span></label>
     				<div class="formRight">
     					<input type="text" readonly="readonly" value="${invitation.invitationTitle }"/>
     				</div>
     				<div class="clear"></div>
  				</div>
				<div class="formRow">
    				<label>帖子内容:<span class="req">*</span></label>
    				<div class="formRight">
    					<!-- 内容 -->
    					${invitation.invitationMessage }
    				</div>
    				<div class="clear"></div>
				</div>
				<div class="formRow">
               		<label>权限设置:<span class="req">*</span></label>
          			<div class="formRight">
          				<!-- 审核后就不会显示了 -->
           				<c:if test="${invitation.isPass == 0 }">
           					<div class="floatL">
	           					<select name="isPass" id="selectReq" class="validate[required]" >
                        		<option value="">审核结果</option>
                           		<option value="1">通过</option>
                           		<option value="2">不通过</option>
                  				</select>
               				</div>
               			</c:if>
         				<div class="floatL" style="margin: 2px 0 0 10px;"><input type="checkbox" id="isEnable" name="isEnable" data-prompt-position="topRight:102" /><label for="isEnable">是否屏蔽</label></div>
        				<div class="floatL" style="margin: 2px 0 0 10px;"><input type="checkbox" id="isCream" name="isCream" data-prompt-position="topRight:102" /><label for="isCream">是否是精华帖</label></div>
          			</div>
                   	<div class="clear"></div>
        		</div>
  				<div class="formSubmit"><input type="submit" value="确定" class="redB" /></div>
      			<div class="clear"></div>
			</div>   
		</fieldset>
	</form>
    
    <!-- Footer line -->
    <div id="footer">
        <div class="wrapper">&nbsp;</div>
    </div>

</div>

<div class="clear"></div>

</body>
</html>

    