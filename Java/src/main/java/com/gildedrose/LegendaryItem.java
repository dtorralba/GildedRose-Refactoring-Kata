package com.gildedrose;

public class LegendaryItem implements ItemDefinition {
    private Item item;

    public LegendaryItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        // Do Nothing
    }

    @Override
    public void updateSellIn() {
        // Do Nothing
    }
}
