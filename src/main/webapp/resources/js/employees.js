function highLightRow(data) {
	//data.tooltip('show');
}

function unHighLightRow(data) {
	//data.toggleClass("highlightableRow highlightedRow");
}




function listEmployees(from, step) {
	
	$.getJSON("/reserve/employees/listajax", {from: from, step: step}, function(data) {
		$('#employees-list').html("");
		$('#employees-list').html(
				$("#tdTemplate").render(data)
				);
		
		var numberOfPages = Math.ceil(data.numberOfEmployees/step);
		
		var pages = new Array();
		
		for (var i=0; i<numberOfPages; i++) {
			pages[i] = new Object();
			pages[i].pageNumber = i+1;
			pages[i].from = step*i;
		}
		
		$('#numberOfPages').html(
				$("#numberOfPagesTemplate").render(pages)
				);

		
//		$("tbody > tr").mouseover( function(){
//			highLightRow($(this));
//		});
//		
//		$("tbody > tr").mouseout( function(){
//			unHighLightRow($(this));
//		});
		
		$("a").tooltip();
		
		
		
    });
}






$(document).ready(
	function() {
		listEmployees(0, 10);
		
		
		
	}
);

$("tbody > tr").ready(
	function() {
	
		
});