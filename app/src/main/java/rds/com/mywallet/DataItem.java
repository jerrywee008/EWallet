package rds.com.mywallet;

/**
 * Created by fwei2 on 9/13/17.
 */

public class DataItem {
    String shoppingDate;
    String itemName;
    float cost;
    DataItem(String shoppingDate, String itemName, float cost){
        this.shoppingDate = shoppingDate;
        this.itemName = itemName;
        this.cost = cost;
    }

    public String getShoppingDate() {
        return shoppingDate;
    }

    public String getItemName() {
        return itemName;
    }

    public Number getCost() {
        return cost;
    }
}
