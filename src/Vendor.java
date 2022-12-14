import java.util.HashMap;
import java.util.Map.*;


/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vendor {
    private static HashMap<String, Item> Stock = new HashMap<String,Item>();
    private double balance;
    private int amount;

    Vendor(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = 0;
    }

    Vendor(int numCandy, int numGum, double initial) {
        Stock.put("Candy", new Item(1.25, numCandy));
        Stock.put("Gum", new Item(.5, numGum));
        this.balance = initial;
    }

    /*
    Vendor(String name, int num) {
        Stock.put("Candy");
        Stock.put("Gum");
        Stock.put()
    }
     */

    /** resets the Balance to 0 */
    void resetBalance () {
        this.balance = 0;
    }

    /** Adds to inventory */
    void addToInventory () {
        //Item i = new Item(1.0, 0);
        //Vendor v = new Vendor (1,1);
        this.amount = 1;
    }

    /** Removes one item from inventory */
    void removesInventory () {
        //Item i = new Item(1.0, 0);
        //Vendor v = new Vendor (1,1);
        if (amount > 0) {
            this.amount = -1;
        } else {
            System.out.println("Sorry, there is nothing in inventory.");
        }
    }

    /** Empties inventory */
    void emptyInventory () {
        //Vendor v = new Vendor();
        this.amount = 0;

    }

    /** Gets number of items in inventory */
    int getAmount() {
        return this.amount;

    }

    /** returns the current balance */
    double getBalance () {
        return this.balance;
    }

    /** adds money to the machine's balance
     * @param amt how much money to add
     * */
    void addMoney (double amt) {
        if(this.balance + amt < 0){
            this.balance = 0;
        } else {
            this.balance = this.balance + amt;
        }
    }


    /** attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select (String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
                if (balance >= item.price) {
                    item.purchase(1);
                    this.balance = this.balance - item.price;
                } else
                    System.out.println("Gimme more money");
        }
        else System.out.println("Sorry, don't know that item");
    }

    /** Changes item name */
    void changeItemName(String oldName, String newName){
        if (oldName != newName & !newName.contains("0") & !newName.contains("1") & !newName.contains("2") & !newName.contains("3") & !newName.contains("4") & !newName.contains("5") & !newName.contains("6") & !newName.contains("7") & !newName.contains("8") & !newName.contains("9") & !newName.contains("0")) {
            Item i = Stock.get(oldName);
            Stock.put(newName, new Item(i.getPrice(), i.getNumPieces()));
        } else {

        }
    }

    /** Checks item name */
    String checksItemName(){
        //return Stock.getKey();
        String r;
        for(Entry<String, Item> entry: Stock.entrySet()) {
            return entry.getKey();
                //break;
        }
        return null;
    }

    /**  manages and prints the inventory
     of 5 different vendors */
    void printVendorInfo(){
        Vendor v1 = new Vendor(1, 1);
        System.out.println("Vendor 1 has " + v1.getAmount() + " items in its iventory");
        for(Entry<String, Item> entry: Stock.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println();
        Vendor v2 = new Vendor(2, 2);
        System.out.println("Vendor 2 has " + v1.getAmount() + " items in its iventory");
        for(Entry<String, Item> entry: Stock.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println();

        Vendor v3 = new Vendor(3, 3);
        System.out.println("Vendor 3 has " + v1.getAmount() + " items in its iventory");
        for(Entry<String, Item> entry: Stock.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println();

        Vendor v4 = new Vendor(4, 4);
        System.out.println("Vendor  has " + v1.getAmount() + " items in its iventory");
        for(Entry<String, Item> entry: Stock.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println();

        Vendor v5 = new Vendor(5, 5);
        System.out.println("Vendor 5 has " + v1.getAmount() + " items in its iventory");
        for(Entry<String, Item> entry: Stock.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println();

    }


}



class Examples {
}

