<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div class="mainbody">
	<span class="fon16"><spring:message code="label.menu.video" /></span>
	<hr />
	<center>
		<br />
		<iframe width="750" height="450"
			src="http://www.youtube.com/embed/BEIAhcwW9J8?feature=player_detailpage"
			frameborder="0" allowfullscreen></iframe>
	</center>
</div>
<jsp:include page="footer.jsp"></jsp:include>


