
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- css -->


<link
	href="<c:url value="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/admin/jplist.min.css" />"
	rel="stylesheet" type="text/css" />
<!-- js -->
<script type="text/javascript"
	src="<c:url value="/resources/js/admin/jquery-1.10.0.min.js"/>"></script>


<script type="text/javascript"
	src="<c:url value="/resources/js/admin/jplist.min.js"/>"></script>


<script>
	$('document').ready(function() {
		$('#demo').jplist({

			itemsBox : '.demo-tbl tbody',
			itemPath : '.tbl-item',
			panelPath : '.jplist-panel'

			//save plugin state
			,
			storage : 'localstorage' //'', 'cookies', 'localstorage'			
			,
			storageName : 'jplist-table-2'

			,
			redrawCallback : function() {
				$('.tbl-item').each(function(index, el) {
					if (index % 2 === 0) {
						$(el).addClass('even');
					} else {
						$(el).addClass('odd');
					}
				});
			}
		});
	});
</script>

<!-- demo -->
<div id="demo" class="box jplist table-layout-2">

	<!-- ios button: show/hide panel -->
	<div class="jplist-ios-button">
		<i class="fa fa-sort"></i> jPList Actions
	</div>

	<!-- panel -->
	<div class="jplist-panel box panel-top">

		<!-- reset button -->
		<button type="button" class="jplist-reset-btn"
			data-control-type="reset" data-control-name="reset"
			data-control-action="reset">
			Reset &nbsp;<i class="fa fa-share"></i>
		</button>

		<!-- items per page dropdown -->
		<div class="jplist-drop-down" data-control-type="drop-down"
			data-control-name="paging" data-control-action="paging">

			<ul>
				<li><span data-number="3"> 3 per page </span></li>
				<li><span data-number="5" data-default="true"> 5 per
						page </span></li>
				<li><span data-number="10"> 10 per page </span></li>
				<li><span data-number="all"> view all </span></li>
			</ul>
		</div>



		<!-- filter by description -->
		<div class="text-filter-box">

			<i class="fa fa-search  jplist-icon"></i>

			<!--[if lt IE 10]>
								<div class="jplist-label">Filter by Description:</div>
								<![endif]-->

			<input data-path=".desc" type="text" value="" name="filt" id="filt" onfocus="enable('filt')"
				placeholder="Filter by Name" data-control-type="textbox"
				data-control-name="desc-filter" data-control-action="filter" />
		</div>

		<!-- pagination results -->
		<div class="jplist-label" data-type="Page {current} of {pages}"
			data-control-type="pagination-info" data-control-name="paging"
			data-control-action="paging"></div>

		<!-- pagination -->
		<div class="jplist-pagination" data-control-type="pagination"
			data-control-name="paging" data-control-action="paging"></div>
	</div>