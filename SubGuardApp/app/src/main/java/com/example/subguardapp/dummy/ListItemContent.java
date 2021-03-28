package com.example.subguardapp.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ListItemContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ListItem> ITEMS = new ArrayList<>(

    );

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ListItem> ITEM_MAP = new HashMap<>();

    static {
        ITEMS.add(new ListItem("1", "Netflix", "25.05.2022", "45 minut", "30.45"));
        ITEMS.add(new ListItem("2", "Spotify", "26.03.2022", "1 godzina", "19.99"));
        ITEMS.add(new ListItem("3", "Amazon Prime", "22.09.2021", "3.5 godziny", "45.00"));
        ITEMS.add(new ListItem("4", "YouTube", "15.06.2022", "30 minut", "9.99"));
        ITEMS.add(new ListItem("5", "HBO GO", "13.02.2022", "2 godziny", "39.99"));
        ITEMS.add(new ListItem("6", "Tidal", "10.08.2022", "15 minut", "29.99"));
    }

    private static void addItem(ListItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.logo, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ListItem {
        public final String logo;
        public final String name;
        public final String lastLogin;
        public final String lastLoginDuration;
        public final String cost;

        public ListItem(String logo, String name, String lastLogin, String lastLoginDuration, String cost) {
            this.logo = logo;
            this.name = name;
            this.lastLogin = lastLogin;
            this.lastLoginDuration = lastLoginDuration;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}