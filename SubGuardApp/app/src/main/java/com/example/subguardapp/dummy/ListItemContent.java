package com.example.subguardapp.dummy;

import com.example.subguardapp.R;

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
        ITEMS.add(new ListItem(R.drawable.netflix, "Netflix", "25.03.2021", "12 godzin", "30.45"));
        ITEMS.add(new ListItem(R.drawable.spotifylogo, "Spotify", "26.03.2020", "1 godzina", "19.99"));
        ITEMS.add(new ListItem(R.drawable.amazonlogo, "Amazon Prime", "22.01.2021", "3.5 godziny", "45.00"));
        ITEMS.add(new ListItem(R.drawable.youtubelogo, "YouTube", "15.02.2021", "30 minut", "9.99"));
        ITEMS.add(new ListItem(R.drawable.hbogologo, "HBO GO", "13.02.2021", "2 godziny", "39.99"));
        ITEMS.add(new ListItem(R.drawable.tidallogo, "Tidal", "10.08.2020", "15 minut", "29.99"));
    }

    public static void addItem(ListItem item) {
        ITEMS.add(item);
//        ITEM_MAP.put(item.logo, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ListItem {
        public final int logo;
        public final String name;
        public final String lastLogin;
        public final String lastLoginDuration;
        public final String cost;

        public ListItem(int logo, String name, String lastLogin, String lastLoginDuration, String cost) {
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