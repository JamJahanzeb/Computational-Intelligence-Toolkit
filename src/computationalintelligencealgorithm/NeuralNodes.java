/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationalintelligencealgorithm;

/**
 *
 * @author Jam Jahanzeb
 */
public class NeuralNodes {

    double X1;
    double X2;
    double X3;
    double Y;

    public NeuralNodes(double X1, double X2, double X3, double Y) {
        this.X1 = X1;
        this.X2 = X2;
        this.X3 = X3;
        this.Y = Y;
    }

    public NeuralNodes(double X1, double X2, double X3) {
        this.X1 = X1;
        this.X2 = X2;
        this.X3 = X3;
        this.Y = 0;
    }

    public NeuralNodes() {
        this.X1 = 0;
        this.X2 = 0;
        this.X3 = 0;
        this.Y = 0;
    }

    public double[] getX() {
        double[] valuesOfXvaluesOfX = new double[3];
        valuesOfXvaluesOfX[0] = this.X1;
        valuesOfXvaluesOfX[1] = this.X2;
        valuesOfXvaluesOfX[2] = this.X3;
        return valuesOfXvaluesOfX;
    }

    public double getY() {
        return this.Y;
    }

    public void setX(double X1, double X2, double X3) {
        this.X1 = X1;
        this.X2 = X2;
        this.X3 = X3;
    }
    public void setY(double Y) {
        this.Y = Y;
    }
}