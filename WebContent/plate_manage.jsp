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
	<form action="" class="form">
		<fieldset>
			<div class="widget">
 				<div class="title"><img src="${pageContext.request.contextPath}/static/images/icons/dark/list.png" alt="" class="titleIcon" /><h6>新建版块</h6></div>
  				<div class="formRow">
					<label>版块标题:</label>
					<div class="formRight"><input type="text" name="plateTitle" value="" required="required"/></div>
       				<div class="clear"></div>
   				</div>
   				<div class="formRow">
     				<label>版块描述:</label>
              		<div class="formRight"><textarea rows="8" cols="" name="plateMessage" required="required"></textarea></div>
           			<div class="clear"></div>
        		</div>
    			<div class="formSubmit"><input type="submit" value="添加版块" class="redB" /></div>
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
<script>
// 使用Ajax实现添加新版块功能
$(function(){
	$("form").submit(function(){
		// 发送ajax请求
		$.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath}/add_plate",
			data: $("form").serialize(),
			success: function(msg){
				var content = '';
				content += '<div class="widget">'
					+'<div class="title">'
					+'<h6>'+msg.plateTitle+'</h6>'
					+'<div class="textC" style="float:right;padding:3px 10px 3px 0px;">'
					+'<a href="plate_alter.jsp?plateId='+msg.plateId+'&plateTitle='+msg.plateTitle+'&plateMessage='+msg.plateMessage+'" title="" class="button greenB" style="margin:0px 1px;"><span>修改版块</span></a>'
					+'<a href="#" plateid="'+msg.plateId+'" onclick="deletePlate(this,event)" title="" class="button redB" style="margin:0px 1px;"><span>删除版块</span></a>'
					+'</div>'
					+'<div class="clear"></div>'
					+'</div>'
					+'<p>'+msg.plateMessage+'</p>'
					+'</div>';
				$("form").after(content);
			},
			error: function(XMLHttpRequest,textStatus,errorThrown) {
			    alert(errorThrown);
			}
		});
		// 不提交到后台
		return false;
	});
});
// 使用Ajax实现加载页面获取到所有的版块信息
$(function(){
	// 发送ajax请求，获取到所有版块信息
	$.ajax({
		type: "POST",
		url: "${pageContext.request.contextPath}/list_plates",
		success: function(msg){
			var content = '';
			for(var item in msg){
				content += '<div class="widget">'
					+'<div class="title">'
					+'<h6>'+msg[item].plateTitle+'</h6>'
					+'<div class="textC" style="float:right;padding:3px 10px 3px 0px;">'
					+'<a href="plate_alter.jsp?plateId='+msg[item].plateId+'&plateTitle='+msg[item].plateTitle+'&plateMessage='+msg[item].plateMessage+'" title="" class="button greenB" style="margin:0px 1px;"><span>修改版块</span></a>'
	 				+'<a href="#" plateid="'+msg[item].plateId+'" onclick="deletePlate(this,event)" title="" class="button redB" style="margin:0px 1px;"><span>删除版块</span></a>'
					+'</div>'
					+'<div class="clear"></div>'
					+'</div>'
					+'<p>'+msg[item].plateMessage+'</p>'
					+'</div>';
			}
			$("form").after(content);
		},
		error: function(XMLHttpRequest,textStatus,errorThrown) {
		    alert(errorThrown);
		}
	});
});
// 实现删除版块功能
function deletePlate(that,event){
	event.preventDefault();
	// 发送Ajax请求
	$.ajax({
		type: "POST",
		url: "${pageContext.request.contextPath}/delete_plate",
		data: {plateId:$(that).attr("plateid")},
		success: function(msg){
			// 移除掉这块
			$(that).parents("div[class='widget']").remove();
		},
		error: function(XMLHttpRequest,textStatus,errorThrown) {
		    alert(errorThrown);
		}
	});
}
</script>
</body>
</html>

    