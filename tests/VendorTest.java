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
    void buyItemTest() {
        Vendor v = new Vendor (2,5);
        v.select("Candy");
        assertEquals("Candy", v.getBalance());
    }

}