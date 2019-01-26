/**
 * Script for basic bar chart
 */
// TODO: get json data from servlet and parse it
var jsonData = $.ajax({
    url: "getData",
    dataType: "json",
    async: false
    }).responseText;

console.log("Data from JSON: ",jsonData);
var json = JSON.parse(jsonData);
var courseList = new Array();
var dropCount = new Array();
var serviveCount = new Array();
for(var i = 0; i < json.length; i++){
  var dropData = json[i];
  dropCount[i] = dropData.drop;
  serviveCount[i] = dropData.servive;
  courseList[i] = dropData.course;
}
console.log("course Data: ",courseList);
console.log("Servive Data: ",serviveCount);

//TODO: render the barchart

Highcharts.chart('BarChartContainer', { 
  chart: {
    type: 'bar'
  },
  title: {
    text: 'Dropout details by course'
  },
  subtitle: {
    text: 'Source: <a href="http://skala.in">skala.in</a>'
  },
  xAxis: {
    categories: courseList,
    title: {
      text: null
    }
  },
  yAxis: {
    min: 0,
    title: {
      text: 'Count',
      align: 'high'
    },
    labels: {
      overflow: 'justify'
    }
  },
  tooltip: {
    valueSuffix: ' Students'
  },
  plotOptions: {
    bar: {
      dataLabels: {
        enabled: true
      }
    }
  },
  legend: {
    layout: 'vertical',
    align: 'right',
    verticalAlign: 'top',
    x: -40,
    y: 80,
    floating: true,
    borderWidth: 1,
    backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
    shadow: true
  },
  credits: {
    enabled: false
  },
  series: [{
    name: 'Dropout',
    data: dropCount
  }, {
    name: 'Servive',
    data: serviveCount
  }]
});