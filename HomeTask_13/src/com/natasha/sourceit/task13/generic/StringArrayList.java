package com.natasha.sourceit.task13.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Stas on 24.11.2016.
 */
public class StringArrayList extends ArrayList<String> {

    public StringArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public StringArrayList() {
    }

    public StringArrayList(Collection<? extends String> c) {
        super(c);
    }
}
