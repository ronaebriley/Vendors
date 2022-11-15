class Item {
    double price;
    int stock;

    Item(double price, int numPieces) {
        this.price = price;
        this.stock = numPieces;
    }

    /** returns the number of items */
    double getNumPieces() {
        return this.stock;
    }

    void restock(int amount) {
        if (amount >= 0) {
            this.stock = this.stock + amount;
        } else {
            this.stock = this.stock;
            System.out.println("Sorry, try restocking a different amount.");
        }
    }

    void purchase(int amount) {
        if (amount <= this.stock && amount >= 0 ) {
            this.stock = this.stock - amount;
        }else{
            this.stock = this.stock;
            System.out.println("Sorry, try purchasing a different amount.");
        }
    }
}