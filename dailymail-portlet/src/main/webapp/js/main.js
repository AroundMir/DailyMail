$(document).ready(function() {
	//alert to delete item
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
	//Lorem Ipsum
	var coll = document.getElementById("collapsible");
	if (coll != null) {
		coll.addEventListener("click", function() {
			console.log("In");
			this.classList.toggle("active");
			var content = this.nextElementSibling;
			if (content.style.display === "block") {
				content.style.display = "none";
			} else {
				content.style.display = "block";
			}
		});
	}
});

// Test Ajax request
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
