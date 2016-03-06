<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="<c:url value="/resources/js/admin/tinymce/tinymce.min.js"/>"></script>
<script type="text/javascript">
tinymce.init({
    selector: "textarea",
    theme: "modern",
    plugins: [
        "advlist autolink lists link image charmap print preview hr anchor pagebreak",
        "searchreplace wordcount visualblocks visualchars code fullscreen",
        "insertdatetime media nonbreaking save table contextmenu directionality",
        "emoticons template paste textcolor colorpicker textpattern"
    ],
    toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
    toolbar2: "print preview media | forecolor backcolor emoticons",
    image_advtab: true,
    templates: [
        {title: 'Test template 1', content: 'Test 1'},
        {title: 'Test template 2', content: 'Test 2'}
    ]
});
</script>

<jsp:include page="Adminheader.jsp" ></jsp:include>
      
    <div class="mainbody">
        
       <center> <h2>${Pagename}</h2></center>
        <form method="post" action="<c:url value="../Admin/CMS_Success"/>">
            <input type="hidden" name="Pagename" value="${Pagename}"/>
        <c:forEach items="${CMScontent}"  var="cont">
    <textarea name="content" style="width:960px;height:400px;">${cont.Content}</textarea>
        </c:forEach>
    <center> <input type="submit" value="Submit"/></center>
</form>
        
        
    </div>
    <jsp:include page="Adminfooter.jsp" ></jsp:include>
