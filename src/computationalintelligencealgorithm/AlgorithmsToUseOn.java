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
public class AlgorithmsToUseOn {

    int parent1Chosen;
    int parent2Chosen;

    public void fitnessProportionalScehem(LinkedList<Cost> setsofXandY, int funtionValueNumber) {
        ComputeCost temp = new ComputeCost();
        int sizeOfSetsOfXAndY = setsofXandY.size();
        double sumForNormalization = 0;
        LinkedList<Double> temporaryNormalized = new LinkedList<Double>();

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            temp.AddStates(setsofXandY.get(i).getValueofX(), setsofXandY.get(i).getValueofY());
            sumForNormalization += temp.getCostOfXandY(i, funtionValueNumber);
        }
        double tempVariableForCalculations = 0;
        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            if (i == (sizeOfSetsOfXAndY - 1)) {
                temporaryNormalized.add(1 - tempVariableForCalculations);
            } else {
                temporaryNormalized.add(temp.getCostOfXandY(i, funtionValueNumber) / sumForNormalization);
            }

            tempVariableForCalculations += temporaryNormalized.get(i);
        }

        int maximumValue = 100;
        int minimumValue = 0;
        int rangeValue = 100;

        tempVariableForCalculations = 0;

        double randomValueForParent1 = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
        this.parent1Chosen = -100;

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            tempVariableForCalculations += temporaryNormalized.get(i);
            if (randomValueForParent1 <= tempVariableForCalculations) {
                this.parent1Chosen = i;
                break;
            }
        }

        tempVariableForCalculations = 0;

        double randomValueForParent2 = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
        this.parent2Chosen = -100;

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            tempVariableForCalculations += temporaryNormalized.get(i);
            if (randomValueForParent2 <= tempVariableForCalculations) {
                this.parent2Chosen = i;
                break;
            }
        }
    }
    
    public void fitnessProportionalScehem(LinkedList<Double> y) {
        
        int sizeOfSetsOfXAndY = y.size();
        LinkedList<Double> temp = new LinkedList<>();
        
        double sumForNormalization = 0;
        
        LinkedList<Double> temporaryNormalized = new LinkedList<>();

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            double SSE = (1/y.get(i));
            temp.add(SSE);
            sumForNormalization += SSE;
        }
        
        double tempVariableForCalculations = 0;
        
        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            if (i == (sizeOfSetsOfXAndY - 1)) {
                temporaryNormalized.add(1 - tempVariableForCalculations);
            } else {
                temporaryNormalized.add(temp.get(i) / sumForNormalization);
            }

            tempVariableForCalculations += temporaryNormalized.get(i);
        }

        int maximumValue = 100;
        int minimumValue = 0;
        int rangeValue = 100;

        tempVariableForCalculations = 0;

        double randomValueForParent1 = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
        this.parent1Chosen = -100;

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            tempVariableForCalculations += temporaryNormalized.get(i);
            if (randomValueForParent1 <= tempVariableForCalculations) {
                this.parent1Chosen = i;
                break;
            }
        }

        tempVariableForCalculations = 0;

        double randomValueForParent2 = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
        this.parent2Chosen = -100;

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            tempVariableForCalculations += temporaryNormalized.get(i);
            if (randomValueForParent2 <= tempVariableForCalculations) {
                this.parent2Chosen = i;
                break;
            }
        }
    }
    
    public void uniformStochastic(LinkedList<Cost> setsofXandY, int funtionValueNumber) {
        ComputeCost temp = new ComputeCost();
        int sizeOfSetsOfXAndY = setsofXandY.size();
        double sumForNormalization = 0;
        LinkedList<Double> temporaryNormalized = new LinkedList<Double>();

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            temp.AddStates(setsofXandY.get(i).getValueofX(), setsofXandY.get(i).getValueofY());
            sumForNormalization += temp.getCostOfXandY(i, funtionValueNumber);
        }
        double tempVariableForCalculations = 0;
        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            if (i == (sizeOfSetsOfXAndY - 1)) {
                temporaryNormalized.add(1 - tempVariableForCalculations);
            } else {
                temporaryNormalized.add(temp.getCostOfXandY(i, funtionValueNumber) / sumForNormalization);
            }

            tempVariableForCalculations += temporaryNormalized.get(i);
        }

        int maximumValue = 100;
        int minimumValue = 0;
        int rangeValue = 100;

        tempVariableForCalculations = 0;

        double randomValueForParent1 = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
        this.parent1Chosen = -100;

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            tempVariableForCalculations += temporaryNormalized.get(i);
            if (randomValueForParent1 <= tempVariableForCalculations) {
                this.parent1Chosen = i;
                break;
            }
        }

        tempVariableForCalculations = 0;
        double randomValueForParent2;

        if ((randomValueForParent1 + .5) > 1) {
            randomValueForParent2 = randomValueForParent1 - .5;
        } else {
            randomValueForParent2 = randomValueForParent1 + .5;
        }

        this.parent2Chosen = -100;

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            tempVariableForCalculations += temporaryNormalized.get(i);
            if (randomValueForParent2 <= tempVariableForCalculations) {
                this.parent2Chosen = i;
                break;
            }
        }
    }

    public int getParent1Chosen() {
        return this.parent1Chosen;
    }

    public int getParent2Chosen() {
        return this.parent2Chosen;
    }

    public void rankBasedScheme(LinkedList<Cost> setsofXandY) {
        ComputeCost temp = new ComputeCost();
        int sizeOfSetsOfXAndY = setsofXandY.size();
        double sumForNormalization = 0;
        LinkedList<Double> temporaryNormalized = new LinkedList<Double>();

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            temp.AddStates(setsofXandY.get(i).getValueofX(), setsofXandY.get(i).getValueofY());
            sumForNormalization += (sizeOfSetsOfXAndY - i);
        }
        double tempVariableForCalculations = 0;
        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            if (i == (sizeOfSetsOfXAndY - 1)) {
                temporaryNormalized.add(1 - tempVariableForCalculations);
            } else {
                temporaryNormalized.add((sizeOfSetsOfXAndY - i) / sumForNormalization);
            }

            tempVariableForCalculations += temporaryNormalized.get(i);
        }

        int maximumValue = 100;
        int minimumValue = 0;
        int rangeValue = 100;

        tempVariableForCalculations = 0;

        double randomValueForParent1 = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
        this.parent1Chosen = -100;

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            tempVariableForCalculations += temporaryNormalized.get(i);
            if (randomValueForParent1 <= tempVariableForCalculations) {
                this.parent1Chosen = i;
                break;
            }
        }

        tempVariableForCalculations = 0;

        double randomValueForParent2 = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
        this.parent2Chosen = -100;

        for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
            tempVariableForCalculations += temporaryNormalized.get(i);
            if (randomValueForParent2 <= tempVariableForCalculations) {
                this.parent2Chosen = i;
                break;
            }
        }
    }

    public void binaryTournament(LinkedList<Cost> setsofXandY, int funtionValueNumber) {
        LinkedList<Integer> smallerSpace = new LinkedList<>();
        int sizeOfSetsOfXAndY = setsofXandY.size();
        int newSizeForSets = (int) getARandomNumberBetween(2, sizeOfSetsOfXAndY - 1);

        for (int j = 0; j < newSizeForSets; j++) {

            int chooseTheNewParentForN = (int) getARandomNumberBetween(0, sizeOfSetsOfXAndY - 1);

            if (smallerSpace.contains(chooseTheNewParentForN)) {
                j--;
            } else {
                smallerSpace.add(chooseTheNewParentForN);
            }
        }

        int randomValueForParent1 = (int) getARandomNumberBetween(0, newSizeForSets - 1);

        int randomValueForParent2;
        do {
            randomValueForParent2 = (int) getARandomNumberBetween(0, newSizeForSets - 1);
        } while (randomValueForParent1 == randomValueForParent2);

        if (setsofXandY.get(smallerSpace.get(randomValueForParent1)).getCost(funtionValueNumber) <= setsofXandY.get(smallerSpace.get(randomValueForParent2)).getCost(funtionValueNumber)) {
            this.parent1Chosen = smallerSpace.get(randomValueForParent2);
        } else {
            this.parent1Chosen = smallerSpace.get(randomValueForParent1);
        }

        smallerSpace.clear();

        newSizeForSets = (int) getARandomNumberBetween(2, sizeOfSetsOfXAndY - 1);

        for (int j = 0; j < newSizeForSets; j++) {

            int chooseTheNewParentForN = (int) getARandomNumberBetween(0, sizeOfSetsOfXAndY - 1);

            if (smallerSpace.contains(chooseTheNewParentForN)) {
                j--;
            } else {
                smallerSpace.add(chooseTheNewParentForN);
            }
        }

        int randomValueForParent3 = (int) getARandomNumberBetween(0, newSizeForSets - 1);

        int randomValueForParent4;
        do {
            randomValueForParent4 = (int) getARandomNumberBetween(0, newSizeForSets - 1);
        } while (randomValueForParent3 == randomValueForParent4);

        if (setsofXandY.get(smallerSpace.get(randomValueForParent3)).getCost(funtionValueNumber) <= setsofXandY.get(smallerSpace.get(randomValueForParent4)).getCost(funtionValueNumber)) {
            this.parent2Chosen = smallerSpace.get(randomValueForParent4);
        } else {
            this.parent2Chosen = smallerSpace.get(randomValueForParent3);
        }
    }

    public static double getARandomNumberBetween(int minimumValue, int maximumValue) {

        Random randomNumber = new Random();
        int newRandomNumber = randomNumber.nextInt((maximumValue - minimumValue) + 1) + minimumValue;

        return newRandomNumber;
    }
}