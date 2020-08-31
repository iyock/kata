package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasItemTest {

    @Test
    void sulfurasItemTest_Before_Sellin_Date(){
        final Item[] items = createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 4;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Sulfuras Item", app.items[0].name);
        assertEquals(6, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfurasItemTest_On_Sellin_Date(){
        final Item[] items = createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 6;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Sulfuras Item", app.items[0].name);
        assertEquals(6, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfurasItemTest_After_Sellin_Date(){
        final Item[] items = createItem();
        final GildedRose app = new GildedRose(items);
        final int days = 7;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("Sulfuras Item", app.items[0].name);
        assertEquals(6, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }


    private Item[] createItem (){
        return new Item[]{new Item("Sulfuras Item", 6, 80) };
    }

}
