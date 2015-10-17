/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaos.core.data;

import java.util.ArrayList;

/**
 *
 * @author endbr
 */
public class UniqueArray<E extends Meta> extends ArrayList<E> {

    public UniqueArray() {
        super();
    }

    @Override
    public boolean add(E e) {
        if (this.contains(e) == false) {
            super.add(e);
            return true; //return if new entry
        } else {
            this.set(this.indexOf(e), e);
            return false; //Return if replacing entry
        }
    }

    @Override
    public int indexOf(Object obj) {
        if (obj instanceof Meta) {
            return super.indexOf(obj);
        } else if (obj instanceof String) {
            return super.indexOf(new Meta(obj.toString()));
        }

        return -1;
    }

}//End Class
