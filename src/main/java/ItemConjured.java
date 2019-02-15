public class ItemConjured extends Item {
    public ItemConjured(String name, int sellIn, int quality){
        super(name, sellIn, quality);
    }

    public void updateQuality(){
        quality -= 2;
        if(sellIn <= 0) quality -= 2;
        if(quality < 0) quality = 0;
    }
}
