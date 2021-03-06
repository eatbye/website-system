<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>栏目修改</title>
</head>
<body class="pos-r">
		<nav class="breadcrumb">
			首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span>更新栏目
		</nav>
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/column/controller/columnController/updateColumn" method="post" class="form form-horizontal" id="form-column-update">
		<input type="hidden" name="id" id="id_" value="${column.id}">
		<%-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>上级栏目：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<!-- <ul id="column_tree" class="ztree"></ul> -->
				<span class="select-box" id="sel_span">
					<select class="select" id="big_class" name="big_class"> 
						<option value="0">--顶级栏目--</option>  
                        <c:forEach items="${columnList}" var="column">  
                        	<option value="${column.id}">${column.name}</option>  
                        </c:forEach>  
                    </select> 
				</span>
			</div>
		</div> --%>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>上级栏目：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<input type="text" class="input-text" value="${column.big_class_name}" placeholder="上级栏目" id="big_class_name" name="big_class_name" readonly="readonly">
				<input type="hidden" name="big_class" id="big_class" value="${column.big_class}">
				<input type="hidden" name="class_type" id="class_type" value="${column.class_type}">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>栏目名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${column.name}" placeholder="栏目名称" id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${column.no_order}" placeholder="排序值，越小越靠前" id="no_order" name="no_order">
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit_but" class="btn btn-secondary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript">
	
$(function(){
	if('${column.big_class}' == '0'){
		$('#big_class_name').val('根栏目');
	}
	//取消按钮
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
	//选择上级菜单
	$("#big_class_name").click(function(){
		utils.treeSelectColumn(false,'',function(columnList){
			if(columnList && columnList.length > 0){
				var column = columnList[0];
				$('#big_class_name').val(column.name);
				$('#big_class').val(column.id);
				$('#class_type').val(column.class_type);
			}
		});
	});
	
});


//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form-column-update").validate({
		rules:{
			name:{
				required:true,
				maxlength:50
			},
			no_order:{
				required:true,
				digits:true
			},
			class_type:{
				required:true
			},
			nav:{
				required:true
			}
		},
		onkeyup:false,
		focusCleanup:false,
		onsubmit:true,
		success:"valid",
		submitHandler:function(form){
			var options = {
					success : function(data) {
						layer.alert(data.result_message, {
						  closeBtn: 1
						}, function(){
							//父页面刷新
							parent.window.location.reload();
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index); //再执行关闭
						});
					}
				};
			// 准备form表单
			$("#form-column-update").ajaxForm(options);
			//提交表单
			$("#form-column-update").ajaxSubmit(options);
			
			return false;
		}
	});
	
});
</script>
</body>
</body>
</html>