<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/tagdefinition.jsp"%>
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
				<li><a href="<c:url value="/Admin/SashwathaPooje"/>"><spring:message
							code="label.poojereceipt" /></a></li>
				<li><a href="<c:url value="/Admin/SashwathaPoojeReceiptList"/>"><spring:message
							code="label.bookedpooje" /></a></li>
				<li><a href="<c:url value="/Admin/SashwathaPoojeReport"/>"><spring:message
							code="label.report" /></a></li>

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.donation" />
		</div>
		<div class="padd">
			<ul>
				<li><a href="<c:url value="/Admin/Donation"/> "><spring:message
							code="label.donationreceipt" /></a></li>
				<li><a href="#" class="big-link"
					data-reveal-id="DonationReceipt"><spring:message
							code="label.list" /></a></li>
				<li><a href="<c:url value="/Admin/DonationReport"/>"><spring:message
							code="label.report" /></a></li>

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.income" />
		</div>
		<div class="padd">
			<ul>
				<li><a href="<c:url value="/Admin/income"/>"><spring:message
							code="label.add" /></a></li>
				<li><a href="#" class="big-link" data-reveal-id="BookedIncome"><spring:message
							code="label.list" /></a></li>
				<li><a href="<c:url value="/Admin/IncomeReport"/>"><spring:message
							code="label.report" /></a></li>

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.expense" />
		</div>
		<div class="padd">
			<ul>
				<li><a href="<c:url value="/Admin/Expenditure"/>"><spring:message
							code="label.add" /></a></li>
				<li><a href="#" class="big-link" data-reveal-id="BookedExpense"><spring:message
							code="label.list" /></a></li>
				<li><a href="<c:url value="/Admin/ExpenditureReport"/>"><spring:message
							code="label.report" /></a></li>

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.others" />
		</div>
		<div class="padd">
			<ul>
				<li><a href="<c:url value="/Admin/AllReport"/>"><spring:message
							code="label.reportall" /></a></li>
				<li><a href="<c:url value="/Admin/coupon"/>"><spring:message
							code="label.coupon" /></a></li>
				<!-- 	<a href="#"><li>Bank Report</li></a> -->
				<sec:authorize ifAnyGranted="ROLE_SUPERADMIN">
					<li><a href="<c:url value="/SuperAdmin/address"/>"><spring:message
								code="label.approve.address" /></a></li>
				</sec:authorize>

			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.adminactivities" />
		</div>
		<div class="padd">
			<ul>
				<li><a href="<c:url value="../Admin/ChangePassword"/>"><spring:message
							code="label.changepassword" /></a></li>
				<li><a href="<c:url value="../Admin/EditProfile"/>"><spring:message
							code="label.editprofile" /></a></li>
			</ul>
		</div>
	</div>

	<div class="boxbody">
		<div class="boxheader">
			<spring:message code="label.emailservice" />
		</div>
		<div class="padd">
			<ul>
				<li><a href="<c:url value="../Admin/getemail"/>"><spring:message
							code="label.getemail" /></a></li>
				<li><a href="https://kanajartemple.com:2096" target="_blank"><spring:message
							code="label.sendemail" /></a></li>

			</ul>
		</div>
	</div>

	<sec:authorize ifAnyGranted="ROLE_SUPERADMIN">

		<div class="boxbody">
			<div class="boxheader">
				<spring:message code="label.bankaccounts" />
			</div>
			<div class="padd">
				<ul>
					<li><a href="<c:url value="../Admin/addaccount"/>"><spring:message
								code="label.bankaccounts.add" /></a></li>
					<li><a href="<c:url value="../Admin/viewaccount"/>"><spring:message
								code="label.bankaccounts.editordelete" /></a></li>
					<li><a href="<c:url value="../Admin/getemail"/>"><spring:message
								code="label.bankaccounts.addentry" /></a></li>
					<li><a href="<c:url value="../Admin/getemail"/>"><spring:message
								code="label.bankaccounts.editordeleteentry" /></a></li>
					<li><a href="<c:url value="../Admin/getemail"/>"><spring:message
								code="label.report" /></a></li>
								

				</ul>
			</div>
		</div>

		<div class="boxbody">
			<div class="boxheader">
				<spring:message code="label.admin.account.activities" />
			</div>
			<div class="padd">
				<ul>
					<li><a href="<c:url value="/SuperAdmin/ApproveAdmin"/>"><spring:message
								code="label.approve.admin" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/RejectAdmin"/>"><spring:message
								code="label.reject.admin" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/ApproveAdmin"/>"><spring:message
								code="label.delete.admin" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/resetadminpassword"/>"><spring:message
								code="label.reset.admin.password" /></a></li>

				</ul>
			</div>
		</div>

		<div class="boxbody">
			<div class="boxheader">
				<spring:message code="label.superadmin.activities.add" />
			</div>
			<div class="padd">
				<ul>
					<li><a href="" data-reveal-id="Pooje"><spring:message
								code="label.superadmin.activities.add.pooje" /></a></li>
					<li><a href="" data-reveal-id="Donation"><spring:message
								code="label.superadmin.activities.add.donation" /></a></li>
					<li><a href="" data-reveal-id="Income"><spring:message
								code="label.superadmin.activities.add.income" /></a></li>
					<li><a href="" data-reveal-id="Expense"><spring:message
								code="label.superadmin.activities.add.expense" /></a></li>
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

					<li><a href="<c:url value="/SuperAdmin/CUDPooje"/>"><spring:message
								code="label.superadmin.activities.delete.pooje" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/CUDDonation"/>"><spring:message
								code="label.superadmin.activities.delete.donation" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/CUDIncome"/>"><spring:message
								code="label.superadmin.activities.delete.income" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/CUDExpenditure"/>"><spring:message
								code="label.superadmin.activities.delete.expenditure" /></a></li>
					<!-- <a href=""><li>Delete Photo</li></a> -->
				</ul>
			</div>
		</div>


		<div class="boxbody">
			<div class="boxheader">
				<spring:message code="label.cms" />
			</div>
			<div class="padd">
				<ul>
					<li><a href="<c:url value="/SuperAdmin/CMS/1"/>"><spring:message
								code="label.home" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/CMS/2"/>"><spring:message
								code="label.news" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/CMS/3"/>"><spring:message
								code="label.sthalapurana" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/CMS/4"/>"><spring:message
								code="label.doddamane" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/CMS/5"/>"><spring:message
								code="label.melbanta-daiva" /></a></li>
					<li><a href="<c:url value="/SuperAdmin/CMS/6"/>"><spring:message
								code="label.contactus" /></a></li>
				</ul>
			</div>
		</div>
	</sec:authorize>


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

	<div id="BookedIncome" class="reveal-modal">
		<center>
			<table cellspacing="10" cellpadding="10">
				<tr>
					<th><spring:message code="label.income" /></th>
				</tr>
				<c:forEach items="${IncomeDetails}" var="income">
					<tr>
						<td><a
							href="<c:url value="/Admin/IncomeList/${income.Iid}"/>">${income.IncomeName}</a></td>
					</tr>
				</c:forEach>

			</table>
		</center>
		<a class="close-reveal-modal">&#215;</a>
	</div>

	<div id="BookedExpense" class="reveal-modal">
		<center>
			<table cellspacing="10" cellpadding="10">
				<tr>
					<th><spring:message code="label.expense" /></th>
				</tr>
				<c:forEach items="${ExpenseDetails}" var="expense">
					<tr>
						<td><a
							href="<c:url value="/Admin/ExpenditureList/${expense.Eid}"/>">${expense.ExpenditureName}</a></td>
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
						<td><input type="number" name="Amount" placeholder="&#8377"
							required="required" id="Amount" /></td>
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
						<td><input type="text" name="IncomeName" required="required"
							id="IncomeName" onfocus="enable('IncomeName')" /></td>
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
						<td><input type="text" name="ExpenseName" required="required"
							id="ExpenseName" onfocus="enable('ExpenseName')" /></td>
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
