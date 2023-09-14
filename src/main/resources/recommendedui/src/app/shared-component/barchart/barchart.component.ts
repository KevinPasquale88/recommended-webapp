import { Component, Input, OnInit } from '@angular/core';
import * as d3 from 'd3-selection';
import * as d3Scale from 'd3-scale';
import * as d3Array from 'd3-array';
import * as d3Axis from 'd3-axis';

@Component({
  selector: 'app-barchart',
  templateUrl: './barchart.component.html',
  styleUrls: ['./barchart.component.scss']
})
export class BarChartComponent implements OnInit {

  @Input() gender?: string;

  @Input() statisticMap?: Map<string, Array<number>>;

  statsBarChart: String[] = ['EXTREMELY BAD', 'BAD', 'NEUTRAL', 'GOOD', 'EXTREMELY GOOD'];
  ageMap = new Map<string, number>([
    ["1-10", 0],
    ["11-20", 0],
    ["21-30", 0],
    ["31-40", 0],
    ["41-50", 0],
    ["51-60", 0],
    ["61-70", 0],
    ["71-", 0]
  ]);

  currentRate = 5;
  width: number;
  height: number;
  margin = { top: 20, right: 20, bottom: 30, left: 40 };
  x: any;
  y: any;
  svg: any;
  g: any;

  constructor() {
    this.width = 900 - this.margin.left - this.margin.right;
    this.height = 500 - this.margin.top - this.margin.bottom;
  }

  ngOnInit() {
    console.log(this.statisticMap);
    this.initSvg();
    this.initAxis();
    this.drawAxis();
    //this.drawBars();
  }

  initSvg() {
    this.svg = d3.select('#barChart')
      .append('svg')
      .attr('width', '100%')
      .attr('height', '100%')
      .attr('viewBox', '0 0 900 500');
    this.g = this.svg.append('g')
      .attr('transform', 'translate(' + this.margin.left + ',' + this.margin.top + ')');
  }

  initAxis() {
    this.x = d3Scale.scaleBand().rangeRound([0, this.width]).padding(0.1);
    this.y = d3Scale.scaleLinear().rangeRound([this.height, 0]);
    this.x.domain(this.statsBarChart.map((elem) => elem));
    let max = 0;
    this.statisticMap?.forEach((value: Array<number>, key: string) => {
      if (max < value.length) {
        max = value.length;
      }
    });
    this.y.domain([0, max]);
  }

  drawAxis() {
    this.g.append('g')
      .attr('class', 'axis axis--x')
      .attr('transform', 'translate(0,' + this.height + ')')
      .call(d3Axis.axisBottom(this.x));
    this.g.append('g')
      .attr('class', 'axis axis--y')
      .call(d3Axis.axisLeft(this.y))
      .append('text')
      .attr('class', 'axis-title')
      .attr('transform', 'rotate(-90)')
      .attr('y', 6)
      .attr('dy', '0.71em')
      .attr('text-anchor', 'end')
      .text('Frequency');
  }

  /*drawBars() {
    this.g.selectAll('.bar')
      .data(StatsBarChart)
      .enter().append('rect')
      .attr('class', 'bar')
      .attr('x', (d) => this.x(d.company))
      .attr('y', (d) => this.y(d.frequency))
      .attr('width', this.x.bandwidth())
      .attr('fill', '#498bfc')
      .attr('height', (d) => this.height - this.y(d.frequency));
  }

  /* get(){
     if (statistic.user.age < 11) {
       let value: number = statisticsMap.get(statistic.emotion)?.get("1-10") || 0;
       statisticsMap.get(statistic.emotion)?.set("1-10", value + 1);
     } else if (statistic.user.age < 21) {
       let value: number = statisticsMap.get(statistic.emotion)?.get("11-20") || 0;
       statisticsMap.get(statistic.emotion)?.set("11-20", value + 1);
     } else if (statistic.user.age < 31) {
       let value: number = statisticsMap.get(statistic.emotion)?.get("21-30") || 0;
       statisticsMap.get(statistic.emotion)?.set("21-30", value + 1);
     } else if (statistic.user.age < 41) {
       let value: number = statisticsMap.get(statistic.emotion)?.get("31-40") || 0;
       statisticsMap.get(statistic.emotion)?.set("31-40", value + 1);
     } else if (statistic.user.age < 51) {
       let value: number = statisticsMap.get(statistic.emotion)?.get("41-50") || 0;
       statisticsMap.get(statistic.emotion)?.set("41-50", value + 1);
     } else if (statistic.user.age < 61) {
       let value: number = statisticsMap.get(statistic.emotion)?.get("51-60") || 0;
       statisticsMap.get(statistic.emotion)?.set("51-60", value + 1);
     } else if (statistic.user.age < 71) {
       let value: number = statisticsMap.get(statistic.emotion)?.get("61-70") || 0;
       statisticsMap.get(statistic.emotion)?.set("61-70", value + 1);
     } else {
       let value: number = statisticsMap.get(statistic.emotion)?.get("71-") || 0;
       statisticsMap.get(statistic.emotion)?.set("71-", value + 1);
     }
   }*/
}
