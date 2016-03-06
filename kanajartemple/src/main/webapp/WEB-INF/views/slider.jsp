
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- slideshow -->

<script type="text/javascript" src="<c:url value="/resources/js/scriptsjquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/scriptsjquery.cycle.all.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/scriptsjquery-ui-dialog.min.js"/>"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('.slideshow').cycle({
		fx: 'fade' // choose your transition type, ex: fade, scrollUp, shuffle, etc...
	});
	

});
</script>
<div class="blackbox">
 <center>
<div class="slideshow">

					<img src="<c:url value="/resources/images/1a.JPG"/>" width="700" height="600" />
					<img src="<c:url value="/resources/images/2a.JPG"/>" width="700" height="600"/>
					<img src="<c:url value="/resources/images/3a.JPG"/>" width="700" height="600"/>		
					<img src="<c:url value="/resources/images/4a.JPG"/>" width="700" height="600"/>				
							
					    </div>
</center>

</div>


