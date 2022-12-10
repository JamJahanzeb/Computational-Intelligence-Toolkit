/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationalintelligencealgorithm;

import org.jfree.data.xy.XYSeries;

/**
 *
 * @author Jam Jahanzeb
 */
public class LineAtrributes {

    XYSeries theSeries;
    boolean drawLine;
    boolean showShapes;

    public LineAtrributes(XYSeries theSaidSeries, boolean drawSaidLine, boolean showSaidShapes) {
        this.theSeries = theSaidSeries;
        this.drawLine = drawSaidLine;
        this.showShapes = showSaidShapes;
    } 

    public boolean getLineBoolean() {
        return this.drawLine;
    }

    public boolean getShapeBoolean() {
        return this.showShapes;
    }

    public XYSeries getTheSeries() {
        return this.theSeries;
    }
}