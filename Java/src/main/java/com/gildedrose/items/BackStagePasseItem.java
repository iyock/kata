package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.Updatable;
import com.gildedrose.utils.Constants;

import static com.gildedrose.utils.Constants.BACKSTAGE_PASSES;
import static com.gildedrose.utils.Constants.QUALITY_MAX_VALUE;

public class BackStagePasseItem implements Updatable {

    private final int numberOfDays;

    public BackStagePasseItem(final int numberOfDays) {this.numberOfDays = numberOfDays;}

    @Override
    public void updateItem(final Item item) {
        final String itemName = item.name;
        if(itemName.contains(BACKSTAGE_PASSES) ){
            updateQualityByDay(this.numberOfDays, item);
            updateSellin(item);
        }
    }

    @Override
    public void updateSellin(Item item){
        item.sellIn -= 1;
        if ( item.sellIn < 0 ) {
            item.quality = 0;
        }
    }

    private void updateQualityByDay(final int numberOfDays, final Item item) {
        int itemQuality = item.quality;
        if (itemQuality < QUALITY_MAX_VALUE) {
           itemQuality = getItemQualityWhen5OrLessDays(itemQuality, numberOfDays);
           itemQuality = getItemQualityWhenBetween10And5Days(itemQuality, numberOfDays);
           itemQuality = getItemQualityWhenMoreThand10Days(itemQuality, numberOfDays);
           itemQuality = getItemQualityMaxValue(itemQuality);
        }
        item.quality = itemQuality;
    }

    private int getItemQualityWhen5OrLessDays(final int itemQuality, final int numberOfDays){
        int quality = itemQuality;
        if( numberOfDays <= 5){
            quality += 3;
        }
        return quality;
    }

    private int getItemQualityWhenBetween10And5Days(final int itemQuality, final int numberOfDays){
        int quality = itemQuality;
        if((numberOfDays > 5) && (numberOfDays <= 10)){
            quality += 2;
        }
        return quality;
    }

    private int getItemQualityWhenMoreThand10Days(final int itemQuality, final int numberOfDays){
        int quality = itemQuality;
        if(numberOfDays > 10 ){
            quality += 1;
        }
        return quality;
    }

    private int getItemQualityMaxValue(final int itemQuality){
        int quality = itemQuality;
        if (quality > QUALITY_MAX_VALUE ) {
            quality = QUALITY_MAX_VALUE;
        }
        return quality;
    }
}
