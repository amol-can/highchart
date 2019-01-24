/**
 * Script for basic bar chart
 */
var jsonData = $.ajax({
    url: "getData",
    dataType: "json",
    async: false
    }).responseText;
console.log("Data from JSON: ",jsonData);
var json = JSON.parse(jsonData);
var cat = json.xAxis.categories;
console.log("cat: ", cat);

Highcharts.chart('BarChartContainer', {	
	chart: {
    type: 'bar'
  },
  title: {
    text: 'Historic World Population by Region'
  },
  subtitle: {
    text: 'Source: <a href="https://en.wikipedia.org/wiki/World_population">Wikipedia.org</a>'
  },
  xAxis: {
    categories: cat,
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
    valueSuffix: ' millions'
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
    data: [107, 31, 635, 203, 2]
  }, {
    name: 'Servive',
    data: [133, 156, 947, 408, 6]
  }]
});