/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationalintelligencealgorithm;

import java.util.*;

/**
 *
 * @author Jam Jahanzeb
 */
public class ComputeCost {

    LinkedList<Cost> setsofXandY = new LinkedList<>();

    public void AddStates(double costX, double costY) {
        Cost temp = new Cost(costX, costY);
        setsofXandY.add(temp);
    }

    public void sortTheSetsOnFitnessValue(int funtionValueNumber) {
        int sizeOfLinkedList = setsofXandY.size();

        for (int i = 0; i < (sizeOfLinkedList - 1); i++) {
            for (int j = 0; j < (sizeOfLinkedList - 1 - i); j++) {
                Cost temp1 = setsofXandY.remove(j);
                Cost temp2 = setsofXandY.remove(j);

                if (temp1.getCost(funtionValueNumber) > temp2.getCost(funtionValueNumber)) {
                    setsofXandY.add(j, temp2);
                    setsofXandY.add(j, temp1);
                } else {
                    setsofXandY.add(j, temp1);
                    setsofXandY.add(j, temp2);
                }
            }
        }
    }

    public double[] getTheSmallestWithIndex(int funtionValueNumber) {
        double min[] = new double[2];
        min[0]= 10000000;
        min[1]= 0;
        
        for (int i = 0; i < this.getListSize(); i++) {
            if (this.getCostOfXandY(i, funtionValueNumber) < min[0]) {
                min[0] = this.getCostOfXandY(i, funtionValueNumber);
                min[1] = i;
            }
        }

        return min;
    }
   
    public double[] getTheBiggestWithIndex(int funtionValueNumber) {
        double max[] = new double[2];
        max[0]= -10000000;
        max[1]= 0;
        
        for (int i = 0; i < this.getListSize(); i++) {
            if (this.getCostOfXandY(i, funtionValueNumber) > max[0]) {
                max[0] = this.getCostOfXandY(i, funtionValueNumber);
                max[1] = i;
            }
        }

        return max;
    }
   
    public double getDistance(int firstIndex, int secondIndex, int type) {

        if (type == 1) {
            return Math.pow(Math.pow(this.setsofXandY.get(firstIndex).getValueofX() - this.setsofXandY.get(secondIndex).getValueofX(), 2) + Math.pow(this.setsofXandY.get(firstIndex).getValueofY() - this.setsofXandY.get(secondIndex).getValueofY(), 2), 0.5);
        } else {
            return (Math.abs(this.setsofXandY.get(firstIndex).getValueofX() - this.setsofXandY.get(secondIndex).getValueofX()) + Math.abs(this.setsofXandY.get(firstIndex).getValueofY() - this.setsofXandY.get(secondIndex).getValueofY()));
        }
    }

    public int getListSize() {
        return this.setsofXandY.size();
    }

    public double getCostOfXandY(int index, int funtionValueNumber) {
        return this.setsofXandY.get(index).getCost(funtionValueNumber);
    }

    public Cost getStates(int index) {
        return this.setsofXandY.get(index);
    }

    public int[] useFitnessProportionSchemeMethod(int funtionValueNumber) {
        AlgorithmsToUseOn temporary = new AlgorithmsToUseOn();
        temporary.fitnessProportionalScehem(this.setsofXandY, funtionValueNumber);
        int[] parent = new int[2];
        parent[0] = temporary.getParent1Chosen();
        parent[1] = temporary.getParent2Chosen();
        return parent;
    }

    public int[] useRankBasedSchemeMethod() {
        AlgorithmsToUseOn temporary = new AlgorithmsToUseOn();
        temporary.rankBasedScheme(this.setsofXandY);
        int[] parent = new int[2];
        parent[0] = temporary.getParent1Chosen();
        parent[1] = temporary.getParent2Chosen();
        return parent;
    }

    public int[] useBinaryTournamentMethod(int funtionValueNumber) {
        AlgorithmsToUseOn temporary = new AlgorithmsToUseOn();
        temporary.binaryTournament(this.setsofXandY, funtionValueNumber);
        int[] parent = new int[2];
        parent[0] = temporary.getParent1Chosen();
        parent[1] = temporary.getParent2Chosen();
        return parent;
    }

    public void useTruncationForSurvivalSelection(int size) {
        SurvivalSelectionAlgorithms temp = new SurvivalSelectionAlgorithms();
        temp.truncationMethodForSurvivalSelection(this.setsofXandY, size);
    }

    public void userFitnessProportionScehemeForSurvival(int funtionValueNumber) {
        SurvivalSelectionAlgorithms temp = new SurvivalSelectionAlgorithms();
        temp.fitnessProportionalScehem(this.setsofXandY, funtionValueNumber);
    }

    public void userbinaryTournamentMethodForSurvival(int funtionValueNumber) {
        SurvivalSelectionAlgorithms temp = new SurvivalSelectionAlgorithms();
        temp.binaryTournamentMethod(this.setsofXandY, funtionValueNumber);
    }

    public void userRankedBasedScehemeForSurvival() {
        SurvivalSelectionAlgorithms temp = new SurvivalSelectionAlgorithms();
        temp.rankedBasedScehem(this.setsofXandY);
    }

    public int[] uniformRandomScheme(int funtionValueNumber) {
        AlgorithmsToUseOn temporary = new AlgorithmsToUseOn();
        temporary.uniformStochastic(this.setsofXandY, funtionValueNumber);

        int[] parent = new int[2];
        parent[0] = temporary.getParent1Chosen();
        parent[1] = temporary.getParent2Chosen();
        return parent;
    }

    public void cleanTheEntireList() {
        this.setsofXandY.clear();
    }

    public int[] subsetAISFitnessBased(int size, int funtionaValue) {
        AIS temp = new AIS(size); 
        
        temp.getNewParentsFBS(this.setsofXandY, funtionaValue);

        int parents[] = temp.getParents();

        return parents;
    }
    
    public int[] subsetAISRankedBased(int size) {
        AIS temp = new AIS(size); 
        
        temp.getNewParentsRBS(this.setsofXandY);

        int parents[] = temp.getParents();

        return parents;
    }
    
    public int[] subsetAISBinaryTournament(int size, int funtionaValue) {
        AIS temp = new AIS(size);
        
        temp.getNewParentsBT(this.setsofXandY, funtionaValue);

        int parents[] = temp.getParents();

        return parents;
    }

    public static int getARandomNumberBetween(int minimumValue, int maximumValue) {

        Random randomNumber = new Random();
        int newRandomNumber = randomNumber.nextInt((maximumValue - minimumValue) + 1) + minimumValue;

        return newRandomNumber;
    }
}
