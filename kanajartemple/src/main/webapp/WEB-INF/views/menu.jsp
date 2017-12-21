<%@include file="/WEB-INF/views/tagdefinition.jsp"%>

<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet"
	type="text/css" />

<script type="text/javascript"
	src="<c:url value="/resources/js/admin/jquery-1.6.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/admin/admin.js"/>"></script>
<script>
	$(document).ready(
			function() {
				$('.container').addClass('original').clone().insertAfter(
						'.container').addClass('cloned').css('position',
						'fixed').css('top', '0').css('margin-top', '0').css(
						'z-index', '500').removeClass('original').hide();

				scrollIntervalID = setInterval(stickIt, 10);

				stickIt();
			});
</script>
<div class="container">

	<ul id="nav">
		<li><a href="<c:url value="/home"/>"><spring:message
					code="label.menu.home" /></a></li>
		<li><a class="hsubs" href="#"><spring:message
					code="label.menu.brahmalingeshwara" /></a>
			<ul class="subs">
				<li><a href="<c:url value="/usercms/3"/>"><spring:message
							code="label.menu.sthalapurana" /></a></li>
				<li><a href="<c:url value="/usercms/4"/>"><spring:message
							code="label.menu.doddamane" /></a></li>

			</ul></li>
		<li><a class="hsubs" href="<c:url value="/usercms/5"/>"><spring:message
					code="label.menu.melbantadaiva" /></a></li>
		<%-- <li><a class="hsubs" href="<c:url value="/SevaBooking"/>"><spring:message
					code="label.menu.sevabooking" /></a></li> --%>
		<li><a href="<c:url value="/nithyapooje"/>"><spring:message
					code="label.menu.nithyapooje" /></a></li>
		<li><a href="#"><spring:message code="label.menu.gallery" /></a>
			<ul class="subs">
				<li><a href="<c:url value="/photos"/>"><spring:message
							code="label.menu.photos" /></a></li>
				<li><a href="<c:url value="/video"/>"><spring:message
							code="label.menu.video" /></a></li>

			</ul></li>

		<li><a href="<c:url value="/contactus"/>"> <spring:message
					code="label.menu.contactus" />
		</a></li>

		<div id="lavalamp"></div>

	</ul>

</div>

