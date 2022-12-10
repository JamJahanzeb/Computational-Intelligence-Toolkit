/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationalintelligencealgorithm;

import static computationalintelligencealgorithm.AlgorithmsToUseOn.getARandomNumberBetween;
import java.util.LinkedList;

/**
 *
 * @author Jam Jahanzeb
 */
public class AIS {
  
    int parents[];

    AIS(int size) {
        parents = new int[size];
    }

    public int[] getParents() {
        return this.parents;
    }

    public void getNewParentsFBS(LinkedList<Cost> setsofXandY, int funtionValueNumber) {
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

        for (int j = 0; j < parents.length; j++) {
            tempVariableForCalculations = 0;

            double randomValueForParent1 = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
            this.parents[j] = -100;

            for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
                tempVariableForCalculations += temporaryNormalized.get(i);
                if (randomValueForParent1 <= tempVariableForCalculations) {
                    this.parents[j] = i;
                    break;
                }
            }
        }
    }

    public void getNewParentsRBS(LinkedList<Cost> setsofXandY) {
        ComputeCost temp = new ComputeCost();
        int sizeOfSetsOfXAndY = setsofXandY.size();
        double sumForNormalization = 0;
        LinkedList<Double> temporaryNormalized = new LinkedList<>();

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

        for (int j = 0; j < parents.length; j++) {
            tempVariableForCalculations = 0;

            double randomValueForParent1 = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
            this.parents[j] = -100;

            for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
                tempVariableForCalculations += temporaryNormalized.get(i);
                if (randomValueForParent1 <= tempVariableForCalculations) {
                    this.parents[j] = i;
                    break;
                }
            }
        }
    }

    public void getNewParentsBT(LinkedList<Cost> setsofXandY, int funtionValueNumber) {
        LinkedList<Integer> smallerSpace = new LinkedList<>();
        int sizeOfSetsOfXAndY = setsofXandY.size();

        for (int i = 0; i < parents.length; i++) {
            
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
                this.parents[i] = smallerSpace.get(randomValueForParent2);
            } else {
                this.parents[i] = smallerSpace.get(randomValueForParent1);
            }

            smallerSpace.clear();
        }
    }
}
