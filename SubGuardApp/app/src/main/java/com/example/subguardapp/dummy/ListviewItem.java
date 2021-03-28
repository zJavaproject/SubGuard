package com.example.subguardapp.dummy;

import java.util.ArrayList;
import java.util.List;

public class ListviewItem {

    public static final List<ListItem> TRANSACTION_ITEMS = new ArrayList<>(
    );


    static {
        TRANSACTION_ITEMS.add(new ListItem("Netflix", "30.45"));
        TRANSACTION_ITEMS.add(new ListItem("Spotify","19.99"));
        TRANSACTION_ITEMS.add(new ListItem("Amazon Prime", "45.00"));
        TRANSACTION_ITEMS.add(new ListItem("YouTube", "9.99"));
        TRANSACTION_ITEMS.add(new ListItem("HBO GO",  "39.99"));
    }

    public int name;


    /**
     * A dummy item representing a piece of content.
     */
    public static class ListItem {
        public final String name;
        public final String cost;

        public ListItem(String name, String cost) {
            this.name = name;
            this.cost = cost;
        }

    }
}
