function popupCenter(url, title, w, h) {
var left = (screen.width/2)-(w/2);
var top = (screen.height/2)-(h/2);
return window.open(url, title, 'toolbar=no,addressbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=1, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
} 

function confirmDelete(){
var answer = confirm ("Are you sure you want to delete ?")
if (answer)
return true;
else
return false;
}

function confirmEdit(){
var answer = confirm ("Are you sure you want to edit ?")
if (answer)
return true;
else
return false;
}

function stickIt() {

	  var orgElementPos = $('.original').offset();
	  orgElementTop = orgElementPos.top;               

	  if ($(window).scrollTop() > 160) {
	    // scrolled past the original position; now only show the cloned, sticky element.

	    // Cloned element should always have same left position and width as original element.     
	    orgElement = $('.original');
	    coordsOrgElement = orgElement.offset();
	    leftOrgElement = coordsOrgElement.left;  
	    widthOrgElement = orgElement.css('width');
	    $('.cloned').css('left',leftOrgElement+'px').css('top',0).css('width',widthOrgElement).show();
	    $('.original').css('visibility','hidden');
	  } else {
	    // not scrolled past the menu; only show the original menu.
	    $('.cloned').hide();
	    $('.original').css('visibility','visible');
	  }
	}


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
