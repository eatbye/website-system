<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<link href="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<title>灵堂模版图片修改</title>
</head>
<body class="pos-r">
	<div class="page-container">
	<form action="${pageContext.request.contextPath}/sinian/templateImg/templateImgController/updateTemplateImg" method="post" class="form form-horizontal" id="form_">
		<input type="hidden" name="id" id="id" value="${templateImg.id }" >
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">图片尺寸说明：</label>
			<div class="radio-box">
				<span>灵堂模版图片尺寸为1170*735</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>模版名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${templateImg.id }" placeholder="标题" id="title" name="title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>模版类型：</label>
			<div class="radio-box">
				<input type="radio" id="template_type1" name="template_type"
					value="1" checked /> <label for="template_type1">单人模版</label>
			</div>
			<div class="radio-box">
				<input type="radio" id="template_type2" name="template_type"
					value="2" /> <label for="template_type2">双人模版</label>
			</div>
		</div>
		<!-- <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">排序值：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="0" placeholder="排序值，越小越靠前" id="no_order" name="no_order">
			</div>
		</div> -->
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">模版图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div id="uploader-demo">
				    <!--用来存放item-->
				    <div id="fileList" class="uploader-list"></div>
				    <div id="filePicker">选择图片</div>
				    <button id="ctlBtn" style="display:none" class="btn btn-default">开始上传</button>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">描述说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="description" cols="" rows="" class="textarea"  placeholder="描述说明"  dragonfly="true" onKeyUp="$.Huitextarealength(this,200)">${templateImg.description }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="remark" cols="" rows="" class="textarea"  placeholder="备注" dragonfly="true" onKeyUp="$.Huitextarealength(this,200)">${templateImg.remark }</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/admin3.0/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/template-upload.js"> </script>
<script type="text/javascript">
	var serverUrl = '/sinian/templateImg/templateImgController/uploadImg';
	// 项目路径
	var contextPath = '${pageContext.request.contextPath}';
	//数据ID
	var model_id = '';
</script>
<script type="text/javascript">
$(function(){
	$("input[name='template_type'][value='${templateImg.template_type }']").attr("checked",true); 
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
});


//表单提交，可上传文件
$(function() {
	//表单验证
	$("#form_").validate({
		debug:true,
		onkeyup:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			var imgList = $('#fileList')
			.children('div');
			if (imgList.length > 0) {
				$('#ctlBtn').trigger("click");
				// not empty
			} else {
				//  is empty
				var options = {
					success : function(data) {
						layer
								.alert(
										data.result_message,
										{
											closeBtn : 1
										},
										function() {
											//父页面刷新
											parent.window.location
													.reload();
											var index = parent.layer
													.getFrameIndex(window.name); //先得到当前iframe层的索引
											parent.layer
													.close(index); //再执行关闭
										});
					}
				};
				// 准备form表单
				$("#form_").ajaxForm(options);
				// 表单提交     
				$("#form_").ajaxSubmit(options);
			}
			return false;
		},
		rules:{
			title:{
				required:true,
				maxlength:100
			}
		}
	});
});
</script>
</body>
</body>
</html>