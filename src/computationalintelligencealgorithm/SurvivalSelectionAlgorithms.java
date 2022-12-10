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
public class SurvivalSelectionAlgorithms {

    public void sortAndTruncate(LinkedList<double[]> weights, LinkedList<Double> y) {
        int sizeOfLinkedList = weights.size();

        for (int i = 0; i < (sizeOfLinkedList - 1); i++) {
            for (int j = 0; j < (sizeOfLinkedList - 1 - i); j++) {
                double[] temp1 = weights.remove(j);
                double[] temp2 = weights.remove(j);
                
                double y1 = y.remove(j);
                double y2 = y.remove(j);
                
                if (y1 < y2) {
                    weights.add(j, temp2);
                    weights.add(j, temp1);
                    y.add(j, y2);
                    y.add(j, y1);
                } else {
                    weights.add(j, temp1);
                    weights.add(j, temp2);
                    y.add(j, y1);
                    y.add(j, y2);
                }
            }
        }

        for (int m = 0; m < (sizeOfLinkedList / 2); m++) {
            weights.removeLast();
            y.removeLast();
        }
    }
    
    public void truncationMethodForSurvivalSelection(LinkedList<Cost> setsofXandY, int size) {

        for (int i = 0; i < size; i++) {
            setsofXandY.removeLast();
        }
    }

    public void fitnessProportionalScehem(LinkedList<Cost> setsofXandY, int funtionValueNumber) {
        ComputeCost temp = new ComputeCost();
        int sizeOfSetsOfXAndY = setsofXandY.size();
        double sumForNormalization = 0;
        LinkedList<Double> temporaryNormalized = new LinkedList<>();

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

        LinkedList<Cost> forNewParents = new LinkedList<>();
        for (int j = 0; j < (sizeOfSetsOfXAndY / 2); j++) {
            double randomValueForParent = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
            tempVariableForCalculations = 0;
            for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
                tempVariableForCalculations += temporaryNormalized.get(i);
                if (randomValueForParent <= tempVariableForCalculations) {
                    Cost tempCostState = new Cost(setsofXandY.get(i).getValueofX(), setsofXandY.get(i).getValueofY());
                    boolean alreadyExists = false;
                    for (int k = 0; k < forNewParents.size(); k++) {
                        Cost temporarilyMadeNode = forNewParents.get(k);
                        if (temporarilyMadeNode.isEqual(tempCostState)) {
                            alreadyExists = true;
                            break;
                        }
                    }
                    if (alreadyExists) {
                        j--;
                    } else {
                        forNewParents.add(tempCostState);
                    }

                    break;
                }
            }
        }

        setsofXandY.clear();

        int sizeofTheNewParentsList = forNewParents.size();

        for (int i = 0; i < sizeofTheNewParentsList; i++) {
            setsofXandY.add(forNewParents.get(i));
        }
    }

    public void rankedBasedScehem(LinkedList<Cost> setsofXandY) {
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

        LinkedList<Cost> forNewParents = new LinkedList<>();
        for (int j = 0; j < (sizeOfSetsOfXAndY / 2); j++) {
            double randomValueForParent = ((getARandomNumberBetween(minimumValue, maximumValue)) / rangeValue);
            tempVariableForCalculations = 0;
            for (int i = 0; i < sizeOfSetsOfXAndY; i++) {
                tempVariableForCalculations += temporaryNormalized.get(i);
                if (randomValueForParent <= tempVariableForCalculations) {
                    Cost tempCostState = new Cost(setsofXandY.get(i).getValueofX(), setsofXandY.get(i).getValueofY());
                    boolean alreadyExists = false;
                    for (int k = 0; k < forNewParents.size(); k++) {
                        Cost temporarilyMadeNode = forNewParents.get(k);
                        if (temporarilyMadeNode.isEqual(tempCostState)) {
                            alreadyExists = true;
                            break;
                        }
                    }
                    if (alreadyExists) {
                        j--;
                    } else {
                        forNewParents.add(tempCostState);
                    }

                    break;
                }
            }
        }

        setsofXandY.clear();

        int sizeofTheNewParentsList = forNewParents.size();

        for (int i = 0; i < sizeofTheNewParentsList; i++) {
            setsofXandY.add(forNewParents.get(i));
        }
    }

    public void binaryTournamentMethod(LinkedList<Cost> setsofXandY, int funtionValueNumber) {
        LinkedList<Integer> smallerSpace = new LinkedList<>();
        int sizeOfSetsOfXAndY = setsofXandY.size();

        LinkedList<Cost> forNewParents = new LinkedList<>();
        for (int l = 0; l < (sizeOfSetsOfXAndY / 2); l++) {

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
                Cost tempCostState = new Cost(setsofXandY.get(smallerSpace.get(randomValueForParent2)).getValueofX(), setsofXandY.get(smallerSpace.get(randomValueForParent2)).getValueofY());
                forNewParents.add(tempCostState);
            } else {
                Cost tempCostState = new Cost(setsofXandY.get(smallerSpace.get(randomValueForParent1)).getValueofX(), setsofXandY.get(smallerSpace.get(randomValueForParent1)).getValueofY());
                forNewParents.add(tempCostState);
            }

            smallerSpace.clear();
        }

        setsofXandY.clear();

        int sizeofTheNewParentsList = forNewParents.size();

        for (int i = 0; i < sizeofTheNewParentsList; i++) {
            setsofXandY.add(forNewParents.get(i));
        }
    }
}