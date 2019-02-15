import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;


/*
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

 */

public class GildedRoseTest {

//	@Test
//	public void testTheTruth() {
//		assertTrue(true);
//	}

    @Test
    public void testNormal(){
        GildedRose rose = new GildedRose();
        rose.add(new Item("+5 Dexterity Vest", 10, 20));
        rose.updateQuality();
        assertEquals(19, rose.getItems().get(0).getQuality());
        System.out.println("√ Items degrade in its quality for once by day.");
    }

    @Test
    public void testEdgyQuality(){
        GildedRose rose = new GildedRose();
        rose.add(new Item("+5 Dexterity Vest", 10, 0));
        rose.updateQuality();
        assertEquals(0, rose.getItems().get(0).getQuality());
        System.out.println("√ The Quality of an item is never negative");
    }

    @Test
    public void testExpiration(){
        GildedRose rose = new GildedRose();
        rose.add(new Item("+5 Dexterity Vest", 0, 20));
        rose.updateQuality();
        assertEquals(18, rose.getItems().get(0).getQuality());
        System.out.println("√ Once the sell by date has passed, Quality degrades twice as fast");
    }

    @Test
    public void testAged(){
        GildedRose rose = new GildedRose();
        rose.add(new ItemAged("Aged Brie", 2, 0));
        rose.updateQuality();
        assertEquals(1, rose.getItems().get(0).getQuality());
        System.out.println("√ \"Aged Brie\" actually increases in Quality the older it gets");
    }

    @Test
    public void testSuper(){
        GildedRose rose = new GildedRose();
        rose.add(new ItemAged("Aged Brie", 2, 50));
        rose.updateQuality();
        assertEquals(50, rose.getItems().get(0).getQuality());
        System.out.println("√ The Quality of an item is never more than 50");
    }

    @Test
    public void testLegend(){
        GildedRose rose = new GildedRose();
        rose.add(new ItemLegend("Sulfuras, Hand of Ragnaros", 0, 80));
        rose.updateQuality();
        assertEquals(80, rose.getItems().get(0).getQuality());
        System.out.println("√ \"Sulfuras\", being a legendary item, never has to be sold or decreases in Quality");
    }

    @Test
    public void testPass(){
        GildedRose rose = new GildedRose();
        rose.add(new ItemTicket("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        rose.add(new ItemTicket("Backstage passes to a TAFKAL80ETC concert", 10, 20));
        rose.add(new ItemTicket("Backstage passes to a TAFKAL80ETC concert", 5, 20));
        rose.add(new ItemTicket("Backstage passes to a TAFKAL80ETC concert", 0, 20));
        rose.updateQuality();
        assertEquals(21, rose.getItems().get(0).getQuality());
        assertEquals(22, rose.getItems().get(1).getQuality());
        assertEquals(23, rose.getItems().get(2).getQuality());
        assertEquals(0, rose.getItems().get(3).getQuality());
        System.out.println("√ \"Backstage passes\", like aged brie, increases in Quality as it's SellIn value approaches; Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert");
    }

    @Test
    public void testConjured(){
        GildedRose rose = new GildedRose();
        // Normal
        rose.add(new ItemConjured("Conjured Mana Cake", 3, 6));
        // Expiration
        rose.add(new ItemConjured("Badly Conjured Mana Cake", 0, 6));
        // Edgy
        rose.add(new ItemConjured("Deadly Conjured Mana Cake", 3, 1));
        rose.updateQuality();
        assertEquals(4, rose.getItems().get(0).getQuality());
        assertEquals(2, rose.getItems().get(1).getQuality());
        assertEquals(0, rose.getItems().get(2).getQuality());
        System.out.println("√ \"Conjured\" items degrade in Quality twice as fast as normal items");
    }
}
