package com.khaos.core.data;

import java.util.ArrayList;

/**
 *
 * @author endbr
 */
public class Array2D<E> extends ArrayList<ArrayList<E>> {

    public E get(int x, int y) {
        if (x < this.size() && y < this.get(x).size()) {
            return super.get(x).get(y);
        }

        return null;
    }

    public boolean add(int x, int y, E e) {
        if (x >= this.size()) {
            super.add(new ArrayList<>());
        }
        return super.get(x).add(e);

        /*      if (x < this.size() && y < this.get(x).size()) {
         return super.get(x).add(e);
         } else { //New Column
         super.add(new ArrayList<>());
         return super.get(x).add(e);
         }*/
    }

    public int getColumns() {
        return super.size();
    }

    public int getRows() {
        return super.get(0).size();
    }

}//End Class
