<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="myCarousel" class="carousel slide">
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner">
		<div class="item active" style="background:#14320b">
			<img src="${pageContext.request.contextPath}/static/images/slide1.png" alt="第一张">
		</div>
		<div class="item" style="background:#F5E4DC;">
			<img src="${pageContext.request.contextPath}/static/images/slide2.png" alt="第二张">
		</div>
		<div class="item" style="background:#DE2A2D;">
			<img src="${pageContext.request.contextPath}/static/images/slide3.png" alt="第三张">
		</div>
	</div>
	<a href="#myCarousel" data-slide="prev" class="carousel-control left">
		<span class="glyphicon glyphicon-chevron-left"></span>
	</a>
	<a href="#myCarousel" data-slide="next" class="carousel-control right">
		<span class="glyphicon glyphicon-chevron-right"></span>
	</a>
</div>