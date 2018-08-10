$(document).ready(function() {
	$('.delete').click(function(event) {
		event.preventDefault();
		if (confirm('are you sure you want to delete this?')) {
			console.log(document.getElementById('myId'));
			document.getElementById('myId').submit();
			return true;
		} else {
			return false;
		}
	});
});


function sendGet() {
	$.ajax({
		type : 'GET',
		url : 'https://httpbin.org/get',
		success : function(result) {
			console.log(result)
			alert("Good Request")
		},
		dataType : 'json'
	})
}

