package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

import static com.gildedrose.utils.Constants.*;

public class OtherItem implements Updatable {


    @Override
    public void updateItem(final Item item) {

        if(isAnotherItem(item)){
            item.quality -= 1;
            if(item.quality < 0 ){
                item.quality = QUALITY_MIN_VALUE;
            }
            updateSellin(item);
        }
    }

    private boolean isAnotherItem(final Item item) {
        return !isContainingItemName(item, AGED_BRIE) && !isContainingItemName(item, BACKSTAGE_PASSES)
               && (!isContainingItemName(item, CONJURED_ITEM) && !isContainingItemName(item, SULFURAS));
    }

    private boolean isContainingItemName(final Item item, final String name){
        final String itemName = item.name.toLowerCase();
        return itemName.contains(name);
    }
}
