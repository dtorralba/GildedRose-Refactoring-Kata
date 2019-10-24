package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void normal_item_after_one_day() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(19, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void normal_item_after_sellIn_decreases_quality_twice() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(18, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    public void aged_item_increases_quality_after_one_day() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(1, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void aged_item_increases_quality_after_sellIn() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(3, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void legendary_item_mantains_quality_after_one_day() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(80, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void backstage_passes_increases_quality_before_ten_days_to_the_sellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(22, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
    }

    @Test
    public void backstage_passes_increases_quality_before_five_days_to_the_sellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(23, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    public void backstage_passes_increases_quality_after_sellIn() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateItems();

        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
}
