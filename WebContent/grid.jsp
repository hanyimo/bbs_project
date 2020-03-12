<%@page import="com.pojo.Plate"%>
<%@page import="com.service.UserService" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
<title>板块管理</title>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/spinner/ui.spinner.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/spinner/jquery.mousewheel.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-ui.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/charts/excanvas.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/charts/jquery.sparkline.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/forms/uniform.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.cleditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.validationEngine-en.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.validationEngine.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/forms/autogrowtextarea.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.maskedinput.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.dualListBox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/forms/jquery.inputlimiter.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/forms/chosen.jquery.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/wizard/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/wizard/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/wizard/jquery.form.wizard.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/uploader/plupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/uploader/plupload.html5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/uploader/plupload.html4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/uploader/jquery.plupload.queue.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/tables/datatable.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/tables/tablesort.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/tables/resizable.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.tipsy.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.collapsible.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.progress.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.timeentry.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.colorpicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.jgrowl.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.breadcrumbs.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/ui/jquery.sourcerer.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/calendar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/elfinder.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/custom.js"></script>

<!-- Shared on MafiaShare.net  --><!-- Shared on MafiaShare.net  -->
<style>
	*{
		padding:0px;
		margin:0px;	
	}
	.addp{
		padding:10px 0px 0px 20px;
	}
	.adds{
		padding:10px 0px 10px 200px;
	}
</style>
</head>

<body>

<!-- Left side content -->
<%@ include file="admin_left_side.jsp" %>


<!-- Right side -->
<div id="rightSide">

    <!-- Top fixed navigation -->
    <div class="topNav">
        <div class="wrapper">
            <div class="welcome"><a href="#" title=""><img src="${pageContext.request.contextPath}/static/images/userPic.png" alt="" /></a><span>系统管理员</span></div>
            <div class="userNav">
                <ul>
                    <li><a href="login.html" title=""><img src="${pageContext.request.contextPath}/static/images/icons/topnav/logout.png" alt="" /><span>登出</span></a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div> <br />
    <!-- Main content wrapper -->
    <div class="wrapper">
        
        <!-- Full width -->
        <div class="widget">
            <div class="title" style="padding-left:450px;"><h6>板块管理</h6><div class="clear"></div></div>
            
        </div>
        
        <!-- Half width -->
        <div class="widgets">
            <div class="oneTwo">
                <div class="widget">
                    <div class="title" style="padding-left:200px;"><h6>查看板块</h6></div>
                    <table class="table" cellspacing="0" style="font-size: 12px;margin:0px 0px 0px 20px;">
			    		<tr height="20px">
			    			<td class="header" width="100px">板块标题</td>
			   	 			<td class="header" width="200px">板块描述</td>
			    			<td class="header" width="100px">是否被屏蔽</td>
			    			<td class="header" width="60px">操作</td>
			    		</tr>
			    		
<%
	ArrayList<Plate> plate = new UserService().listPlate();
	if(plate != null){
		for(Plate plates : plate){
			String isEnable;
			if(plates.getIsEnable() == 0){
				isEnable = "否";
			}else{
				isEnable = "是";
			}
%>
			<tr height="30px">
				<td><%=plates.getPlateTitle() %></td>
    			<td><%=plates.getPlateMessage() %></td>
    			<td><%=isEnable %></td>
    			<td><a href="#">删除</a></td>
			</tr>
<%
		}
	}
%>
			    			
			    	</table>
                </div>
            </div>
            <div class="oneTwo">
                <div class="widget">
                    <div class="title" style="padding-left:200px;"><h6>添加板块</h6></div>
                    <form action="${pageContext.request.contextPath}/add_plate" method="post">
						<p class="addp">板块标题：<input type="text" name="plateTitle" required="required"  /></p>
						<p class="addp">板块描述：<textarea name="plateMessage" style="width:300px;height: 200px;vertical-align: top;" required="required"></textarea></p>   
						<p class="adds"><input type="submit" value=" 保 存 "  /></p>
					</form>
       	        </div>
            </div>
            <div class="clear"></div>
        </div>
     </div>       
    <!-- Footer line -->
    <div id="footer">
        <div class="wrapper">@BBS论坛专有 <a href="http://www.cssmoban.com/" target="_blank" title="论坛之家">论坛之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></div>
    </div>

</div>

<div class="clear"></div>

</body>
</html>