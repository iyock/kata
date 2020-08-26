package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import com.gildedrose.utils.Constants;

import static com.gildedrose.utils.Constants.QUALITY_MAX_VALUE;

public class AgedBrieItem implements Updatable {


    @Override
    public void updateItem(final Item item) {
        if(item.name.contains(Constants.AGED_BRIE)){
            item.quality += 1;
            updateSellin(item);
            if(item.quality > QUALITY_MAX_VALUE){
                item.quality = QUALITY_MAX_VALUE;
            }
        }
    }
}
