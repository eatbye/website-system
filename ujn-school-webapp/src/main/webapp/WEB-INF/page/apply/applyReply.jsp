<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../../common/header.jsp"%>
<title>在线申请</title>
</head>
<body class="pos-r">
		<div class="page-container">
		<form id="form_" method="post" action="${pageContext.request.contextPath}/apply/controller/applyController/replyApply">
		<input type="hidden" name="id" id="id_" value="${apply.id}">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">分类：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.user_type_name}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">申请日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.create_date}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.user_name}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">工作单位：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.user_unit}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">联系电话：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.user_tel}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.address}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">邮政编码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.postcode}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">证件类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.id_type}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">证件号码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.id_num}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">缩略图：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<a href="###" onclick="toShowImg('${apply.id }','1');return false;">
					<img width="200px" src="${apply.id_file }">
				</a>
			</div>
		</div> 
		<c:if test="${apply.user_type == '2' }">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">统一社会信用代码：</label>
				<div class="formControls col-xs-8 col-sm-9">
					${apply.credit_code}
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">营业执照：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<a href="###" onclick="toShowImg('${apply.id }','2');return false;">
						<img width="200px" src="${apply.credit_code_file }">
					</a>
				</div>
			</div>
		</c:if>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">申请内容：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.content}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">申请原因：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.reason}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">备注说明：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.remark}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">确认码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.check_pwd}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				${apply.status_name}
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">附件：</label>
			<div class="formControls col-xs-8 col-sm-9">
				(点击下载->)<a href="##" onclick="downloadFile('${apply.id }');return false;">${apply.apply_file_name} </a>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="radio-box">
			    <input type="radio" id="radio-1" name="status" value="4">
			    <label for="radio-1">申请不通过</label>
			  </div>
			  <div class="radio-box">
			    <input type="radio" id="radio-2" name="status" checked  value="3">
			    <label for="radio-2">申请通过</label>
			  </div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">答复内容：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea id="reply_content" name="reply_content" class="col-xs-12 col-sm-6 col-md-6" rows="5" placeholder=""></textarea>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">上传附件：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="btn-upload form-group">
				  <input class="input-text upload-url radius"  type="text" name="uploadfile-1" id="uploadfile-1" readonly>&nbsp;&nbsp;<a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>
				  <input type="file" multiple name="file-reply" class="input-file">
				</span>
			</div>
		</div>
		</br>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button class="btn btn-primary" type="submit" id="company_but">提交</button>
				<button id="close_but" class="btn btn-default radius" type="button">&nbsp;&nbsp;返回&nbsp;&nbsp;</button>
			</div>
		</div>
			</form>
		</div>
<%@ include file="../../../common/footer_form.jsp"%>
<script type="text/javascript">
$(function(){
	$('#close_but').on('click', function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
		return false;
	});
	
});
//查看原图
function toShowImg(id,type){
	window.open('${pageContext.request.contextPath}/apply/controller/applyController/showImg?id=' + id + '&type=' + type,'查看原图',"fullscreen=1")
}
//附件下载
function downloadFile(id){
	window.open('${pageContext.request.contextPath}/apply/controller/applyController/downloadFile?id=' + id ,'查看原图',"fullscreen=1")
}

//个人申请表单提交
$(function() {
	
	var options = {
			success : function(data) {
				layer.alert(data.result_message,
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
	
	//表单验证
	$("#form_").validate({
		rules:{
			reply_content:{
				maxlength:500
			}
		},
		onkeyup:false,
		//onsubmit:false,
		focusCleanup:false,
		success:"valid",
		submitHandler:function(form){
			// 准备form表单
			$("#form_").ajaxForm(options);
			// 表单提交     
			$("#form_").ajaxSubmit(options);

			return false;
			
		}
	});
	
});
</script>
</body>
</body>
</html>