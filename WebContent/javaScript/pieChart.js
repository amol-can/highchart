/**
 * 
 */
var pieJsonData = $.ajax({
	url: "PieChartByAgeService",
	dataType: "json",
	async: false
}).responseText;

console.log("Pie chart(age) data from JSON: ",pieJsonData);
var parsedJson = JSON.parse(pieJsonData);
var outerArray = Array();
for(var i=0; i<parsedJson.length;i++){
	var dropData = parsedJson[i];
	var dropPercentage = Array();
	dropPercentage[0] = dropData.age;
	dropPercentage[1] = dropData.dropPer;
	outerArray.push(dropPercentage);
	//console.log("Inner: ",outerArray);
}
//console.log( outerArray);

Highcharts.chart('pieChartContainer', {
    chart: {
        type: 'pie',
        options3d: {
            enabled: true,
            alpha: 45,
            beta: 0
        }
    },
    title: {
        text: 'Dropout analysis by Age'
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            depth: 35,
            dataLabels: {
                enabled: true,
                format: '{point.name}'
            }
        }
    },
    series: 
    	[{
        type: 'pie',
        name: 'percent of student dropout',
        data: outerArray
    }]
});