window.addEventListener("load", function() {
	var uAtoggle = this.document.querySelector("#user-alert-toggle");
	var alertBox = this.document.querySelector(".alert-box");
	var newTable = this.document.querySelector(".alam-table");
	uAtoggle.onmouseover = function(e) {
		e.preventDefault();
		alertBox.classList.toggle("d-none");

		uAtoggle.onmouseout = function() {
			alertBox.classList.toggle("d-none");
		}
	}
	newTable.onmouseover = function(e) {
		e.preventDefault();
		alertBox.classList.toggle("d-none");

		newTable.onmouseout = function() {
			alertBox.classList.toggle("d-none");
		}
	}
});
