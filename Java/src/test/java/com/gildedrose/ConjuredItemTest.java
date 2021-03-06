package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    @Test
    void conjuredItemTest_Before_Sellin_Date(){
        final Item[] items = createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 4;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Conjured Item", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void conjuredTest_On_Sellin_Date(){
        final Item[] items = createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 6;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Conjured Item", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void conjuredItemTest_After_Sellin_Date(){
        final Item[] items = createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 7;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Conjured Item", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredItemTest_With_Minimum_Quality(){
        final Item[] items = new Item[]{new Item("Conjured Item", 6, 0) };
        final GildedRose app = new GildedRose(items);
        final int days = 7;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Conjured Item", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    private Item[] createItem (){
        return new Item[]{new Item("Conjured Item", 6, 14) };
    }

}
