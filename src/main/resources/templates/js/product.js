window.loadPage = function (page) {
		const params = new URLSearchParams(window.location.search);
		params.set("page", page);
		
		fetch("/product/page?" + params.toString())
		.then(res => res.text())
		.then(html => {
			document.getElementById("product-container").innerHTML = html
		});
		
	}