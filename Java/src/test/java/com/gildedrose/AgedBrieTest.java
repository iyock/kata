package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {

    @Test
    void agedBrieTest_Before_Sellin_Date(){
        final Item[] items = createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 4;


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
    void agedBrieTest_On_Sellin_Date(){
        final Item[] items =  createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 6;


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
    void agedBrieTest_After_Sellin_Date(){
        final Item[] items =  createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 7;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

    @Test
    void agedBrieTest_With_Maximum_Quality(){
        final Item[] items = new Item[]{new Item("Aged Brie", 6, 50) };
        final GildedRose app = new GildedRose(items);
        final int days = 4;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    private Item[] createItem (){
        return new Item[]{new Item("Aged Brie", 6, 3) };
    }
}
