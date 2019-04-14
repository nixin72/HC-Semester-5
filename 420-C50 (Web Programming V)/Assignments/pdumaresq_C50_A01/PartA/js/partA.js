$(document).ready(() => {	
	function getInvoice(fileNum) {
		$.get(fileNum).done(invoice => {
			let client = invoice.querySelector("client");
			let info = invoice.querySelector("info");
			let record = invoice.querySelectorAll("workRecord");
			record = Object.keys(record).map(x => record[x]);			
			record.sort((a, b) => parseInt($(a).attr("workNumber")) > parseInt($(b).attr("workNumber")));
			
			$("#invoiceInfo").html(
				$(client).find("contactFirstName").text() + " " + 
				$(client).find("contactLastName").text() + 
				"<br />" + $(client).find("clientStreet").text() + "<br />" +
				$(client).find("clientCity").text() + ", " + 
				$(client).find("clientProvince").text() + ", " + 
				$(client).find("clientPostalCode").text() + "<br /><br />" + 
				($(client).find("clientDiscount").text() * 100) + "<br />" + 
				$(info).attr("invoiceNumber") + "<br />" + 
				$(info).find("invoiceDate").text() + "<br />" +
				$(info).find("billRate").text()
			);
			
			let cI = 0;				
			(function di(i) {
				i = (i == -1) ? record.length-1 : (i == record.length) ? 0 : i;
				$("#workOrderInfo").html(
					"<span>"+$(record[i]).attr("workNumber")+"</span><br />" + 
					"<span>"+$(record[i]).find("workDescription").text()+"</span><br />" + 
					"<span>"+$(record[i]).find("workDate").text()+"</span><br />" + 
					"<span>"+$(record[i]).find("workTypeNumber").text()+"</span><br />" + 
					"<span>"+$(record[i]).find("billedHours").text()+"</span><br />"
				);
				
				document.getElementById("btnPrev").onclick = () => di(--i);
				document.getElementById("btnNext").onclick = () => di(++i);
				document.getElementById("btnSearch").onclick = () => di((found => {
					record.forEach((r, k) => {
						if ($(r).attr("workNumber") == document.getElementById("txtSearch").value)
							i = k, found = true;
					});
					
					$("#validate").text(found ? "" : "Work number " + document.getElementById("txtSearch").value + " could not be found.");
					
					return i;
				})(false));
			})(cI);			
		}).fail(err => console.log(err));
	}
	
	$.get("clients.xml").done(data => {
		let dropdown = $("#ddlClients");
		data = data.querySelectorAll("client");
		data = Object.keys(data).map(x => data[x]);
		data.sort((a, b) => 
			$(a).find("clientName").text() > $(b).find("clientName").text());		
		
		$(data).each((key, val) => 
			dropdown.append("<option value='" + $(val).find("invoice").text() + "'>" 
				+ $(val).find("clientName").text() + "</option>"));
		
		getInvoice(dropdown.val());
		dropdown.change(event => getInvoice(dropdown.val()));	
		
	}).fail(err => console.log(err));
});