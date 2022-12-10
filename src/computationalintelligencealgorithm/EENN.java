/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationalintelligencealgorithm;

import java.util.Random;

/**
 *
 * @author Jam Jahanzeb
 */
public class EENN {

    double[] parent1;
    double[] parent2;

    public EENN(double[] parent1, double[] parent2) {

        this.parent1 = new double[parent1.length];
        this.parent2 = new double[parent2.length];
        
        for(int i =0; i<parent1.length; i++)
        {
            this.parent1[i] = parent1[i];
            this.parent2[i] = parent2[i];
        }
    }

    public void crossOverOfTwoParent(double mut, int swapAt) {

        for (int i = 0; i < swapAt; i++) {
            double temp = this.parent1[i];
            this.parent1[i] = this.parent2[i];
            this.parent2[i] = temp;
        }

        this.mutationOfTheParents(mut);
    }

    public double[] newParent1() {
        return this.parent1;
    }

    public double[] newParent2() {
        return this.parent2;
    }

    public void mutationOfTheParents(double mut) {

        int maximumValue = (int)(mut*100);
        int minimumValue = (int)(mut*-100);
        int rangeValue = 100;

        for (int i = 0; i < this.parent1.length; i++) {

            double changeInX1 = getARandomNumberBetween(minimumValue, maximumValue) / rangeValue;

            /*if (type == 1) {

                int the20PercentRule = (int) getARandomNumberBetween(1, 5);

                if (the20PercentRule == 3) {
                    this.parent1[i] += changeInX1;
                }
            } else {*/
                this.parent1[i] += changeInX1;
        }

        for (int i = 0; i < this.parent2.length; i++) {

            double changeInX2 = getARandomNumberBetween(minimumValue, maximumValue) / rangeValue;

            /*if (type == 1) {

                int the20PercentRule = (int) getARandomNumberBetween(1, 5);

                if (the20PercentRule == 3) {
                    this.parent2[i] += changeInX2;
                }
            } else */
                this.parent2[i] += changeInX2;
            
        }
    }

    public static double getARandomNumberBetween(int minimumValue, int maximumValue) {

        Random randomNumber = new Random();
        int newRandomNumber = randomNumber.nextInt((maximumValue - minimumValue) + 1) + minimumValue;

        return newRandomNumber;
    }
}