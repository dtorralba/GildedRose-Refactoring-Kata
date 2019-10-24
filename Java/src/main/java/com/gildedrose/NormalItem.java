package com.gildedrose;

public class NormalItem implements ItemDefinition {

    private Item item;

    public NormalItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        decreaseQuality();
        if (item.sellIn < 0) {
            decreaseQuality();
        }
    }

    @Override
    public void updateSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
