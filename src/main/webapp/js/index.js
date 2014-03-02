
$(document).ready(function() {
	jQuery.ajaxSettings.traditional = true;
	
	$('#btn-register').click(function(){
		var url = 'rest/twitter/createUser/';
		
		var params = {};
		$('#form-register').find('input').each(function(index, elem){
			params[$(elem).attr('name')] =  $(elem).val();
		});
		
		$.ajax({
		    type: "POST",
		    url: url,
		    contentType: "application/json",
		    data: params,
		    success: function(data) { alert("request worked"); },
		    error: function(data) {alert("request error"); }
		});
		
	});

});