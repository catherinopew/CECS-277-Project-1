public class Enemy extends Entity {
    private Item item;
    
    public Enemy(String n, int mHp, Item i) {
        super(n, mHp);
        item = i;
    }

    public Item getItem() {
        return item;
    }
}
