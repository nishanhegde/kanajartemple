
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


