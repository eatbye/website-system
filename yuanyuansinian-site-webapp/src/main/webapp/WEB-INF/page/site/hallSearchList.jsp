<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<%@ include file="../../../common/header-site.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/keleyidivpager.css">
<title>纪念馆搜索结果列表页</title>
</head>
<body>
	<%@ include file="siteHeader.jsp"%>

	<%@ include file="page-pic.jsp"%>

	<div class="container all-bg">
		<div class="row memorial-tab">
			<div class="col-sm-4">
				<div class="memorial-pro">
					<div class="pro-header">
						<h4 class="pro-title pull-left">最新建馆</h4>
						<a href="###" class="more pull-right">更多&raquo;</a>
					</div>
					<div class="clearfix"></div>
					<div class="with-date">
						<ul>
							<li><a href="###" class="pull-left">天束幽花纪念馆</a><span
								class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">鬼山缝魂网上纪念馆鬼山缝魂网上纪念馆鬼山缝魂网上纪念馆</a><span
								class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">幽冥纪念馆</a><span
								class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">特蕾娅纪念馆</a><span
								class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">麒零网上纪念馆</a><span
								class="list-date pull-right">2016-12-30</span></li>
							<li><a href="###" class="pull-left">霓虹网上纪念馆</a><span
								class="list-date pull-right">2016-12-30</span></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="memorial-pro metorial-arc">
					<div class="pro-header">
						<h4 class="pro-title pull-left">最新文章</h4>
						<a href="###" class="more pull-right">更多&raquo;</a>
					</div>
					<div class="clearfix"></div>
					<div class="without-date">
						<ul>
							<li><a href="###">宋人眼里荒唐离奇的北地胡风民俗</a></li>
							<li><a href="###">鬼山缝魂网上纪念馆鬼山缝魂网上纪念馆鬼山缝魂网上纪念馆</a></li>
							<li><a href="###">齐鲁文化—鲁文化在中国上古文化中的地位</a></li>
							<li><a href="###">全民阅读生肖民俗文化惠民活动 明天将在解放碑十</a></li>
							<li><a href="###">全国百家媒体聚焦2016互联网+茶产业暨万里茶道</a></li>
							<li><a href="###">《房陵锣鼓歌》出版 千古诗经民歌传唱至今深山传</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="memorial-pro search-memorial">
					<div class="pro-header">
						<h4 class="pro-title pull-left">查找纪念馆</h4>
					</div>
					<div class="clearfix"></div>
					<div class="search-body">
						<form id="search_hall" action="" method="">
							<div class="form-group">
								<input type="text" class="form-control" id=""
									placeholder="请输入逝者姓名">
							</div>
							<button class="btn btn-warning">查找纪念馆</button>
						</form>
						<dl>
							<dt>
								<a href="###"><h5>
										<span class="glyphicon glyphicon-question-sign"></span>常见问题
									</h5></a>
							</dt>
							<dd>方便新注册用户快速上手</dd>
						</dl>
						<dl>
							<dt>
								<a href="###"><h5>
										<span class="glyphicon glyphicon glyphicon-yen"></span>费用详解
									</h5></a>
							</dt>
							<dd>为您解答相应缴费策略</dd>
						</dl>
					</div>
				</div>
			</div>
		</div>

		<%@ include file="recommend.jsp"%>

		<div class="all-info img-list">
			<div class="pro-header">
				<h4 class="pro-title pull-left">网上纪念馆</h4>
				<button class="btn btn-warning btn-xs btn-memorial" id="single_hall">单人馆</button>
				<button class="btn btn-warning btn-xs btn-memorial" id="double_hall">双人馆</button>
				<a href="###" class="more pull-right">更多&raquo;</a>
			</div>
			<div class="clearfix"></div>
			<%-- <c:forEach items="${listHallByOpenType}" var="hallOpen"> 
				<c:if test="${hallOpen.hall_type == '2'}"> --%>
				<div class="row" id="double_div" style="display:none"> 
	            	<div class="col-sm-4 col-md-3">
						<div class="thumbnail">
							<a href="###"><img src="${pageContext.request.contextPath}/static/images/ex3.jpg" class="img-responsive"
								alt="img"></a>
							<div class="caption">
								<a href="###"><h5>${hallOpen.title}</h5></a>
								<p>
									<strong>在世：</strong>2016-2016
								</p>
								<p class="thumbnail-des text-justify">
									<strong>简介：</strong>${hallOpen.description}
								</p>
							</div>
						</div>
					</div> 
					<div class="clearfix"></div>
					<div class="page">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous"><span
									aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next"><span
									aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</div>
				</div>	
				<%-- </c:if>
            </c:forEach> --%> 
                
			<div class="row" id="single_div"  style="block">
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/ex3.jpg" class="img-responsive"
							alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/ex2.jpg" class="img-responsive"
							alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/slide1.png"
							class="img-responsive" alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/slide2.png"
							class="img-responsive" alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/ex3.jpg" class="img-responsive"
							alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/ex2.jpg" class="img-responsive"
							alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/slide1.png"
							class="img-responsive" alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/slide2.png"
							class="img-responsive" alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/ex2.jpg" class="img-responsive"
							alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/slide1.png"
							class="img-responsive" alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/slide2.png"
							class="img-responsive" alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<a href="###"><img src="${pageContext.request.contextPath}/static/images/ex.jpg" class="img-responsive"
							alt="img"></a>
						<div class="caption">
							<a href="###"><h5>天束幽花</h5></a>
							<p>
								<strong>在世：</strong>2016-2016
							</p>
							<p class="thumbnail-des text-justify">
								<strong>简介：</strong>上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感上代六度使徒与第六王爵之女，出身高贵的郡主，任性、娇蛮、自私、自傲也有些小女儿家的脾气，对麒零有好感
							</p>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="page">
					<ul class="pagination">
						<li><a href="#" aria-label="Previous"><span
								aria-hidden="true">&laquo;</span></a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"><span
								aria-hidden="true">&raquo;</span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="siteFooter.jsp"%>
	<%@ include file="../../../common/footer-site.jsp"%>
	<script type="text/javascript">
		//-------分页数据----------
		var id = '${column_id }';
		var totalPage = '${totalPage }';
		var totalRecords = '${totalRecords }';
		// 项目路径
		var contextPath = '${pageContext.request.contextPath}';
		//-------分页数据----------
	</script>
</body>
</html>