package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        List<ItemDefinition> itemDefinitions = createItemsDefinition(items);

        for (ItemDefinition itemDefinition : itemDefinitions) {
            itemDefinition.updateSellIn();
            itemDefinition.updateSellIn();
        }
    }

    private List<ItemDefinition> createItemsDefinition(Item[] items) {
        List<ItemDefinition> itemDefinitions = new ArrayList<>();

        for(Item item : items) {
            if (isNormal(item)) {
                itemDefinitions.add(new NormalItem(item));
            } else if (item.name.equals("Aged Brie")){
                itemDefinitions.add(new AgedBrieItem(item));
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                itemDefinitions.add(new LegendaryItem(item));
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                itemDefinitions.add(new BackstageItem(item));
            }
        }

        return itemDefinitions;
    }

    private boolean isNormal(Item item) {
        return !item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}