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
    void addZeroTest() {
        Vendor v = new Vendor (2,5);
        v.addMoney(0);
        assertEquals(0, v.getBalance());
    }

    @Test
    void addNegativeTestInitialPositive() {
        Vendor v = new Vendor(2, 5);
        v.addMoney(20);
        v.addMoney(-10);
        assertEquals(10, v.getBalance());
    }



    @Test
    void buyItemTestAtZeroBalance() {
        Vendor v = new Vendor (2,5);
        v.addMoney(1.25);
        v.select("Candy");
        assertEquals(0, v.getBalance());

        //Candy = 1.25
        //Gum = 0.5
    }

    @Test
    void buyItemTestAtPositiveBalance() {
        Vendor v = new Vendor (2,5);
        v.addMoney(5);
        v.select("Candy");
        assertEquals(3.75, v.getBalance());
    }

    @Test
    void buyItemTestAtNegativeBalance() {
        Vendor v = new Vendor (2,5);
        v.addMoney(0);
        v.select("Candy");
        assertEquals(0, v.getBalance());
    }

}