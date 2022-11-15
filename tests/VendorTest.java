import org.junit.jupiter.api.Test;

import static org.junit.gen5.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    @Test
    void addPositiveTest() {
        Vendor v = new Vendor (2,5);
        v.addMoney(2.8);
        assertEquals(2.8, v.getBalance());
    }

    @Test
    void addNegativeTest() {
        Vendor v = new Vendor (2,5);
        v.addMoney(-24);
        assertEquals(0, v.getBalance());
    }

    @Test
    void addZeroDollarsTest() {
        Vendor v = new Vendor (2,5);
        v.addMoney(0);
        assertEquals(0, v.getBalance());
    }

    @Test
    void addNegativeTestInitialPositiveTest() {
        Vendor v = new Vendor(2, 5);
        v.addMoney(20);
        v.addMoney(-10);
        assertEquals(10, v.getBalance());
    }



    @Test
    void buyItemAtZeroBalanceTest() {
        Vendor v = new Vendor (2,5);
        v.addMoney(1.25);
        v.select("Candy");
        assertEquals(0, v.getBalance());

        //Candy = 1.25
        //Gum = 0.5
    }

    @Test
    void buyItemAtPositiveBalanceTest() {
        Vendor v = new Vendor (2,5);
        v.addMoney(5);
        v.select("Candy");
        assertEquals(3.75, v.getBalance());
    }

    @Test
    void buyItemAtNegativeBalanceTest() {
        Vendor v = new Vendor (2,5);
        v.addMoney(0);
        v.select("Candy");
        assertEquals(0, v.getBalance());
    }
    @Test
    void buyItemPositiveTest2() {
        Item i = new Item (2,5);
        i.purchase(5);
        assertEquals(0, i.getNumPieces());
    }
    @Test
    void buyItemNegativeTest2() {
        Item i = new Item (2,5);
        i.purchase(-1);
        assertEquals(5, i.getNumPieces());
    }

    @Test
    void buyItemZeroTest2() {
        Item i = new Item (2,5);
        i.purchase(0);
        assertEquals(5, i.getNumPieces());
    }

    @Test
    void restockItemAtPositiveAmountTest() {
        Item i = new Item(2,5);
        i.restock(5);
        assertEquals(10, i.getNumPieces());
    }

    @Test
    void restockItemAtZeroAmountTest() {
        Item i = new Item(2,5);
        i.restock(0);
        assertEquals(5, i.getNumPieces());
    }

    @Test
    void restockItemAtStartZeroAmountTest() {
        Item i = new Item(2,0);
        i.restock(6);
        assertEquals(6, i.getNumPieces());
    }

    @Test
    void restockItemNegativeAmountTest() {
        Item i = new Item(2,5);
        i.restock(-6);
        assertEquals(5, i.getNumPieces());
    }

    @Test
    void restockAndBuyZeroTest() {
        Item i = new Item(2,5);
        Vendor v = new Vendor (2, 5);
        i.restock(4);
        i.purchase(9);
        assertEquals(0, i.getNumPieces());
    }

    @Test
    void restockAndBuyPositiveTest() {
        Item i = new Item(2,5);
        Vendor v = new Vendor (2, 5);
        i.restock(4);
        i.purchase(4);
        assertEquals(5, i.getNumPieces());
    }

    @Test
    void restockAndBuyNegativeTest() {
        Item i = new Item(2,5);
        Vendor v = new Vendor (2, 5);
        i.restock(4);
        i.purchase(10);
        assertEquals(9, i.getNumPieces());
    }

    @Test
    void restockAndBuyNegativeTest2() {
        Item i = new Item(2,5);
        Vendor v = new Vendor (2, 5);
        i.restock(4);
        i.purchase(-1);
        assertEquals(9, i.getNumPieces());
    }


}