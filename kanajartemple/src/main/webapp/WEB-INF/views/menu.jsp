<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

  <link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet" type="text/css" />
<div class="container">

            <ul id="nav">
                <li><a href="Home"><spring:message code="label.menu.home"/></a></li>
                <li><a class="hsubs" href="#"><spring:message code="label.menu.brahmalingeshwara"/></a>
                    <ul class="subs">
                        <li><a href="UserCMS?PageName=Sthala Purana"><spring:message code="label.menu.sthalapurana"/></a></li>
                        <li><a href="UserCMS?PageName=Doddamane"><spring:message code="label.menu.doddamane"/></a></li>
                       
                    </ul>
                </li>
                <li><a class="hsubs" href="UserCMS?PageName=Melbanta-Daiva"><spring:message code="label.menu.melbantadaiva"/></a></li>
                <li><a class="hsubs" href="SevaBooking"><spring:message code="label.menu.sevabooking"/></a></li>
                <li><a href="NithyaPooje"><spring:message code="label.menu.nithyapooje"/></a></li>
                <li><a href="#"><spring:message code="label.menu.gallery"/></a>
                <ul class="subs">
                        <li><a href="#"><spring:message code="label.menu.photos"/></a></li>
                        <li><a href="Video"><spring:message code="label.menu.video"/></a></li>
                       
                    </ul></li>
               
               <li><a href="ContactUs"><spring:message code="label.menu.contactus"/></a></li>
               
               
                <div id="lavalamp"></div>

            </ul>

        </div>
