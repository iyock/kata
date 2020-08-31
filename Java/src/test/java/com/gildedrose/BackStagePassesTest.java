package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackStagePassesTest {

    @Test
    void backStagePassesTest_Before_Concert_Day() {

        final Item[] items = createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 4;


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
    void backStagePassesTest_On_Concert_Day() {

        final Item[] items = createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 6;


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
    void backStagePassesTest_After_Concert() {

        final Item[] items = createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 7;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Backstage passes", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    private Item[] createItem (){
        return new Item[]{ new Item("Backstage passes", 6, 3) };
    }
}
