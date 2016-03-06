<!--Virtual Keyboard  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/Virtual_Keyboard/pramukhime.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/Virtual_Keyboard/pramukhindic.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/Virtual_Keyboard/pramukhime-common.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/admin/tcal.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/admin/tcal.js"/>"></script>
<link href="<c:url value="/resources/css/admin/admin.css" />"
	rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
	function enable(name) {
		pramukhIME.enable(name);
	}
	function changeLang(name) {
		localStorage.setItem('lang', name);
	}
	pramukhIME.addLanguage(PramukhIndic);
	pramukhIME.onLanguageChange(scriptChangeCallback);
	changeLanguage(localStorage.getItem('lang'));
</script>