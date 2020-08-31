package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OtherItemTest {

    @Test
    void otherItemTest_Before_Sellin_Date(){
        Item[] items = new Item[] { new Item("foo", 5, 6) };
        GildedRose app = new GildedRose(items);
        int days = 4;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("foo", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void otherItemTest_On_Sellin_Date(){
        Item[] items = new Item[] { new Item("foo", 5, 6) };
        GildedRose app = new GildedRose(items);
        int days = 5;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("foo", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void otherItemTest_After_Sellin_Date(){
        Item[] items = new Item[] { new Item("foo", 6, 3) };
        GildedRose app = new GildedRose(items);
        int days = 7;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
