/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationalintelligencealgorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Jam Jahanzeb
 */
public class NeuralNetword {

    LinkedList<NeuralNodes> networkOfNodes = new LinkedList<>();

    public void AddNodes(double X1, double X2, double X3, double Y) {
        NeuralNodes temp = new NeuralNodes(X1, X2, X3, Y);
        networkOfNodes.add(temp);
    }

    public int getNetworkSize() {
        return this.networkOfNodes.size();
    }

    public double getYofNetworkNode(int index) {
        return this.networkOfNodes.get(index).getY();
    }

    public void setYofNetworkNode(int index, double Y) {
        this.networkOfNodes.get(index).setY(Y);
    }

    public NeuralNodes getNodes(int index) {
        return this.networkOfNodes.get(index);
    }

    public void cleanTheEntireList() {
        this.networkOfNodes.clear();
    }

    public void shuffleTheList() {
        Collections.shuffle(this.networkOfNodes);
    }

    public void removeNode(int k) {
        this.networkOfNodes.remove(k);
    }

    public double getTheBiggest() {
        double max = -10000000;
        for (int i = 0; i < this.getNetworkSize(); i++) {
            if (this.getYofNetworkNode(i) > max) {
                max = this.getYofNetworkNode(i);
            }
        }

        return max;
    }

    public double getTheSmallest() {
        double min = 10000000;
        for (int i = 0; i < this.getNetworkSize(); i++) {
            if (this.getYofNetworkNode(i) < min) {
                min = this.getYofNetworkNode(i);
            }
        }

        return min;
    }

    public double[] trainWithBackpropagation(double[] weights, int n, double[] X, double r, double Y) {

        double ValueAtY = 0;
        double[] returnValue = new double[weights.length + 1];

        double[] wXzero = new double[n];
        int i;
        for (i = 0; i < n; i++) {
            wXzero[i] = weights[i];
        }

        double[] wXOne = new double[n];
        for (int j = 0; i < (2 * n); j++, i++) {
            wXOne[j] = weights[i];
        }

        double[] wXTwo = new double[n];
        for (int j = 0; i < (3 * n); j++, i++) {
            wXTwo[j] = weights[i];
        }

        double[] valueAt = new double[n];

        for (int k = 0; k < n; k++) {
            valueAt[k] = sigMoid(wXzero[k] * X[0] + wXOne[k] * X[1] + wXTwo[k] * X[2]);
        }

        double[] wY = new double[n];

        for (int j = 0; i < (4 * n); j++, i++) {
            wY[j] = weights[i];
        }

        double SumforSig = 0;
        for (int j = 0; j < n; j++) {
            SumforSig += (valueAt[j] * wY[j]);
        }

        ValueAtY = sigMoid(SumforSig);

        double ErrorAtY = (Y - ValueAtY) * ValueAtY * (1 - ValueAtY);

        double[] ErrorAt = new double[n];
        for (int j = 0; j < n; j++) {
            ErrorAt[j] = ErrorAtY * wY[j] * valueAt[j] * (1 - valueAt[j]);
        }

        double[] deltaWXZero = new double[n];
        double[] deltaWXOne = new double[n];
        double[] deltaWXTwo = new double[n];

        for (int j = 0; j < n; j++) {
            deltaWXZero[j] = r * ErrorAt[j] * X[0];
            deltaWXOne[j] = r * ErrorAt[j] * X[1];
            deltaWXTwo[j] = r * ErrorAt[j] * X[2];
        }

        for (i = 0; i < n; i++) {
            weights[i] = wXzero[i] + deltaWXZero[i];
        }

        for (int j = 0; i < (2 * n); j++, i++) {
            weights[i] = wXOne[j] + deltaWXOne[j];
        }

        for (int j = 0; i < (3 * n); j++, i++) {
            weights[i] = wXTwo[j] + deltaWXTwo[j];
        }

        double[] deltawY = new double[n];

        for (int j = 0; j < n; j++) {
            deltawY[j] = r * ErrorAtY * valueAt[j];
        }

        for (int j = 0; i < (4 * n); j++, i++) {
            weights[i] = wY[j] + deltawY[j];
        }

        for (i = 0; i < weights.length; i++) {
            returnValue[i] = weights[i];
        }

        returnValue[i] = ValueAtY;

        return returnValue;
    }

    public double sigMoid(double X) {
        return (1 / (1 + (Math.exp(-X))));
    }

    public double finalValueOfY(double[] weights, double[] X, int n) {
        double[] wXzero = new double[n];
        int i;
        for (i = 0; i < n; i++) {
            wXzero[i] = weights[i];
        }

        double[] wXOne = new double[n];
        for (int j = 0; i < (2 * n); j++, i++) {
            wXOne[j] = weights[i];
        }

        double[] wXTwo = new double[n];
        for (int j = 0; i < (3 * n); j++, i++) {
            wXTwo[j] = weights[i];
        }

        double[] valueAt = new double[n];

        for (int k = 0; k < n; k++) {
            valueAt[k] = sigMoid(wXzero[k] * X[0] + wXOne[k] * X[1] + wXTwo[k] * X[2]);
        }

        double[] wY = new double[n];

        for (int j = 0; i < (4 * n); j++, i++) {
            wY[j] = weights[i];
        }

        double SumforSig = 0;
        for (int j = 0; j < n; j++) {
            SumforSig += (valueAt[j] * wY[j]);
        }

        return sigMoid(SumforSig);
    }

    public double[] trainWithEvolutionary(double[] weights, int n, int K) {
        return weights;
    }
    
    public int[] useFitnessProportionSchemeMethod(LinkedList<Double> SSE) {
        AlgorithmsToUseOn temporary = new AlgorithmsToUseOn();
        temporary.fitnessProportionalScehem(SSE);
        int[] parent = new int[2];
        parent[0] = temporary.getParent1Chosen();
        parent[1] = temporary.getParent2Chosen();
        return parent;
    }
}
