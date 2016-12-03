<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>


<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="slider.jsp"></jsp:include>

<div class="indexbody">
	<div class="rightbody">${Home.content}</div>

	<!-- News box -->
	<div id="box">
		<div class="bubble">
			<div class="rectangle">
				<h2>${News.pagename}</h2>
			</div>
			<div class="triangle-l"></div>
			<div class="triangle-r"></div>
			<div class="info">
				<div class="news">
					<marquee behavior="scroll" height=250 width=335 scrollamount=3
						direction="up" align="centre" onmouseover="this.stop();"
						onmouseout="this.start();"> ${News.content} </marquee>

				</div>
			</div>
		</div>

	</div>


	<!-- Map box -->
	<div id="box">


		<div class="bubble">
			<div class="rectangle">
				<h2>
					<spring:message code="label.map" />
				</h2>
			</div>
			<div class="triangle-l"></div>
			<div class="triangle-r"></div>
			<div class="info">
				<iframe width="335" height="250" frameborder="1" scrolling="no"
					marginheight="0" marginwidth="0"
					src="http://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Kanajar+Shree+Brahmalingeshwara+Temple+&amp;aq=&amp;sll=12.922992,74.852064&amp;sspn=0.199772,0.264702&amp;ie=UTF8&amp;hq=Kanajar+Shree+Brahmalingeshwara+Temple&amp;hnear=&amp;t=m&amp;ll=13.274031,74.875946&amp;spn=0.100245,0.102997&amp;z=12&amp;iwloc=A&amp;output=embed">
				</iframe>
			</div>
		</div>

	</div>
</div>

<jsp:include page="footer.jsp" />

</body>
</html>
