
//TODO: get json data from servlet and parse it
var lineJsonData = $.ajax({
	url: "LineChartService",
	dataType: "json",
	async: false
}).responseText;

console.log("Line chart data from JSON: ",jsonData);
var json = JSON.parse(lineJsonData);
var totalCount = new Array();
var dropCount = new Array();
var serviveCount = new Array();
var batchList = new Array();
for(var i = 0; i < json.length; i++){
	var dropData = json[i];
	totalCount[i] = dropData.total;
	dropCount[i] = dropData.dropout;
	serviveCount[i] = dropData.servive;
	batchList[i] = dropData.batch;
	//console.log("DropData: ", dropData)
}
//console.log("batch: ",totalCount);

Highcharts.chart('lineChartContainer', {
	title: {
		text: 'Dropout analysis by batch'
	},

	subtitle: {
		text: 'Source: skala.in'
	},
	xAxis: {
	    categories: batchList,
	    title: {
	      text: null
	    }
	  },

	yAxis: {
		title: {
			text: 'Number of Student'
		}
	},
	legend: {
		layout: 'vertical',
		align: 'right',
		verticalAlign: 'middle'
	},

	plotOptions: {
		series: {
			label: {
				connectorAllowed: false
			},
			//pointStart: 2010
		}
	},

	series: [{
		name: 'Total',
		data: totalCount
	}, {
		name: 'Servive',
		data: serviveCount
	},  {
		name: 'Dropout',
		data: dropCount
	}],

	responsive: {
		rules: [{
			condition: {
				maxWidth: 500
			},
			chartOptions: {
				legend: {
					layout: 'horizontal',
					align: 'center',
					verticalAlign: 'bottom'
				}
			}
		}]
	}

});