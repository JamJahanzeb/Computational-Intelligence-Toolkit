/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationalintelligencealgorithm;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Jam Jahanzeb
 */
public class BSO {

    Cost individuals = new Cost();
    int cluster;

    BSO(double X, double Y) {
        this.setX(X);
        this.setY(Y);
        //individuals.setValueofX(X);
        //individuals.setValueofY(Y);
    }

    BSO() {
        this.setX(0);
        this.setY(0);
    }

    public void setX(double X) {
        individuals.setValueofX(X);
    }

    public void setY(double Y) {
        individuals.setValueofY(Y);
    }
    
    public double getX() {
        return individuals.getValueofX();
    }
    
    public double getY() {
        return individuals.getValueofY();
    }

    public double getCost(int functionValue) {
        return this.individuals.getCost(functionValue);
    }

    public void BSOMutation(double maxValueOfX, double minValueOfX, double maxValueOfY, double minValueOfY, int functionValue) {

        int maximumValue = 5;
        int minimumValue = -5;
        int rangeValue = 100;

        double X1 = this.getX();
        double Y1 = this.getY();

        double changeInX1 = getARandomNumberBetween(minimumValue, maximumValue) / rangeValue;
        double changeInY1 = getARandomNumberBetween(minimumValue, maximumValue) / rangeValue;

        X1 += changeInX1;

        if (X1 > maxValueOfX) {
            X1 = maxValueOfX;
        } else if (X1 < minValueOfX) {
            X1 = minValueOfX;
        }

        Y1 += changeInY1;

        if (Y1 > maxValueOfY) {
            Y1 = maxValueOfY;
        } else if (Y1 < minValueOfY) {
            Y1 = minValueOfY;
        }

        this.setX(X1);
        this.setY(Y1);
        //individuals.setValueofX((X1));
        //individuals.setValueofY((Y1));
    }

    public void setClusterNumber(int cluster) {
        this.cluster = cluster;
    }

    public int getclusterNumber() {
        return this.cluster;
    }

    public static double getARandomNumberBetween(int minimumValue, int maximumValue) {

        Random randomNumber = new Random();
        int newRandomNumber = randomNumber.nextInt((maximumValue - minimumValue) + 1) + minimumValue;

        return newRandomNumber;
    }
}
