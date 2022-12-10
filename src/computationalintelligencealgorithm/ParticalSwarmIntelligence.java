/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationalintelligencealgorithm;

import java.util.LinkedList;

/**
 *
 * @author Jam Jahanzeb
 */
public class ParticalSwarmIntelligence {

    LinkedList<Partical> swarm = new LinkedList<>();
    double gbestX;
    double gbestY;

    public ParticalSwarmIntelligence() {
        this.gbestX = 0;
        this.gbestY = 0;
    }

    public void addPartical(double presentX, double presentY, int funtionNumber) {
        Partical temp = new Partical(presentX, presentY);

        swarm.add(temp);

        if (temp.getCostPresent(funtionNumber) > this.getCostGBest(funtionNumber)) {
            this.gbestX = presentX;
            this.gbestY = presentY;
        }
    }

    public void letTheSwarmMove(int functionNumber, double c1, double c2, double maximumX, double minimumX, double maximumY, double minimumY) {
        for (int i = 0; i < swarm.size(); i++) {

            swarm.get(i).computeVelocity(this.gbestX, this.gbestY, c1, c2, maximumX, minimumX, maximumY, minimumY);

            if (swarm.get(i).isPBestChanged(functionNumber)) {
                if (swarm.get(i).getCostPresent(functionNumber) > this.getCostGBest(functionNumber)) {
                    this.gbestX = swarm.get(i).getX();
                    this.gbestY = swarm.get(i).getY();
                }
            }
        }
    }

    public double getCostOfParticals(int index, int funtionValueNumber) {
        return this.swarm.get(index).getCostPresent(funtionValueNumber);
    }

    public int getSwarmSize() {
        return this.swarm.size();
    }

    public double getTheBiggest(int funtionValueNumber) {
        double max = -10000000;
        for (int i = 0; i < this.getSwarmSize(); i++) {
            if (this.getCostOfParticals(i, funtionValueNumber) > max) {
                max = this.getCostOfParticals(i, funtionValueNumber);
            }
        }

        return max;
    }

    public double getCostGBest(int funtionNumber) {
        if (funtionNumber == 1) {
            return (double) ((100 * Math.pow((Math.pow(this.gbestX, 2) - this.gbestY), 2) + Math.pow((1 - this.gbestX), 2)));
        } else if (funtionNumber == 2) {
            return (double) Math.round((Math.pow((Math.pow(this.gbestX, 2)) + this.gbestY - 11, 2) + Math.pow((Math.pow(this.gbestY, 2)) + this.gbestX - 7, 2)) * 100) / 100;
        } else if (funtionNumber == 3) {
            return (double) (20 + ((Math.pow(this.gbestX, 2)) - 10 * Math.cos(2 * Math.PI * this.gbestX)) + ((Math.pow(this.gbestY, 2)) - 10 * Math.cos(2 * Math.PI * this.gbestY)));
        } else {
            return (double) (4 - (2.1 * Math.pow(this.gbestX, 2)) + (Math.pow(this.gbestX, 4) / 3)) * Math.pow(this.gbestX, 2) + (this.gbestX * this.gbestY) + (-4 + 4 * Math.pow(this.gbestY, 2)) * Math.pow(this.gbestY, 2);
        }
    }
}
