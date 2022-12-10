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
public class Cost {

    double costX;
    double costY;

    Cost(double costX, double costY) {
        this.costX = costX;
        this.costY = costY;
    }

    Cost() {
        this.costX = 0;
        this.costY = 0;
    }

    public double getCost(int funtionNumber) {
        if (funtionNumber == 1) {
            return (double) Math.round((Math.pow(this.costX, 2) + Math.pow(this.costY, 2)) * 100) / 100;
        } else if (funtionNumber == 2) {
            return (double) Math.round(((100 * Math.pow((Math.pow(this.costX, 2) - this.costY), 2) + Math.pow((1 - this.costX), 2))) * 100) / 100;
        } else if (funtionNumber == 3) {
            return (double) Math.round((Math.pow((Math.pow(this.costX, 2)) + this.costY - 11, 2) + Math.pow((Math.pow(this.costY, 2)) + this.costX - 7, 2)) * 100) / 100;
        } else if (funtionNumber == 4) {
            return (double) Math.round((20 + ((Math.pow(this.costX, 2)) - 10 * Math.cos(2 * Math.PI * this.costX)) + ((Math.pow(this.costY, 2)) - 10 * Math.cos(2 * Math.PI * this.costY)))*100)/100;
        } else {
            return (double) Math.round(((4 - (2.1 * Math.pow(this.costX, 2)) + (Math.pow(this.costX, 4) / 3)) * Math.pow(this.costX, 2) + (this.costX * this.costY) + (-4 + 4 * Math.pow(this.costY, 2)) * Math.pow(this.costY, 2))*100)/100;
        }
    }

    public void setValueofX(double newCostOfX) {
        this.costX = newCostOfX;
    }

    public void setValueofY(double newCostOfY) {
        this.costY = newCostOfY;
    }

    public double getValueofX() {
        return this.costX;
    }

    public double getValueofY() {
        return this.costY;
    }

    public boolean isEqual(Cost newValue) {
        if ((newValue.getValueofX() == this.costX) && (newValue.getValueofY() == this.costY)) {
            return true;
        } else {
            return false;
        }
    }
}
