

$(document).ready(function () {
	$('#bankentry').hide();
	  $('#amounttype').change(function(){
		$('#bankentry').hide();
	    if($('#amounttype').val()== 'BANK'){
	    	 var jsonUrl = "searchbankentry";
	    	 $.ajax({url:jsonUrl , success: function(result){
	    	        $("#bankentry").replaceWith(result);
	    	    }});
	    	$('#bankentry').show();
	    }
	  });  
	});
	
function refresh(){	
	 $.ajax({url: "${searchbankentry}", success: function(result){
	        $("#bankentry").replaceWith(result);
	    }});
	$('#bankentry').show();
}
