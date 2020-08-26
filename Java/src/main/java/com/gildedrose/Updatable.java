package com.gildedrose;

@FunctionalInterface
public interface Updatable {

    void updateItem(Item item);

    default void updateSellin(final Item item){
        item.sellIn--;
    }
}
