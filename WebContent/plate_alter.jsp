<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
<title>板块管理</title>
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
    
    <!-- Form -->
	<form action="${pageContext.request.contextPath}/alter_plate" class="form" method="post">
		<input name="plateId" value="${param.plateId }" type="hidden"/>
		<fieldset>
			<div class="widget">
 				<div class="title"><img src="${pageContext.request.contextPath}/static/images/icons/dark/list.png" alt="" class="titleIcon" /><h6>修改版块</h6></div>
  				<div class="formRow">
					<label>版块标题:</label>
					<div class="formRight"><input type="text" name="plateTitle" value="${param.plateTitle }" required="required"/></div>
       				<div class="clear"></div>
   				</div>
   				<div class="formRow">
     				<label>版块描述:</label>
              		<div class="formRight"><textarea rows="8" cols="" name="plateMessage" required="required">${param.plateMessage }</textarea></div>
           			<div class="clear"></div>
        		</div>
    			<div class="formSubmit"><input type="submit" value="确定修改" class="redB" /></div>
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

    