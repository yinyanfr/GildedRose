import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private List<Item> items = new ArrayList<Item>();

    public List<Item> getItems() {
        return items;
    }

    public GildedRose(){

    }

    public void add(Item item){
	    items.add(item);
    }

	
    public void updateQuality()
    {
        items.forEach(item -> item.updateQuality());
    }

}
