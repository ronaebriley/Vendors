class Item {
    double price;
    int stock;

    Item(double price, int numPieces) {
        this.price = price;
        this.stock = numPieces;
    }

    /** returns the number of items */
    double getNumPieces () {
        return this.stock;
    }

    void restock(int amount) {
        if (amount >= this.stock) {
            this.stock = this.stock + amount;
        } else {
            this.stock = this.stock;
        }
    }

    void purchase(int amount) {
        this.stock = this.stock - amount;
    }
}