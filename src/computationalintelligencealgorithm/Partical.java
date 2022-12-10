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
public class Partical {

    double presentX;
    double presentY;
    double velocityX;
    double velocityY;
    double pbestX;
    double pbestY;

    public Partical(double presentX, double presentY) {

        this.presentX = presentX;
        this.presentY = presentY;
        this.velocityX = 0;
        this.velocityY = 0;
        this.pbestX = presentX;
        this.pbestY = presentY;

    }

    public void setPBestToPresent() {
        this.pbestX = this.presentX;
        this.pbestY = this.presentY;
    }

    public double getX() {
        return this.presentX;
    }

    public double getY() {
        return this.presentY;
    }

    public void computeVelocity(double gbestX, double gbestY, double c1, double c2, double maximumX, double minimumX, double maximumY, double minimumY) {
        int max = 100;
        int min = 0;

        double randForGBest = getARandomNumberBetween(min, max) / 100;
        double randForPBest = getARandomNumberBetween(min, max) / 100;

        double gbestVarianceX = c2 * randForGBest * (gbestX - this.presentX);
        double gbestVarianceY = c2 * randForGBest * (gbestY - this.presentY);
        
        double pbestVarianceX = c1 * randForPBest * (this.pbestX - this.presentX);
        double pbestVarianceY = c1 * randForPBest * (this.pbestY - this.presentY);
        
        this.velocityX += ((pbestVarianceX) + (gbestVarianceX));
        this.velocityY += ((pbestVarianceY) + (gbestVarianceY));

        this.computePresent(maximumX, minimumX, maximumY, minimumY);

    }

    private void computePresent(double maximumX, double minimumX, double maximumY, double minimumY) {

        this.presentX += this.velocityX;
        this.presentY += this.velocityY;

        if (this.presentX > maximumX) {
            this.presentX = maximumX;
        } else if (this.presentX < minimumX) {
            this.presentX = minimumX;
        }

        if (this.presentY > maximumY) {
            this.presentY = maximumY;
        } else if (this.presentY < minimumY) {
            this.presentY = minimumY;
        }
    }

    public boolean isPBestChanged(int functionNumber) {

        if (this.getCostPresent(functionNumber) > this.getCostPBest(functionNumber)) {
            setPBestToPresent();
            return true;
        } else {
            return false;
        }
    }

    public static double getARandomNumberBetween(int minimumValue, int maximumValue) {

        Random randomNumber = new Random();
        int newRandomNumber = randomNumber.nextInt((maximumValue - minimumValue) + 1) + minimumValue;

        return newRandomNumber;
    }

    public double getCostPBest(int funtionNumber) {
        if (funtionNumber == 1) {
            return (double) ((100 * Math.pow((Math.pow(this.pbestX, 2) - this.pbestY), 2) + Math.pow((1 - this.pbestX), 2)));
        } else if (funtionNumber == 3) {
            return (double) Math.round((Math.pow((Math.pow(this.pbestX, 2)) + this.pbestY - 11, 2) + Math.pow((Math.pow(this.pbestY, 2)) + this.pbestX - 7, 2)) * 100) / 100;
        } else if (funtionNumber == 4) {
            return (double) (20 + ((Math.pow(this.pbestX, 2)) - 10 * Math.cos(2 * Math.PI * this.pbestX)) + ((Math.pow(this.pbestY, 2)) - 10 * Math.cos(2 * Math.PI * this.pbestY)));
        } else {
            return (double) (4 - (2.1 * Math.pow(this.pbestX, 2)) + (Math.pow(this.pbestX, 4) / 3)) * Math.pow(this.pbestX, 2) + (this.pbestX * this.pbestY) + (-4 + 4 * Math.pow(this.pbestY, 2)) * Math.pow(this.pbestY, 2);
        }
    }

    public double getCostPresent(int funtionNumber) {
        if (funtionNumber == 1) {
            return (double) Math.round(((100 * Math.pow((Math.pow(this.presentX, 2) - this.presentY), 2) + Math.pow((1 - this.presentX), 2))) * 100) / 100;
        } else if (funtionNumber == 2) {
            return (double) Math.round((Math.pow((Math.pow(this.presentX, 2)) + this.presentY - 11, 2) + Math.pow((Math.pow(this.presentY, 2)) + this.presentX - 7, 2)) * 100) / 100;
        } else if (funtionNumber == 3) {
            return (double) (20 + ((Math.pow(this.presentX, 2)) - 10 * Math.cos(2 * Math.PI * this.presentX)) + ((Math.pow(this.presentY, 2)) - 10 * Math.cos(2 * Math.PI * this.presentY)));
        } else {
            return (double) (4 - (2.1 * Math.pow(this.presentX, 2)) + (Math.pow(this.presentX, 4) / 3)) * Math.pow(this.presentX, 2) + (this.presentX * this.presentY) + (-4 + 4 * Math.pow(this.presentY, 2)) * Math.pow(this.presentY, 2);
        }
    }
}
