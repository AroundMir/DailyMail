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