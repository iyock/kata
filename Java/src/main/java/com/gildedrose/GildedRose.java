package com.gildedrose;

import com.gildedrose.items.AgedBrieItem;
import com.gildedrose.items.BackStagePasseItem;
import com.gildedrose.items.ConjuredItem;
import com.gildedrose.items.OtherItem;

class GildedRose {
    Item[] items;
    Updatable updatable;

    public GildedRose(final Item[] items) {
        this.items = items;
    }

    public void updateQuality(final int numberOfDays) {
        if(numberOfDays > 1){
            updateBackStagePassesItem(numberOfDays);
            updateAgedBrieItem();
            updateConjuredItem();
            updateOtherItem();
        }
    }

    private void updateBackStagePassesItem(final int numberOfDays) {
        this.updatable = new BackStagePasseItem(numberOfDays);
        updateItem(this.updatable);
    }

    private void updateAgedBrieItem(){
        this.updatable = new AgedBrieItem();
        updateItem(this.updatable);
    }

    private void updateConjuredItem(){
        this.updatable = new ConjuredItem();
        updateItem(this.updatable);
    }

    private void updateOtherItem(){
        this.updatable = new OtherItem();
        updateItem(this.updatable);
    }

    private void updateItem(final Updatable updatable) {
        for (final Item item : this.items) {
            updatable.updateItem(item);

        }
    }
}