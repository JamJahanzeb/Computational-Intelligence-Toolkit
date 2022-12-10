/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationalintelligencealgorithm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Jam Jahanzeb
 */
public class LineChart extends ApplicationFrame {

    public LineChart(String title, LinkedList<LineAtrributes> series, LinkedList<String> nameOfChart, double lowerDomain, double upperDomain) {
        super(title);
        XYDataset dataset = createDataset(series);
        JFreeChart chart = createChart(series, dataset, nameOfChart, lowerDomain, upperDomain);
        final ChartPanel chartPanel = new ChartPanel(chart);
        JButton b3 = new JButton("CLOSE");
        //chartPanel.add(b3);
        b3.setBounds(0, 0, 100, 50);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 500));

        
        //b3.setLayout(null);

        
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                chartPanel.setVisible(false); //you can't see me!
                dispose(); //Destroy the JFrame object
            }
        });

        setContentPane(chartPanel);
        
        // chartPanel.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

    }
    
    private XYDataset createDataset(LinkedList<LineAtrributes> series) {

        XYSeriesCollection dataset = new XYSeriesCollection();

        for (LineAtrributes serie : series) {
            dataset.addSeries(serie.getTheSeries());
        }

        return dataset;

    }

    private JFreeChart createChart(LinkedList<LineAtrributes> series, XYDataset dataset, LinkedList<String> nameOfChart, double lowerDomain, double upperDomain) {
// boolean showTheZero
        final JFreeChart chart = ChartFactory.createXYLineChart(
                nameOfChart.get(0), // chart title
                nameOfChart.get(1), // x axis label
                nameOfChart.get(2), // y axis label
                dataset, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true, // tooltips
                false // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
        //      legend.setDisplaySeriesShapes(true);
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();

        plot.setBackgroundPaint(Color.LIGHT_GRAY);
        //plot.setBackgroundPaint(Color.white);

        //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.darkGray);
        plot.setRangeGridlinePaint(Color.darkGray);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        for (int i = 0; i < series.size(); i++) {
            renderer.setSeriesLinesVisible(i, series.get(i).getLineBoolean());
            renderer.setSeriesShapesVisible(i, series.get(i).getShapeBoolean());
        }
        //renderer.setSeriesPaint(3, Color.black);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

        if ((upperDomain - lowerDomain) > 1000) {
            upperDomain += 100;
            lowerDomain -= 100;
        } else if ((upperDomain - lowerDomain) > 100) {
            upperDomain += 2;
            lowerDomain -= 2;
        }
        else{
            upperDomain += .2;
            lowerDomain -= .2;
        }
        rangeAxis.setRange(lowerDomain, upperDomain);
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;
    }
}