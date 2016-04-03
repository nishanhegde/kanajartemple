<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.pooje" />
		</div>
		<div class="padd">
			<ul>
				<li><a href="#" class="big-link" data-reveal-id="myModal"><spring:message
							code="label.poojereceipt" /> </a></li>

				<li><a href="#" class="big-link" data-reveal-id="BookedPooje"><spring:message
							code="label.bookedpooje" /> </a></li>
				<li><a href="<c:url value="/Admin/PoojeReport"/>"><spring:message
							code="label.report" /></a></li>

			</ul>
		</div>
	</div>


	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.sashwathapooje" />
		</div>
		<div class="padd">
			<ul>
				<a href="<c:url value="/Admin/SashwathaPooje"/>"><li><spring:message
							code="label.poojereceipt" /></li></a>
				<a href="<c:url value="/Admin/SashwathaPoojeReceiptList"/>"><li><spring:message
							code="label.bookedpooje" /></li></a>
				<a href="<c:url value="/Admin/SashwathaPoojeReport"/>"><li><spring:message
							code="label.report" /></li></a>

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.donation" />
		</div>
		<div class="padd">
			<ul>
				<a href="<c:url value="/Admin/Donation"/>"><li><spring:message
							code="label.donationreceipt" /></li></a>
				<a href="#" class="big-link" data-reveal-id="DonationReceipt"><li><spring:message
							code="label.list" /></li></a>
				<a href="<c:url value="/Admin/DonationReport"/>"><li><spring:message
							code="label.report" /></li></a>

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.income" />
		</div>
		<div class="padd">
			<ul>
				<a href="<c:url value="/Admin/income"/>"><li><spring:message
							code="label.add" /></li></a>
				<a href="<c:url value="/Admin/IncomeList"/>"><li><spring:message
							code="label.list" /></li></a>
				<a href="<c:url value="/Admin/IncomeReport"/>"><li><spring:message
							code="label.report" /></li></a>

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.expense" />
		</div>
		<div class="padd">
			<ul>
				<a href="<c:url value="/Admin/Expenditure"/>"><li><spring:message
							code="label.add" /></li></a>
				<a href="<c:url value="/Admin/ExpenditureList"/>"><li><spring:message
							code="label.list" /></li></a>
				<a href="<c:url value="/Admin/ExpenditureReport"/>"><li><spring:message
							code="label.report" /></li></a>

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.others" />
		</div>
		<div class="padd">
			<ul>
				<a href="<c:url value="/Admin/AllReport"/>"><li><spring:message
							code="label.reportall" /></li></a>
				<!-- 	<a href="#"><li>Bank Report</li></a> -->


			</ul>
		</div>
	</div>


	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.adminactivities" />
		</div>
		<div class="padd">
			<ul>
				<a href="<c:url value="../Admin/ChangePassword"/>"><li><spring:message
							code="label.changepassword" /></li></a>
				<a href="<c:url value="../Admin/EditProfile"/>"><li><spring:message
							code="label.editprofile" /></li></a>

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.cms" />
		</div>
		<div class="padd">
			<ul>
				<a href="<c:url value="/SuperAdmin/CMS?PageName=Home"/>"><li><spring:message
							code="label.home" /></li></a>
				<a href="<c:url value="/SuperAdmin/CMS?PageName=News"/>"><li><spring:message
							code="label.news" /></li></a>
				<a href="<c:url value="/SuperAdmin/CMS?PageName=Sthala Purana"/>"><li><spring:message
							code="label.sthalapurana" /></li></a>
				<a href="<c:url value="/SuperAdmin/CMS?PageName=Doddamane"/>"><li><spring:message
							code="label.doddamane" /></li></a>
				<a href="<c:url value="/SuperAdmin/CMS?PageName=Melbanta-Daiva"/>"><li><spring:message
							code="label.melbanta-daiva" /></li></a>
			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.admin.account.activities" />
		</div>
		<div class="padd">
			<ul>
				<a href="<c:url value="/SuperAdmin/ApproveAdmin"/>"><li><spring:message
							code="label.approve.admin" /></li></a>
				<a href="<c:url value="/SuperAdmin/RejectAdmin"/>"><li><spring:message
							code="label.reject.admin" /></li></a>
				<a href="<c:url value="/SuperAdmin/ApproveAdmin"/>"><li><spring:message
							code="label.delete.admin" /></li></a>
			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.superadmin.activities.add" />
		</div>
		<div class="padd">
			<ul>
				<a href="" data-reveal-id="Pooje"><li><spring:message
							code="label.superadmin.activities.add.pooje" /></li></a>
				<a href="" data-reveal-id="Donation"><li><spring:message
							code="label.superadmin.activities.add.donation" /></li></a>
							<a href="" data-reveal-id="Income"><li><spring:message
							code="label.superadmin.activities.add.income" /></li></a>
							<a href="" data-reveal-id="Expense"><li><spring:message
							code="label.superadmin.activities.add.expense" /></li></a>
				<!-- <a href=""><li>Upload Photo</li></a> -->

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.superadmin.activities.delete" />
		</div>
		<div class="padd">
			<ul>

				<a href="<c:url value="/SuperAdmin/CUDPooje"/>"><li><spring:message
							code="label.superadmin.activities.delete.pooje" /></li></a>
				<a href="<c:url value="/SuperAdmin/CUDDonation"/>"><li><spring:message
							code="label.superadmin.activities.delete.donation" /></li></a>
							<a href="<c:url value="/SuperAdmin/CUDIncome"/>"><li><spring:message
							code="label.superadmin.activities.delete.income" /></li></a>
				<a href="<c:url value="/SuperAdmin/CUDExpenditure"/>"><li><spring:message
							code="label.superadmin.activities.delete.expenditure" /></li></a>
				<!-- <a href=""><li>Delete Photo</li></a> -->
			</ul>
		</div>
	</div>



	<div id="myModal" class="reveal-modal">
		<center>
			<table cellspacing="10" cellpadding="10">
				<tr>
					<th><spring:message code="label.pooje" /></th>
					<th><spring:message code="label.amount" /></th>
				</tr>



				<c:forEach items="${PoojeDetails}" var="puje">
					<tr>
						<td><a
							href="<c:url value="/Admin/PoojeReceipt/${puje.pid}"/>">${puje.PoojeName}</a></td>
						<td>&#8377 ${puje.Amount}</td>
					</tr>
				</c:forEach>

			</table>
		</center>
		<a class="close-reveal-modal">&#215;</a>
	</div>

	<div id="BookedPooje" class="reveal-modal">
		<center>
			<table cellspacing="10" cellpadding="10">
				<tr>
					<th><spring:message code="label.pooje" /></th>

				</tr>
				<c:forEach items="${PoojeDetails}" var="puje">
					<tr>
						<td><a
							href="<c:url value="/Admin/PoojeReceiptList/${puje.pid}"/>">${puje.PoojeName}</a></td>

					</tr>
				</c:forEach>

			</table>
		</center>
		<a class="close-reveal-modal">&#215;</a>
	</div>

	<div id="DonationReceipt" class="reveal-modal">
		<center>
			<table cellspacing="10" cellpadding="10">
				<tr>
					<th><spring:message code="label.donation.name" /></th>

				</tr>



				<c:forEach items="${DonationDetails}" var="puje">
					<tr>
						<td><a
							href="<c:url value="/Admin/DonationReceiptList/${puje.Did}"/>">${puje.DonationName}</a></td>

					</tr>
				</c:forEach>

			</table>
		</center>
		<a class="close-reveal-modal">&#215;</a>
	</div>


	<!--Adding  Pooje  -->


	<div id="Pooje" class="reveal-modal">
		<center>
			<p class="headingfont">
				<spring:message code="label.add.pooje.details" />
			</p>
			<hr />
			<form action="<c:url value="/SuperAdmin/CUDPooje/insert"/>"
				id="pooje" name="pooje" method="post">
				<table>
					<tr>
						<th><spring:message code="label.poojename" /></th>
						<td><input type="text" name="PoojeName"
							onfocus="enable('PoojeName')" required="required" id="PoojeName" /></td>
					</tr>
					<tr>
						<th><spring:message code="label.amount" /></th>
						<td><input type="number" name="Amount" placeholder="&#8377" required="required"
							id="Amount" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit"
							value="<spring:message code="label.submit" />" /><input
							type="reset" value="<spring:message code="label.clear" />" /></td>
					</tr>
				</table>
			</form>
		</center>
		<a class="close-reveal-modal">&#215;</a>
	</div>

	<!-- Adding Donation -->
	<div id="Donation" class="reveal-modal">
		<center>
			<p class="headingfont">
				<spring:message code="label.add.donation" />
			</p>
			<hr />
			<form action="<c:url value="/SuperAdmin/CUDDonation/insert"/>"
				id="Donation" name="Donation" required="required" method="post">
				<table>
					<tr>
						<th><spring:message code="label.donationname" /></th>
						<td><input type="text" name="DonationName"
							required="required" id="DonationName"
							onfocus="enable('DonationName')" /></td>
					</tr>

					<tr>
						<th></th>
						<td><input type="submit"
							value="<spring:message code="label.submit" />" /><input
							type="reset" value="<spring:message code="label.clear" />" /></td>
					</tr>
				</table>
			</form>
		</center>
		<a class="close-reveal-modal">&#215;</a>
	</div>
	
	<!-- Adding Donation -->
	<div id="Income" class="reveal-modal">
		<center>
			<p class="headingfont">
				<spring:message code="label.add.income" />
			</p>
			<hr />
			<form action="<c:url value="/SuperAdmin/CUDIncome/insert"/>"
				id="Income" name="Income" required="required" method="post">
				<table>
					<tr>
						<th><spring:message code="label.incomename" /></th>
						<td><input type="text" name="IncomeName"
							required="required" id="IncomeName"
							onfocus="enable('IncomeName')" /></td>
					</tr>

					<tr>
						<th></th>
						<td><input type="submit"
							value="<spring:message code="label.submit" />" /><input
							type="reset" value="<spring:message code="label.clear" />" /></td>
					</tr>
				</table>
			</form>
		</center>
		<a class="close-reveal-modal">&#215;</a>
	</div>
	
	<!-- Adding Donation -->
	<div id="Expense" class="reveal-modal">
		<center>
			<p class="headingfont">
				<spring:message code="label.add.donation" />
			</p>
			<hr />
			<form action="<c:url value="/SuperAdmin/CUDExpenditure/insert"/>"
				id="Expense" name="Expense" required="required" method="post">
				<table>
					<tr>
						<th><spring:message code="label.expensename" /></th>
						<td><input type="text" name="ExpenseName"
							required="required" id="ExpenseName"
							onfocus="enable('ExpenseName')" /></td>
					</tr>

					<tr>
						<th></th>
						<td><input type="submit"
							value="<spring:message code="label.submit" />" /><input
							type="reset" value="<spring:message code="label.clear" />" /></td>
					</tr>
				</table>
			</form>
		</center>
		<a class="close-reveal-modal">&#215;</a>
	</div>
</div>
<jsp:include page="Adminfooter.jsp"></jsp:include>
