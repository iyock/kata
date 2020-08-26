package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {

        Item[] items = new Item[] { new Item("foo", 0, 3) };
        GildedRose app = new GildedRose(items);
        int days = 3;


        int remainingDays = days;

        for (int i = 0; i < days; i++) {
            app.updateQuality(remainingDays);
            --remainingDays;
        }
        assertEquals("foo", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

}
