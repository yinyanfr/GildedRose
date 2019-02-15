public class ItemTicket extends Item {
    public ItemTicket(String name, int sellIn, int quality){
        super(name, sellIn, quality);
    }

    public void updateQuality(){
        if(sellIn > 10){
            quality++;
        }
        else if(sellIn > 5){
            quality += 2;
        }else if(sellIn > 0){
            quality += 3;
        }

        if(quality > 50){
            quality = 50;
        }

        if(sellIn <= 0){
            quality = 0;
        }

    }
}
