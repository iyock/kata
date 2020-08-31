package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    @Test
    void AgedBrieTest_Before_Sellin_Date(){
        Item[] items = new Item[] { new Item("Aged Brie", 6, 3) };
        GildedRose app = new GildedRose(items);
        int days = 4;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void AgedBrieTest_On_Sellin_Date(){
        Item[] items = new Item[] { new Item("Aged Brie", 6, 3) };
        GildedRose app = new GildedRose(items);
        int days = 6;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void AgedBrieTest_After_Sellin_Date(){
        Item[] items = new Item[] { new Item("Aged Brie", 6, 3) };
        GildedRose app = new GildedRose(items);
        int days = 7;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }
}
