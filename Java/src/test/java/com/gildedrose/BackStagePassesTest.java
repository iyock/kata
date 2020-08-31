package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackStagePassesTest {

    @Test
    void backStagePassesTestt_Before_Concert_Day() {

        Item[] items = new Item[] { new Item("Backstage passes", 6, 3) };
        GildedRose app = new GildedRose(items);
        int days = 4;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Backstage passes", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(15, app.items[0].quality);
    }


    @Test
    void backStagePassesTEST_On_Concert_Day() {

        Item[] items = new Item[] { new Item("Backstage passes", 6, 3) };
        GildedRose app = new GildedRose(items);
        int days = 6;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Backstage passes", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(20, app.items[0].quality);
    }

    @Test
    void backStagePassesTEST_After_Concert() {

        Item[] items = new Item[] { new Item("Backstage passes", 5, 3) };
        GildedRose app = new GildedRose(items);
        int days = 6;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Backstage passes", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
