package com.khaos.core.data.entry;

import com.khaos.core.data.Meta;

/**
 *
 * @author endbr
 */
public class MaterialEntry extends Meta {

    private final int cost;
    private final int beauty;
    private final int durability;

    /*public MaterialEntry(Entry entry) {
        super(entry.getMeta());

        String raw = entry.getValue();

        this.cost = 0;
        this.beauty = 0;
        this.durability = 0;
    }*/
    
    public MaterialEntry(String meta, int cost, int beauty, int durability) {
        super(meta);

        this.cost = cost;
        this.beauty = beauty;
        this.durability = durability;
    }

}//End Class
