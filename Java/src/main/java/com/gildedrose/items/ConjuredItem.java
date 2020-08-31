package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;

import static com.gildedrose.utils.Constants.*;
import static com.gildedrose.utils.Constants.QUALITY_MIN_VALUE;

public class ConjuredItem implements Updatable {

    @Override
    public void updateItem(final Item item) {
        final String itemName = item.name.toLowerCase();
        if (itemName.contains(CONJURED_ITEM)){
            item.quality -= 2;
            updateSellin(item);
            if(item.quality < 0){
                item.quality = QUALITY_MIN_VALUE;
            }
        }
    }
}
