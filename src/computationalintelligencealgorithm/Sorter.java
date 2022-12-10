/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computationalintelligencealgorithm;

import java.util.Comparator;

/**
 *
 * @author Jam Jahanzeb
 */
public class Sorter implements Comparator<BSO>{
  
    @Override
    public int compare(BSO e1, BSO e2) {
        if (e1.getclusterNumber() < e2.getclusterNumber()) {
            return -1;
        } else if (e1.getclusterNumber() > e2.getclusterNumber()) {
            return 1;
        } else {
            return 0;
        }
    }

    
}
