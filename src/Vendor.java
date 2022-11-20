import java.util.HashMap;


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
    double getAmount() {
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

    void changeItemName(String name, double price, int numPieces){
        Stock.put(name,new Item(price, numPieces));
        Stock.get(name);
    }

}



class Examples {
}

