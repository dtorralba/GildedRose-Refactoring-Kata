package com.gildedrose;

public class AgedBrieItem implements ItemDefinition {

    private Item item;

    public AgedBrieItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        increaseQuality(item);

        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    @Override
    public void updateSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
