import org.junit.jupiter.api.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void emptyToZero(){
        Vendor v = new Vendor(2,2);
        v.emptyInventory();
        assertEquals(0, v.getAmount());
    }

    @Test
    void emptyThenAddPositive(){
        Vendor v = new Vendor(2,2);
        v.emptyInventory();
        //v.select("Gum");
        v.addToInventory();
        //v.addMoney(5);
        assertEquals(1, v.getAmount());
    }

    @Test
    void emptyThenNegativeInventory(){
        Vendor v = new Vendor(2,2);
        v.emptyInventory();
        v.removesInventory();
        assertEquals(0, v.getAmount());
    }
    
    @Test
    void nameChange1(){
        Vendor v = new Vendor (2,2);
        v.changeItemName("Candy", "Twix");
        assertEquals("Twix", v.checksItemName());
    }
    @Test
    void sameName(){
        Vendor v = new Vendor (2,2);
        v.changeItemName("Candy", "Candy");
        assertEquals("Candy", v.checksItemName());
    }

    @Test
    void nameChangeToNumbers(){
        Vendor v = new Vendor (2,2);
        v.changeItemName("Candy", "123Snickers");
        assertEquals("Candy", v.checksItemName());
    }

    @Test
    void print5VendorInfo(){
        Vendor v = new Vendor (2,2);
        v.printVendorInfo();
        //assertEquals(randomNum, v.getBalance());
    }
    @Test
    void printRandomVendorInfo(){
        Random rand = new Random();
        int randomNum = rand.nextInt(101);
        Vendor v = new Vendor (randomNum,randomNum);
        v.printVendorInfo();
        //assertEquals(randomNum, v.getBalance());
    }


    @Test
    void printVendorInfo3(){
        Vendor v = new Vendor (0,0);
        v.printVendorInfo();
        //assertEquals(randomNum, v.getBalance());
    }

}