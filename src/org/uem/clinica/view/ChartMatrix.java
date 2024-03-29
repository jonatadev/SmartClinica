package org.uem.clinica.view;

import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.SwingWrapper;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class ChartMatrix {
      public static void main(String[] args) {
            int numcharts = 4;
            
            List<XYChart> charts = new ArrayList<XYChart>();
            
            for(int i = 0; i < numcharts; i++){
                  XYChart chart = new XYChartBuilder().xAxisTitle("X")
                          .yAxisTitle("Y").width(600).height(400).build();
                  chart.getStyler().setYAxisMin((double)-10);
                  chart.getStyler().setYAxisMax((double)10);
                  XYSeries series = chart.addSeries("" + i, null, getRandomWalk(200));
                  series.setMarker(SeriesMarkers.NONE);
                  charts.add(chart);
            }
            new SwingWrapper<XYChart>(charts).displayChartMatrix();
      }
      
      private static double[] getRandomWalk(int numPoints) {

            double[] y = new double[numPoints];
            y[0] = 0;
            for (int i = 1; i < y.length; i++) {
                  y[i] = y[i - 1] + Math.random() - .5;
            }
            return y;
      }
}
