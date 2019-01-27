/**
 * 
 */
var columnJsonData = $.ajax({
	url: "ColumnPerformanceService",
	dataType: "json",
	async: false
}).responseText;

console.log("Column chart data from JSON: ",pieJsonData);
var parsedJson = JSON.parse(columnJsonData);
var performance = Array();
var institute = Array();
for(var i=0; i<parsedJson.length;i++){
	var performanceData = parsedJson[i];
	performance[i] = performanceData.performance;
	institute[i] = performanceData.institute;
	//console.log("Inner: ",outerArray);
}
//console.log( performance);

Highcharts.chart('columnChartContainer', {
    chart: {
        type: 'column',
        options3d: {
            enabled: true,
            alpha: 10,
            beta: 25,
            depth: 70
        }
    },
    title: {
        text: '3D chart for Institute Performance'
    },
    subtitle: {
        text: 'skala.in'
    },
    plotOptions: {
        column: {
            depth: 25
        }
    },
    xAxis: {
        categories: institute,
        labels: {
            skew3d: true,
            style: {
                fontSize: '16px'
            }
        }
    },
    yAxis: {
        title: {
            text: null
        }
    },
    series: [{
        name: 'performance',
        data: performance
    }]
});