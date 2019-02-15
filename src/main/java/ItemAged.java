public class ItemAged extends Item {
    public ItemAged(String name, int sellIn, int quality){
        super(name, sellIn, quality);
    }

    public void updateQuality(){
        if(quality < 50) quality++;
    }
}
